package com.devx.kdeviceinfo.model.desktop

interface OSProcess {
    val name: String
    val path: String
    val commandLine: String
    val arguments: List<String>
    val environmentVariables: Map<String, String>
    val currentWorkingDirectory: String
    val user: String
    val userId: String
    val group: String
    val groupId: String
    val state: String
    val processId: Int
    val parentProcessId: Int
    val threadCount: Int
    val priority: Int
    val virtualSize: Long
    val residentSetSize: Long
    val kernelTime: Long
    val userTime: Long
    val startTime: Long
    val bytesRead: Long
    val bytesWritten: Long
    val openFiles: Long
    val softOpenFileLimit: Long
    val hardOpenFileLimit: Long
    val processCpuLoadCumulative: Long
    val processCpuLoadBetweenTicks: Double
    val bitness: Int
    val affinityMask: Long
    val updateAttributes: Boolean
    val threadDetails: List<OSThread>
    val minorFaults: Long
    val majorFaults: Long
    val contextSwitches: Long
}

/**
 * Process and Thread Execution States
 */
enum class State {
    /**
     * Intermediate state in process creation
     */
    NEW,

    /**
     * Actively executing process
     */
    RUNNING,

    /**
     * Interruptible sleep state
     */
    SLEEPING,

    /**
     * Blocked, uninterruptible sleep state
     */
    WAITING,

    /**
     * Intermediate state in process termination
     */
    ZOMBIE,

    /**
     * Stopped by the user, such as for debugging
     */
    STOPPED,

    /**
     * Other or unknown states not defined
     */
    OTHER,

    /**
     * The state resulting if the process fails to update statistics, probably due to termination.
     */
    INVALID,

    /**
     * Special case of waiting if the process has been intentionally suspended (Windows only)
     */
    SUSPENDED
}