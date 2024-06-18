package com.BySandS.testsandquizes.domain.allData.useCase.avatar

import com.BySandS.testsandquizes.domain.allData.models.avatar.param.SaveAvatarSharedPrefParam
import com.BySandS.testsandquizes.domain.allData.repository.AvatarRepository

class SaveAvatarSPUseCase(private val avatarRepository: AvatarRepository) {

    fun execute(saveAvatarSharedPrefParam: SaveAvatarSharedPrefParam){
        avatarRepository.saveAvatarSharedPref(saveAvatarSharedPrefParam = saveAvatarSharedPrefParam)
    }
}