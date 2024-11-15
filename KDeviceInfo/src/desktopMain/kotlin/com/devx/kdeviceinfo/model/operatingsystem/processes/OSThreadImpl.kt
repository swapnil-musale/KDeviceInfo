package com.devx.kdeviceinfo.model.operatingsystem.processes

import com.devx.kdeviceinfo.model.desktop.operatingsystem.processes.OSThread
import com.devx.kdeviceinfo.model.desktop.operatingsystem.processes.State

class OSThreadImpl(
    override val threadId: Int,
    override val name: String,
    override val state: State,
    override val threadCpuLoadCumulative: Double,
    override val threadCpuLoadBetweenTicks: Double,
    override val owningProcessId: Int,
    override val startMemoryAddress: Long,
    override val contextSwitches: Long,
    override val minorFaults: Long,
    override val majorFaults: Long,
    override val kernelTime: Long,
    override val userTime: Long,
    override val upTime: Long,
    override val startTime: Long,
    override val priority: Int,
    override val updateAttributes: Boolean
) : OSThread