package com.devx.kdeviceinfo

import com.devx.kdeviceinfo.model.DesktopInfoImpl
import com.devx.kdeviceinfo.model.desktop.DesktopInfo

internal class DesktopDeviceInfoImpl(
    override val desktopInfo: DesktopInfo
) : DesktopDeviceInfo

actual fun getDeviceInfo(): DeviceInfo {
    return DesktopDeviceInfoImpl(
        desktopInfo = DesktopInfoImpl()
    )
}
