package com.languagexx.simplenotes.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.languagexx.simplenotes.ui.NoteViewModel
import com.languagexx.simplenotes.util.ViewModelProviderFactory
import dagger.Binds
import dagger.MapKey
import dagger.Module
import dagger.multibindings.IntoMap
import kotlin.reflect.KClass


@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(NoteViewModel::class)
    abstract fun bindMainViewModel(moviesViewModel: NoteViewModel): ViewModel
}
