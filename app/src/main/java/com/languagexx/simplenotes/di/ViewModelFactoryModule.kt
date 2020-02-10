package com.languagexx.simplenotes.di

import androidx.lifecycle.ViewModelProvider
import com.languagexx.simplenotes.util.ViewModelProviderFactory
import dagger.Binds
import dagger.Module


@Module
abstract class ViewModelFactoryModule {
    @Binds
    abstract fun bindViewModelFactory(viewModelProvideFactory: ViewModelProviderFactory): ViewModelProvider.Factory
}