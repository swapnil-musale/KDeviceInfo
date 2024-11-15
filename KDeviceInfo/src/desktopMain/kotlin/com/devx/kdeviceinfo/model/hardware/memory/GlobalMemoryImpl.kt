package com.devx.kdeviceinfo.model.hardware.memory

import com.devx.kdeviceinfo.model.desktop.hardware.memory.GlobalMemory
import com.devx.kdeviceinfo.model.desktop.hardware.memory.PhysicalMemory
import com.devx.kdeviceinfo.model.desktop.hardware.memory.VirtualMemory

class GlobalMemoryImpl(private val globalMemory: oshi.hardware.GlobalMemory) : GlobalMemory {

    private val virtualMemoryImpl by lazy {
        VirtualMemoryImpl(virtualMemory = globalMemory.virtualMemory)
    }

    override val total: Long
        get() = globalMemory.total

    override val available: Long
        get() = globalMemory.available

    override val pageSize: Long
        get() = globalMemory.pageSize

    override val virtualMemory: VirtualMemory
        get() = virtualMemoryImpl

    override val physicalMemory: List<PhysicalMemory>
        get() = loadPhysicalMemories(sourceList = globalMemory.physicalMemory)

    private fun loadPhysicalMemories(sourceList: List<oshi.hardware.PhysicalMemory>): List<PhysicalMemory> {
        val result = mutableListOf<PhysicalMemory>()
        sourceList.forEach { physicalMemory ->
            result.add(
                PhysicalMemoryImpl(
                    bankLabel = physicalMemory.bankLabel,
                    capacity = physicalMemory.capacity,
                    clockSpeed = physicalMemory.clockSpeed,
                    manufacturer = physicalMemory.manufacturer,
                    memoryType = physicalMemory.memoryType,
                    partNumber = physicalMemory.partNumber,
                    serialNumber = physicalMemory.serialNumber
                )
            )
        }
        return result
    }
}