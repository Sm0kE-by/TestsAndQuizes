package com.BySandS.testsandquizes.presentation.mainActivity

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.BySandS.testsandquizes.data.test.repository.TestQuantityOfQuestionRepositoryImpl
import com.BySandS.testsandquizes.domain.tests.models.GetQuantityOfQuestionParam
import com.BySandS.testsandquizes.domain.tests.models.QuantityOfQuestionModel
import com.BySandS.testsandquizes.domain.tests.models.SubcategoryModel
import com.BySandS.testsandquizes.domain.tests.usecase.SelectTestDifficultyLevelUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

private const val TAG = "AAA"

class DifficultyFragmentViewModel(application: Application) : AndroidViewModel(application) {

    private val testQuantityOfQuestionRepository = TestQuantityOfQuestionRepositoryImpl(application)
    private val selectTestDifficultyLevelUseCase =
        SelectTestDifficultyLevelUseCase(quantityOfQuestionRepository = testQuantityOfQuestionRepository)
    private var subcategoryModel: SubcategoryModel? =
        SubcategoryModel(1, "test", "Cosmosss", 33, 66, 100)
    private var quantityOfQuestions: QuantityOfQuestionModel = QuantityOfQuestionModel(2,8,11,16)
    private val quantityOfQuestionParam = GetQuantityOfQuestionParam(idQuantity = 1)

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

    fun getCategory(): SubcategoryModel {
        return subcategoryModel!!
    }

    fun getQuantityOfQuestion(): QuantityOfQuestionModel {
        return quantityOfQuestions
    }
}