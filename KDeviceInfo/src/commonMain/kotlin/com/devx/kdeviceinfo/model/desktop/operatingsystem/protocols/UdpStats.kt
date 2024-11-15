package com.devx.kdeviceinfo.model.desktop.operatingsystem.protocols

interface UdpStats {
    val datagramsSent: Long
    val datagramsReceived: Long
    val datagramsNoPort: Long
    val datagramsReceivedErrors: Long
}