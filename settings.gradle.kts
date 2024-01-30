pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenLocal()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenLocal()
        mavenCentral()
    }
}

rootProject.name = "KMP-DeviceInfo"
include(":KDeviceInfo")
includeBuild("convention-plugins")
include("sampleApp:composeApp")