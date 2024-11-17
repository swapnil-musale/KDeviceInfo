package com.devx.kdeviceinfo.model.desktop.hardware.centralprocessor

interface CentralProcessor {
    val processorIdentifier: ProcessorIdentifier
    val maxFreq: Long
    val currentFreq: LongArray
    val logicalProcessors: List<LogicalProcessor>
    val physicalProcessors: List<PhysicalProcessor>
    val processorCaches: List<ProcessorCache>
    val featureFlags: List<String>
    val systemCpuLoadTicks: LongArray
    val processorCpuLoadTicks: Array<LongArray>
    val logicalProcessorCount: Int
    val physicalProcessorCount: Int
    val physicalPackageCount: Int
    val contextSwitches: Long
    val interrupts: Long

    fun getSystemCpuLoadBetweenTicks(oldTickets: LongArray): Double

    fun getSystemLoadAverage(nelem: Int): DoubleArray

    fun getSystemCpuLoad(delay: Long): Double

    fun getProcessorCpuLoadBetweenTicks(oldTickets: Array<LongArray>): DoubleArray
}