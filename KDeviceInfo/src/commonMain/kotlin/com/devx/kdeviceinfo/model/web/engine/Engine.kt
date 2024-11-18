package com.devx.kdeviceinfo.model.web.engine

import com.devx.kdeviceinfo.model.web.WebInfoItem

interface Engine : WebInfoItem {
    val name: String
    val version: String
}