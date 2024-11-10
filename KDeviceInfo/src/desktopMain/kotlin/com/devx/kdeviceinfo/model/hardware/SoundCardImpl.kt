package com.devx.kdeviceinfo.model.hardware

import com.devx.kdeviceinfo.model.desktop.hardware.SoundCard

class SoundCardImpl(
    override val driverVersion: String,
    override val name: String,
    override val codec: String
) : SoundCard