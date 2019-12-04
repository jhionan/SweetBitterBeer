package app.foca.sweetbitterbeer.di

import app.foca.sweetbitterbeer.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("unused")
@Module
abstract class MainActivityModule {
    @ContributesAndroidInjector (modules = [FragmentBuildersModule::class])
    abstract fun contributeMainActivity(): MainActivity
}
