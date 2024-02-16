package com.BySandS.testsandquizes.presentation.mainActivity

import androidx.lifecycle.ViewModel
import com.BySandS.testsandquizes.data.test.models.SubcategoryModelDb
import com.BySandS.testsandquizes.presentation.mainActivity.mainActivityModels.QuantityOfQuestionModel

class DifficultyFragmentViewModel : ViewModel() {

    private var subcategoryModel: SubcategoryModelDb? = null
    private var quantityOfQuestions: QuantityOfQuestionModel? = null

    init {
        subcategoryModel = SubcategoryModelDb(1,"Тест", "Название категории", 35, 65, 95)
        quantityOfQuestions = QuantityOfQuestionModel(7, 10, 15)
    }

    fun getCategory(): SubcategoryModelDb {
        return subcategoryModel!!
    }

    fun getQuantityOfQuestion(): QuantityOfQuestionModel {
        return quantityOfQuestions!!
    }
}