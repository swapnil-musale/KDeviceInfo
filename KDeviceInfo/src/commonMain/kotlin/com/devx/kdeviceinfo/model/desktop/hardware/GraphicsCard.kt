package com.devx.kdeviceinfo.model.desktop.hardware

interface GraphicsCard {
    val name: String
    val deviceId: String
    val vendor: String
    val versionInfo: String
    val VRam: Long
}