package com.BySandS.testsandquizes.presentation.mainActivity

import androidx.lifecycle.ViewModel
import com.BySandS.testsandquizes.data.test.repository.TestQuantityOfQuestionRepositoryImpl
import com.BySandS.testsandquizes.domain.tests.models.GetQuantityOfQuestionParam
import com.BySandS.testsandquizes.domain.tests.models.QuantityOfQuestionModel
import com.BySandS.testsandquizes.domain.tests.models.SubcategoryModel
import com.BySandS.testsandquizes.domain.tests.usecase.SelectTestDifficultyLevelUseCase

class DifficultyFragmentViewModel : ViewModel() {

    private val testQuantityOfQuestionRepository = TestQuantityOfQuestionRepositoryImpl()
    private val selectTestDifficultyLevelUseCase = SelectTestDifficultyLevelUseCase(quantityOfQuestionRepository = testQuantityOfQuestionRepository)
    private var subcategoryModel: SubcategoryModel? = null
    private var quantityOfQuestions: QuantityOfQuestionModel? = null
    private val quantityOfQuestionParam = GetQuantityOfQuestionParam ( idSubcategory = 1)

    init {
       // quantityOfQuestions =selectTestDifficultyLevelUseCase.execute(param = quantityOfQuestionParam)
    }

    fun getCategory(): SubcategoryModel {
        return subcategoryModel!!
    }

    fun getQuantityOfQuestion(): QuantityOfQuestionModel {
        return quantityOfQuestions!!
    }
}