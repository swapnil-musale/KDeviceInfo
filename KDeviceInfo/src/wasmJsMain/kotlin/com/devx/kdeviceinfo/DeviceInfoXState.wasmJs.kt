package com.devx.kdeviceinfo

import androidx.compose.runtime.Composable
import com.devx.kdeviceinfo.model.WebInfoImpl
import com.devx.kdeviceinfo.model.android.AndroidInfo
import com.devx.kdeviceinfo.model.desktop.DesktopInfo
import com.devx.kdeviceinfo.model.ios.IosInfo
import com.devx.kdeviceinfo.model.web.WebInfo

actual class DeviceInfoXState {

    private val webInfoData: WebInfo by lazy {
        WebInfoImpl()
    }

    actual val isDesktop: Boolean
        get() = false

    actual val desktopInfo: DesktopInfo
        get() = throw Exception("trying to access incorrect platform info")

    actual val isAndroid: Boolean
        get() = false

    actual val androidInfo: AndroidInfo
        get() = throw Exception("trying to access incorrect platform info")

    actual val isIos: Boolean
        get() = false

    actual val iosInfo: IosInfo
        get() = throw Exception("trying to access incorrect platform info")

    actual val webInfo: WebInfo
        get() = webInfoData

    actual val isWeb: Boolean
        get() = true

}

@Composable
actual fun rememberDeviceInfoXState(): DeviceInfoXState {
    return DeviceInfoXState()
}