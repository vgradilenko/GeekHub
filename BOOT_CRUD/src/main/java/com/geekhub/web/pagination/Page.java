package com.geekhub.web.pagination;

import java.util.List;

public class Page<T> {

    private final int page;
    private final int pageCount;

    private final List<T> items;

    public Page(int page, int pageCount, List<T> items) {
        this.page = page;
        this.pageCount = pageCount;
        this.items = items;
    }

    public int getPage() {
        return page;
    }

    public int getPageCount() {
        return pageCount;
    }

    public List<T> getItems() {
        return items;
    }
}
