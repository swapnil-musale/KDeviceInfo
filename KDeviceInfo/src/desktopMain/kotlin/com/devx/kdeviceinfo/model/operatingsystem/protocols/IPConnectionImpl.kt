package com.devx.kdeviceinfo.model.operatingsystem.protocols

import com.devx.kdeviceinfo.model.desktop.operatingsystem.protocols.IPConnection
import com.devx.kdeviceinfo.model.desktop.operatingsystem.protocols.TcpState

class IPConnectionImpl(
    override val type: String,
    override val localAddress: ByteArray,
    override val localPort: Int,
    override val foreignAddress: ByteArray,
    override val foreignPort: Int,
    override val state: TcpState,
    override val transmitQueue: Int,
    override val receiveQueue: Int,
    override val owningProcessId: Int
) : IPConnection