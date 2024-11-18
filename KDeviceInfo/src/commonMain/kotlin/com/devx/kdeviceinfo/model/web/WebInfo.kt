package com.devx.kdeviceinfo.model.web

import com.devx.kdeviceinfo.model.web.browser.Browser
import com.devx.kdeviceinfo.model.web.cpu.CPU
import com.devx.kdeviceinfo.model.web.device.Device
import com.devx.kdeviceinfo.model.web.engine.Engine
import com.devx.kdeviceinfo.model.web.operatingsystem.Os

interface WebInfo {
    val userAgent: String
    val browser: Browser
    val cpu: CPU
    val device: Device
    val engine: Engine
    val os: Os
}