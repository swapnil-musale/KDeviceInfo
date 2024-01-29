package com.devx.kdeviceinfo

import androidx.compose.runtime.Composable
import com.devx.kdeviceinfo.model.AndroidInfo
import com.devx.kdeviceinfo.model.IosInfo
import com.devx.kdeviceinfo.model.Platform

interface DeviceInfoX {
    val currentPlatform: Platform
    val androidInfo: AndroidInfo
    val iosInfo: IosInfo
}

expect fun DeviceInfoState(): DeviceInfoX

@Composable
expect fun rememberDeviceInfoXState(): DeviceInfoX