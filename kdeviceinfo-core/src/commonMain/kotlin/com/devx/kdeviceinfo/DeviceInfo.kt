package com.devx.kdeviceinfo

import com.devx.kdeviceinfo.model.android.AndroidInfo
import com.devx.kdeviceinfo.model.desktop.DesktopInfo
import com.devx.kdeviceinfo.model.ios.IosInfo
import com.devx.kdeviceinfo.model.web.WebInfo

/**
 * Sealed interface representing device information for the current platform.
 *
 * Use Kotlin's `when` expression for compile-time exhaustive platform handling:
 * ```
 * when (val info = getDeviceInfo()) {
 *     is AndroidDeviceInfo -> info.androidInfo.appName
 *     is IosDeviceInfo -> info.iosInfo.systemName
 *     is DesktopDeviceInfo -> info.desktopInfo.operatingSystem.family
 *     is WebDeviceInfo -> info.webInfo.browser.name
 * }
 * ```
 *
 * The sealed hierarchy guarantees that only the four platform-specific sub-interfaces
 * exist, so `when` expressions are exhaustive without an `else` branch.
 */
sealed interface DeviceInfo {
    val platform: Platform
}

/**
 * Device information available when running on Android.
 *
 * Access Android-specific data through [androidInfo].
 */
interface AndroidDeviceInfo : DeviceInfo {
    override val platform: Platform
        get() = Platform.Android
    val androidInfo: AndroidInfo
}

/**
 * Device information available when running on iOS.
 *
 * Access iOS-specific data through [iosInfo].
 */
interface IosDeviceInfo : DeviceInfo {
    override val platform: Platform
        get() = Platform.IOS
    val iosInfo: IosInfo
}

/**
 * Device information available when running on Desktop (macOS, Windows, Linux).
 *
 * Access desktop-specific data through [desktopInfo].
 */
interface DesktopDeviceInfo : DeviceInfo {
    override val platform: Platform
        get() = Platform.Desktop
    val desktopInfo: DesktopInfo
}

/**
 * Device information available when running on Web (WASM).
 *
 * Access web-specific data through [webInfo].
 */
interface WebDeviceInfo : DeviceInfo {
    override val platform: Platform
        get() = Platform.Web
    val webInfo: WebInfo
}

/**
 * Returns the [DeviceInfo] for the current platform.
 *
 * This is the primary entry point for obtaining device information.
 * Each platform provides its own implementation via the expect/actual mechanism.
 *
 * For dependency injection and testing, prefer [DeviceInfoProvider] instead.
 *
 * @see DeviceInfoProvider
 */
expect fun getDeviceInfo(): DeviceInfo
