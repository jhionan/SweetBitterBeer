package app.foca.sweetbitterbeer.data

sealed class Result<out T> {

    enum class Status {
        SUCCESS,
        ERROR,
        LOADING
    }

    class loading<T> : Result<T>()
    data class error<T>(val message: String) : Result<T>()
    data class success<T>(val data: T) : Result<T>()


}