package com.languagexx.simplenotes.di

import com.languagexx.simplenotes.ui.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class ActivityBuildersModule {

    @ContributesAndroidInjector(modules = [ViewModelModule::class,FragmentBuildersModule::class])
    abstract fun contributeMainActivity(): MainActivity

}