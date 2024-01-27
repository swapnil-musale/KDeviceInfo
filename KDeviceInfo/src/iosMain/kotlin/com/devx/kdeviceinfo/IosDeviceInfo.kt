package com.devx.kdeviceinfo

import com.devx.kdeviceinfo.model.AndroidInfo
import com.devx.kdeviceinfo.model.IosInfo
import com.devx.kdeviceinfo.model.Platform

actual class DeviceInfoX {
    actual val currentPlatform: Platform
        get() = Platform.IOS

    internal actual val androidInfo: AndroidInfo
        get() = throw Exception("Incorrect platform trying to access")
    internal actual val iosInfo: IosInfo
        get() = IosInfo()
}