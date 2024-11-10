package com.devx.kdeviceinfo.model.desktop.hardware

interface NetworkIF {
    val name: String
    val index: Int
    val displayName: String
    val ifAlias: String
    val ifOperStatus: IfOperStatus
    val MTU: Long
    val macaddr: String
    val ipv4addr: Array<String>
    val subnetMasks: Array<Short>
    val ipv6addr: Array<String>
    val prefixLengths: Array<Short>
    val ifType: Int
    val ndisPhysicalMediumType: Int
    val isConnectorPresent: Boolean
    val bytesRecv: Long
    val bytesSent: Long
    val packetsRecv: Long
    val packetsSent: Long
    val inErrors: Long
    val outErrors: Long
    val inDrops: Long
    val collisions: Long
    val speed: Long
    val timestamp: Long
    val isKnownVmMacAddr: Boolean
    val updateAttributes: Boolean
}

/**
 * The current operational state of a network interface.
 *
 *
 * As described in RFC 2863.
 */
enum class IfOperStatus(
    val value: Int
) {
    /**
     * Up and operational. Ready to pass packets.
     */
    UP(1),

    /**
     * Down and not operational. Not ready to pass packets.
     */
    DOWN(2),

    /**
     * In some test mode.
     */
    TESTING(3),

    /**
     * The interface status is unknown.
     */
    UNKNOWN(4),

    /**
     * The interface is not up, but is in a pending state, waiting for some external event.
     */
    DORMANT(5),

    /**
     * Some component is missing
     */
    NOT_PRESENT(6),

    /**
     * Down due to state of lower-layer interface(s).
     */
    LOWER_LAYER_DOWN(7);

}