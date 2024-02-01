package com.devx.kdeviceinfo.model

import android.content.res.Resources
import android.util.Log
import com.devx.kdeviceinfo.model.android.DisplayMetrics

class AndroidDisplayMetricsImpl : DisplayMetrics {

    init {
        Log.d("DeviceX", "${this.javaClass.name} Initialized")
    }

    private val displayMetrics: android.util.DisplayMetrics? = Resources.getSystem().displayMetrics
    private val widthPx: Double = displayMetrics?.widthPixels?.toDouble() ?: 0.0
    private val heightPx: Double = displayMetrics?.heightPixels?.toDouble() ?: 0.0
    override val xDpi: Double
        get() = displayMetrics?.xdpi?.toDouble() ?: 0.0
    override val yDpi: Double
        get() = displayMetrics?.ydpi?.toDouble() ?: 0.0
    override val widthInches: Double
        get() = widthPx / xDpi
    override val heightInches: Double
        get() = heightPx / yDpi
}