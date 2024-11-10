package com.devx.kdeviceinfo.model

import com.devx.kdeviceinfo.model.desktop.DesktopInfo
import com.devx.kdeviceinfo.model.desktop.operatingsystem.OperatingSystem
import com.devx.kdeviceinfo.model.operatingsystem.OperatingSystemImpl
import oshi.SystemInfo

class DesktopInfoImpl : DesktopInfo {

    private val systemInfo by lazy { SystemInfo() }

    private val operatingSystemImpl by lazy {
        OperatingSystemImpl(
            systemInfo = systemInfo
        )
    }

    override val operatingSystem: OperatingSystem
        get() = operatingSystemImpl

}