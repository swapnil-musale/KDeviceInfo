package com.devx.kdeviceinfo.model.android

interface Version {
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
}