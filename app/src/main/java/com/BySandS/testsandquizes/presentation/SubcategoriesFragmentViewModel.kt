package com.BySandS.testsandquizes.presentation

import androidx.lifecycle.ViewModel
import com.BySandS.testsandquizes.DataBase.TestsRepository

class SubcategoriesFragmentViewModel : ViewModel() {
    private val testsRepository = TestsRepository.get()
     val listSubcategoryModelLiveData= testsRepository.getAllSubcategories()


//    init {
//        listSubcategoryModelLiveData = getCategories()
////        private val crimeRepository = TestsRepository.get()
////        val crimes = crimeRepository.getCrimes()
////        listCategoryModel = addCategories()
//    }

    /**
     * Создаем список категорий
     */
//    private fun addSubcategories(): MutableLiveData<ArrayList<SubcategoryModel>> {
//for (i in 0..10){
//            listSubcategoryModelLiveData.value?.add(
//                i, SubcategoryModel(
//                    "test",
//                    listSubcategoryDbEntityLiveData.value?.get(i)!!.subcategoryNameRu,
//                    33, 66, 100
//                )
//            )
//        }
////        for (i in 0..10) {
////            listTestsLiveData.add(i, CategoryModel("tests", "name$i", 33, 66, 100))
////        }
//        return listSubcategoryModelLiveData
 //   }

//    private fun addCategory(): CategoryModel {
//        return CategoryModel("Тест", "Название", 35, 65, 95)
//    }

//    fun getCategories(): MutableLiveData<ArrayList<SubcategoryModel>> {
//        listSubcategoryModelLiveData = addSubcategories()
//        return listSubcategoryModelLiveData
//    }
}