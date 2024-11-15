package com.devx.kdeviceinfo.model.operatingsystem

import com.devx.kdeviceinfo.model.desktop.operatingsystem.OSFileStore

class OSFileStoreImpl(
    override val name: String,
    override val volume: String,
    override val label: String,
    override val logicalVolume: String,
    override val mount: String,
    override val description: String,
    override val type: String,
    override val options: String,
    override val uuid: String,
    override val freeSpace: Long,
    override val usableSpace: Long,
    override val totalSpace: Long,
    override val freeInodes: Long,
    override val totalInodes: Long,
    override val updateAttributes: Boolean
) : OSFileStore