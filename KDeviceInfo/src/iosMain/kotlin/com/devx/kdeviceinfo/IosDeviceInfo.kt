@file:Suppress("FunctionName")

package com.devx.kdeviceinfo

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.devx.kdeviceinfo.model.IosInfoImpl
import com.devx.kdeviceinfo.model.android.AndroidInfo
import com.devx.kdeviceinfo.model.ios.IosInfo

class IosDeviceInfoX : DeviceInfoX {

    private val cachedAndroidInfo: IosInfoImpl? = null

    override val androidInfo: AndroidInfo
        get() = throw Exception("trying to access incorrect platform info")
    override val iosInfo: IosInfo
        get() = cachedAndroidInfo ?: IosInfoImpl()
    override val isAndroid: Boolean
        get() = false
    override val isIos: Boolean
        get() = true
}

actual fun DeviceInfoState(): DeviceInfoX = IosDeviceInfoX()

@Composable
actual fun rememberDeviceInfoXState(): DeviceInfoX {
    return remember { IosDeviceInfoX() }
}