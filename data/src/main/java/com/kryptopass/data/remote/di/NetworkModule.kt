package com.kryptopass.data.remote.di

import com.kryptopass.data.remote.network.info.CompanyInfoService
import com.kryptopass.data.remote.network.launch.LaunchService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
    @Provides
    fun provideOkHttpClient(): OkHttpClient = OkHttpClient
        .Builder().apply {
            this.addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
        }
        .readTimeout(15, TimeUnit.SECONDS)
        .connectTimeout(15, TimeUnit.SECONDS)
        .build()

    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .baseUrl("https://api.spacexdata.com/v3/")      // NOTE: typically would put in secrets file
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    fun provideLaunchService(retrofit: Retrofit): LaunchService =
        retrofit.create(LaunchService::class.java)

    @Provides
    fun provideInfoService(retrofit: Retrofit): CompanyInfoService =
        retrofit.create(CompanyInfoService::class.java)
}