package com.devx.kdeviceinfo.model

enum class UIDeviceOrientation(val orientation: String) {
    UNKNOWN(orientation = "unknown"),
    PORTRAIT(orientation = "portrait"),
    PORTRAIT_UPSIDE_DOWN(orientation = "portraitUpsideDown"),
    LANDSCAPE_LEFT(orientation = "landscapeLeft"),
    LANDSCAPE_RIGHT(orientation = "landscapeRight"),
    FACE_UP(orientation = "faceUp"),
    FACE_DOWN(orientation = "faceDown"),
}