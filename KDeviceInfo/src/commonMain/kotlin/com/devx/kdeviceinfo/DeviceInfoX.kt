@file:Suppress("FunctionName")

package com.devx.kdeviceinfo

import androidx.compose.runtime.Composable
import com.devx.kdeviceinfo.model.android.AndroidInfo
import com.devx.kdeviceinfo.model.ios.IosInfo

interface DeviceInfoX {
    val isAndroid: Boolean
    val androidInfo: AndroidInfo
    val isIos: Boolean
    val iosInfo: IosInfo
}

expect fun DeviceInfoState(): DeviceInfoX

@Composable
expect fun rememberDeviceInfoXState(): DeviceInfoX