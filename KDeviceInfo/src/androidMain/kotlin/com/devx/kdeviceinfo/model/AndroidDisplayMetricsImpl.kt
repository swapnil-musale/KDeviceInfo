package com.devx.kdeviceinfo.model

import android.content.res.Resources
import com.devx.kdeviceinfo.model.android.DisplayMetrics

internal class AndroidDisplayMetricsImpl : DisplayMetrics {

    private val displayMetrics: android.util.DisplayMetrics? by lazy { Resources.getSystem().displayMetrics }
    private val widthPx: Double by lazy { displayMetrics?.widthPixels?.toDouble() ?: 0.0 }
    private val heightPx: Double by lazy { displayMetrics?.heightPixels?.toDouble() ?: 0.0 }

    override val xDpi: Double
        get() = displayMetrics?.xdpi?.toDouble() ?: 0.0

    override val yDpi: Double
        get() = displayMetrics?.ydpi?.toDouble() ?: 0.0

    override val widthInches: Double
        get() = widthPx / xDpi

    override val heightInches: Double
        get() = heightPx / yDpi
}