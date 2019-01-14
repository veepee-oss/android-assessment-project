package com.vp.list.model;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import static java.util.Collections.emptyList;

public class SearchResponse {
    private static final String POSITIVE_RESPONSE = "True";
    @SerializedName("Search")
    private List<ListItem> search;

    private int totalResults;
    @SerializedName("Response")
    private String response;

    private SearchResponse(String response) {
        this.response = response;
    }

    @NonNull
    public List<ListItem> getSearch() {
        return search != null ? search : emptyList();
    }

    public int getTotalResults() {
        return totalResults;
    }

    public boolean hasResponse() {
        return POSITIVE_RESPONSE.equals(response);
    }
}
