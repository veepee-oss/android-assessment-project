package com.vp.list.di;

import com.vp.list.service.SearchService;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class ListNetworkModule {

    @Provides
    SearchService providesSearchService(Retrofit retrofit) {
        return retrofit.create(SearchService.class);
    }
}
