package com.BySandS.testsandquizes.presentation

import androidx.lifecycle.ViewModel
import com.BySandS.testsandquizes.presentation.mainActivityModels.SubcategoryModel
import com.BySandS.testsandquizes.presentation.mainActivityModels.QuantityOfQuestionModel

class DifficultyFragmentViewModel : ViewModel() {

    private var subcategoryModel: SubcategoryModel? = null
    private var quantityOfQuestions: QuantityOfQuestionModel? = null

    init {
        subcategoryModel = SubcategoryModel("Тест", "Название", 35, 65, 95)
        quantityOfQuestions = QuantityOfQuestionModel(7, 10, 15)
    }

    fun getCategory(): SubcategoryModel {
        return subcategoryModel!!
    }

    fun getQuantityOfQuestion(): QuantityOfQuestionModel {
        return quantityOfQuestions!!
    }
}