package com.vp.list;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class GridPagingScrollListener extends RecyclerView.OnScrollListener {
    private static final int PAGE_SIZE = 10;
    private final GridLayoutManager layoutManager;
    private static final LoadMoreItemsListener EMPTY_LISTENER = (int page) -> {
        //empty listener
    };
    private LoadMoreItemsListener loadMoreItemsListener = EMPTY_LISTENER;
    private boolean isLastPage = false;
    private boolean isLoading = false;

    GridPagingScrollListener(@NonNull final GridLayoutManager layoutManager) {
        this.layoutManager = layoutManager;
    }

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);

        if (shouldLoadNextPage()) {
            loadMoreItemsListener.loadMoreItems(getNextPageNumber());
        }
    }

    private boolean shouldLoadNextPage() {
        return isNotLoadingInProgress() && userScrollsToNextPage() && isNotFirstPage() && hasNextPage();
    }

    private boolean userScrollsToNextPage() {
        return (layoutManager.getChildCount() + layoutManager.findFirstVisibleItemPosition()) >= layoutManager.getItemCount();
    }

    private boolean isNotFirstPage() {
        return layoutManager.findFirstVisibleItemPosition() >= 0 && layoutManager.getItemCount() >= PAGE_SIZE;
    }

    private boolean hasNextPage() {
        return !isLastPage;
    }

    private boolean isNotLoadingInProgress() {
        return !isLoading;
    }

    private int getNextPageNumber() {
        return layoutManager.getItemCount() / PAGE_SIZE + 1;
    }

    public void setLoadMoreItemsListener(@Nullable final LoadMoreItemsListener loadMoreItemsListener) {
        if (loadMoreItemsListener != null) {
            this.loadMoreItemsListener = loadMoreItemsListener;
        } else {
            this.loadMoreItemsListener = EMPTY_LISTENER;
        }
    }

    public void markLoading(boolean isLoading) {
        this.isLoading = isLoading;
    }

    public void markLastPage(boolean isLastPage) {
        this.isLastPage = isLastPage;
    }

    public interface LoadMoreItemsListener {
        void loadMoreItems(int page);
    }
}
