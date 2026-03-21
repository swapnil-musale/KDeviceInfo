@file:Suppress("unused")

package com.devx.kdeviceinfo.testing

import com.devx.kdeviceinfo.AndroidDeviceInfo
import com.devx.kdeviceinfo.DesktopDeviceInfo
import com.devx.kdeviceinfo.DeviceInfoProvider
import com.devx.kdeviceinfo.IosDeviceInfo
import com.devx.kdeviceinfo.WebDeviceInfo
import com.devx.kdeviceinfo.model.android.AndroidInfo
import com.devx.kdeviceinfo.model.android.DisplayMetrics
import com.devx.kdeviceinfo.model.android.Version
import com.devx.kdeviceinfo.model.android.VersionCode
import com.devx.kdeviceinfo.model.common.DeviceOrientation
import com.devx.kdeviceinfo.model.common.Locale
import com.devx.kdeviceinfo.model.desktop.DesktopInfo
import com.devx.kdeviceinfo.model.desktop.hardware.Hardware
import com.devx.kdeviceinfo.model.desktop.operatingsystem.OperatingSystem
import com.devx.kdeviceinfo.model.ios.IosInfo
import com.devx.kdeviceinfo.model.web.WebInfo
import com.devx.kdeviceinfo.model.web.browser.Browser
import com.devx.kdeviceinfo.model.web.cpu.CPU
import com.devx.kdeviceinfo.model.web.device.Device
import com.devx.kdeviceinfo.model.web.engine.Engine
import com.devx.kdeviceinfo.model.web.operatingsystem.Os

/**
 * Fake implementation of [AndroidDeviceInfo] for unit testing.
 *
 * ```
 * val fakeInfo = FakeAndroidDeviceInfo(
 *     androidInfo = FakeAndroidInfo(appName = "TestApp")
 * )
 * ```
 */
class FakeAndroidDeviceInfo(
    override val androidInfo: AndroidInfo = FakeAndroidInfo()
) : AndroidDeviceInfo

/**
 * Fake implementation of [IosDeviceInfo] for unit testing.
 */
class FakeIosDeviceInfo(
    override val iosInfo: IosInfo = FakeIosInfo()
) : IosDeviceInfo

/**
 * Fake implementation of [DesktopDeviceInfo] for unit testing.
 */
class FakeDesktopDeviceInfo(
    override val desktopInfo: DesktopInfo
) : DesktopDeviceInfo

/**
 * Fake implementation of [WebDeviceInfo] for unit testing.
 */
class FakeWebDeviceInfo(
    override val webInfo: WebInfo = FakeWebInfo()
) : WebDeviceInfo

/**
 * Fake [AndroidInfo] with all fields defaulting to sensible test values.
 */
class FakeAndroidInfo(
    override val appName: String = "TestApp",
    override val packageName: String = "com.test.app",
    override val version: Version = FakeVersion(),
    override val board: String = "board",
    override val bootloader: String = "bootloader",
    override val device: String = "device",
    override val display: String = "display",
    override val fingerprint: String = "fingerprint",
    override val hardware: String = "hardware",
    override val host: String = "host",
    override val id: String = "id",
    override val manufacturer: String = "Google",
    override val model: String = "Pixel 9",
    override val product: String = "product",
    override val supportedAbis: Array<String> = arrayOf("arm64-v8a"),
    override val supported32BitAbis: Array<String> = emptyArray(),
    override val supported64BitAbis: Array<String> = arrayOf("arm64-v8a"),
    override val tags: String = "release-keys",
    override val isPhysicalDevice: Boolean = true,
    override val systemFeatureList: List<String> = emptyList(),
    override val displayMetrics: DisplayMetrics = FakeDisplayMetrics(),
    @Suppress("PropertyName")
    override val VERSION_CODES: VersionCode = FakeVersionCode(),
    override val versionName: String = "1.0.0",
    override val versionCode: Long = 1L,
    override val locale: Locale = Locale(languageCode = "en", region = "US"),
    override val deviceOrientation: DeviceOrientation = FakeDeviceOrientation(),
    override val androidId: String = "fake-android-id",
    override val isDebug: Boolean = true,
) : AndroidInfo

/**
 * Fake [IosInfo] with all fields defaulting to sensible test values.
 */
