package com.devx.kdeviceinfo.model.desktop.hardware.computersystem

interface Firmware {
    val manufacturer: String
    val name: String
    val description: String
    val version: String
    val releaseDate: String
}