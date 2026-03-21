package com.devx.kdeviceinfo

import android.content.Context

/**
 * Entry point for Android initialization of the KDeviceInfo library.
 *
 * By default, the library is automatically initialized via AndroidX Startup.
 * For manual control (e.g., when Startup is disabled or in tests):
 *
 * ```
 * // In Application.onCreate() or before first use:
 * KDeviceInfo.initialize(applicationContext)
 * ```
 *
 * For instrumented tests, call [initialize] with a test [Context]
 * before accessing device info.
 */
object KDeviceInfo {

    @Volatile
    private var _context: Context? = null

    /**
     * The application [Context] used internally by the library.
     *
     * @throws IllegalStateException if [initialize] has not been called
     */
    internal val context: Context
        get() = _context ?: throw IllegalStateException(
            "KDeviceInfo is not initialized. " +
                "Call KDeviceInfo.initialize(context) in Application.onCreate(), " +
                "or ensure AndroidX Startup is not disabled in your manifest."
        )

    /**
     * Initializes KDeviceInfo with the given [context].
     *
     * Uses [Context.getApplicationContext] internally, so any context type is safe.
     * Safe to call multiple times -- only the first call takes effect.
     */
    fun initialize(context: Context) {
        if (_context == null) {
            synchronized(this) {
                if (_context == null) {
                    _context = context.applicationContext
                }
            }
        }
    }

    /**
     * Returns `true` if [initialize] has been called successfully.
     */
    val isInitialized: Boolean get() = _context != null
}
