package com.BySandS.testsandquizes.domain.allData.useCase.avatar

import com.BySandS.testsandquizes.domain.allData.models.avatar.AvatarModel
import com.BySandS.testsandquizes.domain.allData.repository.AvatarRepository

class GetListAvatarsUseCase(private val avatarRepository: AvatarRepository) {

    fun execute(): List<AvatarModel>{
        return avatarRepository.getListAvatars()
    }
}