package app.foca.sweetbitterbeer.data

import android.util.Log
import retrofit2.Response

abstract class BaseDataSource {

    protected suspend fun <T> getResult(call: suspend () -> Response<T>): Result<T> {
        try {
            val response = call()
            if (response.isSuccessful) {
                val body = response.body()
                if (body != null) return Result.success(body)
            }
            return error(" ${response.code()} ${response.message()}")
        } catch (e: Exception) {
            return error(e.message ?: e.toString())
        }
    }

    private fun <T> error(message: String): Result<T> {
        Log.e(TAG, message)
        return Result.error("Network call has failed for a following reason: $message")
    }

    companion object {
        val TAG = BaseDataSource::class.simpleName
    }

}