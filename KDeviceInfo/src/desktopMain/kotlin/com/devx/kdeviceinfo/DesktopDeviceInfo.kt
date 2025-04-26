@file:Suppress("unused")

package com.devx.kdeviceinfo

import androidx.compose.runtime.Composable
import com.devx.kdeviceinfo.model.DesktopInfoImpl
import com.devx.kdeviceinfo.model.android.AndroidInfo
import com.devx.kdeviceinfo.model.common.UnsupportedPlatformException
import com.devx.kdeviceinfo.model.desktop.DesktopInfo
import com.devx.kdeviceinfo.model.ios.IosInfo
import com.devx.kdeviceinfo.model.web.WebInfo

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
        get() = throw UnsupportedPlatformException(
            requestedPlatform = "Android",
            currentPlatform = "Desktop",
        )

    actual val isIos: Boolean
        get() = false

    actual val iosInfo: IosInfo
        get() = throw UnsupportedPlatformException(
            requestedPlatform = "iOS",
            currentPlatform = "Desktop",
        )

    actual val isWeb: Boolean
        get() = false

    actual val webInfo: WebInfo
        get() = throw UnsupportedPlatformException(
            requestedPlatform = "Web",
            currentPlatform = "Desktop",
        )
}

@Composable
actual fun rememberDeviceInfoXState(): DeviceInfoXState {
    return DeviceInfoXState()
}