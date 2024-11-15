package com.devx.kdeviceinfo.sample

import com.devx.kdeviceinfo.DeviceInfoXState
import com.devx.kdeviceinfo.model.android.AndroidInfo
import com.devx.kdeviceinfo.model.ios.IosInfo

class AppViewModel {

    private val deviceInfoXState: DeviceInfoXState = DeviceInfoXState()

    init {
        if (deviceInfoXState.isAndroid) {
            val androidInfo: AndroidInfo = deviceInfoXState.androidInfo
            println("DeviceInfoX - App Name : ${androidInfo.appName}")
        } else if (deviceInfoXState.isIos) {
            val iosInfo: IosInfo = deviceInfoXState.iosInfo
            println("DeviceInfoX - System Name : ${iosInfo.systemName}")
        } else if(deviceInfoXState.isDesktop) {
            val desktopInfo = deviceInfoXState.desktopInfo
            println("DeviceInfoX - System Name : ${desktopInfo.operatingSystem.versionInfo.version}")
        }
    }
}