package com.devx.kdeviceinfo.model.hardware.centralprocessor

import com.devx.kdeviceinfo.model.desktop.hardware.centralprocessor.*

class CentralProcessorImpl(
    private val centralProcessorInfo: oshi.hardware.CentralProcessor
) : CentralProcessor {

    private val processorIdentifierImpl by lazy {
        ProcessorIdentifierImpl(
            processorIdentifierInfo = centralProcessorInfo.processorIdentifier
        )
    }

    override val processorIdentifier: ProcessorIdentifier
        get() = processorIdentifierImpl

    override val maxFreq: Long
        get() = centralProcessorInfo.maxFreq

    override val currentFreq: LongArray
        get() = centralProcessorInfo.currentFreq

    override val logicalProcessors: List<LogicalProcessor>
        get() = TODO("Not yet implemented")

    override val physicalProcessors: List<PhysicalProcessor>
        get() = TODO("Not yet implemented")

    override val processorCaches: List<ProcessorCache>
        get() = TODO("Not yet implemented")

    override val featureFlags: List<String>
        get() = TODO("Not yet implemented")

    override val systemCpuLoadTicks: LongArray
        get() = centralProcessorInfo.systemCpuLoadTicks

    override val processorCpuLoadTicks: Array<LongArray>
        get() = centralProcessorInfo.processorCpuLoadTicks

    override val logicalProcessorCount: Int
        get() = centralProcessorInfo.logicalProcessorCount

    override val physicalProcessorCount: Int
        get() = centralProcessorInfo.physicalProcessorCount

    override val physicalPackageCount: Int
        get() = centralProcessorInfo.physicalPackageCount

    override val contextSwitches: Long
        get() = centralProcessorInfo.contextSwitches

    override val interrupts: Long
        get() = centralProcessorInfo.interrupts

    fun getSystemCpuLoadBetweenTicks(
        oldTickets: LongArray
    ) : Double {
        return centralProcessorInfo.getSystemCpuLoadBetweenTicks(oldTickets)
    }

    fun getSystemLoadAverage(
        nelem: Int
    ): DoubleArray {
        return centralProcessorInfo.getSystemLoadAverage(nelem)
    }

    fun getSystemCpuLoad(
        delay: Long
    ): Double {
        return centralProcessorInfo.getSystemCpuLoad(delay)
    }

    fun getProcessorCpuLoadBetweenTicks(
        oldTickets: Array<LongArray>
    ): DoubleArray {
        return centralProcessorInfo.getProcessorCpuLoadBetweenTicks(oldTickets)
    }

}