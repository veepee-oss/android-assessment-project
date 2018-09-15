package com.vp.detail.di;

import com.vp.detail.service.DetailService;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class DetailNetworkModule {

    @Provides
    DetailService providesDetailService(Retrofit retrofit) {
        return retrofit.create(DetailService.class);
    }
}