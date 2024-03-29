@file:Suppress("FunctionName", "unused")

package com.devx.kdeviceinfo

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.devx.kdeviceinfo.model.IosInfoImpl
import com.devx.kdeviceinfo.model.android.AndroidInfo
import com.devx.kdeviceinfo.model.ios.IosInfo

actual class DeviceInfoXState {

    private lateinit var cachedIosInfo: IosInfo

    actual val androidInfo: AndroidInfo
        get() = throw Exception("trying to access incorrect platform info")
    actual val iosInfo: IosInfo
        get() {
            if (::cachedIosInfo.isInitialized.not()) {
                cachedIosInfo = IosInfoImpl()
            }
            return cachedIosInfo
        }
    actual val isAndroid: Boolean
        get() = false
    actual val isIos: Boolean
        get() = true
}

@Composable
actual fun rememberDeviceInfoXState(): DeviceInfoXState {
    return remember { DeviceInfoXState() }
}