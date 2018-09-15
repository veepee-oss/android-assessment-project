package com.vp.list.viewmodel;

import com.vp.list.model.ListItem;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class SearchResult {

    private List<ListItem> items;
    private int totalResult;
    private ListState listState;

    private SearchResult(List<ListItem> items, int totalResult, ListState listState) {
        this.items = items;
        this.listState = listState;
        this.totalResult = totalResult;
    }

    public List<ListItem> getItems() {
        return items;
    }

    public int getTotalResult() {
        return totalResult;
    }

    public ListState getListState() {
        return listState;
    }

    public static SearchResult error() {
        return new SearchResult(Collections.emptyList(), 0, ListState.ERROR);
    }

    public static SearchResult success(List<ListItem> items, int totalResult) {
        return new SearchResult(items, totalResult, ListState.LOADED);
    }

    public static SearchResult inProgress() {
        return new SearchResult(Collections.emptyList(), 0, ListState.IN_PROGRESS);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SearchResult that = (SearchResult) o;
        return totalResult == that.totalResult &&
                Objects.equals(items, that.items) &&
                listState == that.listState;
    }

    @Override
    public int hashCode() {
        return Objects.hash(items, totalResult, listState);
    }
}
