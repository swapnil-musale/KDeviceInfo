package com.devx.kdeviceinfo.model

import android.os.Build
import com.devx.kdeviceinfo.model.android.VersionCode

internal class AndroidVersionCodeImpl : VersionCode {
    override val CUR_DEVELOPMENT: Int
        get() = Build.VERSION_CODES.CUR_DEVELOPMENT
    override val LOLLIPOP: Int
        get() = Build.VERSION_CODES.LOLLIPOP
    override val LOLLIPOP_MR1: Int
        get() = Build.VERSION_CODES.LOLLIPOP_MR1
    override val M: Int
        get() = Build.VERSION_CODES.M
    override val N: Int
        get() = Build.VERSION_CODES.N
    override val N_MR1: Int
        get() = Build.VERSION_CODES.N_MR1
    override val O: Int
        get() = Build.VERSION_CODES.O
    override val O_MR1: Int
        get() = Build.VERSION_CODES.O_MR1
    override val P: Int
        get() = Build.VERSION_CODES.P
    override val R: Int
        get() = Build.VERSION_CODES.R
    override val S: Int
        get() = Build.VERSION_CODES.S
    override val S_V2: Int
        get() = Build.VERSION_CODES.S_V2
    override val TIRAMISU: Int
        get() = Build.VERSION_CODES.TIRAMISU
    override val UPSIDE_DOWN_CAKE: Int
        get() = Build.VERSION_CODES.UPSIDE_DOWN_CAKE
}