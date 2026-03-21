package com.devx.kdeviceinfo.model.operatingsystem.protocols

import com.devx.kdeviceinfo.model.desktop.operatingsystem.protocols.UdpStats

internal class UdpStatsImpl(
    override val datagramsSent: Long,
    override val datagramsReceived: Long,
    override val datagramsNoPort: Long,
    override val datagramsReceivedErrors: Long
) : UdpStats
