package com.devx.kdeviceinfo.model.operatingsystem.processes

import com.devx.kdeviceinfo.model.desktop.operatingsystem.processes.OSProcess
import com.devx.kdeviceinfo.model.desktop.operatingsystem.processes.OSThread
import com.devx.kdeviceinfo.model.desktop.operatingsystem.processes.State

class OSProcessImpl(
    override val name: String,
    override val path: String,
    override val commandLine: String,
    override val arguments: List<String>,
    override val environmentVariables: Map<String, String>,
    override val currentWorkingDirectory: String,
    override val user: String,
    override val userId: String,
    override val group: String,
    override val groupId: String,
    override val state: State,
    override val processId: Int,
    override val parentProcessId: Int,
    override val threadCount: Int,
    override val priority: Int,
    override val virtualSize: Long,
    override val residentSetSize: Long,
    override val kernelTime: Long,
    override val userTime: Long,
    override val startTime: Long,
    override val bytesRead: Long,
    override val bytesWritten: Long,
    override val openFiles: Long,
    override val softOpenFileLimit: Long,
    override val hardOpenFileLimit: Long,
    override val processCpuLoadCumulative: Double,
    override val processCpuLoadBetweenTicks: Double,
    override val bitness: Int,
    override val affinityMask: Long,
    override val updateAttributes: Boolean,
    override val threadDetails: List<OSThread>,
    override val minorFaults: Long,
    override val majorFaults: Long,
    override val contextSwitches: Long
) : OSProcess