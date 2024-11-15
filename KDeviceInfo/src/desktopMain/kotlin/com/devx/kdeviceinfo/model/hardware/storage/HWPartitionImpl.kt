package com.devx.kdeviceinfo.model.hardware.storage

import com.devx.kdeviceinfo.model.desktop.hardware.storage.HWPartition

class HWPartitionImpl(
    override val identification: String,
    override val name: String,
    override val type: String,
    override val uuid: String,
    override val size: Long,
    override val major: Int,
    override val minor: Int,
    override val mountPoint: String
) : HWPartition