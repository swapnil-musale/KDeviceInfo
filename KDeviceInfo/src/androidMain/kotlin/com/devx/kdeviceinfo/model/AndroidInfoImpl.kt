package com.devx.kdeviceinfo.model

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import com.devx.kdeviceinfo.model.android.AndroidInfo
import com.devx.kdeviceinfo.model.android.DisplayMetrics
import com.devx.kdeviceinfo.model.android.Version
import com.devx.kdeviceinfo.model.android.VersionCode

class AndroidInfoImpl : AndroidInfo {

    init {
        Log.d("DeviceX", "${this.javaClass.name} Initialized")
    }

    // TODO("Not yet implemented")
    private lateinit var applicationContext: Context

    private lateinit var cachedAndroidVersion: Version
    private lateinit var cachedAndroidVersionCode: VersionCode
    private lateinit var cachedAndroidDisplayMetrics: DisplayMetrics

    override val version: Version
        get() {
            if (::cachedAndroidVersion.isInitialized.not()) {
                cachedAndroidVersion = AndroidVersion()
            }
            return cachedAndroidVersion
        }
    override val board: String
        get() = Build.BOARD
    override val bootloader: String
        get() = Build.BOOTLOADER
    override val device: String
        get() = Build.DEVICE
    override val display: String
        get() = Build.DISPLAY
    override val fingerprint: String
        get() = Build.FINGERPRINT
    override val hardware: String
        get() = Build.HARDWARE
    override val host: String
        get() = Build.HOST
    override val id: String
        get() = Build.ID
    override val manufacturer: String
        get() = Build.MANUFACTURER
    override val model: String
        get() = Build.MODEL
    override val product: String
        get() = Build.PRODUCT
    override val supportedAbis: Array<String>
        get() = Build.SUPPORTED_ABIS
    override val supported32BitAbis: Array<String>
        get() = Build.SUPPORTED_32_BIT_ABIS
    override val supported64BitAbis: Array<String>
        get() = Build.SUPPORTED_64_BIT_ABIS
    override val tags: String
        get() = Build.TAGS
    override val isPhysicalDevice: Boolean
        get() = getIsPhysicalDevice()
    override val systemFeatureList: List<String>
        get() = getSystemFeatures()

    override val displayMetrics: DisplayMetrics
        get() {
            if (::cachedAndroidDisplayMetrics.isInitialized.not()) {
                cachedAndroidDisplayMetrics = AndroidDisplayMetricsImpl()
            }
            return cachedAndroidDisplayMetrics
        }

    override val serialNumber: String
        @SuppressLint("MissingPermission")
        @RequiresApi(Build.VERSION_CODES.O)
        get() = Build.getSerial()
    override val VERSION_CODES: VersionCode
        get() {
            if (::cachedAndroidVersionCode.isInitialized.not()) {
                cachedAndroidVersionCode = AndroidVersionCodeImpl()
            }
            return cachedAndroidVersionCode
        }

    private fun getIsPhysicalDevice(): Boolean {
        return !((Build.BRAND.startsWith("generic") && Build.DEVICE.startsWith("generic"))
                || Build.FINGERPRINT.startsWith("generic")
                || Build.FINGERPRINT.startsWith("unknown")
                || Build.HARDWARE.contains("goldfish")
                || Build.HARDWARE.contains("ranchu")
                || Build.MODEL.contains("google_sdk")
                || Build.MODEL.contains("Emulator")
                || Build.MODEL.contains("Android SDK built for x86")
                || Build.MANUFACTURER.contains("Genymotion")
                || Build.PRODUCT.contains("sdk")
                || Build.PRODUCT.contains("vbox86p")
                || Build.PRODUCT.contains("emulator"))
    }

    private fun getSystemFeatures(): List<String> {
        val packageManager = applicationContext.packageManager
        return packageManager.systemAvailableFeatures
            .filterNot {
                it.name == null
            }.map {
                it.name
            }
    }
}