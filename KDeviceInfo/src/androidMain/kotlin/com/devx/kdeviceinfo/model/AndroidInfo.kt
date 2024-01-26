package com.devx.kdeviceinfo.model

import android.os.Build
import androidx.annotation.RequiresApi

actual class AndroidInfo {
    actual val baseOs: String
        @RequiresApi(Build.VERSION_CODES.M)
        get() = Build.VERSION.BASE_OS
    actual val sdkInt: Int
        get() = Build.VERSION.SDK_INT
    actual val codeName: String
        get() = Build.VERSION.CODENAME
    actual val release: String
        get() = Build.VERSION.RELEASE
    actual val incremental: String
        get() = Build.VERSION.INCREMENTAL
    actual val releaseOrCodeName: String
        @RequiresApi(Build.VERSION_CODES.R)
        get() = Build.VERSION.RELEASE_OR_CODENAME
    actual val releaseOrPreviewDisplay: String
        @RequiresApi(Build.VERSION_CODES.TIRAMISU)
        get() = Build.VERSION.RELEASE_OR_PREVIEW_DISPLAY
    actual val securityPatch: String
        @RequiresApi(Build.VERSION_CODES.M)
        get() = Build.VERSION.SECURITY_PATCH
    actual val mediaPerformanceClass: Int
        @RequiresApi(Build.VERSION_CODES.S)
        get() = Build.VERSION.MEDIA_PERFORMANCE_CLASS
    actual val previewSdkInt: Int
        @RequiresApi(Build.VERSION_CODES.M)
        get() = Build.VERSION.PREVIEW_SDK_INT
}