package com.devx.kdeviceinfo.model.operatingsystem

import com.devx.kdeviceinfo.model.desktop.operatingsystem.OSSession

class OSSessionImpl(
    override val userName: String,
    override val terminalDevice: String,
    override val loginTime: Long,
    override val host: String
) : OSSession