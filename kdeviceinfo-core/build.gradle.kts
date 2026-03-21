plugins {
    id("kdeviceinfo.kmp.library")
}

kotlin {
    configure(listOf(iosX64(), iosArm64(), iosSimulatorArm64())) {
        binaries.framework {
            baseName = "KDeviceInfoCore"
            isStatic = true
        }
    }

    sourceSets {
        commonMain.dependencies {
            implementation(libs.androidx.annotation)
        }

        commonTest.dependencies {
            implementation(kotlin("test"))
        }

        androidMain.dependencies {
            implementation(libs.startup.runtime)
            implementation(libs.androidx.core)
        }

        getByName("desktopMain").dependencies {
            implementation(libs.oshi.core)
        }

        getByName("wasmJsMain").dependencies {
            implementation(libs.kotlinx.browser)
            implementation(npm("ua-parser-js", "2.0.0"))
        }
    }
}

android {
    namespace = "com.devx.kdeviceinfo.core"

    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")

    buildFeatures {
        buildConfig = true
    }
}
