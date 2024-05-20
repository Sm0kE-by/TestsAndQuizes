package com.BySandS.testsandquizes.data.allData.storage.sharedPref.storageInterfaceImpl

import android.content.Context
import com.BySandS.testsandquizes.data.allData.storage.sharedPref.models.AvatarModelSPForMainMenu
import com.BySandS.testsandquizes.data.allData.storage.storageInterface.AvatarStorageSharedPref

const val SHARED_PREFS_AVATAR_NAME = "SHARED_PREFS_AVATAR_NAME"
const val KEY_AVATAR_ID = "KEY_AVATAR_ID"
const val KEY_AVATAR_NAME = "KEY_AVATAR_NAME"

class AvatarStorageSharedPrefImpl(context: Context): AvatarStorageSharedPref {

    private val sharedPreferences = context.getSharedPreferences(SHARED_PREFS_AVATAR_NAME, Context.MODE_PRIVATE)

    override fun getAvatarSharedPref(): AvatarModelSPForMainMenu {
        // 11 - default
        return AvatarModelSPForMainMenu(
            id = sharedPreferences.getLong(KEY_AVATAR_ID,11),
            name = sharedPreferences.getString(KEY_AVATAR_NAME,"11")!!,
        )
    }

    override fun saveAvatarSharedPref(avatarModelSp: AvatarModelSPForMainMenu) {
       sharedPreferences.edit().putLong(KEY_AVATAR_ID, avatarModelSp.id).apply()
       sharedPreferences.edit().putString(KEY_AVATAR_NAME, avatarModelSp.name).apply()
    }
}