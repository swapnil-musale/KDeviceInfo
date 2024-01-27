package com.devx.kdeviceinfo.model

import android.content.res.Resources
import android.util.DisplayMetrics
import kotlin.math.sqrt

class AndroidDisplayMetrics {
    private val displayMetrics: DisplayMetrics? = Resources.getSystem().displayMetrics

    private val widthPx: Double = displayMetrics?.widthPixels?.toDouble() ?: 0.0
    private val heightPx: Double = displayMetrics?.heightPixels?.toDouble() ?: 0.0
    val xDpi: Double = displayMetrics?.xdpi?.toDouble() ?: 0.0
    val yDpi: Double = displayMetrics?.ydpi?.toDouble() ?: 0.0
    val widthInches: Double = widthPx / xDpi
    val heightInches: Double = heightPx / yDpi
    val sizeInches: Double
        get() = sqrt(x = (widthInches * widthInches) + (heightInches * heightInches))
}