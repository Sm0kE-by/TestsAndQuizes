package com.BySandS.testsandquizes.presentation.mainActivity

import android.util.Log
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
    private val subcategoryAndStatisticModelMutable = MutableLiveData<SubcategoryModel>()
    private val quantityOfQuestionsMutable = MutableLiveData<QuantityOfQuestionModel>()

    var subcategoryAndStatisticModel: LiveData<SubcategoryModel> =
        subcategoryAndStatisticModelMutable
    var quantityOfQuestions: LiveData<QuantityOfQuestionModel> = quantityOfQuestionsMutable

    // private var idQuantityOfQuestion: Long = DifficultyFragment.idQuantityOfQuestion
    private var idSubcategory: Long = DifficultyFragment.idSubcategoryAndStatistic

    // private var quantityOfQuestionParam = GetQuantityOfQuestionParam(idQuantityOfQuestion)
    private var getTestSubcategoryAndStatisticParam = GetSubcategoryByIdParam(idSubcategory)

    init {
        completeOrder()
//       // viewModelScope.launch(Dispatchers.IO) {
//
//            subcategoryAndStatisticModelMutable.postValue(
//                getTestSubcategoryUseCase.execute(
//                    param = getTestSubcategoryAndStatisticParam
//                )
//            )
//
//            val quantityOfQuestionParam =
//                subcategoryAndStatisticModel.value?.let { GetQuantityOfQuestionParam(it.quantityOfQuestionsId) }
//            quantityOfQuestionsMutable.postValue(quantityOfQuestionParam?.let { getQuantityOfQuestionUseCase.execute(param = it) })
//        }
    }

    private fun completeOrder() = viewModelScope.launch(Dispatchers.IO) {
        val createOrderJob = launch {
            subcategoryAndStatisticModelMutable.postValue(
                getTestSubcategoryUseCase.execute(
                    param = getTestSubcategoryAndStatisticParam
                )
            )
            Log.i(TAG, "idSubcategory => ${subcategoryAndStatisticModelMutable.value}")
        }
        createOrderJob.join()
        Log.i(TAG, "idSubcategory => ${subcategoryAndStatisticModelMutable.value}")
        val invoiceJob = launch {
            val quantityOfQuestionParam =
                subcategoryAndStatisticModel.value?.quantityOfQuestionsId?.let {
                    GetQuantityOfQuestionParam(
                        it
                    )
                }
            quantityOfQuestionsMutable.postValue(
                quantityOfQuestionParam?.let {
                    getQuantityOfQuestionUseCase.execute(
                        param = it
                    )
                }
            )
            Log.i(TAG, "idSubcategory => ${quantityOfQuestionsMutable.value}")
        }
        invoiceJob.join()

        Log.i(TAG, "idSubcategory => ${quantityOfQuestionsMutable.value}")
    }
}
