package com.devx.kdeviceinfo.model.operatingsystem.protocols

import com.devx.kdeviceinfo.model.desktop.operatingsystem.protocols.NetworkParams

class NetworkParamsImpl(private val networkParamsInfo: oshi.software.os.NetworkParams) :
    NetworkParams {

    override val hostName: String
        get() = networkParamsInfo.hostName

    override val domainName: String
        get() = networkParamsInfo.domainName

    override val dnsServers: Array<String>
        get() = networkParamsInfo.dnsServers

    override val ipv4DefaultGateway: String
        get() = networkParamsInfo.ipv4DefaultGateway

    override val ipv6DefaultGateway: String
        get() = networkParamsInfo.ipv6DefaultGateway
}