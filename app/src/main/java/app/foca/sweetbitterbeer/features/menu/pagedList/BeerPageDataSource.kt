package app.foca.sweetbitterbeer.features.menu.pagedList

import androidx.paging.PageKeyedDataSource
import app.foca.sweetbitterbeer.data.BeerDao
import app.foca.sweetbitterbeer.data.BeerRemoteDataSource
import app.foca.sweetbitterbeer.model.Beer
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import app.foca.sweetbitterbeer.data.Result
import timber.log.Timber
import javax.inject.Inject

class BeerPageDataSource @Inject constructor(
    private val beerRemoteDataSource: BeerRemoteDataSource,
    private val beerDao: BeerDao,
    private val coroutineScope: CoroutineScope
) : PageKeyedDataSource<Int, Beer>() {

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, Beer>
    ) {
       fetchData(page = 1){beerList ->
           callback.onResult(beerList,null, 2)
       }
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Beer>) {
        val page = params.key
        fetchData(page = params.key){beerList ->
            callback.onResult(beerList,page+1 )
        }
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Beer>) {
        val page = params.key
        fetchData(page = params.key){beerList ->
            callback.onResult(beerList,page-1 )
        }
    }

    private fun fetchData(page: Int,  callback: (List<Beer>) -> Unit) {
        coroutineScope.launch(getJobErrorHandler()) {
            val response  = beerRemoteDataSource.fetchBeers(page)
            if (response is Result.success) {
                beerDao.insertAll(response.data)
                callback(response.data)
            } else if (response is Result.error) {
                reportError(response.message)
            }
        }
    }

    private fun reportError(message: String) {
        Timber.e("Ops, something wrong on beerDataSoucer: $message")
    }

    private fun getJobErrorHandler() = CoroutineExceptionHandler { _, e ->
        reportError(e.message ?: e.toString())
    }
}