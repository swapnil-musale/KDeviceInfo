package com.devx.kdeviceinfo.model.desktop.operatingsystem.protocols

interface TcpStats {
    val connectionsEstablished: Long
    val connectionsActive: Long
    val connectionsPassive: Long
    val connectionFailures: Long
    val connectionsReset: Long
    val segmentsSent: Long
    val segmentsReceived: Long
    val segmentsRetransmitted: Long
    val inErrors: Long
    val outResets: Long
}