package com.BySandS.testsandquizes.domain.allData.repository

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

interface UserStatisticRepository {

    fun getUserStatisticById(param: GetUserStatisticParam): UserStatisticModel
    fun saveUserStatistic(userStatistic: UserStatisticModel)
    fun getPercentGameCompletionByUserId(param: GetPercentGameCompletionParam): GameCompletionPercentageModel
    fun savePercentGameCompletion(param: SavePercentGameCompletionParam)
    fun getUserNameByUserId(param: GetUserNameParam): UserNameModel
    fun saveQuantityOfGems(param: SaveUserNameParam)
    fun getQuantityOfGemsByUserId(param: GetQuantityOfGemsParam): QuantityOfGemsModel
    fun saveQuantityOfGems(param: SaveQuantityOfGemsParam)


}