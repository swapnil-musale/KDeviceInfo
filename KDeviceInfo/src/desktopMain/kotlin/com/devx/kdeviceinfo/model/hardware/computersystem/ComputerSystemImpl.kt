package com.devx.kdeviceinfo.model.hardware.computersystem

import com.devx.kdeviceinfo.model.desktop.hardware.computersystem.Baseboard
import com.devx.kdeviceinfo.model.desktop.hardware.computersystem.ComputerSystem
import com.devx.kdeviceinfo.model.desktop.hardware.computersystem.Firmware

class ComputerSystemImpl(
    val computerSystemInfo: oshi.hardware.ComputerSystem,
) : ComputerSystem {

    override val manufacturer: String
        get() = computerSystemInfo.manufacturer

    override val model: String
        get() = computerSystemInfo.model

    override val serialNumber: String
        get() = computerSystemInfo.serialNumber

    override val hardwareUUID: String
        get() = computerSystemInfo.hardwareUUID

    override val firmware: Firmware
        get() = initFirmware(source = computerSystemInfo.firmware)

    override val baseboard: Baseboard
        get() = initBaseBoard(source = computerSystemInfo.baseboard)

    private fun initFirmware(source: oshi.hardware.Firmware): Firmware {
        return FirmwareImpl(
            manufacturer = source.manufacturer,
            name = source.name,
            description = source.description,
            version = source.version,
            releaseDate = source.releaseDate
        )
    }

    private fun initBaseBoard(source: oshi.hardware.Baseboard): Baseboard {
        return BaseboardImpl(
            manufacturer = source.manufacturer,
            model = source.model,
            version = source.version,
            serialNumber = source.serialNumber
        )
    }
}