package com.igeek.bean;

import java.util.List;

public class Paging<T> {
	private int pageCount;
	private int rowsCount;
	private int pageSize;
	private int curPage;
	private List<T> data;
	public Paging() {
		
	}
	public Paging(int pageSize, int curPage) {
		this.pageSize = pageSize;
		this.curPage = curPage;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getRowsCount() {
		return rowsCount;
	}
	public void setRowsCount(int rowsCount) {
		this.rowsCount = rowsCount;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getCurPage() {
		return curPage;
	}
	public void setCurPage(int currPage) {
		this.curPage = currPage;
	}
	public List<T> getData() {
		return data;
	}
	public void setData(List<T> data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "Paging [pageCount=" + pageCount + ", rowsCount=" + rowsCount + ", pageSize=" + pageSize + ", currPage="
				+ curPage + ", data=" + data + "]";
	}
	
}
