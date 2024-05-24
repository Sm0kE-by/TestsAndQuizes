package com.BySandS.testsandquizes.domain.allData.useCase

import com.BySandS.testsandquizes.domain.allData.models.AvatarModel
import com.BySandS.testsandquizes.domain.allData.models.AvatarModelForMainMenu
import com.BySandS.testsandquizes.domain.allData.models.param.GetAvatarByIdParam
import com.BySandS.testsandquizes.domain.allData.repository.AvatarRepository

class GetAvatarByIdUseCase (private val avatarRepository: AvatarRepository){

    fun execute(param: GetAvatarByIdParam): AvatarModel {
        return avatarRepository.getAvatarById(getAvatarByIdParam = param)
    }

}