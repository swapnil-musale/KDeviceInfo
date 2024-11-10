package com.devx.kdeviceinfo.model.desktop

interface Sensors {
    val cpuTemperature: Double
    val fanSpeeds: Array<Int>
    val cpuVoltage: Double
}