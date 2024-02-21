package com.BySandS.testsandquizes.presentation.mainActivity

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.BySandS.testsandquizes.data.test.repository.TestSubcategoryRepositoryImpl
import com.BySandS.testsandquizes.domain.tests.models.GetCategoryParam
import com.BySandS.testsandquizes.domain.tests.models.SubcategoryModel
import com.BySandS.testsandquizes.domain.tests.usecase.GetTestSubcategoryUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class SubcategoriesFragmentViewModel(application: Application) : AndroidViewModel(application) {


    private val testSubcategoryRepository = TestSubcategoryRepositoryImpl(application)
    private val getTestSubcategoryUseCase = GetTestSubcategoryUseCase(testSubcategoryRepository)
    private val param = GetCategoryParam(1)
    private var listSubcategoryModelLiveData: LiveData<List<SubcategoryModel>> =
        MutableLiveData()

    fun getListLiveData(): LiveData<List<SubcategoryModel>> {
        viewModelScope.launch(Dispatchers.IO) {
           listSubcategoryModelLiveData = MutableLiveData(getTestSubcategoryUseCase.execute(param))
        }
        return listSubcategoryModelLiveData
    }
}





