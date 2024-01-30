@file:Suppress("FunctionName")

package com.devx.kdeviceinfo

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.devx.kdeviceinfo.model.AndroidInfo
import com.devx.kdeviceinfo.model.IosInfo

class AndroidDeviceInfoX : DeviceInfoX {
    override val androidInfo: AndroidInfo
        get() = AndroidInfo()
    override val iosInfo: IosInfo
        get() = throw Exception("trying to access incorrect platform info")
    override val isAndroid: Boolean
        get() = true
    override val isIos: Boolean
        get() = false
}

actual fun DeviceInfoState(): DeviceInfoX = AndroidDeviceInfoX()

@Composable
actual fun rememberDeviceInfoXState(key: Any?): DeviceInfoX {
    return remember(key1 = key) {
        AndroidDeviceInfoX()
    }
}