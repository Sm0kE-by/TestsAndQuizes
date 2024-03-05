package com.BySandS.testsandquizes.presentation.mainActivity

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.BySandS.testsandquizes.domain.tests.models.QuantityOfQuestionModel
import com.BySandS.testsandquizes.domain.tests.models.SubcategoryAndStatisticModel
import com.BySandS.testsandquizes.domain.tests.models.param.GetQuantityOfQuestionParam
import com.BySandS.testsandquizes.domain.tests.usecase.GetQuantityOfQuestionUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

private const val TAG = "AAA"

class DifficultyFragmentViewModel(
    private val getQuantityOfQuestionUseCase: GetQuantityOfQuestionUseCase
) : ViewModel() {

    private val subcategoryAndStatisticModelMutable = MutableLiveData<SubcategoryAndStatisticModel>(
        SubcategoryAndStatisticModel(
            1, "test", "Cosmosss", 33, 66, 100
        )
    )
    var subcategoryAndStatisticModel: LiveData<SubcategoryAndStatisticModel> = subcategoryAndStatisticModelMutable

    private val quantityOfQuestionsMutable = MutableLiveData<QuantityOfQuestionModel>()
    var quantityOfQuestions: LiveData<QuantityOfQuestionModel> = quantityOfQuestionsMutable

    private val quantityOfQuestionParam =
        GetQuantityOfQuestionParam(idQuantity = 1)

    init {
        viewModelScope.launch(Dispatchers.IO) {
            quantityOfQuestionsMutable.postValue(getQuantityOfQuestionUseCase.execute(param = quantityOfQuestionParam))
        }
    }
}