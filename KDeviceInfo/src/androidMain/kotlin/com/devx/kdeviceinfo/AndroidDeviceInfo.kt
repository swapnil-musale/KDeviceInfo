package com.devx.kdeviceinfo

import com.devx.kdeviceinfo.model.AndroidInfo
import com.devx.kdeviceinfo.model.IosInfo
import com.devx.kdeviceinfo.model.Platform

actual class DeviceInfoX {
    actual val currentPlatform: Platform
        get() = Platform.ANDROID
    actual val androidInfo: AndroidInfo
        get() = AndroidInfo()
    actual val iosInfo: IosInfo
        get() = throw Exception("Incorrect platform trying to access")
}