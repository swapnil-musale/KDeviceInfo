package com.devx.kdeviceinfo.model.browser

import com.devx.kdeviceinfo.model.web.browser.Browser

class BrowserImpl(
    private val parsedBrowser: com.devx.kdeviceinfo.model.Browser
) : Browser {

    override val name: String
        get() = parsedBrowser.name.safeValue()

    override val version: String
        get() = parsedBrowser.version.safeValue()
}