package com.devx.kdeviceinfo.model.desktop.hardware.centralprocessor

interface PhysicalProcessor {
    val physicalPackageNumber: Int
    val physicalProcessorNumber: Int
    val efficiency: Int
    val idString: String
}