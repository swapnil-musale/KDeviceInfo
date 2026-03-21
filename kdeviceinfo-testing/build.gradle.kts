plugins {
    id("kdeviceinfo.kmp.library")
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(project(":kdeviceinfo-core"))
        }
    }
}

android {
    namespace = "com.devx.kdeviceinfo.testing"
}
