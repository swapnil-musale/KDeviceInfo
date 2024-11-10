package com.devx.kdeviceinfo.model.hardware

import com.devx.kdeviceinfo.model.desktop.hardware.UsbDevice

class UsbDeviceImpl(
    override val name: String,
    override val vendor: String,
    override val vendorId: String,
    override val productId: String,
    override val serialNumber: String,
    override val uniqueDeviceId: String,
    override val connectedDevices: List<UsbDevice>
) : UsbDevice