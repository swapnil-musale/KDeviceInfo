package com.devx.kdeviceinfo.model.hardware

import com.devx.kdeviceinfo.model.desktop.hardware.Display

class DisplayImpl(
    override val edid: ByteArray
) : Display