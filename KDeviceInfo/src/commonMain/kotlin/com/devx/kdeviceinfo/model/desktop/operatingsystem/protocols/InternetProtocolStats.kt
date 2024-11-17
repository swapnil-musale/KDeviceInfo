package com.devx.kdeviceinfo.model.desktop.operatingsystem.protocols

interface InternetProtocolStats {
    val tcpV4Stats: TcpStats
    val tcpV6Stats: TcpStats
    val udpV4Stats: UdpStats
    val udpV6Stats: UdpStats
    val ipConnections: List<IPConnection>
}