package com.devx.kdeviceinfo

import com.devx.kdeviceinfo.model.AndroidInfoImpl
import com.devx.kdeviceinfo.model.android.AndroidInfo

internal class AndroidDeviceInfoImpl(
    override val androidInfo: AndroidInfo
) : AndroidDeviceInfo

actual fun getDeviceInfo(): DeviceInfo {
    val context = KDeviceInfo.context
    return AndroidDeviceInfoImpl(
        androidInfo = AndroidInfoImpl(context)
    )
}
