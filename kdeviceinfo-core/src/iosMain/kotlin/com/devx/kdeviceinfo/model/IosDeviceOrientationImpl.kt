package com.devx.kdeviceinfo.model

import com.devx.kdeviceinfo.model.common.DeviceOrientation
import platform.UIKit.UIApplication
import platform.UIKit.UIWindow
import platform.UIKit.UIWindowScene

internal class IosDeviceOrientationImpl : DeviceOrientation {

    private val windows =
        (UIApplication.sharedApplication.connectedScenes.first() as UIWindowScene).windows

    private val windowOrientation =
        (windows.first() as UIWindow).windowScene?.interfaceOrientation?.toInt()

    override val UNKNOWN: String
        get() = "unknown"

    override val PORTRAIT: String
        get() = "portrait"

    override val LANDSCAPE: String
        get() = "landscape"

    override val isPortrait: Boolean
        get() = windowOrientation == 1

    override val isLandscape: Boolean
        get() = windowOrientation == 3 || windowOrientation == 4

    override fun getDeviceOrientation(): String {
        return when (windowOrientation) {
            0 -> UNKNOWN
            1 -> PORTRAIT
            3, 4 -> LANDSCAPE
            else -> UNKNOWN
        }
    }
}