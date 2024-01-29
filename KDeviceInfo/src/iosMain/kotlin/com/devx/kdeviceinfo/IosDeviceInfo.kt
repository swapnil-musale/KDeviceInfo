package com.devx.kdeviceinfo

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.devx.kdeviceinfo.model.AndroidInfo
import com.devx.kdeviceinfo.model.IosInfo
import com.devx.kdeviceinfo.model.Platform
import platform.UIKit.UIApplication

class IosDeviceInfoX : DeviceInfoX {
    override val currentPlatform: Platform
        get() = Platform.IOS

    override val androidInfo: AndroidInfo
        get() = throw Exception("trying to access incorrect platform info")
    override val iosInfo: IosInfo
        get() = IosInfo()
}

actual fun DeviceInfoState() : DeviceInfoX =  IosDeviceInfoX()

@Composable
actual fun rememberDeviceInfoXState(): DeviceInfoX {
    UIApplication.sharedApplication.keyWindow?.rootViewController?.beingPresented?.let {
    }
    val state by remember { mutableStateOf(value = IosDeviceInfoX()) }

    return state
}