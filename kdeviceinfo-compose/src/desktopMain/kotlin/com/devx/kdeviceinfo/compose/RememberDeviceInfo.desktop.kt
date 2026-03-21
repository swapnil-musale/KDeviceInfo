package com.devx.kdeviceinfo.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.devx.kdeviceinfo.DeviceInfo
import com.devx.kdeviceinfo.getDeviceInfo

@Composable
actual fun rememberDeviceInfo(): DeviceInfo {
    return remember { getDeviceInfo() }
}
