package com.amirhusseinsoori.template.di

import android.content.Context
import com.amirhusseinsoori.template.util.Constance.SHARED_PREFERENCES_NAME

import com.squareup.picasso.OkHttp3Downloader
import com.squareup.picasso.Picasso
import dagger.Module
import dagger.Provides
import dagger.Reusable
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import okhttp3.OkHttpClient
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
object AppModule {



    @Reusable
    @Provides
    fun provideSharedPreference(@ApplicationContext context: Context) =
         context.getSharedPreferences(SHARED_PREFERENCES_NAME,Context.MODE_PRIVATE)
    @Reusable
    @Provides
    fun providePicasso(@ApplicationContext context: Context, client: OkHttpClient): Picasso {
        return Picasso.Builder(context)
            .downloader(OkHttp3Downloader(client))
            .build()
    }
}