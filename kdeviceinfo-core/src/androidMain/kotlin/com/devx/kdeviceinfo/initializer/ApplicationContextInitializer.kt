package com.devx.kdeviceinfo.initializer

import android.content.Context
import androidx.startup.Initializer
import com.devx.kdeviceinfo.KDeviceInfo

/**
 * AndroidX Startup initializer that automatically initializes [KDeviceInfo]
 * with the application context when the app starts.
 *
 * This runs before any content provider or activity, ensuring [KDeviceInfo]
 * is ready for use without manual setup.
 *
 * To disable automatic initialization, remove or override the provider
 * entry in your AndroidManifest.xml.
 */
internal class ApplicationContextInitializer : Initializer<Context> {
    override fun create(context: Context): Context = context.also {
        KDeviceInfo.initialize(it)
    }

    override fun dependencies(): List<Class<out Initializer<*>>> = emptyList()
}
