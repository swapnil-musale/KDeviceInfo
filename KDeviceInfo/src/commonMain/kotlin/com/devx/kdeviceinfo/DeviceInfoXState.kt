@file:Suppress("FunctionName")

package com.devx.kdeviceinfo

import androidx.compose.runtime.Composable
import com.devx.kdeviceinfo.model.android.AndroidInfo
import com.devx.kdeviceinfo.model.desktop.DesktopInfo
import com.devx.kdeviceinfo.model.ios.IosInfo

expect class DeviceInfoXState() {
    val isAndroid: Boolean
    val androidInfo: AndroidInfo
    val isIos: Boolean
    val iosInfo: IosInfo
    val isDesktop: Boolean
    val desktopInfo: DesktopInfo
}

@Composable
expect fun rememberDeviceInfoXState(): DeviceInfoXState