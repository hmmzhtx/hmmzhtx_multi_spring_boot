package com.myylm.commons.web.request;

/**
 * @author hmmzhtx
 */
public class PageReq {
    public static final String DIR_ASC = "ASC";
    public static final String DIR_DESC = "DESC";
    private Integer page;
    private Integer start;
    private Integer limit;
    private String sort;
    private String dir;

    public PageReq() {
    }

    public Integer getPage() {
        return this.page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getStart() {
        return this.start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getLimit() {
        return this.limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public String getSort() {
        return this.sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getDir() {
        return this.dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }
}
