package com.devx.kdeviceinfo.model.web

private const val UNKNOWN = "Unknown"

internal fun String?.safeValue(): String = this ?: UNKNOWN
