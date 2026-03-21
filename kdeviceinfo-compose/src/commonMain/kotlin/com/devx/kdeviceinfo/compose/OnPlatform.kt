@file:Suppress("unused", "FunctionName")

package com.devx.kdeviceinfo.compose

import androidx.compose.runtime.Composable
import com.devx.kdeviceinfo.AndroidDeviceInfo
import com.devx.kdeviceinfo.DesktopDeviceInfo
import com.devx.kdeviceinfo.DeviceInfo
import com.devx.kdeviceinfo.IosDeviceInfo
import com.devx.kdeviceinfo.WebDeviceInfo
import com.devx.kdeviceinfo.model.android.AndroidInfo
import com.devx.kdeviceinfo.model.desktop.DesktopInfo
import com.devx.kdeviceinfo.model.ios.IosInfo
import com.devx.kdeviceinfo.model.web.WebInfo

/**
 * Composable that renders platform-specific UI based on [DeviceInfo].
 *
 * Only the block matching the current platform is invoked:
 * ```
 * OnPlatform(
 *     onAndroid = { androidInfo -> Text(androidInfo.model) },
 *     onIos = { iosInfo -> Text(iosInfo.systemName) },
 *     onDesktop = { desktopInfo -> Text(desktopInfo.operatingSystem.family) },
 *     onWeb = { webInfo -> Text(webInfo.browser.name) },
 * )
 * ```
 *
 * @param deviceInfo the device information; defaults to [rememberDeviceInfo]
 * @param onAndroid composable rendered on Android
 * @param onIos composable rendered on iOS
 * @param onDesktop composable rendered on Desktop
 * @param onWeb composable rendered on Web
 */
@Composable
fun OnPlatform(
    deviceInfo: DeviceInfo = rememberDeviceInfo(),
    onAndroid: @Composable ((AndroidInfo) -> Unit)? = null,
    onIos: @Composable ((IosInfo) -> Unit)? = null,
    onDesktop: @Composable ((DesktopInfo) -> Unit)? = null,
    onWeb: @Composable ((WebInfo) -> Unit)? = null,
) {
    when (deviceInfo) {
        is AndroidDeviceInfo -> onAndroid?.invoke(deviceInfo.androidInfo)
        is IosDeviceInfo -> onIos?.invoke(deviceInfo.iosInfo)
        is DesktopDeviceInfo -> onDesktop?.invoke(deviceInfo.desktopInfo)
        is WebDeviceInfo -> onWeb?.invoke(deviceInfo.webInfo)
    }
}
