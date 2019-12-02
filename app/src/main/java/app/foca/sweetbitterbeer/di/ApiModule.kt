package app.foca.sweetbitterbeer.di

import app.foca.sweetbitterbeer.api.BeerApi
import dagger.Module
import dagger.Provides
import dagger.Reusable
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@Suppress("unused")

object ApiModule {

    @Provides
    @Reusable
    @JvmStatic
    internal fun provideBeerApi(retrofit: Retrofit): BeerApi {
        return retrofit.create(BeerApi::class.java)
    }
    @Provides
    @Reusable
    @JvmStatic
    internal fun provideRetrofit() : Retrofit {
        return  Retrofit.Builder()
            .baseUrl(BeerApi.baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

}