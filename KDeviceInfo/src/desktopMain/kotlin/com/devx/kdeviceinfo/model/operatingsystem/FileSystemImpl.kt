package com.devx.kdeviceinfo.model.operatingsystem

import com.devx.kdeviceinfo.model.desktop.operatingsystem.FileSystem
import com.devx.kdeviceinfo.model.desktop.operatingsystem.OSFileStore
import oshi.SystemInfo

class FileSystemImpl : FileSystem {
    
    private val fileSystem by lazy { SystemInfo().operatingSystem.fileSystem }
    
    override val fileStores: List<OSFileStore>
        get() = loadFileStoresList(
            sourceList = fileSystem.fileStores
        )

    override val openFileDescriptors
        get() = fileSystem.openFileDescriptors
    
    override val maxFileDescriptors
        get() = fileSystem.maxFileDescriptors
    
    override val maxFileDescriptorsPerProcess
        get() = fileSystem.maxFileDescriptorsPerProcess

    fun getFileStores(localOnly: Boolean): List<OSFileStore> {
        return loadFileStoresList(
            sourceList = fileSystem.getFileStores(localOnly)
        )
    }

    private fun loadFileStoresList(
        sourceList: List<oshi.software.os.OSFileStore>
    ) : List<OSFileStore> {
        val result: MutableList<OSFileStore> = mutableListOf()
        sourceList.forEach { fileStore ->
            result.add(
                OSFileStoreImpl(
                    name = fileStore.name,
                    volume = fileStore.volume,
                    label = fileStore.label,
                    logicalVolume = fileStore.logicalVolume,
                    mount = fileStore.mount,
                    description = fileStore.description,
                    type = fileStore.type,
                    options = fileStore.options,
                    uuid = fileStore.uuid,
                    freeSpace = fileStore.freeSpace,
                    usableSpace = fileStore.usableSpace,
                    totalSpace = fileStore.totalSpace,
                    freeInodes = fileStore.freeInodes,
                    totalInodes = fileStore.freeInodes,
                    updateAttributes = fileStore.updateAttributes()
                )
            )
        }
        return result
    }

}