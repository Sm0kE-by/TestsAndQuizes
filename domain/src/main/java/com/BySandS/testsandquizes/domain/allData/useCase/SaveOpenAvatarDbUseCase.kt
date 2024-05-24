package com.BySandS.testsandquizes.domain.allData.useCase

import com.BySandS.testsandquizes.domain.allData.models.param.SaveOpenAvatarParam
import com.BySandS.testsandquizes.domain.allData.repository.AvatarRepository

class SaveOpenAvatarDbUseCase(private val avatarRepository: AvatarRepository) {

    fun execute(saveOpenAvatarParam: SaveOpenAvatarParam){
       avatarRepository.saveOpenAvatar(param = saveOpenAvatarParam)
    }
}