package com.devx.kdeviceinfo.model.desktop.hardware.centralprocessor

interface LogicalProcessor {
    val processorNumber: Int
    val physicalProcessorNumber: Int
    val physicalPackageNumber: Int
    val numaNode: Int
    val processorGroup: Int
}