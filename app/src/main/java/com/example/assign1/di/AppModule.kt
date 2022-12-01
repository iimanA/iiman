package com.example.assign1.di

import com.example.assign1.service.OpenWeatherMapApi
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ViewModelComponent
import retrofit2.Retrofit
import retrofit2.Retrofit.Builder
import retrofit2.converter.moshi.MoshiConverterFactory

@Module
@InstallIn(ActivityComponent ::class, ViewModelComponent ::class)
class AppModule {
    @Provides
    fun provideMoshi(): Moshi {
        return Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
    }

    @Provides
    fun providesRetrofit(moshi: Moshi): Retrofit {
        return Builder()
            .addConverterFactory(MoshiConverterFactory.create(moshi))
        .baseUrl("https://api.openweathermap.org")
        .build()
    }
    @Provides
    fun providesOpenWeatherMapApi(retrofit: Retrofit):OpenWeatherMapApi{
        return retrofit.create(OpenWeatherMapApi::class.java)
    }
}

