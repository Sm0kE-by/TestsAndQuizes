package com.BySandS.testsandquizes.data

import androidx.room.DeleteColumn
import androidx.room.DeleteTable
import androidx.room.RenameColumn
import androidx.room.migration.AutoMigrationSpec

@RenameColumn(
    tableName = "difficulty_level",
    fromColumnName = "name_level",
    toColumnName = "name_level_ru"
)
@RenameColumn(
    tableName = "subcategory",
    fromColumnName = "subcategory_name_ru",
    toColumnName = "name_ru"
)
@RenameColumn(
    tableName = "subcategory",
    fromColumnName = "subcategory_name_eng",
    toColumnName = "name_eng"
)
@RenameColumn(
    tableName = "result",
    fromColumnName = "difficulty_id",
    toColumnName = "difficulty_lexel_id"
)
@DeleteColumn(
    tableName = "subcategory",
    columnName = "test_result_id"
)
@DeleteColumn(
    tableName = "subcategory",
    columnName = "statistic_id"
)
@DeleteColumn(
    tableName = "result",
    columnName = "result_text_id"
)
@DeleteColumn(
    tableName = "result",
    columnName = "test_result_id"
)
@DeleteColumn(
    tableName = "question",
    columnName = "question_text_id"
)
@DeleteTable(
    tableName = "question_text"
)
@DeleteTable(
    tableName = "test_result"
)
@DeleteTable(
    tableName = "result_text"
)
@DeleteTable(
    tableName = "statistic_subcategory"
)
class AutoMigrationSpecFrom4To7 : AutoMigrationSpec {
}
