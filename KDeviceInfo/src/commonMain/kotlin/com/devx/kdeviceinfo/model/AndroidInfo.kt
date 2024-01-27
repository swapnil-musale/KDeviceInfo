package com.devx.kdeviceinfo.model

expect class AndroidInfo {
    val baseOs: String
    val sdkInt: Int
    val codeName: String
    val release: String
    val incremental: String
    val releaseOrCodeName: String
    val releaseOrPreviewDisplay: String
    val securityPatch: String
    val mediaPerformanceClass: Int
    val previewSdkInt: Int
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
    val systemFeatures: List<String>
    val displaySizeInches: Double
    val displayWidthPixels: Double
    val displayWidthInches: Double
    val displayHeightPixels: Double
    val displayHeightInches: Double
    val displayXDpi: Double
    val displayYDpi: Double
    val serialNumber: String
}