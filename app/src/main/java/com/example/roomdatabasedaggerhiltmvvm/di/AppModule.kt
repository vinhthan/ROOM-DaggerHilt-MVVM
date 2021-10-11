package com.example.roomdatabasedaggerhiltmvvm.di

import android.app.Application
import android.content.Context
import com.example.roomdatabasedaggerhiltmvvm.database.AppDatabase
import com.example.roomdatabasedaggerhiltmvvm.database.UserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun getAppDB(context: Application): AppDatabase{
        return AppDatabase.getAppDatabase(context)
    }

    @Singleton
    @Provides
    fun getDao(appDatabase: AppDatabase): UserDao{
        return appDatabase.getUserDao()
    }

}