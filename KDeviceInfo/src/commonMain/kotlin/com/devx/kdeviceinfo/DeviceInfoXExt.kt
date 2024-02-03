@file:Suppress("unused")

package com.devx.kdeviceinfo

import androidx.compose.runtime.Composable
import com.devx.kdeviceinfo.model.android.AndroidInfo
import com.devx.kdeviceinfo.model.ios.IosInfo

@Composable
fun OnPlatform(
    onAndroid: @Composable ((AndroidInfo) -> Unit)? = null,
    onIos: @Composable ((IosInfo) -> Unit)? = null,
) {
    val deviceInfoXState = rememberDeviceInfoXState()
    if (deviceInfoXState.isAndroid) {
        onAndroid?.invoke(deviceInfoXState.androidInfo)
    } else {
        onIos?.invoke(deviceInfoXState.iosInfo)
    }
}

fun onPlatform(
    onAndroid: ((AndroidInfo) -> Unit)? = null,
    onIos: ((IosInfo) -> Unit)? = null,
) {
    val deviceInfoXState = DeviceInfoState()
    if (deviceInfoXState.isAndroid) {
        onAndroid?.invoke(deviceInfoXState.androidInfo)
    } else {
        onIos?.invoke(deviceInfoXState.iosInfo)
    }
}