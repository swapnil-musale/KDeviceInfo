package com.devx.kdeviceinfo.model.operatingsystem

import com.devx.kdeviceinfo.model.desktop.operatingsystem.OSService
import com.devx.kdeviceinfo.model.desktop.operatingsystem.ServiceState

class OSServiceImpl(
    override val name: String,
    override val processID: Int,
    override val state: ServiceState
) : OSService