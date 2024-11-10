package com.devx.kdeviceinfo.model.desktop.operatingsystem

interface OSSession {
    val userName: String
    val terminalDevice: String
    val loginTime: Long
    val host: String
}