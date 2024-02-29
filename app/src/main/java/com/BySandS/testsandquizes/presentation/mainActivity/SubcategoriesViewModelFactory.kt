package com.BySandS.testsandquizes.presentation.mainActivity

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.BySandS.testsandquizes.data.test.repository.TestSubcategoryRepositoryImpl
import com.BySandS.testsandquizes.data.test.storage.dao.DaoSubcategoryStorage
import com.BySandS.testsandquizes.domain.tests.usecase.GetTestSubcategoryUseCase

/**
 *
 */
class SubcategoriesViewModelFactory(context: Context) : ViewModelProvider.Factory {

    private val testSubcategoryRepository by lazy {
        TestSubcategoryRepositoryImpl(
            subcategoryStorage = DaoSubcategoryStorage(context = context)
        )
    }
    private val getTestSubcategoryUseCase by lazy {
        GetTestSubcategoryUseCase(
            testSubcategoryRepository = testSubcategoryRepository
        )
    }

    /**
     * Здесь мы указываем как создавать ВМ
     */
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return SubcategoriesViewModel(getTestSubcategoryUseCase = getTestSubcategoryUseCase) as T
    }
}