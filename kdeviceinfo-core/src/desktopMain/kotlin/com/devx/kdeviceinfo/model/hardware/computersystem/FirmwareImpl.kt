package com.devx.kdeviceinfo.model.hardware.computersystem

import com.devx.kdeviceinfo.model.desktop.hardware.computersystem.Firmware

internal class FirmwareImpl(
    override val manufacturer: String,
    override val name: String,
    override val description: String,
    override val version: String,
    override val releaseDate: String
) : Firmware
