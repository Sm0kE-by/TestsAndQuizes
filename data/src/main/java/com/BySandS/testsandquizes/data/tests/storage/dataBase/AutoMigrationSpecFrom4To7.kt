package com.BySandS.testsandquizes.data.tests.storage.dataBase

import androidx.room.DeleteColumn
import androidx.room.DeleteTable
import androidx.room.RenameColumn
import androidx.room.migration.AutoMigrationSpec

@RenameColumn(
    tableName = "difficulty_level",
    fromColumnName = "name_level",
    toColumnName = "name_level_ru"
)

class AutoMigrationSpecFrom4To7 : AutoMigrationSpec {
}
