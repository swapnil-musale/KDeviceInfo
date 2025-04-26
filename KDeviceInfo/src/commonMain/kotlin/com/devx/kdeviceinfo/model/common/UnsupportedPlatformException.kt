package com.devx.kdeviceinfo.model.common

class UnsupportedPlatformException(requestedPlatform: String, currentPlatform: String) :
    IllegalStateException(
        "Attempted to access $requestedPlatform platform info while running on $currentPlatform platform"
    )