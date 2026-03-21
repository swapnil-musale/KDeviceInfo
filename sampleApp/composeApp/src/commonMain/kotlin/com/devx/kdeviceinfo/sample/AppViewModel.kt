package com.devx.kdeviceinfo.sample

import com.devx.kdeviceinfo.AndroidDeviceInfo
import com.devx.kdeviceinfo.DesktopDeviceInfo
import com.devx.kdeviceinfo.DeviceInfoProvider
import com.devx.kdeviceinfo.IosDeviceInfo
import com.devx.kdeviceinfo.WebDeviceInfo
import com.devx.kdeviceinfo.onPlatform

class AppViewModel(
    private val deviceInfoProvider: DeviceInfoProvider = DeviceInfoProvider()
) {

    init {
        val deviceInfo = deviceInfoProvider.get()

        when (deviceInfo) {
            is AndroidDeviceInfo -> {
                println("DeviceInfo - App Name : ${deviceInfo.androidInfo.appName}")
            }
            is IosDeviceInfo -> {
                println("DeviceInfo - System Name : ${deviceInfo.iosInfo.systemName}")
            }
            is DesktopDeviceInfo -> {
                println("DeviceInfo - OS Version : ${deviceInfo.desktopInfo.operatingSystem.versionInfo.version}")
            }
            is WebDeviceInfo -> {
                println("DeviceInfo - OS Version : ${deviceInfo.webInfo.os.version}")
            }
        }

        val platformLabel: String = onPlatform(deviceInfo) {
            android { it.appName }
            ios { it.systemName }
            desktop { it.operatingSystem.family }
            web { it.browser.name }
        }
        println("DeviceInfo - Platform label: $platformLabel")
    }
}
