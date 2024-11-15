package com.devx.kdeviceinfo.model.operatingsystem

import com.devx.kdeviceinfo.model.desktop.operatingsystem.OSDesktopWindow

class OSDesktopWindowImpl(
    override val windowId: Long,
    override val title: String,
    override val command: String,
    override val owningProcessId: Long,
    override val order: Int,
    override val visible: Boolean
) : OSDesktopWindow