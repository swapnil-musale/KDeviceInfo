package com.devx.kdeviceinfo.model.desktop.hardware.memory

interface GlobalMemory {
    val total: Long
    val available: Long
    val pageSize: Long
    val virtualMemory: VirtualMemory
    val physicalMemory: List<PhysicalMemory>
}