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
}