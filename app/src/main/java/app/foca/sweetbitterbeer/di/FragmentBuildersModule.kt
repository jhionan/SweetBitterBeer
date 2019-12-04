package app.foca.sweetbitterbeer.di


import app.foca.sweetbitterbeer.features.detail.DetailsFragment
import app.foca.sweetbitterbeer.features.menu.MenuFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("unused")
@Module
abstract class FragmentBuildersModule {

    @ContributesAndroidInjector
    abstract fun injectMenuFragment(): MenuFragment

    @ContributesAndroidInjector
    abstract fun injectDetailFragment(): DetailsFragment

}
