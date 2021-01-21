package com.amirhusseinsoori.template.di

import android.content.Context
import androidx.room.Room
import com.amirhusseinsoori.template.db.MyDao
import com.amirhusseinsoori.template.db.MyDataBase


import com.amirhusseinsoori.template.util.Constance.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
object RoomModule {

    @Singleton
    @Provides
    fun provideMyDb(@ApplicationContext context: Context): MyDataBase {
        return Room
            .databaseBuilder(
                context,
                MyDataBase::class.java,
                DATABASE_NAME
            )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideMyDAO(myDataBase: MyDataBase): MyDao {
        return myDataBase.getMyDao()
    }


}