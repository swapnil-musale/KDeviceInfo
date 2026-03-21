package com.devx.kdeviceinfo.model.common

/**
 * Represents the physical orientation of the device.
 *
 * Replaces the string-based [DeviceOrientation] interface with a type-safe enum:
 * ```
 * when (orientation) {
 *     Orientation.PORTRAIT -> { /* portrait layout */ }
 *     Orientation.LANDSCAPE -> { /* landscape layout */ }
 *     Orientation.UNKNOWN -> { /* fallback */ }
 * }
 * ```
 */
enum class Orientation {
    PORTRAIT,
    LANDSCAPE,
    UNKNOWN
}
