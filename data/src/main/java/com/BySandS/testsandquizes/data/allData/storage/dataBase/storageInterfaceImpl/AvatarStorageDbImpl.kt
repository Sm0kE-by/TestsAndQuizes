package com.BySandS.testsandquizes.data.allData.storage.dataBase.storageInterfaceImpl

import android.content.Context
import com.BySandS.testsandquizes.data.allData.storage.dataBase.models.AvatarModelDb
import com.BySandS.testsandquizes.data.allData.storage.storageInterface.AvatarStorageDb
import com.BySandS.testsandquizes.data.tests.storage.dataBase.AppDatabase

class AvatarStorageDbImpl(context: Context): AvatarStorageDb {

    private val avatarDao = AppDatabase.getInstance(context).avatarDao()
    override fun getListAvatars(): List<AvatarModelDb> {
        return avatarDao.getListAvatars()
    }

    override fun getAvatarById(id: Long): AvatarModelDb {
       return avatarDao.getAvatarById(id = id)
    }

    override fun saveOpenAvatar(id: Long, open: Boolean) {
       avatarDao.saveOpenAvatar(id = id, open = open)
    }
}