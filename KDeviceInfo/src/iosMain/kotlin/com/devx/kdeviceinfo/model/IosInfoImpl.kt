package com.devx.kdeviceinfo.model

import com.devx.kdeviceinfo.model.common.DeviceOrientation
import com.devx.kdeviceinfo.model.common.Locale
import com.devx.kdeviceinfo.model.ios.IosInfo
import platform.Foundation.NSBundle
import platform.Foundation.NSLocale
import platform.Foundation.NSProcessInfo
import platform.Foundation.currentLocale
import platform.Foundation.languageCode
import platform.Foundation.regionCode
import platform.UIKit.UIDevice
import kotlin.experimental.ExperimentalNativeApi

internal class IosInfoImpl : IosInfo {

    private val iosDeviceOrientation: DeviceOrientation by lazy {
        IosDeviceOrientationImpl()
    }

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
        get() = NSProcessInfo.processInfo.environment["SIMULATOR_UDID"] == null
    override val isMultitaskingSupported: Boolean
        get() = UIDevice.currentDevice.isMultitaskingSupported()
    override val isGeneratingDeviceOrientationNotifications: Boolean
        get() = UIDevice.currentDevice.isGeneratingDeviceOrientationNotifications()
    override val deviceOrientation: DeviceOrientation
        get() = iosDeviceOrientation
    override val appName: String
        get() = (NSBundle.mainBundle.infoDictionary?.get("CFBundleDisplayName")
            ?: NSBundle.mainBundle.infoDictionary?.get("CFBundleName")) as String
    override val bundleId: String
        get() = NSBundle.mainBundle.bundleIdentifier.orEmpty()
    override val appVersion: String
        get() = NSBundle.mainBundle.infoDictionary?.get("CFBundleVersion") as String
    override val appShortVersion: String
        get() = NSBundle.mainBundle.infoDictionary?.get("CFBundleShortVersionString") as String
    override val locale: Locale
        get() = Locale(
            languageCode = NSLocale.currentLocale.languageCode,
            region = NSLocale.currentLocale.regionCode.orEmpty()
        )

    @OptIn(ExperimentalNativeApi::class)
    override val isDebug: Boolean
        get() = Platform.isDebugBinary
}