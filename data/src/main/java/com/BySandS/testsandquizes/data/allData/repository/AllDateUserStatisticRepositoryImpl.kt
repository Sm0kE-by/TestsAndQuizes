package com.BySandS.testsandquizes.data.allData.repository

import com.BySandS.testsandquizes.data.allData.storage.dataBase.entity.UserStatisticDbEntity
import com.BySandS.testsandquizes.data.allData.storage.dataBase.models.GameCompletionPercentageModelDb
import com.BySandS.testsandquizes.data.allData.storage.dataBase.models.QuantityOfGemsModelDb
import com.BySandS.testsandquizes.data.allData.storage.dataBase.models.UserNameModelDb
import com.BySandS.testsandquizes.data.allData.storage.dataBase.models.UserStatisticModelDb
import com.BySandS.testsandquizes.data.allData.storage.storageInterface.UserStatisticStorage
import com.BySandS.testsandquizes.domain.allData.models.mainMenu.GameCompletionPercentageModel
import com.BySandS.testsandquizes.domain.allData.models.mainMenu.QuantityOfGemsModel
import com.BySandS.testsandquizes.domain.allData.models.mainMenu.UserNameModel
import com.BySandS.testsandquizes.domain.allData.models.mainMenu.UserStatisticModel
import com.BySandS.testsandquizes.domain.allData.models.mainMenu.param.GetPercentGameCompletionParam
import com.BySandS.testsandquizes.domain.allData.models.mainMenu.param.GetQuantityOfGemsParam
import com.BySandS.testsandquizes.domain.allData.models.mainMenu.param.GetUserNameParam
import com.BySandS.testsandquizes.domain.allData.models.mainMenu.param.GetUserStatisticParam
import com.BySandS.testsandquizes.domain.allData.models.mainMenu.param.SavePercentGameCompletionParam
import com.BySandS.testsandquizes.domain.allData.models.mainMenu.param.SaveQuantityOfGemsParam
import com.BySandS.testsandquizes.domain.allData.models.mainMenu.param.SaveUserNameParam
import com.BySandS.testsandquizes.domain.allData.repository.UserStatisticRepository

class AllDateUserStatisticRepositoryImpl(private val userStatisticStorage: UserStatisticStorage) :
    UserStatisticRepository {

    override fun getUserStatisticById(param: GetUserStatisticParam): UserStatisticModel {
        return mapToDomainUserStatistic(statistic = userStatisticStorage.getUserStatisticById(userId = param.userID))
    }

    override fun saveUserStatistic(userStatistic: UserStatisticModel) {
        userStatisticStorage.saveUserStatistic(mapToDateUserStatistic(statistic = userStatistic))
    }

    override fun getPercentGameCompletionByUserId(param: GetPercentGameCompletionParam): GameCompletionPercentageModel {
        return mapToDomainPercentGameCompletion(
            percent = userStatisticStorage.getPercentGameCompletionByUserId(
                param.userId
            )
        )
    }

    override fun savePercentGameCompletion(param: SavePercentGameCompletionParam) {
        userStatisticStorage.savePercentGameCompletion(
            userId = param.userId,
            percent = param.percent
        )
    }

    override fun getUserNameByUserId(param: GetUserNameParam): UserNameModel {
        return mapToDomainUserName(name = userStatisticStorage.getUserNameByUserId(param.userId))
    }

    override fun saveQuantityOfGems(param: SaveUserNameParam) {
        userStatisticStorage.saveUserName(userId = param.userId, userName = param.userName)
    }

    override fun getQuantityOfGemsByUserId(param: GetQuantityOfGemsParam): QuantityOfGemsModel {
        return mapToDomainQuantityOfGems(gems = userStatisticStorage.getQuantityOfGemsByUserId(param.userId))
    }

    override fun saveQuantityOfGems(param: SaveQuantityOfGemsParam) {
        userStatisticStorage.saveQuantityOfGems(userId = param.userId, gems = param.quantityOfGems)
    }

    private fun mapToDomainUserStatistic(statistic: UserStatisticModelDb): UserStatisticModel {
        return UserStatisticModel(
            id = statistic.id,
            userName = statistic.userName,
            percentGameCompletion = statistic.percentGameCompletion,
            prestige = statistic.prestige,
            gems = statistic.gems
        )
    }
    private fun mapToDateUserStatistic(statistic: UserStatisticModel): UserStatisticDbEntity {
        return UserStatisticDbEntity(
            id = statistic.id,
            userName = statistic.userName,
            percentGameCompletion = statistic.percentGameCompletion,
            prestige = statistic.prestige,
            gems = statistic.gems
        )
    }
    private fun mapToDomainPercentGameCompletion(percent: GameCompletionPercentageModelDb): GameCompletionPercentageModel {
        return GameCompletionPercentageModel(
            percentGameCompletion = percent.percentGameCompletion
        )
    }
    private fun mapToDomainUserName(name: UserNameModelDb): UserNameModel {
        return UserNameModel(
            userName = name.userName
        )
    }
    private fun mapToDomainQuantityOfGems(gems: QuantityOfGemsModelDb): QuantityOfGemsModel {
        return QuantityOfGemsModel(
            gems = gems.gems
        )
    }


}