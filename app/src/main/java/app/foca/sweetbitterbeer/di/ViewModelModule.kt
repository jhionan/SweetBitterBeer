package app.foca.sweetbitterbeer.di


import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import app.foca.sweetbitterbeer.features.detail.DetailsViewModel
import app.foca.sweetbitterbeer.features.menu.MenuViewModel
import app.foca.sweetbitterbeer.utils.viewModel.ViewModelFactory

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Suppress("unused")
@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(MenuViewModel::class)
    abstract fun bindMenuViewModel(viewModel: MenuViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(DetailsViewModel::class)
    abstract fun bindDetailsViewModel(viewModel: DetailsViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}
