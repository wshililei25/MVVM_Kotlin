package com.flower.base.room

import android.content.Context
import com.flower.base.data.response.UserInfo

/**
 *  @author: XiLei  @date: 2019/4/4
 */
class RoomUtils {
    companion object {
        fun getUserInfo(context: Context): UserInfo {
            return UserRoomDatabase.getDatabase(context).userDao().getUserInfo()
        }
    }

}