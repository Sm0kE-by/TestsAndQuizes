package com.BySandS.testsandquizes.presentation.mainActivity

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.BySandS.testsandquizes.data.test.repository.TestQuantityOfQuestionRepositoryImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

private const val TAG = "AAA"

class DifficultyFragmentViewModel(application: Application) : AndroidViewModel(application) {

    private val testQuantityOfQuestionRepository = TestQuantityOfQuestionRepositoryImpl(application)
    private val selectTestDifficultyLevelUseCase =
        com.BySandS.testsandquizes.domain.tests.usecase.SelectTestDifficultyLevelUseCase(
            quantityOfQuestionRepository = testQuantityOfQuestionRepository
        )
    private var subcategoryModel: com.BySandS.testsandquizes.domain.tests.models.SubcategoryModel? =
        com.BySandS.testsandquizes.domain.tests.models.SubcategoryModel(
            1,
            "test",
            "Cosmosss",
            33,
            66,
            100
        )
    private var quantityOfQuestions: com.BySandS.testsandquizes.domain.tests.models.QuantityOfQuestionModel =
        com.BySandS.testsandquizes.domain.tests.models.QuantityOfQuestionModel(2, 8, 11, 16)
    private val quantityOfQuestionParam =
        com.BySandS.testsandquizes.domain.tests.models.GetQuantityOfQuestionParam(idQuantity = 1)

    init {
        getQuantity()
    }

    private fun getQuantity() {
        viewModelScope.launch(Dispatchers.IO) {
            val quantity =
                selectTestDifficultyLevelUseCase.execute(param = quantityOfQuestionParam)
            quantityOfQuestions = quantity
        }
    }

    fun getCategory(): com.BySandS.testsandquizes.domain.tests.models.SubcategoryModel {
        return subcategoryModel!!
    }

    fun getQuantityOfQuestion(): com.BySandS.testsandquizes.domain.tests.models.QuantityOfQuestionModel {
        return quantityOfQuestions
    }
}