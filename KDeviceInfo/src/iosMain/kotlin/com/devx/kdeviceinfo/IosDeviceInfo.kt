@file:Suppress("FunctionName", "unused")

package com.devx.kdeviceinfo

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.devx.kdeviceinfo.model.IosInfoImpl
import com.devx.kdeviceinfo.model.android.AndroidInfo
import com.devx.kdeviceinfo.model.ios.IosInfo

internal class IosDeviceInfoXState : DeviceInfoXState {

    private lateinit var cachedIosInfo: IosInfo

    override val androidInfo: AndroidInfo
        get() = throw Exception("trying to access incorrect platform info")
    override val iosInfo: IosInfo
        get() {
            if (::cachedIosInfo.isInitialized.not()) {
                cachedIosInfo = IosInfoImpl()
            }
            return cachedIosInfo
        }
    override val isAndroid: Boolean
        get() = false
    override val isIos: Boolean
        get() = true
}

actual fun DeviceInfoState(): DeviceInfoXState = IosDeviceInfoXState()

@Composable
actual fun rememberDeviceInfoXState(): DeviceInfoXState {
    return remember { IosDeviceInfoXState() }
}