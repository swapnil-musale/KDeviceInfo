package com.devx.kdeviceinfo.model.device

import com.devx.kdeviceinfo.model.web.device.Device

class DeviceImpl(
    private val parsedDevice: com.devx.kdeviceinfo.model.Device
) : Device {

    override val model: String
        get() = parsedDevice.model.safeValue()

    override val type: String
        get() = parsedDevice.type.safeValue()

    override val vendor: String
        get() = parsedDevice.vendor.safeValue()

}