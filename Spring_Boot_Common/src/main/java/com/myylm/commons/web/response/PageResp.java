package com.myylm.commons.web.response;

import com.myylm.commons.T;

import java.util.List;

/**
 * @author hmmzhtx
 */
public class PageResp<U> {
    private Long totalCount;
    private List<T> data;

    public PageResp() {
        
    }

    public PageResp(Long count, List<T> data) {
        this.totalCount = count;
        this.data = data;
    }

    public Long getTotalCount() {
        return this.totalCount;
    }

    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }

    public List<T> getData() {
        return this.data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
