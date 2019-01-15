package com.vp.list.model;

import androidx.annotation.NonNull;

import java.util.Collections;
import java.util.List;

public class SearchResult {

    private List<ListItem> items;
    private boolean hasResponse;
    private int totalResult;

    private SearchResult(@NonNull List<ListItem> items, boolean hasResponse, int totalResult) {
        this.items = items;
        this.hasResponse = hasResponse;
        this.totalResult = totalResult;
    }

    @NonNull
    public List<ListItem> getItems() {
        return items;
    }

    public boolean hasResponse() {
        return hasResponse;
    }

    public int getTotalResult() {
        return totalResult;
    }

    public static SearchResult error() {
        return new SearchResult(Collections.emptyList(), false, 0);
    }

    public static SearchResult success(List<ListItem> items, int totalResult) {
        return new SearchResult(items, true, totalResult);
    }
}
