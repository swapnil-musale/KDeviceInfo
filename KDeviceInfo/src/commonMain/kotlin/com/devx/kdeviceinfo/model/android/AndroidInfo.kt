@file:Suppress("PropertyName")

package com.devx.kdeviceinfo.model.android

interface AndroidInfo {
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
    val serialNumber: String
    val VERSION_CODES: VersionCode
}