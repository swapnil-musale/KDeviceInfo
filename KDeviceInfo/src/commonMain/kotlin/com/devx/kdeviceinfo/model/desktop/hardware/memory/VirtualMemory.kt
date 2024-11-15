package com.devx.kdeviceinfo.model.desktop.hardware.memory

interface VirtualMemory {
    val swapTotal: Long
    val swapUsed: Long
    val virtualMax: Long
    val virtualInUse: Long
    val swapPagesIn: Long
    val swapPagesOut: Long
}