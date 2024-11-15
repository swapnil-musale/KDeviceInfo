package com.devx.kdeviceinfo.model.desktop.operatingsystem

interface OSFileStore {
    val name: String
    val volume: String
    val label: String
    val logicalVolume: String
    val mount: String
    val description: String
    val type: String
    val options: String
    val uuid: String
    val freeSpace: Long
    val usableSpace: Long
    val totalSpace: Long
    val freeInodes: Long
    val totalInodes: Long
    val updateAttributes: Boolean
}