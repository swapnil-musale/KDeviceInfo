package com.devx.kdeviceinfo

import com.android.build.gradle.LibraryExtension
import org.gradle.api.Project
import org.gradle.api.publish.PublishingExtension
import org.gradle.api.publish.maven.MavenPublication
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.getByType
import org.gradle.kotlin.dsl.withType
import org.gradle.api.JavaVersion
import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension
import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinCompilationTask

internal fun Project.configureKmpLibrary(
    libraryExtension: LibraryExtension,
    kmpExtension: KotlinMultiplatformExtension,
) {
    configureKmpTargets(kmpExtension)
    configureAndroidDefaults(libraryExtension)
    configureCompilerOptions()
    configureNativeKDocExport(kmpExtension)
    configurePublishing()
    tasks.register("testClasses")
}

@OptIn(ExperimentalWasmDsl::class)
private fun configureKmpTargets(kmpExtension: KotlinMultiplatformExtension) {
    kmpExtension.apply {
        androidTarget {
            compilations.configureEach {
                compilerOptions.configure {
                    jvmTarget.set(JvmTarget.JVM_17)
                }
            }
            publishLibraryVariants("release")
        }

        iosX64()
        iosArm64()
        iosSimulatorArm64()

        jvm("desktop") {
            compilations.configureEach {
                compilerOptions.configure {
                    jvmTarget.set(JvmTarget.JVM_17)
                }
            }
        }

        wasmJs {
            browser()
        }
    }
}

private fun configureAndroidDefaults(libraryExtension: LibraryExtension) {
    libraryExtension.apply {
        compileSdk = 36
        defaultConfig {
            minSdk = 21
        }
        compileOptions {
            sourceCompatibility = JavaVersion.VERSION_17
            targetCompatibility = JavaVersion.VERSION_17
        }
    }
}

private fun Project.configureCompilerOptions() {
    tasks.withType<KotlinCompilationTask<*>>().configureEach {
        compilerOptions {
            freeCompilerArgs.add("-Xexpect-actual-classes")
        }
    }
}

private fun Project.configureNativeKDocExport(kmpExtension: KotlinMultiplatformExtension) {
    afterEvaluate {
        kmpExtension.targets.withType<KotlinNativeTarget>().configureEach {
            compilations.getByName("main").compileTaskProvider.configure {
                compilerOptions.freeCompilerArgs.add("-Xexport-kdoc")
            }
        }
    }
}

private fun Project.configurePublishing() {
    extensions.configure<PublishingExtension> {
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
}
