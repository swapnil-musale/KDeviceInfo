package com.devx.kdeviceinfo

import com.devx.kdeviceinfo.model.android.AndroidInfo
import com.devx.kdeviceinfo.model.android.DisplayMetrics
import com.devx.kdeviceinfo.model.android.Version
import com.devx.kdeviceinfo.model.android.VersionCode
import com.devx.kdeviceinfo.model.common.DeviceOrientation
import com.devx.kdeviceinfo.model.common.Locale
import com.devx.kdeviceinfo.model.web.WebInfo
import com.devx.kdeviceinfo.model.web.browser.Browser
import com.devx.kdeviceinfo.model.web.cpu.CPU
import com.devx.kdeviceinfo.model.web.device.Device
import com.devx.kdeviceinfo.model.web.engine.Engine
import com.devx.kdeviceinfo.model.web.operatingsystem.Os
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

@Suppress("PropertyName")
class PlatformDslTest {

    private val fakeAndroidInfo = object : AndroidInfo {
        override val appName = "TestApp"
        override val packageName = "com.test"
        override val version = object : Version {
            override val baseOs = ""
            override val sdkInt = 34
            override val codeName = "U"
            override val release = "14"
            override val incremental = "1"
            override val releaseOrCodeName = "14"
            override val releaseOrPreviewDisplay = "14"
            override val securityPatch = ""
            override val mediaPerformanceClass = 0
            override val previewSdkInt = 0
        }
        override val board = ""
        override val bootloader = ""
        override val device = ""
        override val display = ""
        override val fingerprint = ""
        override val hardware = ""
        override val host = ""
        override val id = ""
        override val manufacturer = "Google"
        override val model = "Pixel"
        override val product = ""
        override val supportedAbis = emptyArray<String>()
        override val supported32BitAbis = emptyArray<String>()
        override val supported64BitAbis = emptyArray<String>()
        override val tags = ""
        override val isPhysicalDevice = true
        override val systemFeatureList = emptyList<String>()
        override val displayMetrics = object : DisplayMetrics {
            override val widthInches = 0.0
            override val heightInches = 0.0
            override val xDpi = 0.0
            override val yDpi = 0.0
        }
        override val VERSION_CODES = object : VersionCode {
            override val CUR_DEVELOPMENT = 10000
            override val LOLLIPOP = 21
            override val LOLLIPOP_MR1 = 22
            override val M = 23
            override val N = 24
            override val N_MR1 = 25
            override val O = 26
            override val O_MR1 = 27
            override val P = 28
            override val R = 30
            override val S = 31
            override val S_V2 = 32
            override val TIRAMISU = 33
            override val UPSIDE_DOWN_CAKE = 34
        }
        override val versionName = "1.0"
        override val versionCode = 1L
        override val locale = Locale("en", "US")
        override val deviceOrientation = object : DeviceOrientation {
            override val UNKNOWN = "unknown"
            override val PORTRAIT = "portrait"
            override val LANDSCAPE = "landscape"
            override val isPortrait = true
            override val isLandscape = false
            override fun getDeviceOrientation() = "portrait"
        }
        override val androidId = "id"
        override val isDebug = true
    }

    private val fakeAndroidDeviceInfo = object : AndroidDeviceInfo {
        override val androidInfo = fakeAndroidInfo
    }

    private val fakeWebDeviceInfo = object : WebDeviceInfo {
        override val webInfo = object : WebInfo {
            override val userAgent = "TestAgent"
            override val browser = object : Browser {
                override val name = "TestBrowser"
                override val version = "1.0"
            }
            override val cpu = object : CPU { override val architecture = "x86" }
            override val device = object : Device {
                override val model = "Test"
                override val type = "desktop"
                override val vendor = "Test"
            }
            override val engine = object : Engine {
                override val name = "TestEngine"
                override val version = "1.0"
            }
            override val os = object : Os {
                override val name = "TestOS"
                override val version = "1.0"
            }
        }
    }

    @Test
    fun onPlatform_returns_value_from_matching_android_block() {
        val result: String = onPlatform(fakeAndroidDeviceInfo) {
            android { it.appName }
            ios { it.systemName }
            desktop { it.operatingSystem.family }
            web { it.browser.name }
        }
        assertEquals("TestApp", result)
    }

    @Test
    fun onPlatform_returns_value_from_matching_web_block() {
        val result: String = onPlatform(fakeWebDeviceInfo) {
            android { it.appName }
            ios { it.systemName }
            desktop { it.operatingSystem.family }
            web { it.browser.name }
        }
        assertEquals("TestBrowser", result)
    }

    @Test
    fun onPlatform_throws_when_no_handler_matches() {
        assertFailsWith<IllegalStateException> {
            onPlatform<String>(fakeAndroidDeviceInfo) {
                ios { it.systemName }
            }
        }
    }

    @Test
    fun platform_sealed_class_has_correct_subtypes() {
        val android: Platform = Platform.Android
        val ios: Platform = Platform.IOS
        val desktop: Platform = Platform.Desktop
        val web: Platform = Platform.Web

        assertEquals(Platform.Android, android)
        assertEquals(Platform.IOS, ios)
        assertEquals(Platform.Desktop, desktop)
        assertEquals(Platform.Web, web)
    }

    @Test
    fun deviceInfo_platform_property_returns_correct_value() {
        assertEquals(Platform.Android, fakeAndroidDeviceInfo.platform)
        assertEquals(Platform.Web, fakeWebDeviceInfo.platform)
    }

    @Test
    fun deviceInfoProvider_factory_delegates_to_getDeviceInfo() {
        val provider = DeviceInfoProvider { fakeAndroidDeviceInfo }
        val result = provider.get()
        assertEquals(fakeAndroidDeviceInfo, result)
    }
}
