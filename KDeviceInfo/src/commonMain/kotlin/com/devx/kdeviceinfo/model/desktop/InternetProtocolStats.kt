package com.devx.kdeviceinfo.model.desktop

interface InternetProtocolStats {
    val TCPv4Stats: TcpStats
    val TCPv6Stats: TcpStats
    val UDPv4Stats: UdpStats
    val UDPv6Stats: UdpStats
    val IPConnection: IPConnection
}