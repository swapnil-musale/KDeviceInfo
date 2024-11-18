package com.devx.kdeviceinfo.model.operatingsystem

import com.devx.kdeviceinfo.model.web.operatingsystem.Os

class OsImpl(
    private val parsedOs : com.devx.kdeviceinfo.model.Os
) : Os {

    override val name: String
        get() = parsedOs.name.safeValue()

    override val version: String
        get() = parsedOs.version.safeValue()

}