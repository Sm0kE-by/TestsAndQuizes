package com.BySandS.testsandquizes.domain.allData.useCase

import com.BySandS.testsandquizes.domain.allData.models.AvatarModel
import com.BySandS.testsandquizes.domain.allData.repository.AvatarRepository

class GetListAvatarsUseCase(private val avatarRepository: AvatarRepository) {

    fun execute(): List<AvatarModel>{
        return avatarRepository.getListAvatars()
    }
}