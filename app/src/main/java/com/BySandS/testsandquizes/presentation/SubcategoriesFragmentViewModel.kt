package com.BySandS.testsandquizes.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import com.BySandS.testsandquizes.DataBase.TestsRepository
import com.BySandS.testsandquizes.presentation.mainActivityModels.SubcategoryModel

class SubcategoriesFragmentViewModel : ViewModel() {
    private val testsRepository = TestsRepository.get()
    private val listSubcategoryDbEntityLiveData = testsRepository.getAllSubcategories()
    lateinit var listSubcategoryModel: MutableLiveData<ArrayList<SubcategoryModel>>

    init {
        listSubcategoryModel = getCategories()
//        private val crimeRepository = TestsRepository.get()
//        val crimes = crimeRepository.getCrimes()
//        listCategoryModel = addCategories()
    }

    /**
     * Создаем список категорий
     */
    private fun addSubcategories(): MutableLiveData<ArrayList<SubcategoryModel>> {
for (i in 0..10){
            listSubcategoryModel.value?.add(
                i, SubcategoryModel(
                    "test",
                    listSubcategoryDbEntityLiveData.value?.get(i)!!.subcategoryNameRu,
                    33, 66, 100
                )
            )
        }
//        for (i in 0..10) {
//            listTestsLiveData.add(i, CategoryModel("tests", "name$i", 33, 66, 100))
//        }
        return listSubcategoryModel
    }

//    private fun addCategory(): CategoryModel {
//        return CategoryModel("Тест", "Название", 35, 65, 95)
//    }

    fun getCategories(): MutableLiveData<ArrayList<SubcategoryModel>> {
        listSubcategoryModel = addSubcategories()
        return listSubcategoryModel
    }
}