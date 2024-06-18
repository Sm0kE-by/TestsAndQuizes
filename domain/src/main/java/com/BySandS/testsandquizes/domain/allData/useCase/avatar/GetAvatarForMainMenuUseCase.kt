package com.BySandS.testsandquizes.domain.allData.useCase.avatar

import com.BySandS.testsandquizes.domain.allData.models.avatar.AvatarModelForMainMenu
import com.BySandS.testsandquizes.domain.allData.models.avatar.param.SaveAvatarSharedPrefParam
import com.BySandS.testsandquizes.domain.allData.repository.AvatarRepository

class GetAvatarForMainMenuUseCase(private val avatarRepository: AvatarRepository) {

    fun execute(): AvatarModelForMainMenu {
        var avatar = avatarRepository.getAvatarSharedPref()

        if (avatar.avatarIcon == "11") {
            avatarRepository.saveAvatarSharedPref(
                saveAvatarSharedPrefParam = SaveAvatarSharedPrefParam(
                    id = 1,
                    avatarIcon = "avatar_1.png"
                )
            )
            avatar = avatarRepository.getAvatarSharedPref()
        }
        return avatar
    }
}