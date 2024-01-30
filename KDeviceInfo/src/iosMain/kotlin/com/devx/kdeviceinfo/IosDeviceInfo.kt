@file:Suppress("FunctionName")

package com.devx.kdeviceinfo

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.devx.kdeviceinfo.model.AndroidInfo
import com.devx.kdeviceinfo.model.IosInfo

class IosDeviceInfoX : DeviceInfoX {
    override val androidInfo: AndroidInfo
        get() = throw Exception("trying to access incorrect platform info")
    override val iosInfo: IosInfo
        get() = IosInfo()
    override val isAndroid: Boolean
        get() = false
    override val isIos: Boolean
        get() = true
}

actual fun DeviceInfoState(): DeviceInfoX = IosDeviceInfoX()

@Composable
actual fun rememberDeviceInfoXState(key: Any?): DeviceInfoX {
    return remember(key1 = key) { IosDeviceInfoX() }
}