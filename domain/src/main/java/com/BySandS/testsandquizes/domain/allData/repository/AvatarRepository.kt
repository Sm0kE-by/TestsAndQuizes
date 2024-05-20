package com.BySandS.testsandquizes.domain.allData.repository

import com.BySandS.testsandquizes.domain.allData.models.AvatarModel
import com.BySandS.testsandquizes.domain.allData.models.AvatarModelForMainMenu
import com.BySandS.testsandquizes.domain.allData.models.param.SaveAvatarSharedPrefParam
import com.BySandS.testsandquizes.domain.allData.models.param.SaveOpenAvatarParam

interface AvatarRepository {
    fun getListAvatars(): List<AvatarModel>
    fun saveOpenAvatar(saveOpenAvatarParam: SaveOpenAvatarParam)
    fun getAvatarSharedPref(): AvatarModelForMainMenu
    fun saveAvatarSharedPref(saveAvatarSharedPrefParam: SaveAvatarSharedPrefParam)
}