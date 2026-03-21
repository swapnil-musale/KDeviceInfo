import com.android.build.gradle.LibraryExtension
import com.devx.kdeviceinfo.configureKmpLibrary
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.getByType
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

class KmpLibraryConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply("org.jetbrains.kotlin.multiplatform")
            pluginManager.apply("com.android.library")
            pluginManager.apply("com.vanniktech.maven.publish")
            pluginManager.apply("org.jetbrains.kotlinx.binary-compatibility-validator")

            val libraryExtension = extensions.getByType<LibraryExtension>()
            val kmpExtension = extensions.getByType<KotlinMultiplatformExtension>()
            configureKmpLibrary(libraryExtension, kmpExtension)
        }
    }
}
