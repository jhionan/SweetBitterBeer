package app.foca.sweetbitterbeer.data

import app.foca.sweetbitterbeer.testing.OpenForTesting
import javax.inject.Inject
import javax.inject.Singleton

@OpenForTesting
@Singleton
class BeerRepository @Inject constructor(
    private val beerRemoteDataSource: BeerRemoteDataSource,
    private val beerDao: BeerDao
) {


    companion object {
        // For Singleton instantiation
        @Volatile
        private var instance: BeerRepository? = null

        fun getInstance(beerRemoteDataSource: BeerRemoteDataSource, beerDao: BeerDao) =
            instance ?: synchronized(this) {
                instance
                    ?: BeerRepository(beerRemoteDataSource, beerDao).also { instance = it }
            }
    }

}
