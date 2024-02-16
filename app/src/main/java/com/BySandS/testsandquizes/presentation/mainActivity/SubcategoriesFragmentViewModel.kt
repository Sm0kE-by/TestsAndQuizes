package com.BySandS.testsandquizes.presentation.mainActivity

import androidx.lifecycle.ViewModel
import com.BySandS.testsandquizes.data.test.subcategory.TestSubcategoryRepositoryImpl

class SubcategoriesFragmentViewModel : ViewModel() {
    private val testSubcategoryRepositoryImpl = TestSubcategoryRepositoryImpl.get()
     val listSubcategoryModelLiveData= testSubcategoryRepositoryImpl.getAllSubcategories()

}