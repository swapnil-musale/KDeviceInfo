package com.devx.kdeviceinfo.model.desktop

interface OSVersionInfo {
    val version: String
    val codeName: String
    val buildNumber: String
    val versionStr: String
}