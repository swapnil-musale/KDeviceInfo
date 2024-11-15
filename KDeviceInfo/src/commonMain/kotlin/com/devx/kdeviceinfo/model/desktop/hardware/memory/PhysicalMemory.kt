package com.devx.kdeviceinfo.model.desktop.hardware.memory

interface PhysicalMemory {
    val bankLabel: String
    val capacity: Long
    val clockSpeed: Long
    val manufacturer: String
    val memoryType: String
    val partNumber: String
    val serialNumber: String
}