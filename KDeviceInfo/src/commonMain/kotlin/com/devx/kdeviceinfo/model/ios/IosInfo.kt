package com.devx.kdeviceinfo.model.ios

import com.devx.kdeviceinfo.model.common.Locale

interface IosInfo {
    val name: String
    val systemName: String
    val systemVersion: String
    val model: String
    val localizedModel: String
    val identifierForVendor: String
    val isPhysicalDevice: Boolean
    val isMultitaskingSupported: Boolean
    val isGeneratingDeviceOrientationNotifications: Boolean
    val deviceOrientation: DeviceOrientation
    val appName: String
    val bundleId: String
    val appVersion: String
    val appShortVersion: String
    val locale: Locale
}