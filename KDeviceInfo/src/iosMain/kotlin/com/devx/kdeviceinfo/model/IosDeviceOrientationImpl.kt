package com.devx.kdeviceinfo.model

import com.devx.kdeviceinfo.model.ios.DeviceOrientation
import platform.UIKit.UIDevice

internal class IosDeviceOrientationImpl : DeviceOrientation {
    override val UNKNOWN: String
        get() = "unknown"
    override val PORTRAIT: String
        get() = "portrait"
    override val LANDSCAPE: String
        get() = "landscape"
    override val PORTRAIT_UPSIDE_DOWN: String
        get() = "portraitUpsideDown"
    override val LANDSCAPE_LEFT: String
        get() = "landscapeLeft"
    override val LANDSCAPE_RIGHT: String
        get() = "landscapeRight"
    override val FACE_UP: String
        get() = "faceUp"
    override val FACE_DOWN: String
        get() = "faceDown"
    override val isPortrait: Boolean
        get() = UIDevice.currentDevice.orientation.value.toString() == PORTRAIT

    override fun getDeviceOrientation(): String {
        return when (UIDevice.currentDevice.orientation.value.toInt()) {
            0 -> UNKNOWN
            1 -> PORTRAIT
            2 -> PORTRAIT_UPSIDE_DOWN
            3 -> LANDSCAPE_LEFT
            4 -> LANDSCAPE_RIGHT
            5 -> FACE_UP
            6 -> FACE_DOWN
            else -> UNKNOWN
        }
    }
}