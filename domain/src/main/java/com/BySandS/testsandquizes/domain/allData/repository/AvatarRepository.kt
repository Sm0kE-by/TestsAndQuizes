package com.BySandS.testsandquizes.domain.allData.repository

import com.BySandS.testsandquizes.domain.allData.models.avatar.AvatarModel
import com.BySandS.testsandquizes.domain.allData.models.avatar.AvatarModelForMainMenu
import com.BySandS.testsandquizes.domain.allData.models.avatar.param.GetAvatarByIdParam
import com.BySandS.testsandquizes.domain.allData.models.avatar.param.SaveAvatarSharedPrefParam
import com.BySandS.testsandquizes.domain.allData.models.avatar.param.SaveOpenAvatarParam

interface AvatarRepository {
    fun getListAvatars(): List<AvatarModel>
    fun getAvatarById(getAvatarByIdParam: GetAvatarByIdParam): AvatarModel
    fun saveOpenAvatar(param: SaveOpenAvatarParam)
    fun getAvatarSharedPref(): AvatarModelForMainMenu
    fun saveAvatarSharedPref(saveAvatarSharedPrefParam: SaveAvatarSharedPrefParam)
}