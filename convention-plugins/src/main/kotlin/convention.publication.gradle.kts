//Publishing your Kotlin Multiplatform library to Maven Central
//https://dev.to/kotlin/how-to-build-and-publish-a-kotlin-multiplatform-library-going-public-4a8k

import java.util.Properties

plugins {
    id("maven-publish")
    id("signing")
}

// Stub secrets to let the project sync and build without the publication values set up
ext["signing.keyId"] = null
ext["signing.password"] = null
ext["signing.secretKeyRingFile"] = null
ext["ossrhUsername"] = null
ext["ossrhPassword"] = null

// Grabbing secrets from local.properties file or from Github workflow environment variables, which could be used on CI
val secretPropsFile = project.rootProject.file("local.properties")
if (secretPropsFile.exists()) {
    secretPropsFile.reader().use {
        Properties().apply {
            load(it)
        }
    }.onEach { (name, value) ->
        ext[name.toString()] = value
    }
} else {
    ext["signing.keyId"] = System.getenv("SIGNING_KEY_ID")
    ext["signing.password"] = System.getenv("SIGNING_PASSWORD")
    ext["signing.secretKeyRingFile"] = System.getenv("SIGNING_SECRET_KEY_RING_FILE")
    ext["ossrhUsername"] = System.getenv("OSSRH_USERNAME")
    ext["ossrhPassword"] = System.getenv("OSSRH_PASSWORD")
}

val javadocJar by tasks.registering(Jar::class) {
    archiveClassifier.set("javadoc")
}

fun getExtraString(name: String) = ext[name]?.toString()

publishing {
    // Configure maven central repository
    repositories {
        maven {
            name = "sonatype"
            setUrl("https://s01.oss.sonatype.org/service/local/staging/deploy/maven2/")
            credentials {
                username = getExtraString("ossrhUsername")
                password = getExtraString("ossrhPassword")
            }
        }
    }

    // Configure all publications
    publications {
        create<MavenPublication>("maven") {
            groupId = "io.github.swapnil-musale"
            artifactId = "kdeviceinfo"
            version = "0.0.1"
            from(components["kotlin"])
        }

        // Configure all publications
        withType<MavenPublication> {
            // Stub javadoc.jar artifact
            artifact(javadocJar.get())

            // Provide artifacts information requited by Maven Central
            pom {
                name.set("KDeviceInfo")
                description.set("KDeviceInfo is Kotlin Multiplatform library to access the device info without writing the boilerplate code")
                url.set("https://github.com/swapnil-musale/KDeviceInfo")

                licenses {
                    license {
                        name.set("MIT")
                        url.set("https://opensource.org/licenses/MIT")
                    }
                }
                developers {
                    developer {
                        id.set("swapnilmusale")
                        name.set("Swapnil Musale")
                        email.set("swapnilmusale19@gmail.com")
                    }
                }
                scm {
                    connection.set("scm:git:github.com/swapnil-musale/KDeviceInfo.git")
                    developerConnection.set("scm:git:ssh://github.com/swapnil-musale/KDeviceInfo.git")
                    url.set("https://github.com/swapnil-musale/KDeviceInfo")
                }
            }
        }
    }
}

// Signing artifacts. Signing.* extra properties values will be used
signing {
    if (getExtraString("signing.keyId") != null) {
        sign(publishing.publications)
    }
}

val signingTasks = tasks.withType<Sign>()
tasks.withType<AbstractPublishToMaven>().configureEach {
    mustRunAfter(signingTasks)
}