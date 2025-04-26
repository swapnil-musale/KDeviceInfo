package com.devx.kdeviceinfo

import androidx.compose.runtime.Composable
import com.devx.kdeviceinfo.model.WebInfoImpl
import com.devx.kdeviceinfo.model.android.AndroidInfo
import com.devx.kdeviceinfo.model.common.UnsupportedPlatformException
import com.devx.kdeviceinfo.model.desktop.DesktopInfo
import com.devx.kdeviceinfo.model.ios.IosInfo
import com.devx.kdeviceinfo.model.web.WebInfo

actual class DeviceInfoXState {

    private val webInfoData: WebInfo by lazy {
        WebInfoImpl()
    }

    actual val isWeb: Boolean
        get() = true

    actual val webInfo: WebInfo
        get() = webInfoData

    actual val isAndroid: Boolean
        get() = false

    actual val androidInfo: AndroidInfo
        get() = throw UnsupportedPlatformException(
            requestedPlatform = "Android",
            currentPlatform = "Web",
        )

    actual val isIos: Boolean
        get() = false

    actual val iosInfo: IosInfo
        get() = throw UnsupportedPlatformException(
            requestedPlatform = "iOS",
            currentPlatform = "Web",
        )

    actual val isDesktop: Boolean
        get() = false

    actual val desktopInfo: DesktopInfo
        get() = throw UnsupportedPlatformException(
            requestedPlatform = "Desktop",
            currentPlatform = "Web",
        )
}

@Composable
actual fun rememberDeviceInfoXState(): DeviceInfoXState {
    return DeviceInfoXState()
}