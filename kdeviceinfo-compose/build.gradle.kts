plugins {
    id("kdeviceinfo.kmp.compose")
}

kotlin {
    configure(listOf(iosX64(), iosArm64(), iosSimulatorArm64())) {
        binaries.framework {
            baseName = "KDeviceInfoCompose"
            isStatic = true
        }
    }

    sourceSets {
        commonMain.dependencies {
            api(project(":kdeviceinfo-core"))
            implementation(libs.compose.ui)
            implementation(libs.compose.runtime)
        }
    }
}

android {
    namespace = "com.devx.kdeviceinfo.compose"
}
