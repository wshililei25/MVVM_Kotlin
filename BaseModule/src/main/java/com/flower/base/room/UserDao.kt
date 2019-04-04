package com.flower.base.room

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.flower.base.data.response.UserInfo

/**
 *  @author: XiLei  @date: 2019/4/2
 */

@Dao
interface UserDao {

    @Insert
    fun insert(userInfo: UserInfo)

    @Query("DELETE FROM SgmUserTable")
    fun deleteAll()

    @Query("SELECT * from SgmUserTable")
    fun getUserInfo(): UserInfo
}