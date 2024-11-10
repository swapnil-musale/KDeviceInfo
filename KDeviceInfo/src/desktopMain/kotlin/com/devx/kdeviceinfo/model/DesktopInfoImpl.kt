package com.devx.kdeviceinfo.model

import com.devx.kdeviceinfo.model.desktop.DesktopInfo
import com.devx.kdeviceinfo.model.desktop.operatingsystem.OperatingSystem
import com.devx.kdeviceinfo.model.operatingsystem.OperatingSystemImpl

class DesktopInfoImpl : DesktopInfo {

    private val operatingSystemImpl by lazy { OperatingSystemImpl() }

    override val operatingSystem: OperatingSystem
        get() = operatingSystemImpl

}