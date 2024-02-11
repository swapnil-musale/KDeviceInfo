@file:Suppress("FunctionName", "unused")

package com.devx.kdeviceinfo

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.devx.kdeviceinfo.model.AndroidInfoImpl
import com.devx.kdeviceinfo.model.android.AndroidInfo
import com.devx.kdeviceinfo.model.ios.IosInfo

actual class DeviceInfoXState {

    private lateinit var cachedAndroidInfo: AndroidInfo

    actual val androidInfo: AndroidInfo
        get() {
            if (::cachedAndroidInfo.isInitialized.not()) {
                cachedAndroidInfo = AndroidInfoImpl()
            }
            return cachedAndroidInfo
        }
    actual val iosInfo: IosInfo
        get() = throw Exception("trying to access incorrect platform info")
    actual val isAndroid: Boolean
        get() = true
    actual val isIos: Boolean
        get() = false
}

@Composable
actual fun rememberDeviceInfoXState(): DeviceInfoXState {
    return remember { DeviceInfoXState() }
}