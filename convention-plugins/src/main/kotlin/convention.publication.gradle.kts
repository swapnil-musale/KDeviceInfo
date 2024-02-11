//Publishing your Kotlin Multiplatform library to Maven Central
//https://dev.to/kotlin/how-to-build-and-publish-a-kotlin-multiplatform-library-going-public-4a8k

import java.util.Properties

plugins {
    id("maven-publish")
    id("signing")
}

val Project.versionCatalog
    get(): VersionCatalog = extensions.getByType<VersionCatalogsExtension>().named("libs")
val libraryVersion = "${versionCatalog.findVersion("kDeviceInfoLibraryVersion").get()}"

// Stub secrets to let the project sync and build without the publication values set up
ext["signing.keyId"] = null
ext["signing.password"] = null
ext["signing.secretKeyRingFile"] = null
ext["ossrhUsername"] = null
ext["ossrhPassword"] = null
ext["ossrhEmailAddress"] = null
ext["library.author"] = null

// Grabbing secrets from local.properties file or from Github workflow environment variables, which could be used on CI
val secretPropertiesFile: File = project.rootProject.file("local.properties")
if (secretPropertiesFile.exists()) {
    secretPropertiesFile.reader().use {
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
    ext["ossrhEmailAddress"] = System.getenv("OSSRH_EMAIL_ADDRESS")
    ext["library.author"] = System.getenv("OSSRH_LIBRARY_AUTHOR")
}

val javadocJar by tasks.registering(Jar::class) {
    archiveClassifier.set("javadoc")
}

fun getExtraString(name: String): String = ext[name]?.toString().orEmpty()

publishing {
    // Configure maven central repository
    repositories {
        maven {
            name = "sonatype"
            val releasesRepoUrl =
                "https://s01.oss.sonatype.org/service/local/staging/deploy/maven2/"
            val snapShotRepoUrl = "https://s01.oss.sonatype.org/content/repositories/snapshots/"

            val publishingUrl = if (libraryVersion.endsWith("SNAPSHOT")) {
                snapShotRepoUrl
            } else {
                releasesRepoUrl
            }
            setUrl(publishingUrl)
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
            artifactId = "KDeviceInfo"
            version = libraryVersion
            from(components["kotlin"])
        }

        withType<MavenPublication> {
            // Stub javadoc.jar artifact
            artifact(javadocJar.get())

            // Provide artifacts information requited by Maven Central
            pom {
                name.set("KDeviceInfo")
                description.set("KDeviceInfo is Kotlin Multiplatform library to access the device info without writing the boilerplate code")
                url.set("https://github.com/swapnil-musale/KDeviceInfo")
                inceptionYear = "2024"

                licenses {
                    license {
                        name.set("MIT")
                        url.set("https://opensource.org/licenses/MIT")
                    }
                }
                developers {
                    developer {
                        id.set(getExtraString("ossrhUsername"))
                        name.set(getExtraString("library.author"))
                        email.set(getExtraString("ossrhEmailAddress"))
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
    if (getExtraString("signing.keyId").isNotEmpty()) {
        sign(publishing.publications)
    }
}

val signingTasks = tasks.withType<Sign>()
tasks.withType<AbstractPublishToMaven>().configureEach {
    mustRunAfter(signingTasks)
}