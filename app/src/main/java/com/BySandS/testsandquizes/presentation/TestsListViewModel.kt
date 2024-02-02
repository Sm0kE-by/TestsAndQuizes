package com.BySandS.testsandquizes.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.BySandS.testsandquizes.DataBase.TestsRepository
import com.BySandS.testsandquizes.DataBase.models.SubcategoryModel
import com.BySandS.testsandquizes.presentation.mainActivityModels.CategoryModel
import com.BySandS.testsandquizes.presentation.mainActivityModels.DifficultyNameModel

class TestsListViewModel : ViewModel() {

    var difficultyNameModel: DifficultyNameModel? = null
    var categoryModel: CategoryModel? = null
    var listCategoryModel : LiveData<List<SubcategoryModel>>

    init {
        difficultyNameModel = addDifficultyName()
        categoryModel = addCategory()
        listCategoryModel = addCategories()
    }

    private val testRepository = TestsRepository.get()

    /**
     * Создаем список категорий
     */
    private fun addCategories(): LiveData<List<SubcategoryModel>> {
          val listTestsLiveData = testRepository.getAllSubcategories()
        return listTestsLiveData
    }

    private fun addCategory(): CategoryModel {
        return CategoryModel("Тест", "Название", 35, 65, 95)
    }

    /**
     * Загружаем текс фрагмента категории
     */
    private fun addDifficultyName(): DifficultyNameModel {
        return DifficultyNameModel(
            "Уровень сложность",
            "Количество вопросов",
            7, 10, 15,
            "Лучший результат",
            "Легк", "Сред", "Слож"
        )
    }
}