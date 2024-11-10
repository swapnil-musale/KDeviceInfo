package com.devx.kdeviceinfo.model.hardware.storage

import com.devx.kdeviceinfo.model.desktop.hardware.storage.HWDiskStore
import com.devx.kdeviceinfo.model.desktop.hardware.storage.HWPartition

class HWDiskStoreImpl(
    override val name: String,
    override val model: String,
    override val serial: String,
    override val size: Long,
    override val reads: Long,
    override val readBytes: Long,
    override val writes: Long,
    override val writesBytes: Long,
    override val currentQueueLength: Long,
    override val transferTime: Long,
    override val partitions: List<HWPartition>,
    override val timestamp: Long,
    override val updateAttributes: Boolean
) : HWDiskStore