package com.geekhub.web.pagination;

public class PageRequest {

    private final int page;
    private final int perPage;

    public PageRequest(int page, int perPage) {
        this.page = page;
        this.perPage = perPage;
    }

    public int getPage() {
        return page;
    }

    public int getPerPage() {
        return perPage;
    }
}
