package com.devx.kdeviceinfo.model.desktop.hardware.computersystem

interface ComputerSystem {
    val manufacturer: String
    val model: String
    val serialNumber: String
    val hardwareUUID: String
    val firmware: Firmware
    val baseboard: Baseboard
}