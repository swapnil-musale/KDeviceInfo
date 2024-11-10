package com.devx.kdeviceinfo.model.desktop.operatingsystem

interface OSDesktopWindow {
    val windowId: Long
    val title: String
    val command: String
    val owningProcessId: Long
    val order: Int
    val visible: Boolean
}