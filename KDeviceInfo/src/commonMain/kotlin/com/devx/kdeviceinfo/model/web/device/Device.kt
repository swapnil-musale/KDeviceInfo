package com.devx.kdeviceinfo.model.web.device

import com.devx.kdeviceinfo.model.web.WebInfoItem

interface Device : WebInfoItem {
    val model: String
    val type: String
    val vendor: String
}