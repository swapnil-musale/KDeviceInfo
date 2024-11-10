package com.devx.kdeviceinfo.model.desktop.hardware.storage

interface HWDiskStore {
    val name: String
    val model: String
    val serial: String
    val size: Long
    val reads: Long
    var readBytes: Long
    val writes: Long
    var writesBytes: Long
    val currentQueueLength: Long
    val transferTime: Long
    val partitions: List<HWPartition>
    val timestamp: Long
    val updateAttributes: Boolean
}