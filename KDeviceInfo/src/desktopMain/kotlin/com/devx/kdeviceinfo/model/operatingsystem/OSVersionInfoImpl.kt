package com.devx.kdeviceinfo.model.operatingsystem

import com.devx.kdeviceinfo.model.desktop.operatingsystem.OSVersionInfo
import oshi.SystemInfo

class OSVersionInfoImpl : OSVersionInfo {

    private val versionInfo by lazy { SystemInfo().operatingSystem.versionInfo }

    override val version: String
        get() = versionInfo.version

    override val codeName: String
        get() = versionInfo.codeName

    override val buildNumber: String
        get() = versionInfo.buildNumber

}