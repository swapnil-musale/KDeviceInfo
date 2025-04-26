@file:Suppress("unused")

package com.devx.kdeviceinfo

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.interop.LocalUIViewController
import com.devx.kdeviceinfo.model.IosInfoImpl
import com.devx.kdeviceinfo.model.android.AndroidInfo
import com.devx.kdeviceinfo.model.common.UnsupportedPlatformException
import com.devx.kdeviceinfo.model.desktop.DesktopInfo
import com.devx.kdeviceinfo.model.ios.IosInfo
import com.devx.kdeviceinfo.model.web.WebInfo
import platform.UIKit.interfaceOrientation

actual class DeviceInfoXState {

    private val iosInfoData: IosInfo by lazy {
        IosInfoImpl()
    }

    actual val isIos: Boolean
        get() = true

    actual val iosInfo: IosInfo
        get() = iosInfoData

    actual val isAndroid: Boolean
        get() = false

    actual val androidInfo: AndroidInfo
        get() = throw UnsupportedPlatformException(
            requestedPlatform = "Android",
            currentPlatform = "iOS",
        )

    actual val isDesktop: Boolean
        get() = false

    actual val desktopInfo: DesktopInfo
        get() = throw UnsupportedPlatformException(
            requestedPlatform = "Desktop",
            currentPlatform = "iOS",
        )

    actual val isWeb: Boolean
        get() = false

    actual val webInfo: WebInfo
        get() = throw UnsupportedPlatformException(
            requestedPlatform = "Web",
            currentPlatform = "iOS",
        )
}

@Composable
actual fun rememberDeviceInfoXState(): DeviceInfoXState {
    val orientation = LocalUIViewController.current.interfaceOrientation
    return remember(key1 = orientation) { DeviceInfoXState() }
}