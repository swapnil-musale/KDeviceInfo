package com.devx.kdeviceinfo.compose

import androidx.compose.runtime.Composable
import com.devx.kdeviceinfo.DeviceInfo

/**
 * Remembers and returns the [DeviceInfo] for the current platform.
 *
 * On Android, this recomposes when device orientation changes
 * (via `LocalConfiguration`). On iOS, it recomposes on orientation
 * changes via `LocalUIViewController`. On Desktop and Web,
 * the value is remembered for the lifetime of the composition.
 *
 * ```
 * @Composable
 * fun MyScreen() {
 *     val deviceInfo = rememberDeviceInfo()
 *     when (deviceInfo) {
 *         is AndroidDeviceInfo -> Text(deviceInfo.androidInfo.model)
 *         is IosDeviceInfo -> Text(deviceInfo.iosInfo.systemName)
 *         is DesktopDeviceInfo -> Text(deviceInfo.desktopInfo.operatingSystem.family)
 *         is WebDeviceInfo -> Text(deviceInfo.webInfo.browser.name)
 *     }
 * }
 * ```
 */
@Composable
expect fun rememberDeviceInfo(): DeviceInfo
