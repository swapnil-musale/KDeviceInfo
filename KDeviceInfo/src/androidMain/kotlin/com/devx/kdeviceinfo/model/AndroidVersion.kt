package com.devx.kdeviceinfo.model

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import com.devx.kdeviceinfo.model.android.Version

internal class AndroidVersion : Version {

    init {
        Log.d("DeviceX", "${this.javaClass.name} Initialized")
    }

    override val baseOs: String
        @RequiresApi(Build.VERSION_CODES.M)
        get() = Build.VERSION.BASE_OS
    override val sdkInt: Int
        get() = Build.VERSION.SDK_INT
    override val codeName: String
        get() = Build.VERSION.CODENAME
    override val release: String
        get() = Build.VERSION.RELEASE
    override val incremental: String
        get() = Build.VERSION.INCREMENTAL
    override val releaseOrCodeName: String
        @RequiresApi(Build.VERSION_CODES.R)
        get() = Build.VERSION.RELEASE_OR_CODENAME
    override val releaseOrPreviewDisplay: String
        @RequiresApi(Build.VERSION_CODES.TIRAMISU)
        get() = Build.VERSION.RELEASE_OR_PREVIEW_DISPLAY
    override val securityPatch: String
        @RequiresApi(Build.VERSION_CODES.M)
        get() = Build.VERSION.SECURITY_PATCH
    override val mediaPerformanceClass: Int
        @RequiresApi(Build.VERSION_CODES.S)
        get() = Build.VERSION.MEDIA_PERFORMANCE_CLASS
    override val previewSdkInt: Int
        @RequiresApi(Build.VERSION_CODES.M)
        get() = Build.VERSION.PREVIEW_SDK_INT
}