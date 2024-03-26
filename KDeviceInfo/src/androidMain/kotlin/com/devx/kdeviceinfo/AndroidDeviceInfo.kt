@file:Suppress("FunctionName", "unused")

package com.devx.kdeviceinfo

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalConfiguration
import com.devx.kdeviceinfo.model.AndroidInfoImpl
import com.devx.kdeviceinfo.model.android.AndroidInfo
import com.devx.kdeviceinfo.model.ios.IosInfo

actual class DeviceInfoXState {

    private val androidInfoData: AndroidInfo by lazy {
        AndroidInfoImpl()
    }

    actual val androidInfo: AndroidInfo
        get() = androidInfoData
    actual val iosInfo: IosInfo
        get() = throw Exception("trying to access incorrect platform info")
    actual val isAndroid: Boolean
        get() = true
    actual val isIos: Boolean
        get() = false
}

@Composable
actual fun rememberDeviceInfoXState(): DeviceInfoXState {
    val orientation = LocalConfiguration.current.orientation
    return remember(key1 = orientation) { DeviceInfoXState() }
}