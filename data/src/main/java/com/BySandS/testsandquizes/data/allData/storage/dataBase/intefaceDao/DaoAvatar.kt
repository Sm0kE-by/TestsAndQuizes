package com.BySandS.testsandquizes.data.allData.storage.dataBase.intefaceDao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Update
import com.BySandS.testsandquizes.data.allData.storage.dataBase.models.AvatarModelDb

@Dao
interface DaoAvatar {

    @Query(
        "SELECT avatar.id, avatar.name_ru as name, avatar_type.avatar_type_name_ru as type, avatar.description, avatar.open FROM avatar, avatar_type " +
                "WHERE avatar_type_id = avatar_type.id"
    )
    fun getListAvatars(): List<AvatarModelDb>

    @Query("UPDATE avatar SET open=:open WHERE id=:id")
    fun saveOpenAvatar(id: Long, open: Boolean)
}