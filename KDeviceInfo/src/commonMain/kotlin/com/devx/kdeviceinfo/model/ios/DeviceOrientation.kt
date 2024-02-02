@file:Suppress("PropertyName")

package com.devx.kdeviceinfo.model.ios

interface DeviceOrientation {
    val UNKNOWN: String
    val PORTRAIT: String
    val LANDSCAPE: String
    val PORTRAIT_UPSIDE_DOWN: String
    val LANDSCAPE_LEFT: String
    val LANDSCAPE_RIGHT: String
    val FACE_UP: String
    val FACE_DOWN: String
    val isPortrait: Boolean
    fun getDeviceOrientation(): String
}