package com.BySandS.testsandquizes

import androidx.lifecycle.ViewModel
import com.BySandS.testsandquizes.models.mainActivityModels.CategoryModel
import com.BySandS.testsandquizes.models.mainActivityModels.DifficultyNameModel

class TestsListViewModel : ViewModel() {

    var  difficultyNameModel: DifficultyNameModel? = null
    var listCategoryModel= ArrayList<CategoryModel>()

    init {
        difficultyNameModel = addDifficultyName()
        listCategoryModel = addCategory()
    }

    /**
     * Создаем список категорий
     */
    private fun addCategory(): ArrayList<CategoryModel> {
        val list = ArrayList<CategoryModel>()
        for (i in 1..10) {
            list.add(CategoryModel("Тест", "Название$i", 33, 66, 100))
        }
        return list
    }

    /**
     * Загружаем текс фрагмента категории
     */
    private fun addDifficultyName(): DifficultyNameModel {
        return DifficultyNameModel(
            "Уровень сложность",
            "Количество вопросов",
            "Лучший результат",
            "Легкий", "Средний", "Сложный"
        )
    }
}