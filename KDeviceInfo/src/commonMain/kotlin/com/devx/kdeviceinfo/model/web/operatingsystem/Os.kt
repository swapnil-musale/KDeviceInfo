package com.devx.kdeviceinfo.model.web.operatingsystem

import com.devx.kdeviceinfo.model.web.WebInfoItem

interface Os : WebInfoItem {
    val name: String
    val version: String
}