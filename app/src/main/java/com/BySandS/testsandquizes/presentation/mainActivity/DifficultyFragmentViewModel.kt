package com.BySandS.testsandquizes.presentation.mainActivity

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.BySandS.testsandquizes.domain.tests.models.param.GetQuantityOfQuestionParam
import com.BySandS.testsandquizes.domain.tests.usecase.GetQuantityOfQuestionUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

private const val TAG = "AAA"

class DifficultyFragmentViewModel(
    private val getQuantityOfQuestionUseCase: GetQuantityOfQuestionUseCase
) : ViewModel() {

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
        GetQuantityOfQuestionParam(idQuantity = 1)

    init {
        viewModelScope.launch(Dispatchers.IO) {
            val quantity =
                getQuantityOfQuestionUseCase.execute(param = quantityOfQuestionParam)
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