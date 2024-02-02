@file:Suppress("FunctionName", "unused")

package com.devx.kdeviceinfo

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import com.devx.kdeviceinfo.model.AndroidInfoImpl
import com.devx.kdeviceinfo.model.android.AndroidInfo
import com.devx.kdeviceinfo.model.ios.IosInfo

class AndroidDeviceInfoX(private val context: Context? = null) : DeviceInfoX {

    private lateinit var cachedAndroidInfo: AndroidInfo
    override val androidInfo: AndroidInfo
        get() {
            if (::cachedAndroidInfo.isInitialized.not() && context != null) {
                cachedAndroidInfo = AndroidInfoImpl(context = context)
            }
            return cachedAndroidInfo
        }
    override val iosInfo: IosInfo
        get() = throw Exception("trying to access incorrect platform info")
    override val isAndroid: Boolean
        get() = true
    override val isIos: Boolean
        get() = false
}

actual fun DeviceInfoState(): DeviceInfoX = AndroidDeviceInfoX()

@Composable
actual fun rememberDeviceInfoXState(): DeviceInfoX {
    val context = LocalContext.current
    return remember { AndroidDeviceInfoX(context = context) }
}