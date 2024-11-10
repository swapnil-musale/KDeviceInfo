package com.devx.kdeviceinfo.model.hardware

import com.devx.kdeviceinfo.model.desktop.hardware.*
import com.devx.kdeviceinfo.model.desktop.hardware.centralprocessor.CentralProcessor
import com.devx.kdeviceinfo.model.desktop.hardware.computersystem.ComputerSystem
import com.devx.kdeviceinfo.model.desktop.hardware.memory.GlobalMemory
import com.devx.kdeviceinfo.model.desktop.hardware.storage.HWDiskStore
import com.devx.kdeviceinfo.model.desktop.hardware.storage.HWPartition
import com.devx.kdeviceinfo.model.desktop.hardware.storage.LogicalVolumeGroup
import com.devx.kdeviceinfo.model.hardware.centralprocessor.CentralProcessorImpl
import com.devx.kdeviceinfo.model.hardware.computersystem.ComputerSystemImpl
import com.devx.kdeviceinfo.model.hardware.memory.GlobalMemoryImpl
import com.devx.kdeviceinfo.model.hardware.storage.HWDiskStoreImpl
import com.devx.kdeviceinfo.model.hardware.storage.HWPartitionImpl
import com.devx.kdeviceinfo.model.hardware.storage.LogicalVolumeGroupImpl
import oshi.SystemInfo

