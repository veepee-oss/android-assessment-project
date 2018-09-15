package com.vp.list.di

import com.vp.list.ListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ListFragmentModule {

    @ContributesAndroidInjector
    abstract fun bindListFragment(): ListFragment
}