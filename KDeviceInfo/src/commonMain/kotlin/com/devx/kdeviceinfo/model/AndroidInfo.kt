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
//    val board: String
//    val bootloader: String
//    val device: String
//    val display: String
//    val fingerprint: String
//    val hardware: String
//    val host: String
//    val id: String
//    val manufacturer: String
//    val model: String
//    val product: String
//    val supportedAbis: String
//    val supported32BitAbis: String
//    val supported64BitAbis: String
//    val tags: String
//    val isPhysicalDevice: String
//    val systemFeatures: String
//    val displaySizeInches: String
//    val displayWidthPixels: String
//    val displayWidthInches: String
//    val displayHeightPixels: String
//    val displayHeightInches: String
//    val displayXDpi: String
//    val displayYDpi: String
//    val serialNumber: String
}