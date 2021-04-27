package org.app.speed.utils;


import java.util.Collection;

/**
 * 分页查询结果构建
 *
 * @author Lian.QianChao
 */
public class PaginationUtil<T> {


    //总条数
    private Integer count;

    //第几条开始
    private Integer index;

    //到多少条结束
    private Integer indexTo;

    //总共多少页
    private Integer pageCount;

    //当前页
    private Integer onPage;

    //每页条数
    private Integer onePageSize;

    //数据
    private Collection<T> data;


    /**
     * 构建分页数据结构
     *
     * @param onPage      当前页
     * @param onePageSize 每页条数
     * @param count       总条数
     * @param data        数据
     */
    public PaginationUtil(Integer onPage, Integer onePageSize, Integer count, Collection<T> data) {
        this.onPage = onPage;
        this.onePageSize = onePageSize;
        this.count = count;
        this.data = data;
    }

    public void setCount(Integer count){
        this.count = count;
    }

    public void setOnPage(Integer onPage) {
        this.onPage = onPage;
    }

    public Integer getCount() {
        return count;
    }

    public Integer getIndex() {
        return (onPage - 1) * onePageSize;
    }


    public Integer getIndexTo() {
        int count = onePageSize + getIndex();
        if (count >= getCount()) {
            return getCount();
        }
        return count;
    }


    public Collection<T> getData() {
        return data;
    }

    public void setData(Collection<T> data) {
        this.data = data;
    }

    public Integer getPageCount() {
        if (count % onePageSize == 0) {
            return count / onePageSize;
        }
        return count / onePageSize + 1;
    }

    public Integer getOnePageSize() {
        return onePageSize;
    }

    public void setOnePageSize(Integer onePageSize) {
        this.onePageSize = onePageSize;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public void setIndexTo(Integer indexTo) {
        this.indexTo = indexTo;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    @Override
    public String toString() {
        return "PaginationUtil{" +
                "count=" + count +
                ", index=" + index +
                ", indexTo=" + indexTo +
                ", pageCount=" + pageCount +
                ", onPage=" + onPage +
                ", onePageSize=" + onePageSize +
                ", data=" + data +
                '}';
    }
}
