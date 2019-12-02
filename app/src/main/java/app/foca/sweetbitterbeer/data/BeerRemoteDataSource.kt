package app.foca.sweetbitterbeer.data


import app.foca.sweetbitterbeer.api.BeerApi
import javax.inject.Inject


class BeerRemoteDataSource @Inject constructor(private val service: BeerApi) : BaseDataSource() {

    suspend fun fetchBeers(page: Int)
            = getResult { service.beers(page) }

}