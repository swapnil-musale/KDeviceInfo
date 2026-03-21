package com.devx.kdeviceinfo.model.hardware

import com.devx.kdeviceinfo.model.desktop.hardware.Sensors

internal class SensorsImpl(private val sensorsInfo: oshi.hardware.Sensors) : Sensors {

    override val cpuTemperature: Double
        get() = sensorsInfo.cpuTemperature

    override val fanSpeeds: IntArray
        get() = sensorsInfo.fanSpeeds

    override val cpuVoltage: Double
        get() = sensorsInfo.cpuVoltage
}
