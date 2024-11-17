package com.devx.kdeviceinfo.model.desktop.hardware

import com.devx.kdeviceinfo.model.desktop.hardware.centralprocessor.CentralProcessor
import com.devx.kdeviceinfo.model.desktop.hardware.computersystem.ComputerSystem
import com.devx.kdeviceinfo.model.desktop.hardware.memory.GlobalMemory
import com.devx.kdeviceinfo.model.desktop.hardware.storage.HWDiskStore
import com.devx.kdeviceinfo.model.desktop.hardware.storage.LogicalVolumeGroup

interface Hardware {
    val computerSystem: ComputerSystem
    val centralProcessor: CentralProcessor
    val globalMemory: GlobalMemory
    val powerSources: List<PowerSource>
    val diskStores: List<HWDiskStore>
    val logicalVolumeGroups: List<LogicalVolumeGroup>
    val networkIFs: List<NetworkIF>
    val displays: List<Display>
    val sensors: Sensors
    val soundCards: List<SoundCard>
    val graphicsCards: List<GraphicsCard>

    fun getNetworkIfs(includeLocalInterfaces: Boolean): List<NetworkIF>

    fun getUsbDevices(tree: Boolean): List<UsbDevice>
}