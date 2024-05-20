package com.BySandS.testsandquizes.data.allData.storage.storageInterface

import com.BySandS.testsandquizes.data.allData.storage.sharedPref.models.AvatarModelSPForMainMenu

interface AvatarStorageSharedPref {
    fun getAvatarSharedPref(): AvatarModelSPForMainMenu
    fun saveAvatarSharedPref(avatarModelSp: AvatarModelSPForMainMenu)
}