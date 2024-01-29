package com.devx.kdeviceinfo

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.devx.kdeviceinfo.model.AndroidInfo
import com.devx.kdeviceinfo.model.IosInfo
import com.devx.kdeviceinfo.model.Platform

class AndroidDeviceInfoX : DeviceInfoX {
    override val currentPlatform: Platform
        get() = Platform.ANDROID
    override val androidInfo: AndroidInfo
        get() = AndroidInfo()
    override val iosInfo: IosInfo
        get() = throw Exception("trying to access incorrect platform info")
}

actual fun DeviceInfoState(): DeviceInfoX = AndroidDeviceInfoX()

@Composable
actual fun rememberDeviceInfoXState(): DeviceInfoX {
    return remember { mutableStateOf(value = AndroidDeviceInfoX()) }.value
}