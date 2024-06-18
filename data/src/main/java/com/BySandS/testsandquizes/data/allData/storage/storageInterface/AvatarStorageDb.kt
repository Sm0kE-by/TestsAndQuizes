package com.BySandS.testsandquizes.data.allData.storage.storageInterface

import com.BySandS.testsandquizes.data.allData.storage.dataBase.models.AvatarModelDb

interface AvatarStorageDb {
    fun getListAvatars(): List<AvatarModelDb>
    fun getAvatarById(id: Long): AvatarModelDb
    fun saveOpenAvatar(id: Long, open: Boolean)
}