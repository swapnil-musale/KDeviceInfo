import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension
import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinCompilationTask

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.jetbrainsCompose)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.mavenPublish)
    alias(libs.plugins.compose.compiler)
}

kotlin {
    // Android
    androidTarget {
        compilations {
            compilerOptions.jvmTarget.set(JvmTarget.JVM_17)
        }
        publishLibraryVariants("release")
    }

    // Ios
    val iosTargets = listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    )

    configure(iosTargets) {
        binaries.framework {
            baseName = "KDeviceInfo"
            isStatic = true
        }
    }

    // Desktop (macOS, Windows, Linux)
    jvm("desktop") {
        compilations {
            compilerOptions.jvmTarget.set(JvmTarget.JVM_17)
        }
    }

    // Web (WASM JavaScript)
    @OptIn(ExperimentalWasmDsl::class)
    wasmJs {
        binaries.executable()
        browser {
            webpackTask {
                dependencies {
                    implementation(npm("ua-parser-js", "2.0.0"))
                }
            }
        }
    }

    sourceSets {
        getByName("commonMain").dependencies {
            implementation(libs.compose.ui)
            implementation(libs.compose.runtime)
            implementation(libs.androidx.annotation)
        }

        getByName("androidMain").dependencies {
            implementation(libs.startup.runtime)
            implementation(libs.androidx.core)
        }

        getByName("desktopMain").dependencies {
            implementation(libs.oshi.core)
        }
    }
}

afterEvaluate {
    extensions.configure<KotlinMultiplatformExtension>("kotlin") {
        targets.withType<KotlinNativeTarget>().configureEach {
            compilations.getByName("main").compileTaskProvider.configure {
                compilerOptions.freeCompilerArgs.add("-Xexport-kdoc")
            }
        }
    }
}

tasks.withType<KotlinCompilationTask<*>>().configureEach {
    compilerOptions {
        freeCompilerArgs.add("-Xexpect-actual-classes")
    }
}

android {
    namespace = "com.devx.kdeviceinfo"
    compileSdk = 35

    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")

    defaultConfig {
        minSdk = 21
    }

    buildFeatures {
        buildConfig = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

publishing {
    repositories {
        maven {
            name = "sonatype"
            credentials {
                username = System.getProperty("mavenCentralUsername")
                password = System.getProperty("mavenCentralPassword")
            }
        }
    }
}

tasks.register("testClasses")
