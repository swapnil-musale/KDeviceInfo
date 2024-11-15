@file:Suppress("unused")

package com.devx.kdeviceinfo

import androidx.compose.runtime.Composable
import com.devx.kdeviceinfo.model.DesktopInfoImpl
import com.devx.kdeviceinfo.model.android.AndroidInfo
import com.devx.kdeviceinfo.model.desktop.DesktopInfo
import com.devx.kdeviceinfo.model.ios.IosInfo

actual class DeviceInfoXState {

    private val desktopInfoData: DesktopInfo by lazy {
        DesktopInfoImpl()
    }

    actual val isDesktop: Boolean
        get() = true

    actual val desktopInfo: DesktopInfo
        get() = desktopInfoData

    actual val isAndroid: Boolean
        get() = false

    actual val androidInfo: AndroidInfo
        get() = throw Exception("trying to access incorrect platform info")

    actual val isIos: Boolean
        get() = false

    actual val iosInfo: IosInfo
        get() = throw Exception("trying to access incorrect platform info")
}

@Composable
actual fun rememberDeviceInfoXState(): DeviceInfoXState {
    return DeviceInfoXState()
}