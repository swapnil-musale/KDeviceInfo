package com.devx.kdeviceinfo.model.hardware

import com.devx.kdeviceinfo.model.desktop.GraphicsCard
import com.devx.kdeviceinfo.model.desktop.Sensors
import com.devx.kdeviceinfo.model.desktop.hardware.*
import com.devx.kdeviceinfo.model.desktop.hardware.NetworkIF
import com.devx.kdeviceinfo.model.desktop.hardware.centralprocessor.CentralProcessor
import com.devx.kdeviceinfo.model.desktop.hardware.computersystem.ComputerSystem
import com.devx.kdeviceinfo.model.desktop.hardware.memory.GlobalMemory
import com.devx.kdeviceinfo.model.desktop.hardware.storage.HWDiskStore
import com.devx.kdeviceinfo.model.desktop.hardware.storage.LogicalVolumeGroup
import oshi.SystemInfo

class HardwareImpl(
    systemInfo: SystemInfo
) : Hardware {

    private val hardwareInfo by lazy { systemInfo.hardware }

    override val computerSystem: ComputerSystem
        get() = TODO("Not yet implemented")

    override val centralProcessor: CentralProcessor
        get() = TODO("Not yet implemented")

    override val globalMemory: GlobalMemory
        get() = TODO("Not yet implemented")

    override val powerSources: List<PowerSource>
        get() = TODO("Not yet implemented")

    override val diskStores: List<HWDiskStore>
        get() = TODO("Not yet implemented")

    override val logicalVolumeGroups: List<LogicalVolumeGroup>
        get() = TODO("Not yet implemented")

    override val networkIFs: List<NetworkIF>
        get() = TODO("Not yet implemented")

    override val getNetworkIFsFiltered: List<NetworkIF>
        get() = TODO("Not yet implemented")

    override val displays: List<Display>
        get() = TODO("Not yet implemented")

    override val sensors: Sensors
        get() = TODO("Not yet implemented")

    override val usbDevices: List<UsbDevice>
        get() = TODO("Not yet implemented")

    override val soundCards: List<SoundCard>
        get() = TODO("Not yet implemented")

    override val graphicsCards: List<GraphicsCard>
        get() = TODO("Not yet implemented")

}