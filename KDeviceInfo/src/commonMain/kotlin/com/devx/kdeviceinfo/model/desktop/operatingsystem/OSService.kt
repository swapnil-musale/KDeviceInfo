package com.devx.kdeviceinfo.model.desktop.operatingsystem

interface OSService {
    val name: String
    val processID: Int
    val state: ServiceState
}

/**
 * Service Execution States
 */
enum class ServiceState {
    RUNNING,
    STOPPED,
    OTHER
}