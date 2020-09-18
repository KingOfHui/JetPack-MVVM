package com.wwy.android.data.db

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.dh.base.app.MyApplication
import com.whdx.data.data.user.User


/**
 * @Description
 * @Author dinghui
 * @Date 2020/9/18 0018 16:29
 */
@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao

    companion object {

        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(): AppDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDatabase().also { INSTANCE = it }
            }

        private fun buildDatabase() =
            Room.databaseBuilder(
                MyApplication.CONTEXT,
                AppDatabase::class.java, "user.db"
            )
                .build()
    }
}