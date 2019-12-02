package app.foca.sweetbitterbeer.worker

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import app.foca.sweetbitterbeer.data.AppDatabase
import app.foca.sweetbitterbeer.model.Beer
import app.foca.sweetbitterbeer.utils.constants.DATA_FILENAME
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.google.gson.stream.JsonReader
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.withContext

class SeedDatabaseWorker(
    context: Context,
    workerParams: WorkerParameters
) : CoroutineWorker(context, workerParams) {

    override suspend fun doWork(): Result = coroutineScope {
        withContext(Dispatchers.IO) {

            try {
                applicationContext.assets.open(DATA_FILENAME).use { inputStream ->
                    JsonReader(inputStream.reader()).use { jsonReader ->
                        val type = object : TypeToken<List<Beer>>() {}.type
                        val list: List<Beer> = Gson().fromJson(jsonReader, type)

                        AppDatabase.getInstance(applicationContext).beerDao().insertAll(list)

                        Result.success()
                    }
                }
            } catch (e: Exception) {
                Log.e(TAG, "Error seeding database $e")
                Result.failure()
            }
        }
    }

    companion object {
        val TAG = SeedDatabaseWorker::class.java.simpleName
    }
}