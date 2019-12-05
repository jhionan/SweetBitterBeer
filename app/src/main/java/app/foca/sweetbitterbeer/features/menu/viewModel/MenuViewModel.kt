package app.foca.sweetbitterbeer.features.menu.viewModel

import androidx.lifecycle.ViewModel
import app.foca.sweetbitterbeer.data.BeerRepository
import app.foca.sweetbitterbeer.di.CoroutineScropeIO
import kotlinx.coroutines.CoroutineScope
import javax.inject.Inject

class MenuViewModel @Inject constructor
    (repository: BeerRepository,
     @CoroutineScropeIO private val ioCoroutineScope: CoroutineScope) : ViewModel() {

}