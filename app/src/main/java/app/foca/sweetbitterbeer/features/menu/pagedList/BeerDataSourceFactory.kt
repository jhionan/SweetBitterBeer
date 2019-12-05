package app.foca.sweetbitterbeer.features.menu.pagedList

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import androidx.paging.PagedList
import app.foca.sweetbitterbeer.data.BeerDao
import app.foca.sweetbitterbeer.data.BeerRemoteDataSource
import app.foca.sweetbitterbeer.model.Beer
import kotlinx.coroutines.CoroutineScope
import javax.inject.Inject

class BeerDataSourceFactory @Inject constructor(
    private val dataSource: BeerRemoteDataSource,
    private val dao: BeerDao,
    private val scope: CoroutineScope
) : DataSource.Factory<Int, Beer>() {

    private val liveData = MutableLiveData<BeerPageDataSource>()

    override fun create(): DataSource<Int, Beer> {
        val source = BeerPageDataSource(dataSource, dao, scope)
        liveData.postValue(source)
        return source
    }

    companion object {
        private const val PAGE_SIZE = 50

        fun pagedListConfig() = PagedList.Config.Builder()
            .setInitialLoadSizeHint(PAGE_SIZE)
            .setPageSize(PAGE_SIZE)
            .setEnablePlaceholders(true)
            .build()
    }

}