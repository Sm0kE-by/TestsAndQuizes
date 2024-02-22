package com.BySandS.testsandquizes.presentation.mainActivity

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.BySandS.testsandquizes.data.test.repository.TestQuantityOfQuestionRepositoryImpl
import com.BySandS.testsandquizes.domain.tests.models.GetQuantityOfQuestionParam
import com.BySandS.testsandquizes.domain.tests.models.QuantityOfQuestionModel
import com.BySandS.testsandquizes.domain.tests.models.SubcategoryModel
import com.BySandS.testsandquizes.domain.tests.usecase.SelectTestDifficultyLevelUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DifficultyFragmentViewModel(application: Application) : AndroidViewModel(application) {

    private val testQuantityOfQuestionRepository = TestQuantityOfQuestionRepositoryImpl(application)
    private val selectTestDifficultyLevelUseCase =
        SelectTestDifficultyLevelUseCase(quantityOfQuestionRepository = testQuantityOfQuestionRepository)
    private var subcategoryModel: SubcategoryModel? = null
    private var quantityOfQuestions: QuantityOfQuestionModel? = null
    private val quantityOfQuestionParam = GetQuantityOfQuestionParam(idSubcategory = 1)

    private fun getQuantity() {
        viewModelScope.launch(Dispatchers.IO) {
            val quantity =
                selectTestDifficultyLevelUseCase.execute(param = quantityOfQuestionParam)
            quantityOfQuestions = quantity
        }

        //Передача из фрагмента!!!!!!!
        subcategoryModel = SubcategoryModel(1, "test", "Cosmosss", 33, 66, 100)
    }

    fun getCategory(): SubcategoryModel {
        getQuantity()
        return subcategoryModel!!
    }

    fun getQuantityOfQuestion(): QuantityOfQuestionModel {
        getQuantity()
        return quantityOfQuestions!!
    }
}