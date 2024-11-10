package com.devx.kdeviceinfo.model

import com.devx.kdeviceinfo.model.desktop.DesktopInfo
import oshi.SystemInfo

class DesktopInfoImpl : DesktopInfo {
    val systeInfoStatus = SystemInfo
}