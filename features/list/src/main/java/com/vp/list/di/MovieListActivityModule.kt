package com.vp.list.di

import com.vp.list.MovieListActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MovieListActivityModule {

    @ContributesAndroidInjector(modules = [ListFragmentModule::class, ListNetworkModule::class, ListViewModelsModule::class])
    abstract fun bindMovieListActivity(): MovieListActivity
}