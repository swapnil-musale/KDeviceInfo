package com.devx.kdeviceinfo.model

import android.annotation.SuppressLint
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.core.app.LocaleManagerCompat
import androidx.core.content.pm.PackageInfoCompat
import com.devx.kdeviceinfo.initilizer.applicationContext
import com.devx.kdeviceinfo.model.android.AndroidInfo
import com.devx.kdeviceinfo.model.android.DisplayMetrics
import com.devx.kdeviceinfo.model.android.Version
import com.devx.kdeviceinfo.model.android.VersionCode
import com.devx.kdeviceinfo.model.common.DeviceOrientation
import com.devx.kdeviceinfo.model.common.Locale

internal class AndroidInfoImpl : AndroidInfo {

    private val packageManager: PackageManager by lazy {
        applicationContext.packageManager
    }
    private val packageInfo: PackageInfo by lazy {
        packageManager.getPackageInfo(applicationContext.packageName, 0)
    }
    private val androidVersion: Version by lazy {
        AndroidVersionImpl()
    }
    private val androidVersionCode: VersionCode by lazy {
        AndroidVersionCodeImpl()
    }
    private val androidDisplayMetrics: DisplayMetrics by lazy {
        AndroidDisplayMetricsImpl()
    }

    private val androidDeviceOrientation: DeviceOrientation by lazy {
        AndroidDeviceOrientation()
    }

    override val appName: String
        get() = packageInfo.applicationInfo?.loadLabel(packageManager)?.toString().orEmpty()

    override val packageName: String
        get() = applicationContext.packageName

    override val version: Version
        get() = androidVersion
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
        get() = androidDisplayMetrics

    override val serialNumber: String
        @SuppressLint("MissingPermission")
        @RequiresApi(Build.VERSION_CODES.O)
        get() = Build.getSerial()
    override val VERSION_CODES: VersionCode
        get() = androidVersionCode

    override val versionName: String
        get() = packageInfo.versionName

    override val versionCode: Long
        get() = PackageInfoCompat.getLongVersionCode(packageInfo)

    override val locale: Locale
        get() {
            val locale = LocaleManagerCompat.getSystemLocales(applicationContext).get(0)
            return Locale(
                languageCode = locale?.language.orEmpty(),
                region = locale?.country.orEmpty()
            )
        }

    override val deviceOrientation: DeviceOrientation
        get() = androidDeviceOrientation

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
        return applicationContext.packageManager.systemAvailableFeatures
            .filterNot {
                it.name == null
            }.map {
                it.name
            }
    }
}