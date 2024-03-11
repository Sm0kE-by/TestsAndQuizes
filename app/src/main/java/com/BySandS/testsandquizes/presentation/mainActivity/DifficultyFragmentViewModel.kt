package com.BySandS.testsandquizes.presentation.mainActivity

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.BySandS.testsandquizes.domain.tests.models.QuantityOfQuestionModel
import com.BySandS.testsandquizes.domain.tests.models.SubcategoryModel
import com.BySandS.testsandquizes.domain.tests.models.param.GetQuantityOfQuestionParam
import com.BySandS.testsandquizes.domain.tests.models.param.GetSubcategoryByIdParam
import com.BySandS.testsandquizes.domain.tests.usecase.mainActivity.GetQuantityOfQuestionUseCase
import com.BySandS.testsandquizes.domain.tests.usecase.mainActivity.GetTestSubcategoryUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

private const val TAG = "AAA"

class DifficultyFragmentViewModel(
    private val getQuantityOfQuestionUseCase: GetQuantityOfQuestionUseCase,
    private val getTestSubcategoryUseCase: GetTestSubcategoryUseCase
) : ViewModel() {
    private val subcategoryAndStatisticModelMutable =
        MutableLiveData<SubcategoryModel>()
    private val quantityOfQuestionsMutable = MutableLiveData<QuantityOfQuestionModel>()
    var subcategoryAndStatisticModel: LiveData<SubcategoryModel> =
        subcategoryAndStatisticModelMutable
    var quantityOfQuestions: LiveData<QuantityOfQuestionModel> = quantityOfQuestionsMutable
    private var idQuantityOfQuestion: Long = DifficultyFragment.idQuantityOfQuestion
    private var idSubcategory: Long = DifficultyFragment.idSubcategoryAndStatistic
    private var quantityOfQuestionParam = GetQuantityOfQuestionParam(idQuantityOfQuestion)
    private var getTestSubcategoryAndStatisticParam = GetSubcategoryByIdParam(idSubcategory)

    init {
        viewModelScope.launch(Dispatchers.IO) {
            quantityOfQuestionsMutable.postValue(getQuantityOfQuestionUseCase.execute(param = quantityOfQuestionParam))
            subcategoryAndStatisticModelMutable.postValue(
                getTestSubcategoryUseCase.execute(
                    param = getTestSubcategoryAndStatisticParam
                )
            )
        }
    }
}