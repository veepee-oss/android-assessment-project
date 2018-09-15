package com.vp.list.service;

import com.vp.list.model.SearchResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface SearchService {

    @GET("/")
    Call<SearchResponse> search(@Query("s") String query, @Query("page") int page);
}

