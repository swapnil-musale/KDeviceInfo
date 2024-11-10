package com.devx.kdeviceinfo.model.desktop

interface DesktopInfo {
    val family: String
    val manufacturer: String
    val versionInfo: OSVersionInfo
    val fileSystem: FileSystem
    val internetProtocolStats: InternetProtocolStats
    val osProcess: List<OSProcess>
}