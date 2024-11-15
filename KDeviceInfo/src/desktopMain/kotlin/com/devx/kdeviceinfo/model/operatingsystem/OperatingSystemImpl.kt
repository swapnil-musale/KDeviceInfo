package com.devx.kdeviceinfo.model.operatingsystem

import com.devx.kdeviceinfo.model.desktop.operatingsystem.FileSystem
import com.devx.kdeviceinfo.model.desktop.operatingsystem.OSDesktopWindow
import com.devx.kdeviceinfo.model.desktop.operatingsystem.OSService
import com.devx.kdeviceinfo.model.desktop.operatingsystem.OSSession
import com.devx.kdeviceinfo.model.desktop.operatingsystem.OSVersionInfo
import com.devx.kdeviceinfo.model.desktop.operatingsystem.OperatingSystem
import com.devx.kdeviceinfo.model.desktop.operatingsystem.ServiceState
import com.devx.kdeviceinfo.model.desktop.operatingsystem.processes.OSProcess
import com.devx.kdeviceinfo.model.desktop.operatingsystem.processes.OSThread
import com.devx.kdeviceinfo.model.desktop.operatingsystem.processes.State
import com.devx.kdeviceinfo.model.desktop.operatingsystem.protocols.InternetProtocolStats
import com.devx.kdeviceinfo.model.desktop.operatingsystem.protocols.NetworkParams
import com.devx.kdeviceinfo.model.operatingsystem.processes.OSProcessImpl
import com.devx.kdeviceinfo.model.operatingsystem.processes.OSThreadImpl
import com.devx.kdeviceinfo.model.operatingsystem.protocols.InternetProtocolStatsImpl
import com.devx.kdeviceinfo.model.operatingsystem.protocols.NetworkParamsImpl
import oshi.SystemInfo

class OperatingSystemImpl(systemInfo: SystemInfo) : OperatingSystem {

    private val fileSystemInfo by lazy { systemInfo.operatingSystem }

    private val osVersionInfo by lazy {
        OSVersionInfoImpl(osVersionInfo = fileSystemInfo.versionInfo)
    }

    private val fileSystemImpl by lazy {
        FileSystemImpl(fileSystemInfo = fileSystemInfo.fileSystem)
    }

    private val internetProtocolStatsImpl by lazy {
        InternetProtocolStatsImpl(internetProtocolStatsInfo = fileSystemInfo.internetProtocolStats)
    }

    private val networkParamsImpl by lazy {
        NetworkParamsImpl(networkParamsInfo = fileSystemInfo.networkParams)
    }

    override val family: String
        get() = fileSystemInfo.family

    override val manufacturer: String
        get() = fileSystemInfo.manufacturer

    override val versionInfo: OSVersionInfo
        get() = osVersionInfo

    override val fileSystem: FileSystem
        get() = fileSystemImpl

    override val internetProtocolStats: InternetProtocolStats
        get() = internetProtocolStatsImpl

    override val processId: Int
        get() = fileSystemInfo.processId

    override val currentProcess: OSProcess
        get() = initOSProcess(source = fileSystemInfo.currentProcess)

    override val processCount: Int
        get() = fileSystemInfo.processCount

    override val threadId: Int
        get() = fileSystemInfo.threadId

    override val currentThread: OSThread
        get() = initOSThread(source = fileSystemInfo.currentThread)

    override val threadCount: Int
        get() = fileSystemInfo.threadCount

    override val bitness: Int
        get() = fileSystemInfo.bitness

    override val systemUptime: Long
        get() = fileSystemInfo.systemUptime

    override val systemBootTime: Long
        get() = fileSystemInfo.systemBootTime

    override val isElevated: Boolean
        get() = fileSystemInfo.isElevated

    override val networkParams: NetworkParams
        get() = networkParamsImpl

    override val services: List<OSService>
        get() = loadOSServices(sourceList = fileSystemInfo.services)

    override val sessions: List<OSSession>
        get() = loadOSSessions(sourceList = fileSystemInfo.sessions)

    override fun getProcesses(): List<OSProcess> {
        return loadOSProcesses(sourceList = fileSystemInfo.processes)
    }

    override fun getProcesses(pids: Collection<Int>): List<OSProcess> {
        return loadOSProcesses(sourceList = fileSystemInfo.getProcesses(pids))
    }

    override fun getProcess(pid: Int): OSProcess {
        return initOSProcess(source = fileSystemInfo.getProcess(pid))
    }

