package com.devx.kdeviceinfo.model

import com.devx.kdeviceinfo.model.desktop.DesktopInfo
import com.devx.kdeviceinfo.model.desktop.hardware.Hardware
import com.devx.kdeviceinfo.model.desktop.operatingsystem.OperatingSystem
import com.devx.kdeviceinfo.model.hardware.HardwareImpl
import com.devx.kdeviceinfo.model.operatingsystem.OperatingSystemImpl
import oshi.SystemInfo

class DesktopInfoImpl : DesktopInfo {

    private val systemInfo by lazy { SystemInfo() }

    private val operatingSystemImpl by lazy {
        OperatingSystemImpl(
            systemInfo = systemInfo
        )
    }

    private val hardwareImpl by lazy {
        HardwareImpl(
            systemInfo = systemInfo
        )
    }

    override val operatingSystem: OperatingSystem
        get() = operatingSystemImpl

    override val hardware: Hardware
        get() = hardwareImpl

}