@file:Suppress("FunctionName")

package com.devx.kdeviceinfo

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.devx.kdeviceinfo.model.AndroidInfoImpl
import com.devx.kdeviceinfo.model.android.AndroidInfo
import com.devx.kdeviceinfo.model.ios.IosInfo

class AndroidDeviceInfoX : DeviceInfoX {

    private lateinit var cachedAndroidInfo: AndroidInfo
    override val androidInfo: AndroidInfo
        get() {
            if (::cachedAndroidInfo.isInitialized.not()) {
                cachedAndroidInfo = AndroidInfoImpl()
            }
            return cachedAndroidInfo
        }
    override val iosInfo: IosInfo
        get() = throw Exception("trying to access incorrect platform info")
    override val isAndroid: Boolean
        get() = true
    override val isIos: Boolean
        get() = false
}

actual fun DeviceInfoState(): DeviceInfoX = AndroidDeviceInfoX()

@Composable
actual fun rememberDeviceInfoXState(): DeviceInfoX {
    return remember { AndroidDeviceInfoX() }
}