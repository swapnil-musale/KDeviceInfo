package com.devx.kdeviceinfo.model.hardware.computersystem

import com.devx.kdeviceinfo.model.desktop.hardware.computersystem.Baseboard

class BaseboardImpl(
    override val manufacturer: String,
    override val model: String,
    override val version: String,
    override val serialNumber: String
) : Baseboard