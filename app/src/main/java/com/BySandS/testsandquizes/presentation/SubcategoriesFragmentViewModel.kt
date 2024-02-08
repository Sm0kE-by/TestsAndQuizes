package com.BySandS.testsandquizes.presentation

import androidx.lifecycle.ViewModel
import com.BySandS.testsandquizes.DataBase.TestsRepository
import com.BySandS.testsandquizes.DataBase.entity.SubcategoryDbEntity

class CategoriesFragmentViewModel : ViewModel() {
    private val testsRepository = TestsRepository.get()
//    private lateinit var listCategoryModel: ArrayList<SubcategoryDbEntity>

//    init {
//        private val crimeRepository = TestsRepository.get()
//        val crimes = crimeRepository.getCrimes()
//        listCategoryModel = addCategories()
//    }

    /**
     * Создаем список категорий
     */
//    private fun addCategories(): List<SubcategoryDbEntity> {
//        //        for (i in 0..10) {
////            listTestsLiveData.add(i, CategoryModel("tests", "name$i", 33, 66, 100))
////        }
//        return crimeRepository.getAllSubcategories()
//    }

//    private fun addCategory(): CategoryModel {
//        return CategoryModel("Тест", "Название", 35, 65, 95)
//    }

    fun getCategories(): List<SubcategoryDbEntity> {
        return testsRepository.getAllSubcategories()
    }
}