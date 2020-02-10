package com.languagexx.simplenotes.di


import com.languagexx.simplenotes.ui.AddFragment
import com.languagexx.simplenotes.ui.EditFragment
import com.languagexx.simplenotes.ui.ListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class FragmentBuildersModule {

    @ContributesAndroidInjector
    abstract fun contributeListFragment(): ListFragment

    @ContributesAndroidInjector
    abstract fun contributeAddFragment(): AddFragment

    @ContributesAndroidInjector
    abstract fun contributeEditFragment(): EditFragment
}