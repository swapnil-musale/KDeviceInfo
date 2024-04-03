package com.devx.kdeviceinfo.model

import android.content.res.Configuration
import com.devx.kdeviceinfo.initilizer.applicationContext
import com.devx.kdeviceinfo.model.common.DeviceOrientation

internal class AndroidDeviceOrientation : DeviceOrientation {

    private val orientation: Int = applicationContext.resources.configuration.orientation

    override val UNKNOWN: String
        get() = "unknown"
    override val PORTRAIT: String
        get() = "portrait"
    override val LANDSCAPE: String
        get() = "landscape"
    override val isPortrait: Boolean
        get() = orientation == Configuration.ORIENTATION_PORTRAIT
    override val isLandscape: Boolean
        get() = orientation == Configuration.ORIENTATION_LANDSCAPE

    override fun getDeviceOrientation(): String {
        return when (orientation) {
            0 -> UNKNOWN
            1 -> PORTRAIT
            2 -> LANDSCAPE
            else -> UNKNOWN
        }
    }
}