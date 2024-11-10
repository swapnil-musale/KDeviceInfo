package com.devx.kdeviceinfo.model.desktop.operatingsystem

interface FileSystem {
    val fileStores: List<OSFileStore>
    val openFileDescriptors: Long
    val maxFileDescriptors: Long
    val maxFileDescriptorsPerProcess: Long
}