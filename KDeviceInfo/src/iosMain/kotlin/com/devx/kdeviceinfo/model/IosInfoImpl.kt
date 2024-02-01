package com.devx.kdeviceinfo.model

import com.devx.kdeviceinfo.model.ios.DeviceOrientation
import com.devx.kdeviceinfo.model.ios.IosInfo
import platform.UIKit.UIDevice

class IosInfoImpl : IosInfo {

    private lateinit var cachedDeviceOrientation: DeviceOrientation

    override val name: String
        get() = UIDevice.currentDevice.name
    override val systemName: String
        get() = UIDevice.currentDevice.systemName
    override val systemVersion: String
        get() = UIDevice.currentDevice.systemVersion
    override val model: String
        get() = UIDevice.currentDevice.model
    override val localizedModel: String
        get() = UIDevice.currentDevice.localizedModel
    override val identifierForVendor: String
        get() = UIDevice.currentDevice.identifierForVendor?.UUIDString.orEmpty()

    override val isPhysicalDevice: Boolean
        get() = false
    override val isMultitaskingSupported: Boolean
        get() = UIDevice.currentDevice.isMultitaskingSupported()
    override val isGeneratingDeviceOrientationNotifications: Boolean
        get() = UIDevice.currentDevice.isGeneratingDeviceOrientationNotifications()
    override val deviceOrientation: String
        get() {
            if (::cachedDeviceOrientation.isInitialized.not()) {
                cachedDeviceOrientation = IosDeviceOrientationImpl()
            }
            return cachedDeviceOrientation.getDeviceOrientation()
        }
}