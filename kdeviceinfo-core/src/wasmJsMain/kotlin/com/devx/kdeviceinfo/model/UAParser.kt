package com.devx.kdeviceinfo.model

@JsModule("ua-parser-js")
external class UAParser(
    userAgent: String
) {

    fun getResult(): UAParserResult
}

external interface UAParserResult {
    val browser: Browser
    val cpu: CPU
    val device: Device
    val engine: Engine
    val os: Os
}

external interface Browser {
    val name: String?
    val version: String?
}

external interface CPU {
    val architecture: String?
}

external interface Device {
    val model: String?
    val type: String?
    val vendor: String?
}

external interface Engine {
    val name: String?
    val version: String?
}

external interface Os {
    val name: String?
    val version: String?
}

fun parseUserAgent(
    userAgent: String
): UAParserResult {
    return UAParser(userAgent).getResult()
}