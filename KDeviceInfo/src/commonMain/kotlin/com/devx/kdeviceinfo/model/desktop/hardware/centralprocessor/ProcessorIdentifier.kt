package com.devx.kdeviceinfo.model.desktop.hardware.centralprocessor

interface ProcessorIdentifier {
    val cpuVendor: String
    val cpuName: String
    val cpuFamily: String
    val cpuModel: String
    val cpuStepping: String
    val processorId: String
    val cpuIdentifier: String
    val isCpu64bit: Boolean
    val cpuVendorFreq: Long
}