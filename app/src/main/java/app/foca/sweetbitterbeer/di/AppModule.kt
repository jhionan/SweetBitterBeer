package app.foca.sweetbitterbeer.di


import android.app.Application
import app.foca.sweetbitterbeer.api.BeerApi
import app.foca.sweetbitterbeer.data.AppDatabase
import app.foca.sweetbitterbeer.data.BeerRemoteDataSource
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module(includes = [ViewModelModule::class, NetworkModule::class])
class AppModule {

    @Singleton
    @Provides
    fun provideBeerService(
        @BeerAPI okhttpClient: OkHttpClient,
        converterFactory: GsonConverterFactory
    ) = provideService(okhttpClient, converterFactory, BeerApi::class.java)

    @Singleton
    @Provides
    fun provideBeerRemoteDataSource(beerApi: BeerApi) = BeerRemoteDataSource(beerApi)


    @Singleton
    @Provides
    fun provideDb(app: Application) = AppDatabase.getInstance(app)

    @Singleton
    @Provides
    fun provideBeerDao(db: AppDatabase) = db.beerDao()


    @CoroutineScropeIO
    @Provides
    fun provideCoroutineScopeIO() = CoroutineScope(Dispatchers.IO)


    private fun createRetrofit(
        okhttpClient: OkHttpClient,
        converterFactory: GsonConverterFactory
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BeerApi.baseUrl)
            .client(okhttpClient)
            .addConverterFactory(converterFactory)
            .build()
    }

    private fun <T> provideService(
        okhttpClient: OkHttpClient,
        converterFactory: GsonConverterFactory, classe: Class<T>
    ): T {
        return createRetrofit(okhttpClient, converterFactory).create(classe)
    }
}
