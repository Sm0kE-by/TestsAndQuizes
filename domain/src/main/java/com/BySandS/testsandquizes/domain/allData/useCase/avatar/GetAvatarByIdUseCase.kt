package com.BySandS.testsandquizes.domain.allData.useCase.avatar

import com.BySandS.testsandquizes.domain.allData.models.avatar.AvatarModel
import com.BySandS.testsandquizes.domain.allData.models.avatar.param.GetAvatarByIdParam
import com.BySandS.testsandquizes.domain.allData.repository.AvatarRepository

class GetAvatarByIdUseCase (private val avatarRepository: AvatarRepository){

    fun execute(param: GetAvatarByIdParam): AvatarModel {
        return avatarRepository.getAvatarById(getAvatarByIdParam = param)
    }

}