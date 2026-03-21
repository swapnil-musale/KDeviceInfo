package com.devx.kdeviceinfo.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalConfiguration
import com.devx.kdeviceinfo.DeviceInfo
import com.devx.kdeviceinfo.getDeviceInfo

@Composable
actual fun rememberDeviceInfo(): DeviceInfo {
    val orientation = LocalConfiguration.current.orientation
    return remember(key1 = orientation) {
        getDeviceInfo()
    }
}
