package com.devx.kdeviceinfo.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.uikit.LocalUIViewController
import com.devx.kdeviceinfo.DeviceInfo
import com.devx.kdeviceinfo.getDeviceInfo
import platform.UIKit.interfaceOrientation

@Composable
actual fun rememberDeviceInfo(): DeviceInfo {
    val orientation = LocalUIViewController.current.interfaceOrientation
    return remember(key1 = orientation) {
        getDeviceInfo()
    }
}
