package com.BySandS.testsandquizes.presentation

import androidx.lifecycle.ViewModel
import com.BySandS.testsandquizes.DataBase.models.SubcategoryModelDB
import com.BySandS.testsandquizes.presentation.mainActivityModels.QuantityOfQuestionModel

class DifficultyFragmentViewModel : ViewModel() {

    private var subcategoryModel: SubcategoryModelDB? = null
    private var quantityOfQuestions: QuantityOfQuestionModel? = null

    init {
        subcategoryModel = SubcategoryModelDB(1,"Тест", "Название", 35, 65, 95)
        quantityOfQuestions = QuantityOfQuestionModel(7, 10, 15)
    }

    fun getCategory(): SubcategoryModelDB {
        return subcategoryModel!!
    }

    fun getQuantityOfQuestion(): QuantityOfQuestionModel {
        return quantityOfQuestions!!
    }
}