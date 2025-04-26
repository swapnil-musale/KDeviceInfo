package com.devx.kdeviceinfo.model.web

import com.devx.kdeviceinfo.model.web.WebInfoItem.Companion.UNKNOWN


interface WebInfoItem {

    companion object {

        /**
         * **UNKNOWN** -> the Unknown value to use when the specific information has not found
         */
        private const val UNKNOWN = "Unknown"
    }

    /**
     * Method to use a null-safe value
     *
     * @return the found value or the [UNKNOWN] value as [String]
     */
    fun String?.safeValue(): String {
        return this ?: UNKNOWN
    }
}