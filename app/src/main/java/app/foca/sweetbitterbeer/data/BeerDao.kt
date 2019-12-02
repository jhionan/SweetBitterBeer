package app.foca.sweetbitterbeer.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import app.foca.sweetbitterbeer.model.Beer

@Dao
interface BeerDao {

    @Query("SELECT * FROM beers")
    fun getBeers(): LiveData<List<Beer>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(beers: List<Beer>)

}
