package com.devx.kdeviceinfo.model.hardware

import com.devx.kdeviceinfo.model.desktop.hardware.Display

internal class DisplayImpl(override val edid: ByteArray) : Display
