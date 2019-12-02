package app.foca.sweetbitterbeer.di


import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import app.foca.sweetbitterbeer.ui.BeerListViewModel
import app.foca.sweetbitterbeer.utils.viewModel.ViewModelFactory

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Suppress("unused")
@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(BeerListViewModel::class)
    abstract fun bindThemeViewModel(viewModel: BeerListViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}
