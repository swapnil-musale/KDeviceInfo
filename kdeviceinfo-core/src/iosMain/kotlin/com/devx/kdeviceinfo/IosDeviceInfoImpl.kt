package com.devx.kdeviceinfo

import com.devx.kdeviceinfo.model.IosInfoImpl
import com.devx.kdeviceinfo.model.ios.IosInfo

internal class IosDeviceInfoImpl(
    override val iosInfo: IosInfo
) : IosDeviceInfo

actual fun getDeviceInfo(): DeviceInfo {
    return IosDeviceInfoImpl(
        iosInfo = IosInfoImpl()
    )
}
