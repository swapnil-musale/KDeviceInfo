package com.devx.kdeviceinfo.model.web

interface WebInfoItem {

    companion object {

        /**
         * **UKNOWN** -> the uknown value to use when the specific information has not found
         */
        private const val UKNOWN = "uknown"
    }

    /**
     * Method to use a null-safe value
     *
     * @return the found value or the [UKNOWN] value as [String]
     */
    fun String?.safeValue(): String {
        return if (this != null)
            this
        else
            UKNOWN
    }

}