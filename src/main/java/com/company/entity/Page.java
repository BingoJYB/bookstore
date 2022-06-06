package com.company.entity;

import java.util.List;

public class Page {

    private int pageNow;
    private int totalPages;
    private int totalCount;
    private int pageSize;
    private List<Book> items;

    public Page(int pageNow, int totalPages, int totalCount, int pageSize, List<Book> items) {

        this.totalPages = totalPages;
        this.totalCount = totalCount;
        this.pageSize = pageSize;
        setPageNow(pageNow);
        this.items = items;
    }

    public Page() {

    }

    public int getPageNow() {
        return pageNow;
    }

    public void setPageNow(int pageNow) {
        if (pageNow < 1) {
            this.pageNow = 1;
        } else if (pageNow > this.totalPages) {
            this.pageNow = this.totalPages;
        } else {
            this.pageNow = pageNow;
        }
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public List<Book> getItems() {
        return items;
    }

    public void setItems(List<Book> items) {
        this.items = items;
    }

    public String toString() {
        return "Page {pageNow: " + pageNow + ", totalPages: " + totalPages + ", totalCount: "
                + totalCount + ", pageSize: " + pageSize + "}";
    }

}
