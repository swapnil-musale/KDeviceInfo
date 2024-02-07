package com.devx.kdeviceinfo.sample

import com.devx.kdeviceinfo.DeviceInfoState
import com.devx.kdeviceinfo.DeviceInfoXState
import com.devx.kdeviceinfo.model.android.AndroidInfo
import com.devx.kdeviceinfo.model.ios.IosInfo

class AppViewModel {

    private val deviceInfoXState: DeviceInfoXState = DeviceInfoState()

    init {
        if (deviceInfoXState.isAndroid) {
            val androidInfo: AndroidInfo = deviceInfoXState.androidInfo
            println("DeviceInfoX - App Name : ${androidInfo.appName}")
        } else {
            val iosInfo: IosInfo = deviceInfoXState.iosInfo
            println("DeviceInfoX - System Name : ${iosInfo.systemName}")
        }
    }
}