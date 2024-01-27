package com.devx.kdeviceinfo

import com.devx.kdeviceinfo.model.AndroidInfo
import com.devx.kdeviceinfo.model.IosInfo
import com.devx.kdeviceinfo.model.Platform

actual class DeviceInfoX {
    actual val currentPlatform: Platform
        get() = Platform.ANDROID
    internal actual val androidInfo: AndroidInfo
        get() = AndroidInfo()
    internal actual val iosInfo: IosInfo
        get() = throw Exception("trying to access incorrect platform")
}