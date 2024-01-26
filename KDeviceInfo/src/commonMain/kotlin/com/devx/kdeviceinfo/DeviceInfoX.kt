package com.devx.kdeviceinfo

import com.devx.kdeviceinfo.model.AndroidInfo
import com.devx.kdeviceinfo.model.IosInfo
import com.devx.kdeviceinfo.model.Platform

expect class DeviceInfoX {
    val currentPlatform: Platform
    val androidInfo: AndroidInfo
    val iosInfo: IosInfo
}