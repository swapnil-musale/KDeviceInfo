package com.devx.kdeviceinfo.model.hardware

import com.devx.kdeviceinfo.model.desktop.hardware.IfOperStatus
import com.devx.kdeviceinfo.model.desktop.hardware.NetworkIF
import java.net.NetworkInterface

class NetworkIFImpl(
    override val name: String,
    override val index: Int,
    override val displayName: String,
    override val ifAlias: String,
    override val ifOperStatus: IfOperStatus,
    override val MTU: Long,
    override val macaddr: String,
    override val ipv4addr: Array<String>,
    override val subnetMasks: Array<Short>,
    override val ipv6addr: Array<String>,
    override val prefixLengths: Array<Short>,
    override val ifType: Int,
    override val ndisPhysicalMediumType: Int,
    override val isConnectorPresent: Boolean,
    override val bytesRecv: Long,
    override val bytesSent: Long,
    override val packetsRecv: Long,
    override val packetsSent: Long,
    override val inErrors: Long,
    override val outErrors: Long,
    override val inDrops: Long,
    override val collisions: Long,
    override val speed: Long,
    override val timestamp: Long,
    override val isKnownVmMacAddr: Boolean,
    override val updateAttributes: Boolean
) : NetworkIF {

    fun queryNetworkInterface(
        source: oshi.hardware.NetworkIF
    ): NetworkInterface {
        return source.queryNetworkInterface()
    }

}