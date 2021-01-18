package com.amirhusseinsoori.template.di

import android.content.Context
import com.amirhusseinsoori.template.util.Constance.BASE_URL
import com.amirhusseinsoori.template.api.MyApi
import com.amirhusseinsoori.template.util.Constance
import com.example.template.api.safe.Connectivity


import com.franmontiel.persistentcookiejar.ClearableCookieJar
import com.franmontiel.persistentcookiejar.PersistentCookieJar
import com.franmontiel.persistentcookiejar.cache.SetCookieCache
import com.franmontiel.persistentcookiejar.persistence.SharedPrefsCookiePersistor
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
object RetrofitModule {


    @Singleton
    @Provides
    fun provideSharedPrefsCookie(@ApplicationContext context: Context): SharedPrefsCookiePersistor {
        return SharedPrefsCookiePersistor(context)
    }

    @Singleton
    @Provides
    fun provideCookieJar(sharedPrefsCookie: SharedPrefsCookiePersistor): ClearableCookieJar {
        return PersistentCookieJar(SetCookieCache(), sharedPrefsCookie)
    }


    @Singleton
    @Provides
    fun provideConnectivity(@ApplicationContext context: Context): Connectivity {
        return Connectivity(context)
    }


    @Singleton
    @Provides
    fun provideGsonBuilder(): Gson {
        return GsonBuilder()
                .setLenient()
                .create()
    }

    @Singleton
    @Provides
    fun provideOkHttp(connectivity: Connectivity, cookieJar: ClearableCookieJar): OkHttpClient {
        return OkHttpClient.Builder()
                .readTimeout(8000, TimeUnit.SECONDS)
                .writeTimeout(8000, TimeUnit.SECONDS)
                .connectTimeout(1, TimeUnit.MINUTES)
                .cookieJar(cookieJar)
                .addInterceptor(connectivity)
                .build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(client: OkHttpClient, gson: Gson): Retrofit.Builder {
        return Retrofit.Builder()
                .client(client)
                .baseUrl(Constance.URL)
            .addConverterFactory(GsonConverterFactory.create(gson))

    }

    @Singleton
    @Provides
    fun provideApiService(retrofit: Retrofit.Builder): MyApi {
        return retrofit.build().create(MyApi::class.java)
    }



}