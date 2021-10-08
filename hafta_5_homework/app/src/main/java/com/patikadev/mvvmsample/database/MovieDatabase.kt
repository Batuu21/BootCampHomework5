package com.patikadev.mvvmsample.database

import android.content.Context
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.Room



@Database(entities = [MovieTable::class], version = 1, exportSchema = false)
abstract class MovieDatabase : RoomDatabase() {


    abstract val movieDatabaseDao: MovieDatabaseDao

    companion object {

        @Volatile
        private var INSTANCE: MovieDatabase? = null


        fun getInstance(context: Context): MovieDatabase {

            synchronized(this) {

                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        MovieDatabase::class.java,
                        "movies"
                    )
                        .fallbackToDestructiveMigration()
                        .build()

                    INSTANCE = instance
                }

                return instance
            }
        }
    }
}
