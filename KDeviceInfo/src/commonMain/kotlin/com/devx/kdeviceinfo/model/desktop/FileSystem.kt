package com.devx.kdeviceinfo.model.desktop

interface FileSystem {
    val fileStores: List<OSFileStore>
    val fileStoresLocalOnly: List<OSFileStore>
    val openFileDescriptors: Long
    val maxFileDescriptors: Long
    val maxFileDescriptorsPerProcess: Long
}