package com.devx.kdeviceinfo.model.hardware.centralprocessor

import com.devx.kdeviceinfo.model.desktop.hardware.centralprocessor.ProcessorIdentifier
import oshi.hardware.CentralProcessor

class ProcessorIdentifierImpl(
    val processorIdentifierInfo: CentralProcessor.ProcessorIdentifier
): ProcessorIdentifier {

    override val cpuVendor: String
        get() = processorIdentifierInfo.vendor

    override val cpuName: String
        get() = processorIdentifierInfo.name

    override val cpuFamily: String
        get() = processorIdentifierInfo.family

    override val cpuModel: String
        get() = processorIdentifierInfo.model

    override val cpuStepping: String
        get() = processorIdentifierInfo.stepping

    override val processorId: String
        get() = processorIdentifierInfo.processorID

    override val cpuIdentifier: String
        get() = processorIdentifierInfo.identifier

    override val isCpu64bit: Boolean
        get() = processorIdentifierInfo.isCpu64bit

    override val cpuVendorFreq: Long
        get() = processorIdentifierInfo.vendorFreq

}