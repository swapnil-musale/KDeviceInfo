@file:Suppress("unused")

package com.devx.kdeviceinfo

import com.devx.kdeviceinfo.model.android.AndroidInfo
import com.devx.kdeviceinfo.model.desktop.DesktopInfo
import com.devx.kdeviceinfo.model.ios.IosInfo
import com.devx.kdeviceinfo.model.web.WebInfo

/**
 * Marker annotation for the platform DSL to prevent scope leaking.
 */
@DslMarker
annotation class PlatformDslMarker

/**
 * Scope class for the [onPlatform] DSL.
 *
 * Provides platform-specific builder functions that execute only on the matching platform.
 * At most one block will execute per invocation.
 *
 * @param T the return type of the platform blocks
 */
@PlatformDslMarker
class PlatformScope<T> @PublishedApi internal constructor(
    @PublishedApi internal val deviceInfo: DeviceInfo
) {
    @PublishedApi
    internal var result: T? = null

    @PublishedApi
    internal var matched: Boolean = false

    /**
     * Executes [block] with [AndroidInfo] if the current platform is Android.
     */
    inline fun android(block: (AndroidInfo) -> T) {
        if (!matched && deviceInfo is AndroidDeviceInfo) {
            result = block(deviceInfo.androidInfo)
            matched = true
        }
    }

    /**
     * Executes [block] with [IosInfo] if the current platform is iOS.
     */
    inline fun ios(block: (IosInfo) -> T) {
        if (!matched && deviceInfo is IosDeviceInfo) {
            result = block(deviceInfo.iosInfo)
            matched = true
        }
    }

    /**
     * Executes [block] with [DesktopInfo] if the current platform is Desktop.
     */
    inline fun desktop(block: (DesktopInfo) -> T) {
        if (!matched && deviceInfo is DesktopDeviceInfo) {
            result = block(deviceInfo.desktopInfo)
            matched = true
        }
    }

    /**
     * Executes [block] with [WebInfo] if the current platform is Web.
     */
    inline fun web(block: (WebInfo) -> T) {
        if (!matched && deviceInfo is WebDeviceInfo) {
            result = block(deviceInfo.webInfo)
            matched = true
        }
    }
}

/**
 * Type-safe DSL for platform-specific logic that returns a value.
 *
 * Unlike [kotlin.when], this DSL provides platform-specific info objects
 * directly to each block, reducing boilerplate:
 *
 * ```
 * val appLabel: String = onPlatform(deviceInfo) {
 *     android { it.appName }
 *     ios { it.systemName }
 *     desktop { it.operatingSystem.family }
 *     web { it.browser.name }
 * }
 * ```
 *
 * @param T the return type produced by whichever platform block matches
 * @param deviceInfo the [DeviceInfo] to match against
 * @param block builder lambda where platform-specific blocks are declared
 * @return the value produced by the matching platform block
 * @throws IllegalStateException if no platform block matched
 */
inline fun <T> onPlatform(
    deviceInfo: DeviceInfo,
    block: PlatformScope<T>.() -> Unit
): T {
    val scope = PlatformScope<T>(deviceInfo)
    scope.block()
    if (!scope.matched) {
        throw IllegalStateException(
            "No platform handler matched for ${deviceInfo.platform}. " +
                "Ensure you have registered a handler for the current platform."
        )
    }
    @Suppress("UNCHECKED_CAST")
    return scope.result as T
}
