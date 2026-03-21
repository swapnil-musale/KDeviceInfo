plugins {
    `kotlin-dsl`
}

group = "com.devx.kdeviceinfo.buildlogic"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {
    implementation(libs.android.gradlePlugin)
    implementation(libs.kotlin.gradlePlugin)
    implementation(libs.compose.gradlePlugin)
    implementation(libs.compose.compiler.gradlePlugin)
    implementation(libs.mavenPublish.gradlePlugin)
    implementation(libs.binaryCompatibilityValidator.gradlePlugin)
}

gradlePlugin {
    plugins {
        register("kmpLibrary") {
            id = "kdeviceinfo.kmp.library"
            implementationClass = "KmpLibraryConventionPlugin"
        }
        register("composeLibrary") {
            id = "kdeviceinfo.kmp.compose"
            implementationClass = "ComposeLibraryConventionPlugin"
        }
    }
}
