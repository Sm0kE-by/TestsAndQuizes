package com.BySandS.testsandquizes.domain.allData.useCase

import com.BySandS.testsandquizes.domain.allData.models.AvatarModelForMainMenu
import com.BySandS.testsandquizes.domain.allData.repository.AvatarRepository

class GetAvatarForMainMenuUseCase(private val avatarRepository: AvatarRepository){

    fun execute():AvatarModelForMainMenu{
        return avatarRepository.getAvatarSharedPref()
    }

}