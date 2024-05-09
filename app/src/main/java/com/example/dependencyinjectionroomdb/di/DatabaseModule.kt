package com.example.dependencyinjectionroomdb.di

import android.app.Application
import androidx.room.Room
import com.example.dependencyinjectionroomdb.db.ProductDB
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideProductsDAO(database: ProductDB) = database.getDB()



}