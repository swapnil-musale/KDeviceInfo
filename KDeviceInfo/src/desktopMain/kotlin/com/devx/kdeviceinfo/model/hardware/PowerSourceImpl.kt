package com.devx.kdeviceinfo.model.hardware

import com.devx.kdeviceinfo.model.desktop.hardware.CapacityUnits
import com.devx.kdeviceinfo.model.desktop.hardware.PowerSource
import java.time.LocalDate

class PowerSourceImpl(
    private val powerSourceInfo: oshi.hardware.PowerSource,
) : PowerSource {

    override val name: String
        get() = powerSourceInfo.name

    override val deviceName: String
        get() = powerSourceInfo.deviceName

    override val remainingCapacityPercent: Double
        get() = powerSourceInfo.remainingCapacityPercent

    override val timeRemainingEstimated: Double
        get() = powerSourceInfo.timeRemainingEstimated

    override val timeRemainingInstant: Double
        get() = powerSourceInfo.timeRemainingInstant

    override val powerUsageRate: Double
        get() = powerSourceInfo.powerUsageRate

    override val voltage: Double
        get() = powerSourceInfo.voltage

    override val amperage: Double
        get() = powerSourceInfo.amperage

    override val isPowerOnLine: Boolean
        get() = powerSourceInfo.isPowerOnLine

    override val isCharging: Boolean
        get() = powerSourceInfo.isCharging

    override val isDischarging: Boolean
        get() = powerSourceInfo.isDischarging

    override val capacityUnits: CapacityUnits
        get() = CapacityUnits.valueOf(powerSourceInfo.capacityUnits.name)

    override val currentCapacity: Int
        get() = powerSourceInfo.currentCapacity

    override val maxCapacity: Int
        get() = powerSourceInfo.maxCapacity

    override val designCapacity: Int
        get() = powerSourceInfo.designCapacity

    override val cycleCount: Int
        get() = powerSourceInfo.cycleCount

    override val chemistry: String
        get() = powerSourceInfo.chemistry

    override val manufacturer: String
        get() = powerSourceInfo.manufacturer

    override val serialNumber: String
        get() = powerSourceInfo.serialNumber

    override val temperature: Double
        get() = powerSourceInfo.temperature

    override val updateAttributes: Boolean
        get() = powerSourceInfo.updateAttributes()

    fun getManufacturerDate(): LocalDate {
        return powerSourceInfo.manufactureDate
    }
}