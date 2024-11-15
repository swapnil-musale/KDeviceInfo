package com.devx.kdeviceinfo.model.operatingsystem.protocols

import com.devx.kdeviceinfo.model.desktop.operatingsystem.protocols.TcpStats

class TcpStatsImpl(
    override val connectionsEstablished: Long,
    override val connectionsActive: Long,
    override val connectionsPassive: Long,
    override val connectionFailures: Long,
    override val connectionsReset: Long,
    override val segmentsSent: Long,
    override val segmentsReceived: Long,
    override val segmentsRetransmitted: Long,
    override val inErrors: Long,
    override val outResets: Long
) : TcpStats