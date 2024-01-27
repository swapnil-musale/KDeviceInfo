package com.devx.kdeviceinfo

import com.devx.kdeviceinfo.model.AndroidInfo
import com.devx.kdeviceinfo.model.IosInfo
import com.devx.kdeviceinfo.model.Platform

expect class DeviceInfoX() {
    val currentPlatform: Platform
    internal val androidInfo: AndroidInfo
    internal val iosInfo: IosInfo
}