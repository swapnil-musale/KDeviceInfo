package com.devx.kdeviceinfo.model.desktop.hardware

interface Sensors {
    val cpuTemperature: Double
    val fanSpeeds: IntArray
    val cpuVoltage: Double
}