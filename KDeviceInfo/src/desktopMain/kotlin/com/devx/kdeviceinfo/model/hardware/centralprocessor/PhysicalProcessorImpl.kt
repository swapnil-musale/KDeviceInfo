package com.devx.kdeviceinfo.model.hardware.centralprocessor

import com.devx.kdeviceinfo.model.desktop.hardware.centralprocessor.PhysicalProcessor

class PhysicalProcessorImpl(
    override val physicalPackageNumber: Int,
    override val physicalProcessorNumber: Int,
    override val efficiency: Int,
    override val idString: String
) : PhysicalProcessor