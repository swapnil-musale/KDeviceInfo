package com.devx.kdeviceinfo.model

import platform.UIKit.UIDevice

actual class IosInfo {
    actual val name: String
        get() = UIDevice.currentDevice.name
    actual val systemName: String
        get() = UIDevice.currentDevice.systemName
    actual val systemVersion: String
        get() = UIDevice.currentDevice.systemVersion
    actual val model: String
        get() = UIDevice.currentDevice.model
    actual val localizedModel: String
        get() = UIDevice.currentDevice.localizedModel
    actual val identifierForVendor: String
        get() = UIDevice.currentDevice.identifierForVendor?.UUIDString.orEmpty()

    actual val isPhysicalDevice: Boolean
        get() = false
    actual val isMultitaskingSupported: Boolean
        get() = UIDevice.currentDevice.isMultitaskingSupported()
    actual val isGeneratingDeviceOrientationNotifications: Boolean
        get() = UIDevice.currentDevice.isGeneratingDeviceOrientationNotifications()
    actual val uiDeviceOrientation: UIDeviceOrientation
        get() = getDeviceOrientation()

    private fun getDeviceOrientation(): UIDeviceOrientation {
        return when (UIDevice.currentDevice.orientation.value) {
            0L -> UIDeviceOrientation.UNKNOWN
            1L -> UIDeviceOrientation.PORTRAIT
            2L -> UIDeviceOrientation.PORTRAIT_UPSIDE_DOWN
            3L -> UIDeviceOrientation.LANDSCAPE_LEFT
            4L -> UIDeviceOrientation.LANDSCAPE_RIGHT
            5L -> UIDeviceOrientation.FACE_UP
            6L -> UIDeviceOrientation.FACE_DOWN
            else -> UIDeviceOrientation.UNKNOWN
        }
    }
}