package com.devx.kdeviceinfo.model

import com.devx.kdeviceinfo.model.browser.BrowserImpl
import com.devx.kdeviceinfo.model.cpu.CPUImpl
import com.devx.kdeviceinfo.model.device.DeviceImpl
import com.devx.kdeviceinfo.model.engine.EngineImpl
import com.devx.kdeviceinfo.model.operatingsystem.OsImpl
import com.devx.kdeviceinfo.model.web.WebInfo
import com.devx.kdeviceinfo.model.web.browser.Browser
import com.devx.kdeviceinfo.model.web.cpu.CPU
import com.devx.kdeviceinfo.model.web.device.Device
import com.devx.kdeviceinfo.model.web.engine.Engine
import com.devx.kdeviceinfo.model.web.operatingsystem.Os
import kotlinx.browser.window

class WebInfoImpl : WebInfo {

    override val userAgent: String = window.navigator.userAgent

    override val browser: Browser

    override val cpu: CPU

    override val device: Device

    override val engine: Engine

    override val os: Os

    init {
        val result = UAParser(
            userAgent = userAgent
        ).getResult()
        browser = BrowserImpl(
           parsedBrowser = result.browser
        )
        cpu = CPUImpl(
            parsedCPU = result.cpu
        )
        device = DeviceImpl(
            parsedDevice = result.device
        )
        engine = EngineImpl(
            parsedEngine = result.engine
        )
        os = OsImpl(
            parsedOs = result.os
        )
    }

}