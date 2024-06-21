package com.BySandS.testsandquizes.data.allData.storage.dataBase.intefaceDao

import androidx.room.Dao
import androidx.room.Query
import com.BySandS.testsandquizes.data.allData.storage.dataBase.models.AvatarModelDb

@Dao
interface DaoAvatar {

    @Query(
        "SELECT avatar.id, avatar.name_ru as name, avatar_type.avatar_type_name_ru as type, avatar.description, avatar.open, avatar.avatar_icon FROM avatar, avatar_type " +
                "WHERE avatar_type_id = avatar_type.id"
    )
    fun getListAvatars(): List<AvatarModelDb>

    @Query("SELECT avatar.id, avatar.name_ru as name, avatar_type.avatar_type_name_ru as type, avatar.description, avatar.open, avatar.avatar_icon FROM avatar, avatar_type " +
        "WHERE avatar_type_id = avatar_type.id AND avatar.id = :id")
    fun getAvatarById(id: Long): AvatarModelDb

    //сохранить статус нового, открытого автара
    @Query("UPDATE avatar SET open=:open WHERE id=:id")
    fun saveOpenAvatar(id: Long, open: Boolean)
}