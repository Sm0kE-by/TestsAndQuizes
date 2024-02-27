package com.BySandS.testsandquizes.presentation.mainActivity

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.BySandS.testsandquizes.data.test.repository.TestSubcategoryRepositoryImpl
import com.BySandS.testsandquizes.data.test.storage.dao.DaoSubcategoryStorage
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

private const val TAG = "AAA"

class SubcategoriesFragmentViewModel(application: Application) : AndroidViewModel(application) {

    private val subcategoryStorage = DaoSubcategoryStorage(application)
    private val testSubcategoryRepository = TestSubcategoryRepositoryImpl(subcategoryStorage)
    private val getTestSubcategoryUseCase =
        com.BySandS.testsandquizes.domain.tests.usecase.GetTestSubcategoryUseCase(
            testSubcategoryRepository
        )
    private val param = com.BySandS.testsandquizes.domain.tests.models.GetCategoryParam(1)
    private var listSubcategoryModelLiveData = MutableLiveData<List<com.BySandS.testsandquizes.domain.tests.models.SubcategoryModel>>()

    private fun initList() {
        // Create a new coroutine to move the execution off the UI thread
        viewModelScope.launch(Dispatchers.IO) {
            val list = getTestSubcategoryUseCase.execute(param)
            listSubcategoryModelLiveData.postValue(list)
        }
    }

    //Проверить перезапись и автообновление
    fun getList(): LiveData<List<com.BySandS.testsandquizes.domain.tests.models.SubcategoryModel>> {
        initList()
        return listSubcategoryModelLiveData
    }
}





