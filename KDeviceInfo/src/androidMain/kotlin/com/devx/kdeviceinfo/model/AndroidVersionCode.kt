package com.devx.kdeviceinfo.model

enum class AndroidVersionCode(val versionCode: Int) {
    CUR_DEVELOPMENT(10000),
    L(21),
    LOLLIPOP(22),
    LOLLIPOP_MR1(23),
    M(24),
    N(25),
    N_MR1(26),
    O(27),
    O_MR1(28),
    P(29),
    R(30),
    S(31),
    S_V2(32),
    TIRAMISU(33),
    UPSIDE_DOWN_CAKE(34)
}

object VersionCode {
    const val UPSIDE_DOWN_CAKE = 34
}