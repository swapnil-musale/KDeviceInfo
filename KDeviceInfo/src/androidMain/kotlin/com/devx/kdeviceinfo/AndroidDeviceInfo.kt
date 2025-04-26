@file:Suppress("unused")

package com.devx.kdeviceinfo

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalConfiguration
import com.devx.kdeviceinfo.model.AndroidInfoImpl
import com.devx.kdeviceinfo.model.android.AndroidInfo
import com.devx.kdeviceinfo.model.common.UnsupportedPlatformException
import com.devx.kdeviceinfo.model.desktop.DesktopInfo
import com.devx.kdeviceinfo.model.ios.IosInfo
import com.devx.kdeviceinfo.model.web.WebInfo

actual class DeviceInfoXState {

    private val androidInfoData: AndroidInfo by lazy {
        AndroidInfoImpl()
    }

    actual val isAndroid: Boolean
        get() = true

    actual val androidInfo: AndroidInfo
        get() = androidInfoData

    actual val isIos: Boolean
        get() = false

    actual val iosInfo: IosInfo
        get() = throw UnsupportedPlatformException(
            requestedPlatform = "iOS",
            currentPlatform = "Android",
        )

    actual val isDesktop: Boolean
        get() = false

    actual val desktopInfo: DesktopInfo
        get() = throw UnsupportedPlatformException(
            requestedPlatform = "Desktop",
            currentPlatform = "Android",
        )

    actual val isWeb: Boolean
        get() = false

    actual val webInfo: WebInfo
        get() = throw UnsupportedPlatformException(
            requestedPlatform = "Web",
            currentPlatform = "Android",
        )
}

@Composable
actual fun rememberDeviceInfoXState(): DeviceInfoXState {
    val orientation = LocalConfiguration.current.orientation
    return remember(key1 = orientation) { DeviceInfoXState() }
}