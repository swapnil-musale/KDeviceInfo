package com.devx.kdeviceinfo.model.desktop.hardware

interface UsbDevice {
    val name: String
    val vendor: String
    val vendorId: String
    val productId: String
    val serialNumber: String
    val uniqueDeviceId: String
    val connectedDevices: List<UsbDevice>
}