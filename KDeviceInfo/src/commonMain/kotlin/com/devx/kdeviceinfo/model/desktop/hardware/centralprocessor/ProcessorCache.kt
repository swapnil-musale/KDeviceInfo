package com.devx.kdeviceinfo.model.desktop.hardware.centralprocessor

interface ProcessorCache {
    val level: Byte
    val associativity: Byte
    val lineSize: Short
    val cacheSize: Int
    val type: CacheType
}

/**
 * The type of cache.
 */
enum class CacheType {
    UNIFIED, INSTRUCTION, DATA, TRACE;

    override fun toString(): String {
        return name.substring(0, 1) + name.substring(1).lowercase()
    }
}
