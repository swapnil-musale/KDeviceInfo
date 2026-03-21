package com.devx.kdeviceinfo.model.cpu

import com.devx.kdeviceinfo.model.web.cpu.CPU
import com.devx.kdeviceinfo.model.web.safeValue

internal class CPUImpl(
    private val parsedCPU: com.devx.kdeviceinfo.model.CPU
) : CPU {

    override val architecture: String
        get() = parsedCPU.architecture.safeValue()
}