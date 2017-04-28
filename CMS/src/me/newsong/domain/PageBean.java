package me.newsong.domain;

import java.util.List;

public class PageBean<T> {
	private List<T> datas;// 当前页记录数, 需要传递
	private int totalRecord;// 总记录数, 需要传递
	private int currPageCode;// 当前页码, 需要传递

	private int pageSize;// 每页记录数, 需要传递
	private int totalPage;// 总页数, 计算
	private int currPageBeginIndex; // 需要计算
	private String url;// 方法名+查询条件

	public PageBean(int currPageCode, int totalRecord, int pageSize, String url) {
		this.currPageCode = currPageCode;
		this.totalRecord = totalRecord;
		this.pageSize = pageSize;
		this.url = url;
		init();
	}

	private void init() {
		this.totalPage = totalRecord / pageSize;
		if (totalRecord % pageSize != 0) {
			this.totalPage++;
		}
		this.currPageBeginIndex = (this.currPageCode - 1) * this.pageSize;
	}

	public List<T> getDatas() {
		return datas;
	}

	public void setDatas(List<T> datas) {
		this.datas = datas;
	}

	public int getCurrPageBeginIndex() {
		return currPageBeginIndex;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	public String getUrl() {
		return url;
	}

	public int getCurrPageCode() {
		return currPageCode;
	}

	public int getPageSize() {
		return pageSize;
	}

	public int getTotalPage() {
		return totalPage;
	}

}
