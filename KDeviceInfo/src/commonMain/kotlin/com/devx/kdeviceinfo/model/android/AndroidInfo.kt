@file:Suppress("PropertyName")

package com.devx.kdeviceinfo.model.android

import com.devx.kdeviceinfo.model.common.DeviceOrientation
import com.devx.kdeviceinfo.model.common.Locale

interface AndroidInfo {
    val appName: String
    val packageName: String
    val version: Version
    val board: String
    val bootloader: String
    val device: String
    val display: String
    val fingerprint: String
    val hardware: String
    val host: String
    val id: String
    val manufacturer: String
    val model: String
    val product: String
    val supportedAbis: Array<String>
    val supported32BitAbis: Array<String>
    val supported64BitAbis: Array<String>
    val tags: String
    val isPhysicalDevice: Boolean
    val systemFeatureList: List<String>
    val displayMetrics: DisplayMetrics
    val VERSION_CODES: VersionCode
    val versionName: String
    val versionCode: Long
    val locale: Locale
    val deviceOrientation: DeviceOrientation
    val androidId: String
    val isDebug: Boolean
}