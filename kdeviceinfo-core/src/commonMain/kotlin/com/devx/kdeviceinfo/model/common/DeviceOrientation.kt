@file:Suppress("PropertyName")

package com.devx.kdeviceinfo.model.common

/**
 * @deprecated Use [Orientation] enum instead, which provides type-safe
 * orientation handling without stringly-typed values.
 */
@Deprecated(
    message = "Use Orientation enum instead for type-safe orientation handling.",
    replaceWith = ReplaceWith("Orientation", "com.devx.kdeviceinfo.model.common.Orientation")
)
interface DeviceOrientation {
    val UNKNOWN: String
    val PORTRAIT: String
    val LANDSCAPE: String
    val isPortrait: Boolean
    val isLandscape: Boolean

    fun getDeviceOrientation(): String
}
