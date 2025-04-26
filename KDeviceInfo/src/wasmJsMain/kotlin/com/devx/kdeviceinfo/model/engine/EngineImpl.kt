package com.devx.kdeviceinfo.model.engine

import com.devx.kdeviceinfo.model.web.engine.Engine

class EngineImpl(
    private val parsedEngine: com.devx.kdeviceinfo.model.Engine
) : Engine {

    override val name: String
        get() = parsedEngine.name.safeValue()

    override val version: String
        get() = parsedEngine.version.safeValue()
}