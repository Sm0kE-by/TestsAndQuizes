package com.BySandS.testsandquizes.domain.allData.useCase

import com.BySandS.testsandquizes.domain.allData.models.param.SaveAvatarSharedPrefParam
import com.BySandS.testsandquizes.domain.allData.repository.AvatarRepository

class SaveAvatarSPUseCase(private val avatarRepository: AvatarRepository) {

    fun execute(saveAvatarSharedPrefParam: SaveAvatarSharedPrefParam){
        avatarRepository.saveAvatarSharedPref(saveAvatarSharedPrefParam = saveAvatarSharedPrefParam)
    }
}