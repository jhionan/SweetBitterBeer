package app.foca.sweetbitterbeer.api

import app.foca.sweetbitterbeer.model.Beer
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface BeerApi {

    companion object {
        val baseUrl = "https://api.punkapi.com/v2/"
    }


    @GET("beers")
    suspend fun beers(@Query("page") page: Int? = null,
                      @Query("per_page") pageSize: Int? = 50): Response<List<Beer>>
}