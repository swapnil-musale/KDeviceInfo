package com.devx.kdeviceinfo.model.desktop

import com.devx.kdeviceinfo.model.desktop.hardware.Hardware
import com.devx.kdeviceinfo.model.desktop.operatingsystem.OperatingSystem

interface DesktopInfo {
    val operatingSystem: OperatingSystem
    val hardware: Hardware
}