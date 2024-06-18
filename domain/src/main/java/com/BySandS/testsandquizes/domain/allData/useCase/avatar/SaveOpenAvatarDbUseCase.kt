package com.BySandS.testsandquizes.domain.allData.useCase.avatar

import com.BySandS.testsandquizes.domain.allData.models.avatar.param.SaveOpenAvatarParam
import com.BySandS.testsandquizes.domain.allData.repository.AvatarRepository

class SaveOpenAvatarDbUseCase(private val avatarRepository: AvatarRepository) {

    fun execute(saveOpenAvatarParam: SaveOpenAvatarParam){
       avatarRepository.saveOpenAvatar(param = saveOpenAvatarParam)
    }
}