package com.devx.kdeviceinfo.model.web.browser

import com.devx.kdeviceinfo.model.web.WebInfoItem

interface Browser : WebInfoItem {
    val name: String
    val version: String
}