package com.devx.kdeviceinfo

import com.android.build.gradle.LibraryExtension
import org.gradle.api.Project
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

internal fun Project.configureComposeLibrary(
    libraryExtension: LibraryExtension,
    kmpExtension: KotlinMultiplatformExtension,
) {
    pluginManager.apply("org.jetbrains.compose")
    pluginManager.apply("org.jetbrains.kotlin.plugin.compose")

    configureKmpLibrary(libraryExtension, kmpExtension)
}
