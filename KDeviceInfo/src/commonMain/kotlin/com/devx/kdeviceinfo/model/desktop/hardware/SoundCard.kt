package com.devx.kdeviceinfo.model.desktop.hardware

interface SoundCard {
    val driverVersion: String
    val name: String
    val codec: String
}