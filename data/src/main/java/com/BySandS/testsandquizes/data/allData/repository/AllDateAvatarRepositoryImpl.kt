package com.BySandS.testsandquizes.data.allData.repository

import com.BySandS.testsandquizes.data.allData.storage.dataBase.models.AvatarModelDb
import com.BySandS.testsandquizes.data.allData.storage.sharedPref.models.AvatarModelSPForMainMenu
import com.BySandS.testsandquizes.data.allData.storage.storageInterface.AvatarStorageDb
import com.BySandS.testsandquizes.data.allData.storage.storageInterface.AvatarStorageSharedPref
import com.BySandS.testsandquizes.domain.allData.models.AvatarModel
import com.BySandS.testsandquizes.domain.allData.models.AvatarModelForMainMenu
import com.BySandS.testsandquizes.domain.allData.models.param.SaveAvatarSharedPrefParam
import com.BySandS.testsandquizes.domain.allData.models.param.SaveOpenAvatarParam
import com.BySandS.testsandquizes.domain.allData.repository.AvatarRepository

class AllDateAvatarRepositoryImpl(
    private val avatarStorageDb: AvatarStorageDb,
    private val avatarStorageSharedPref: AvatarStorageSharedPref
) :
    AvatarRepository {
    override fun getListAvatars(): List<AvatarModel> {
        return mapToDomainListAvatarsDb(avatarList = avatarStorageDb.getListAvatars())
    }

    override fun saveOpenAvatar(saveOpenAvatarParam: SaveOpenAvatarParam) {
        avatarStorageDb.saveOpenAvatar(
            id = saveOpenAvatarParam.id,
            open = saveOpenAvatarParam.open
        )
    }

    override fun getAvatarSharedPref(): AvatarModelForMainMenu {
        return mapToDomainAvatarSP(avatarStorageSharedPref.getAvatarSharedPref())
    }

    override fun saveAvatarSharedPref(saveAvatarSharedPrefParam: SaveAvatarSharedPrefParam) {
        avatarStorageSharedPref.saveAvatarSharedPref(mapToDataAvatarSP(saveAvatarSharedPrefParam = saveAvatarSharedPrefParam))
    }

    private fun mapToDomainListAvatarsDb(avatarList: List<AvatarModelDb>): List<AvatarModel> {
        var listAvatarModel = ArrayList<AvatarModel>()
        avatarList.forEach { it ->
            listAvatarModel.add(
                AvatarModel(
                    id = it.id,
                    name = it.name,
                    type = it.type,
                    description = it.description,
                    open = it.open
                )
            )
        }
        return listAvatarModel
    }

    private fun mapToDomainAvatarSP(avatar: AvatarModelSPForMainMenu): AvatarModelForMainMenu {
        return AvatarModelForMainMenu(id = avatar.id, name = avatar.name)
    }

    private fun mapToDataAvatarSP(saveAvatarSharedPrefParam: SaveAvatarSharedPrefParam): AvatarModelSPForMainMenu {
        return AvatarModelSPForMainMenu(
            id = saveAvatarSharedPrefParam.id,
            name = saveAvatarSharedPrefParam.nameAvatar
        )
    }
}