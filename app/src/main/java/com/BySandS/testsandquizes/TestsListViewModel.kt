package com.BySandS.testsandquizes

import androidx.lifecycle.ViewModel
import com.BySandS.testsandquizes.models.mainActivityModels.CategoryModel
import com.BySandS.testsandquizes.models.mainActivityModels.DifficultyNameModel

class TestsListViewModel : ViewModel() {

    var difficultyNameModel: DifficultyNameModel? = null
    var categoryModel: CategoryModel? = null
    var listCategoryModel = ArrayList<CategoryModel>()

    init {
        difficultyNameModel = addDifficultyName()
        categoryModel = addCategory()
        listCategoryModel = addCategories()
    }

    /**
     * Создаем список категорий
     */
    private fun addCategories(): ArrayList<CategoryModel> {
        val list = ArrayList<CategoryModel>()
        for (i in 1..10) {
            list.add(CategoryModel("Тест", "Название$i", 33, 66, 100))
        }
        return list
    }

    private fun addCategory(): CategoryModel{
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