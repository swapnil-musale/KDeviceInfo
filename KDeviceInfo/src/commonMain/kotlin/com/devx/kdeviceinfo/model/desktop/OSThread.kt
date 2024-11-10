package com.devx.kdeviceinfo.model.desktop

interface OSThread {
    val threadId: Int
    val name: String
    val state: State
    val threadCpuLoadCumulative: Double
    val threadCpuLoadBetweenTicks: Double
    val owningProcessId: Int
    val startMemoryAddress: Long
    val contextSwitches: Long
    val minorFaults: Long
    val majorFaults: Long
    val kernelTime: Long
    val userTime: Long
    val upTime: Long
    val startTime: Long
    val priority: Int
    val updateAttributes: Boolean
}