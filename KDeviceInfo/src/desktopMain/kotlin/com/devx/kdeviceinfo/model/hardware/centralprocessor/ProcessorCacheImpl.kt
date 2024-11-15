package com.devx.kdeviceinfo.model.hardware.centralprocessor

import com.devx.kdeviceinfo.model.desktop.hardware.centralprocessor.CacheType
import com.devx.kdeviceinfo.model.desktop.hardware.centralprocessor.ProcessorCache

class ProcessorCacheImpl(
    override val level: Byte,
    override val associativity: Byte,
    override val lineSize: Short,
    override val cacheSize: Int,
    override val type: CacheType
) : ProcessorCache