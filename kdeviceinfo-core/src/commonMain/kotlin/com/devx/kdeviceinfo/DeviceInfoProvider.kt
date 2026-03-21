package com.devx.kdeviceinfo

/**
 * Provider interface for obtaining [DeviceInfo].
 *
 * Use this in ViewModels and business logic classes to enable
 * dependency injection and testing:
 *
 * ```
 * class MyViewModel(
 *     private val deviceInfoProvider: DeviceInfoProvider = DeviceInfoProvider()
 * ) {
 *     val info = deviceInfoProvider.get()
 * }
 * ```
 *
 * For testing, inject a fake provider:
 * ```
 * val viewModel = MyViewModel(
 *     deviceInfoProvider = DeviceInfoProvider { FakeAndroidDeviceInfo() }
 * )
 * ```
 *
 * @see getDeviceInfo
 */
fun interface DeviceInfoProvider {
    /**
     * Returns the [DeviceInfo] for the current platform.
     */
    fun get(): DeviceInfo
}

/**
 * Creates a default [DeviceInfoProvider] that delegates to the platform-specific [getDeviceInfo].
 *
 * This is the recommended way to obtain a provider for production use:
 * ```
 * val provider = DeviceInfoProvider()
 * val info = provider.get()
 * ```
 */
fun DeviceInfoProvider(): DeviceInfoProvider = DeviceInfoProvider { getDeviceInfo() }
