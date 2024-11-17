package com.devx.kdeviceinfo.model.hardware.memory

import com.devx.kdeviceinfo.model.desktop.hardware.memory.VirtualMemory

class VirtualMemoryImpl(private val virtualMemory: oshi.hardware.VirtualMemory) : VirtualMemory {

    override val swapTotal: Long
        get() = virtualMemory.swapTotal

    override val swapUsed: Long
        get() = virtualMemory.swapUsed

    override val virtualMax: Long
        get() = virtualMemory.virtualMax

    override val virtualInUse: Long
        get() = virtualMemory.virtualInUse

    override val swapPagesIn: Long
        get() = virtualMemory.swapPagesIn

    override val swapPagesOut: Long
        get() = virtualMemory.swapPagesOut
}