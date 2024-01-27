package com.devx.kdeviceinfo.model

//'utsname.sysname:': data.utsname.sysname,
//'utsname.nodename:': data.utsname.nodename,
//'utsname.release:': data.utsname.release,
//'utsname.version:': data.utsname.version,
//'utsname.machine:': data.utsname.machine,

internal expect class IosInfo {
    val name: String
    val systemName: String
    val systemVersion: String
    val model: String
    val localizedModel: String
    val identifierForVendor: String
    val isPhysicalDevice: Boolean
}