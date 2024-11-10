package com.devx.kdeviceinfo.model.hardware.memory

import com.devx.kdeviceinfo.model.desktop.hardware.memory.PhysicalMemory

class PhysicalMemoryImpl(
    override val bankLabel: String,
    override val capacity: Long,
    override val clockSpeed: Long,
    override val manufacturer: String,
    override val memoryType: String,
    override val partNumber: String,
    override val serialNumber: String
) : PhysicalMemory