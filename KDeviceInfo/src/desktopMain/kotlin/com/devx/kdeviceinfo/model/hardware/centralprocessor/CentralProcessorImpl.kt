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
        get() = loadLogicalProcessors(
            sourceList = centralProcessorInfo.logicalProcessors
        )

    override val physicalProcessors: List<PhysicalProcessor>
        get() = loadPhysicalProcessors(
            sourceList = centralProcessorInfo.physicalProcessors
        )

    override val processorCaches: List<ProcessorCache>
        get() = loadProcessorCache(
            sourceList = centralProcessorInfo.processorCaches
        )

    override val featureFlags: List<String>
        get() = centralProcessorInfo.featureFlags

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

    override fun getSystemCpuLoadBetweenTicks(
        oldTickets: LongArray
    ) : Double {
        return centralProcessorInfo.getSystemCpuLoadBetweenTicks(oldTickets)
    }

    override fun getSystemLoadAverage(
        nelem: Int
    ): DoubleArray {
        return centralProcessorInfo.getSystemLoadAverage(nelem)
    }

    override fun getSystemCpuLoad(
        delay: Long
    ): Double {
        return centralProcessorInfo.getSystemCpuLoad(delay)
    }

    override fun getProcessorCpuLoadBetweenTicks(
        oldTickets: Array<LongArray>
    ): DoubleArray {
        return centralProcessorInfo.getProcessorCpuLoadBetweenTicks(oldTickets)
    }

    private fun loadLogicalProcessors(
        sourceList: List<oshi.hardware.CentralProcessor.LogicalProcessor>
    ) : List<LogicalProcessor> {
        val result = mutableListOf<LogicalProcessor>()
        sourceList.forEach { processor ->
            result.add(
                LogicalProcessorImpl(
                    processorNumber = processor.processorNumber,
                    physicalProcessorNumber = processor.physicalProcessorNumber,
                    physicalPackageNumber = processor.physicalPackageNumber,
                    numaNode = processor.numaNode,
                    processorGroup = processor.processorGroup
                )
            )
        }
        return result
    }

    private fun loadPhysicalProcessors(
        sourceList: List<oshi.hardware.CentralProcessor.PhysicalProcessor>
    ) : List<PhysicalProcessor> {
        val result = mutableListOf<PhysicalProcessor>()
        sourceList.forEach { processor ->
            result.add(
                PhysicalProcessorImpl(
                    physicalPackageNumber = processor.physicalPackageNumber,
                    physicalProcessorNumber = processor.physicalProcessorNumber,
                    efficiency = processor.efficiency,
                    idString = processor.idString,
                )
            )
        }
        return result
    }

    private fun loadProcessorCache(
        sourceList: List<oshi.hardware.CentralProcessor.ProcessorCache>
    ) : List<ProcessorCache> {
        val result = mutableListOf<ProcessorCache>()
        sourceList.forEach { cache ->
            result.add(
                ProcessorCacheImpl(
                    level = cache.level,
                    associativity = cache.associativity,
                    lineSize = cache.lineSize,
                    cacheSize = cache.cacheSize,
                    type = CacheType.valueOf(cache.type.name)

                )
            )
        }
        return result
    }

}