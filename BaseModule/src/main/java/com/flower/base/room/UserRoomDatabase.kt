package com.flower.base.room

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.flower.base.data.response.UserInfo


/**
 *  @author: XiLei  @date: 2019/4/2
 */

@Database(entities = [UserInfo::class], version = 1)
abstract class UserRoomDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao

    companion object {
        private var INSTANCE: UserRoomDatabase? = null

        fun getDatabase(context: Context): UserRoomDatabase {
            if (INSTANCE == null) {
                synchronized(UserRoomDatabase::class.java) {
                    if (INSTANCE == null) {
                        INSTANCE = Room.databaseBuilder(
                            context.getApplicationContext(),
                            UserRoomDatabase::class.java!!, "sgm_room"
                        ).allowMainThreadQueries() //粗暴方法，解决不能在UI线程访问Room
                            .build()
                    }
                }
            }
            return INSTANCE!!
        }
    }

}