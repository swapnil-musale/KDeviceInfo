package com.devx.kdeviceinfo.model.desktop

interface UdpStats {
    val datagramsSent: Long
    val datagramsReceived: Long
    val datagramsNoPort: Long
    val datagramsReceivedErrors: Long
}