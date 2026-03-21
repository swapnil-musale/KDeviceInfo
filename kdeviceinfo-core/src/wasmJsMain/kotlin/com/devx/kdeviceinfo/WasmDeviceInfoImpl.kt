package com.devx.kdeviceinfo

import com.devx.kdeviceinfo.model.WebInfoImpl
import com.devx.kdeviceinfo.model.web.WebInfo

internal class WasmDeviceInfoImpl(
    override val webInfo: WebInfo
) : WebDeviceInfo

actual fun getDeviceInfo(): DeviceInfo {
    return WasmDeviceInfoImpl(
        webInfo = WebInfoImpl()
    )
}
