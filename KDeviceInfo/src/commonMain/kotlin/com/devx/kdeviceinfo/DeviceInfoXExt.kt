@file:Suppress("unused")

package com.devx.kdeviceinfo

import androidx.compose.runtime.Composable
import com.devx.kdeviceinfo.model.android.AndroidInfo
import com.devx.kdeviceinfo.model.desktop.DesktopInfo
import com.devx.kdeviceinfo.model.ios.IosInfo
import com.devx.kdeviceinfo.model.web.WebInfo

@Composable
fun OnPlatform(
    deviceInfoXState: DeviceInfoXState = rememberDeviceInfoXState(),
    onAndroid: @Composable ((AndroidInfo) -> Unit)? = null,
    onIos: @Composable ((IosInfo) -> Unit)? = null,
    onDesktop: @Composable ((DesktopInfo) -> Unit)? = null,
    onWeb: @Composable ((WebInfo) -> Unit)? = null,
) {
    if (deviceInfoXState.isAndroid) {
        onAndroid?.invoke(deviceInfoXState.androidInfo)
    } else if(deviceInfoXState.isIos){
        onIos?.invoke(deviceInfoXState.iosInfo)
    } else if(deviceInfoXState.isDesktop) {
        onDesktop?.invoke(deviceInfoXState.desktopInfo)
    } else {
        onWeb?.invoke(deviceInfoXState.webInfo)
    }
}

fun onPlatform(
    deviceInfoXState: DeviceInfoXState = DeviceInfoXState(),
    onAndroid: ((AndroidInfo) -> Unit)? = null,
    onIos: ((IosInfo) -> Unit)? = null,
    onDesktop: ((DesktopInfo) -> Unit)? = null,
    onWeb: ((WebInfo) -> Unit)? = null
) {
    if (deviceInfoXState.isAndroid) {
        onAndroid?.invoke(deviceInfoXState.androidInfo)
    } else if(deviceInfoXState.isIos){
        onIos?.invoke(deviceInfoXState.iosInfo)
    } else if(deviceInfoXState.isDesktop) {
        onDesktop?.invoke(deviceInfoXState.desktopInfo)
    } else {
        onWeb?.invoke(deviceInfoXState.webInfo)
    }
}