class FakeIosInfo(
    override val name: String = "iPhone",
    override val systemName: String = "iOS",
    override val systemVersion: String = "17.0",
    override val model: String = "iPhone",
    override val localizedModel: String = "iPhone",
    override val identifierForVendor: String = "fake-vendor-id",
    override val isPhysicalDevice: Boolean = true,
    override val isMultitaskingSupported: Boolean = true,
    override val isGeneratingDeviceOrientationNotifications: Boolean = true,
    override val deviceOrientation: DeviceOrientation = FakeDeviceOrientation(),
    override val appName: String = "TestApp",
    override val bundleId: String = "com.test.app",
    override val appVersion: String = "1",
    override val appShortVersion: String = "1.0",
    override val locale: Locale = Locale(languageCode = "en", region = "US"),
    override val isDebug: Boolean = true,
) : IosInfo

/**
 * Fake [WebInfo] with all fields defaulting to sensible test values.
 */
class FakeWebInfo(
    override val userAgent: String = "Mozilla/5.0 Test",
    override val browser: Browser = FakeBrowser(),
    override val cpu: CPU = FakeCPU(),
    override val device: Device = FakeDevice(),
    override val engine: Engine = FakeEngine(),
    override val os: Os = FakeOs(),
) : WebInfo

class FakeVersion(
    override val baseOs: String = "",
    override val sdkInt: Int = 34,
    override val codeName: String = "UpsideDownCake",
    override val release: String = "14",
    override val incremental: String = "1",
    override val releaseOrCodeName: String = "14",
    override val releaseOrPreviewDisplay: String = "14",
    override val securityPatch: String = "2024-01-01",
    override val mediaPerformanceClass: Int = 0,
    override val previewSdkInt: Int = 0,
) : Version

class FakeVersionCode(
    override val CUR_DEVELOPMENT: Int = 10000,
    override val LOLLIPOP: Int = 21,
    override val LOLLIPOP_MR1: Int = 22,
    override val M: Int = 23,
    override val N: Int = 24,
    override val N_MR1: Int = 25,
    override val O: Int = 26,
    override val O_MR1: Int = 27,
    override val P: Int = 28,
    override val R: Int = 30,
    override val S: Int = 31,
    override val S_V2: Int = 32,
    override val TIRAMISU: Int = 33,
    override val UPSIDE_DOWN_CAKE: Int = 34,
) : VersionCode

class FakeDisplayMetrics(
    override val widthInches: Double = 3.0,
    override val heightInches: Double = 6.0,
    override val xDpi: Double = 440.0,
    override val yDpi: Double = 440.0,
) : DisplayMetrics

@Suppress("PropertyName")
class FakeDeviceOrientation(
    override val UNKNOWN: String = "unknown",
    override val PORTRAIT: String = "portrait",
    override val LANDSCAPE: String = "landscape",
    override val isPortrait: Boolean = true,
    override val isLandscape: Boolean = false,
    private val orientationValue: String = "portrait",
) : DeviceOrientation {
    override fun getDeviceOrientation(): String = orientationValue
}

class FakeBrowser(
    override val name: String = "Chrome",
    override val version: String = "120.0",
) : Browser

class FakeCPU(
    override val architecture: String = "amd64",
) : CPU

class FakeDevice(
    override val model: String = "PC",
    override val type: String = "desktop",
    override val vendor: String = "Unknown",
) : Device

class FakeEngine(
    override val name: String = "Blink",
    override val version: String = "120.0",
) : Engine

class FakeOs(
    override val name: String = "Windows",
    override val version: String = "10",
) : Os

/**
 * Factory for creating [DeviceInfoProvider] instances with fake data.
 *
 * ```
 * val provider = FakeDeviceInfoProvider.android(
 *     info = FakeAndroidInfo(appName = "MyApp")
 * )
 * val viewModel = MyViewModel(provider)
 * ```
 */
object FakeDeviceInfoProvider {
    fun android(info: AndroidInfo = FakeAndroidInfo()): DeviceInfoProvider =
        DeviceInfoProvider { FakeAndroidDeviceInfo(info) }

    fun ios(info: IosInfo = FakeIosInfo()): DeviceInfoProvider =
        DeviceInfoProvider { FakeIosDeviceInfo(info) }

    fun desktop(info: DesktopInfo): DeviceInfoProvider =
        DeviceInfoProvider { FakeDesktopDeviceInfo(info) }

    fun web(info: WebInfo = FakeWebInfo()): DeviceInfoProvider =
        DeviceInfoProvider { FakeWebDeviceInfo(info) }
}
