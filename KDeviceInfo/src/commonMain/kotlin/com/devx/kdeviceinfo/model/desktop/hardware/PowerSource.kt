package com.devx.kdeviceinfo.model.desktop.hardware

interface PowerSource {
    val name: String
    val deviceName: String
    val remainingCapacityPercent: Double
    val timeRemainingEstimated: Double
    val timeRemainingInstant: Double
    val powerUsageRate: Double
    val voltage: Double
    val amperage: Double
    val isPowerOnLine: Boolean
    val isCharging: Boolean
    val isDischarging: Boolean
    val capacityUnits: CapacityUnits
    val currentCapacity: Int
    val maxCapacity: Int
    val designCapacity: Int
    val cycleCount: Int
    val chemistry: String
    val manufacturerDate: Long
    val manufacturer: String
    val serialNumber: String
    val temperature: Long
    val updateAttributes: Boolean
}

/**
 * Units of Battery Capacity
 */
enum class CapacityUnits {
    /**
     * MilliWattHours (mWh).
     */
    MWH,

    /**
     * MilliAmpHours (mAh). Should be multiplied by voltage to convert to mWh.
     */
    MAH,

    /**
     * Relative units. The specific units are not defined. The ratio of current/max capacity still represents state
     * of charge and the ratio of max/design capacity still represents state of health.
     */
    RELATIVE
}