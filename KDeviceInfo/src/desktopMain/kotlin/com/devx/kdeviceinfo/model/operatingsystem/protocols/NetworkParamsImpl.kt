package com.devx.kdeviceinfo.model.operatingsystem.protocols

import com.devx.kdeviceinfo.model.desktop.operatingsystem.protocols.NetworkParams
import oshi.SystemInfo

class NetworkParamsImpl : NetworkParams {

    private val networkParamsInfo by lazy { SystemInfo().operatingSystem.networkParams }

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