    override fun getOSDesktopWindows(visibleOnly: Boolean): List<OSDesktopWindow> {
        return loadOSDesktopWindows(sourceList = fileSystemInfo.getDesktopWindows(visibleOnly))
    }

    private fun loadOSProcesses(sourceList: List<oshi.software.os.OSProcess>): List<OSProcess> {
        val result = mutableListOf<OSProcess>()
        sourceList.forEach { process ->
            result.add(initOSProcess(source = process))
        }
        return result
    }

    private fun initOSProcess(source: oshi.software.os.OSProcess): OSProcess {
        return OSProcessImpl(
            name = source.name,
            path = source.path,
            commandLine = source.commandLine,
            arguments = source.arguments,
            environmentVariables = source.environmentVariables,
            currentWorkingDirectory = source.currentWorkingDirectory,
            user = source.user,
            userId = source.userID,
            group = source.group,
            groupId = source.groupID,
            state = State.valueOf(source.state.name),
            processId = source.processID,
            parentProcessId = source.parentProcessID,
            threadCount = source.threadCount,
            priority = source.priority,
            virtualSize = source.virtualSize,
            residentSetSize = source.residentSetSize,
            kernelTime = source.kernelTime,
            userTime = source.userTime,
            startTime = source.startTime,
            bytesRead = source.bytesRead,
            bytesWritten = source.bytesWritten,
            openFiles = source.openFiles,
            softOpenFileLimit = source.softOpenFileLimit,
            hardOpenFileLimit = source.hardOpenFileLimit,
            processCpuLoadCumulative = source.processCpuLoadCumulative,
            processCpuLoadBetweenTicks = source.getProcessCpuLoadBetweenTicks(source),
            bitness = source.bitness,
            affinityMask = source.affinityMask,
            updateAttributes = source.updateAttributes(),
            threadDetails = loadOSThreads(sourceList = source.threadDetails),
            minorFaults = source.minorFaults,
            majorFaults = source.majorFaults,
            contextSwitches = source.contextSwitches
        )
    }

    private fun loadOSThreads(sourceList: List<oshi.software.os.OSThread>): List<OSThread> {
        val result = mutableListOf<OSThread>()
        sourceList.forEach { thread ->
            result.add(initOSThread(source = thread))
        }
        return result
    }

    private fun initOSThread(source: oshi.software.os.OSThread): OSThread {
        return OSThreadImpl(
            threadId = source.threadId,
            name = source.name,
            state = State.valueOf(source.state.name),
            threadCpuLoadCumulative = source.threadCpuLoadCumulative,
            threadCpuLoadBetweenTicks = source.getThreadCpuLoadBetweenTicks(source),
            owningProcessId = source.threadId,
            startMemoryAddress = source.startMemoryAddress,
            contextSwitches = source.contextSwitches,
            minorFaults = source.minorFaults,
            majorFaults = source.majorFaults,
            kernelTime = source.kernelTime,
            userTime = source.userTime,
            upTime = source.upTime,
            startTime = source.startTime,
            priority = source.priority,
            updateAttributes = source.updateAttributes()
        )
    }

    private fun loadOSServices(sourceList: List<oshi.software.os.OSService>): List<OSService> {
        val result = mutableListOf<OSService>()
        sourceList.forEach { service ->
            result.add(
                OSServiceImpl(
                    name = service.name,
                    processID = service.processID,
                    state = ServiceState.valueOf(service.state.name)
                )
            )
        }
        return result
    }

    private fun loadOSSessions(sourceList: List<oshi.software.os.OSSession>): List<OSSession> {
        val result = mutableListOf<OSSession>()
        sourceList.forEach { session ->
            result.add(
                OSSessionImpl(
                    userName = session.userName,
                    terminalDevice = session.terminalDevice,
                    loginTime = session.loginTime,
                    host = session.host
                )
            )
        }
        return result
    }

    private fun loadOSDesktopWindows(sourceList: List<oshi.software.os.OSDesktopWindow>): List<OSDesktopWindow> {
        val result = mutableListOf<OSDesktopWindow>()
        sourceList.forEach { desktopWindow ->
            result.add(
                OSDesktopWindowImpl(
                    windowId = desktopWindow.windowId,
                    title = desktopWindow.title,
                    command = desktopWindow.command,
                    owningProcessId = desktopWindow.owningProcessId,
                    order = desktopWindow.order,
                    visible = desktopWindow.isVisible
                )
            )
        }
        return result
    }
}
