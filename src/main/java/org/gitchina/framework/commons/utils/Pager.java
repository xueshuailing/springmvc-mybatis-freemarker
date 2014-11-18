package org.gitchina.framework.commons.utils;
import java.util.Collection;

import org.apache.commons.lang.StringUtils;

 
public class Pager {
	private static int START_ROWS = 1;
	public static final int ONE_PAGE_SIZE = 1;
	public static final int TEN = 10;
	public static final int TWELVE = 12;
	public static final int FIFTEEN = 15;
	public static final int TWENTY = 20;
	
	//总记录数
	private long totalCount;
	//当前页数
	private int page = 1;
	//总页数
	private int pageCount = 1;
	//每页显示记录数
	private int pageSize = TWENTY;
	//存储结果
	private Collection<?> result;
	private String url;
	private String parames;
	
	//以下为构造函数
	public Pager(long totalCount) {
		this(totalCount, 1);
	}
	public Pager(long totalCount, int page) {
		this(totalCount, page, Pager.TWENTY);
	}
	public Pager(long totalCount, int page, int PageSize) {
		this.setTotalCount(totalCount);
		this.setPageSize(PageSize);
		this.setPage(page);
	}
	
	public static Pager getPager(long totalCount, int rowStart, int pageSize) {
		int count = (int)rowStart / pageSize + 1;
		return new Pager(totalCount, count, pageSize);
	}
	
	public Pager(long totalCount, int page, int pageSize, String url, String parames) {
		this(totalCount, page, pageSize);
		this.setUrl(url);
		this.setParames(parames);
	}
	
	//以下为公共方法=======================================
	
	//获取总页数
	public int getTotalPages() {
		if (totalCount < 0) {
			return -1;
		}
		int count = (int)totalCount / pageSize;
		if (totalCount % pageSize > 0) {
			count++;
		}
		return count;
	}
	
	//是否有下一页
	public boolean isHasNext() {
		return (page + 1 <= getTotalPages());
	}
	
	//获取下一页
	public int getNextPage() {
		if (isHasNext()) {
			return page + 1;
		} else {
			return page;
		}
	}
	
	//是否有上一页
	public boolean isHasPre() {
		return (page - 1 >= 1);
	}
	
	//获取上一页
	public int getPrePage() {
		if (isHasPre()) {
			return page - 1;
		} else {
			return page;
		}
	}
	
	//获取开始行数
	public long getStartRows() {
		int val = (getPage() - 1) * getPageSize();
		if (val < START_ROWS) {
			return START_ROWS;
		}
		if (val > this.getTotalCount()) {
			return (this.getTotalPages() - 1) * this.getPageSize();
		}
		return val;
	}
	
	public long getEndRows() {
		long val = getStartRows() + this.getPageSize() - 1;
		if (val > this.getTotalCount()) {
			val = this.getTotalCount();
		}
		
		return val;
	}
	
	public long getViewStartRows() {
		return getStartRows() + 1;
	}
	
	public long getViewEndRows() {
		return getEndRows() + 1;
	}
	
	public long getTotalCount() {
		return this.totalCount;
	}
	public int getPage() {
		return this.page;
	}
	public int getPageSize() {
		return this.pageSize;
	}
	public Collection<?> getResult() {
		return result;
	}
	public void setResult(Collection<?> result) {
		this.result = result;
	}
	public String getUrl() {
		return url;
	}
	public String getUrlParames(long pageNo) {
		String val = url + "?page=" + pageNo + "&pageSiz=" + this.getPageSize();
		if (StringUtils.isNotEmpty(this.getParames())) {
			val = val + "&" + this.getParames();
		}
		return val;
	}
	
	//以下为私有方法=======================================
	private void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
		if (this.totalCount < 0) {
			this.totalCount = 0;
		}
	}
	private void setPage(int page) {
		this.page = page;
		if (this.page > this.getTotalPages()) {
			this.page = (int)this.getTotalPages();
		}
		if (this.page < 1) {
			this.page = 1;
		}
	}
	private void setPageSize(int pageSize) {
		this.pageSize = pageSize;
		if (this.pageSize < 1) {
			this.pageSize = Pager.ONE_PAGE_SIZE;
		} 
	}
	private void setUrl(String url) {
		this.url = url;
	}

	public String getParames() {
		return parames;
	}

	private void setParames(String parames) {
		this.parames = parames;
	}
	public int getPageCount() {
		return this.getTotalPages();
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
		if (this.pageCount < 1) {
			this.pageCount = 1;
		}
	}
	
}

