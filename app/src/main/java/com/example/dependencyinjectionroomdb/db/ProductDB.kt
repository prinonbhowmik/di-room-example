package com.example.dependencyinjectionroomdb.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.dependencyinjectionroomdb.models.ProductList


@Database(entities = [ProductList::class], version = 1, exportSchema = false)
abstract class ProductDB : RoomDatabase() {
    abstract fun getDB() : ProductDao

    companion object {
        @Volatile
        private var INSTANCE: ProductDB? = null

        fun getInstance(context: Context): ProductDB {
            synchronized(this) {
                var instance: ProductDB? = INSTANCE
                if (instance == null) {
                    instance = Room
                        .databaseBuilder(
                            context.applicationContext,
                            ProductDB::class.java,
                            "product.db"
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