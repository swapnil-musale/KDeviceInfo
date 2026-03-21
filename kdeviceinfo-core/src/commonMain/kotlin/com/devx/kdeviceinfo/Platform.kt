package com.devx.kdeviceinfo

/**
 * Represents the runtime platform the library is executing on.
 *
 * Use with Kotlin's `when` expression for exhaustive, compile-time safe platform branching:
 * ```
 * when (deviceInfo.platform) {
 *     is Platform.Android -> { /* Android-specific logic */ }
 *     is Platform.IOS -> { /* iOS-specific logic */ }
 *     is Platform.Desktop -> { /* Desktop-specific logic */ }
 *     is Platform.Web -> { /* Web-specific logic */ }
 * }
 * ```
 */
sealed class Platform {
    data object Android : Platform()
    data object IOS : Platform()
    data object Desktop : Platform()
    data object Web : Platform()
}
