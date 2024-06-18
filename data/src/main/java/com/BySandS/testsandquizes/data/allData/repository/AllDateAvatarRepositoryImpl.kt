package com.BySandS.testsandquizes.data.allData.repository

import com.BySandS.testsandquizes.data.allData.storage.dataBase.models.AvatarModelDb
import com.BySandS.testsandquizes.data.allData.storage.sharedPref.models.AvatarModelSPForMainMenu
import com.BySandS.testsandquizes.data.allData.storage.storageInterface.AvatarStorageDb
import com.BySandS.testsandquizes.data.allData.storage.storageInterface.AvatarStorageSharedPref
import com.BySandS.testsandquizes.domain.allData.models.avatar.AvatarModel
import com.BySandS.testsandquizes.domain.allData.models.avatar.AvatarModelForMainMenu
import com.BySandS.testsandquizes.domain.allData.models.avatar.param.GetAvatarByIdParam
import com.BySandS.testsandquizes.domain.allData.models.avatar.param.SaveAvatarSharedPrefParam
import com.BySandS.testsandquizes.domain.allData.models.avatar.param.SaveOpenAvatarParam
import com.BySandS.testsandquizes.domain.allData.repository.AvatarRepository

class AllDateAvatarRepositoryImpl(
    private val avatarStorageDb: AvatarStorageDb,
    private val avatarStorageSharedPref: AvatarStorageSharedPref
) :
    AvatarRepository {
    override fun getListAvatars(): List<AvatarModel> {
        return mapToDomainListAvatarsDb(avatarList = avatarStorageDb.getListAvatars())
    }

    override fun getAvatarById(param: GetAvatarByIdParam): AvatarModel {
        return mapToDomainAvatarDb(avatar = avatarStorageDb.getAvatarById(id = param.id))
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
                    open = it.open,
                    avatarIcon = it.avatarIcon
                )
            )
        }
        return listAvatarModel
    }

    private fun mapToDomainAvatarDb(avatar: AvatarModelDb): AvatarModel {
        return AvatarModel(
            id = avatar.id,
            name = avatar.name,
            type = avatar.type,
            description = avatar.description,
            open = avatar.open,
            avatarIcon = avatar.avatarIcon
        )
    }

    private fun mapToDomainAvatarSP(avatar: AvatarModelSPForMainMenu): AvatarModelForMainMenu {
        return AvatarModelForMainMenu(id = avatar.id, avatarIcon = avatar.avatarIcon)
    }

    private fun mapToDataAvatarSP(saveAvatarSharedPrefParam: SaveAvatarSharedPrefParam): AvatarModelSPForMainMenu {
        return AvatarModelSPForMainMenu(
            id = saveAvatarSharedPrefParam.id,
            avatarIcon = saveAvatarSharedPrefParam.avatarIcon
        )
    }
}