class HardwareImpl(
    systemInfo: SystemInfo
) : Hardware {

    private val hardwareInfo by lazy { systemInfo.hardware }

    private val computerSystemImpl by lazy {
        ComputerSystemImpl(
            computerSystemInfo = hardwareInfo.computerSystem
        )
    }

    private val centralProcessorImpl by lazy {
        CentralProcessorImpl(
            centralProcessorInfo = hardwareInfo.processor
        )
    }

    private val globalMemoryImpl by lazy {
        GlobalMemoryImpl(
            globalMemory = hardwareInfo.memory
        )
    }

    private val sensorsImpl by lazy {
        SensorsImpl(
            sensorsInfo = hardwareInfo.sensors
        )
    }

    override val computerSystem: ComputerSystem
        get() = computerSystemImpl

    override val centralProcessor: CentralProcessor
        get() = centralProcessorImpl

    override val globalMemory: GlobalMemory
        get() = globalMemoryImpl

    override val powerSources: List<PowerSource>
        get() = loadPowerSources(
            sourceList = hardwareInfo.powerSources
        )

    override val diskStores: List<HWDiskStore>
        get() = loadDisks(
            sourceList = hardwareInfo.diskStores
        )

    override val logicalVolumeGroups: List<LogicalVolumeGroup>
        get() = loadLogicalVolumeGroup(
            sourceList = hardwareInfo.logicalVolumeGroups
        )

    override val networkIFs: List<NetworkIF>
        get() = loadNetworkIf(
            sourceList = hardwareInfo.networkIFs
        )

    override val displays: List<Display>
        get() = loadDisplays(
            sourceList = hardwareInfo.displays
        )

    override val sensors: Sensors
        get() = sensorsImpl

    override val soundCards: List<SoundCard>
        get() = loadSoundcards(
            sourceList = hardwareInfo.soundCards
        )

    override val graphicsCards: List<GraphicsCard>
        get() = loadGraphicCards(
            sourceList = hardwareInfo.graphicsCards
        )

    override fun getNetworkIfs(
        includeLocalInterfaces: Boolean
    ): List<NetworkIF> {
        return loadNetworkIf(
            sourceList = hardwareInfo.getNetworkIFs(includeLocalInterfaces)
        )
    }

    override fun getUsbDevices(
        tree: Boolean
    ): List<UsbDevice> {
        return loadUsbDevices(
            sourceList = hardwareInfo.getUsbDevices(tree)
        )
    }

    private fun loadPowerSources(
        sourceList: List<oshi.hardware.PowerSource>
    ) : List<PowerSource> {
        val result = mutableListOf<PowerSource>()
        sourceList.forEach { source ->
            result.add(
                PowerSourceImpl(
                    powerSourceInfo = source
                )
            )
        }
        return result
    }

    private fun loadDisks(
        sourceList: List<oshi.hardware.HWDiskStore>
    ) : List<HWDiskStore> {
        val result = mutableListOf<HWDiskStore>()
        sourceList.forEach { disk ->
            result.add(
                HWDiskStoreImpl(
                    name = disk.name,
                    model = disk.model,
                    serial = disk.serial,
                    size = disk.size,
                    reads = disk.reads,
                    readBytes = disk.readBytes,
                    writes = disk.readBytes,
                    writesBytes = disk.writeBytes,
                    currentQueueLength = disk.currentQueueLength,
                    transferTime = disk.transferTime,
                    partitions = loadPartitions(
                        sourceList = disk.partitions
                    ),
                    timestamp = disk.timeStamp,
                    updateAttributes = disk.updateAttributes()
                )
            )
        }
        return result
    }

    private fun loadPartitions(
        sourceList: List<oshi.hardware.HWPartition>
    ) : List<HWPartition> {
        val result = mutableListOf<HWPartition>()
        sourceList.forEach { partition ->
            result.add(
                HWPartitionImpl(
                    identification = partition.identification,
                    name = partition.name,
                    type = partition.type,
                    uuid = partition.uuid,
                    size = partition.size,
                    major = partition.major,
                    minor = partition.minor,
                    mountPoint = partition.mountPoint
                )
            )
        }
        return result
    }

    private fun loadLogicalVolumeGroup(
        sourceList: List<oshi.hardware.LogicalVolumeGroup>
    ) : List<LogicalVolumeGroup> {
        val result = mutableListOf<LogicalVolumeGroup>()
        sourceList.forEach { volumeGroup ->
            result.add(
                LogicalVolumeGroupImpl(
                    name = volumeGroup.name,
                    physicalVolumes = volumeGroup.physicalVolumes,
                    logicalVolumes = volumeGroup.logicalVolumes
                )
            )
        }
        return result
    }

    private fun loadNetworkIf(
        sourceList: List<oshi.hardware.NetworkIF>
    ) : List<NetworkIF> {
        val result = mutableListOf<NetworkIF>()
        sourceList.forEach { networkIf ->
            result.add(
                NetworkIFImpl(
                    name = networkIf.name,
                    index = networkIf.index,
                    displayName = networkIf.displayName,
                    ifAlias = networkIf.ifAlias,
                    ifOperStatus = IfOperStatus.valueOf(networkIf.ifOperStatus.name),
                    MTU = networkIf.mtu,
                    macaddr = networkIf.macaddr,
                    ipv4addr = networkIf.iPv4addr,
                    subnetMasks = networkIf.subnetMasks,
                    ipv6addr = networkIf.iPv6addr,
                    prefixLengths = networkIf.prefixLengths,
                    ifType = networkIf.ifType,
                    ndisPhysicalMediumType = networkIf.ndisPhysicalMediumType,
                    isConnectorPresent = networkIf.isConnectorPresent,
                    bytesRecv = networkIf.bytesRecv,
                    bytesSent = networkIf.bytesSent,
                    packetsRecv = networkIf.packetsRecv,
                    packetsSent = networkIf.packetsSent,
                    inErrors = networkIf.inErrors,
                    outErrors = networkIf.outErrors,
                    inDrops = networkIf.inDrops,
                    collisions = networkIf.collisions,
                    speed = networkIf.collisions,
                    timestamp = networkIf.timeStamp,
                    isKnownVmMacAddr = networkIf.isKnownVmMacAddr,
                    updateAttributes = networkIf.updateAttributes()
                )
            )
        }
        return result
    }

    private fun loadDisplays(
        sourceList: List<oshi.hardware.Display>
    ) : List<Display> {
        val result = mutableListOf<Display>()
        sourceList.forEach { display ->
            result.add(
                DisplayImpl(
                    edid = display.edid
                )
            )
        }
        return result
    }

    private fun loadUsbDevices(
        sourceList: List<oshi.hardware.UsbDevice>
    ) : List<UsbDevice> {
        val result = mutableListOf<UsbDevice>()
        sourceList.forEach { usbDevice ->
            val connectedDevices = loadUsbDevices(
                sourceList = usbDevice.connectedDevices
            )
            result.add(
                UsbDeviceImpl(
                    name = usbDevice.name,
                    vendor = usbDevice.vendor,
                    vendorId = usbDevice.vendorId,
                    productId = usbDevice.productId,
                    serialNumber = usbDevice.serialNumber,
                    uniqueDeviceId = usbDevice.uniqueDeviceId,
                    connectedDevices = connectedDevices
                )
            )
        }
        return result
    }

    private fun loadSoundcards(
        sourceList: List<oshi.hardware.SoundCard>
    ) : List<SoundCard> {
        val result = mutableListOf<SoundCard>()
        sourceList.forEach { card ->
            result.add(
                SoundCardImpl(
                    driverVersion = card.driverVersion,
                    name = card.name,
                    codec = card.codec
                )
            )
        }
        return result
    }

    private fun loadGraphicCards(
        sourceList: List<oshi.hardware.GraphicsCard>
    ) : List<GraphicsCard> {
        val result = mutableListOf<GraphicsCard>()
        sourceList.forEach { card ->
            result.add(
                GraphicsCardImpl(
                    name = card.name,
                    deviceId = card.deviceId,
                    vendor = card.vendor,
                    versionInfo = card.versionInfo,
                    VRam = card.vRam
                )
            )
        }
        return result
    }

}