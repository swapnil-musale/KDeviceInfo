package com.devx.kdeviceinfo.model.desktop.hardware.centralprocessor

interface CentralProcessor {
    val processorIdentifier: ProcessorIdentifier
    val maxFreq: Long
    val currentFreq: Array<Long>
    val logicalProcessors: List<LogicalProcessor>
    val physicalProcessors: List<PhysicalProcessor>
    val processorCaches: List<ProcessorCache>
    val featureFlags: List<String>
    val systemCpuLoadBetweenTicks: Array<Double>
    val systemCpuLoadTicks: Array<Double>
    val systemLoadAverage: Array<Double>
    val systemCpuLoad: Double
    val processorCpuLoad: Array<Double>
    val processorCpuLoadBetweenTicks: Array<Double>
    val processorCpuLoadTicks: Array<Array<Double>>
    val logicalProcessorCount: Int
    val physicalProcessorCount: Int
    val physicalPackageCount: Int
    val contextSwitches: Long
    val interrupts: Long
}