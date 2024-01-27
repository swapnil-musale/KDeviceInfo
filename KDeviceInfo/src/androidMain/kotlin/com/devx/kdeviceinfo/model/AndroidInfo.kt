package com.devx.kdeviceinfo.model

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi

internal actual class AndroidInfo {

    // TODO("Not yet implemented")
    private lateinit var applicationContext: Context
    private val displayMetrics: AndroidDisplayMetrics = AndroidDisplayMetrics()

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
    actual val board: String
        get() = Build.BOARD
    actual val bootloader: String
        get() = Build.BOOTLOADER
    actual val device: String
        get() = Build.DEVICE
    actual val display: String
        get() = Build.DISPLAY
    actual val fingerprint: String
        get() = Build.FINGERPRINT
    actual val hardware: String
        get() = Build.HARDWARE
    actual val host: String
        get() = Build.HOST
    actual val id: String
        get() = Build.ID
    actual val manufacturer: String
        get() = Build.MANUFACTURER
    actual val model: String
        get() = Build.MODEL
    actual val product: String
        get() = Build.PRODUCT
    actual val supportedAbis: Array<String>
        get() = Build.SUPPORTED_ABIS
    actual val supported32BitAbis: Array<String>
        get() = Build.SUPPORTED_32_BIT_ABIS
    actual val supported64BitAbis: Array<String>
        get() = Build.SUPPORTED_64_BIT_ABIS
    actual val tags: String
        get() = Build.TAGS
    actual val isPhysicalDevice: Boolean
        get() = getIsPhysicalDevice()
    actual val systemFeatures: List<String>
        get() = getSystemFeatures()

    actual val displaySizeInches: Double
        get() = (displayMetrics.sizeInches * 10).toDouble() / 10
    actual val displayWidthPixels: Double
        get() = displayMetrics.widthInches
    actual val displayWidthInches: Double
        get() = displayMetrics.heightInches
    actual val displayHeightPixels: Double
        get() = displayMetrics.heightInches
    actual val displayHeightInches: Double
        get() = displayMetrics.heightInches
    actual val displayXDpi: Double
        get() = displayMetrics.xDpi
    actual val displayYDpi: Double
        get() = displayMetrics.yDpi
    actual val serialNumber: String
        @SuppressLint("MissingPermission")
        @RequiresApi(Build.VERSION_CODES.O)
        get() = Build.getSerial()

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