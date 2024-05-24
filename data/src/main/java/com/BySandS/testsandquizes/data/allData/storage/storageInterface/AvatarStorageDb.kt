package com.BySandS.testsandquizes.data.allData.storage.storageInterface

import com.BySandS.testsandquizes.data.allData.storage.dataBase.models.AvatarModelDb
import com.BySandS.testsandquizes.domain.allData.models.AvatarModel

interface AvatarStorageDb {
    fun getListAvatars(): List<AvatarModelDb>
    fun getAvatarById(id: Long): AvatarModelDb
    fun saveOpenAvatar(id: Long, open: Boolean)
}