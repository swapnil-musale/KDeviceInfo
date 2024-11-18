package com.devx.kdeviceinfo.model.web.cpu

import com.devx.kdeviceinfo.model.web.WebInfoItem

interface CPU : WebInfoItem {
    val architecture: String
}