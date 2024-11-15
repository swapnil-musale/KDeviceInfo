package com.devx.kdeviceinfo.model.desktop.hardware.computersystem

interface Baseboard {
    val manufacturer: String
    val model: String
    val version: String
    val serialNumber: String
}