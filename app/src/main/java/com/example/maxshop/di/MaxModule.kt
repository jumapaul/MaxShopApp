package com.example.maxshop.di

import android.content.Context
import com.example.maxshop.presentation.onboard.viewpage.DataStoreRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MaxModule {

    @Provides
    @Singleton
    fun provideDataStoreRepository(@ApplicationContext context: Context) = DataStoreRepository(context)
}