package com.devx.kdeviceinfo.model.desktop

interface IPConnection {
    val type: String
    val localAddress: ByteArray
    val localPort: Int
    val foreignAddress: ByteArray
    val foreignPort: Int
    val state: TcpState
    val transmitQueue: Int
    val receiveQueue: Int
    val owningProcessId: Int
}