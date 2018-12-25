package cn.canying.util;


/**
 */
public class TurnPage {

	/**
	 * 锟斤拷前页锟斤拷募锟铰硷拷锟�
	 */
	private int rowInOnePage = 10;

	/**
	 * 锟斤拷锟捷碉拷锟杰癸拷锟斤拷
	 */
	private long total;

	/**
	 * 锟斤拷前页锟斤拷
	 */
	private int pageNum = 1;

	/**
	 * 锟杰癸拷页锟斤拷
	 */
	private int pageCount = 0;
	
	/**
	 * 执锟叫诧拷询时锟斤拷锟斤拷实锟侥硷拷录锟斤拷
	 */
	private int startNum=0;
	/**
	 * 
	 */
	public TurnPage() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return Returns the pageCount.
	 */
	public int getPageCount() {
		long tmp = total/(new Long(rowInOnePage)).longValue();
		pageCount = (new Long(tmp)).intValue();
		if((total%rowInOnePage)>0)
			pageCount++;
		return pageCount;
	}
	/**
	 * @param pageCount The pageCount to set.
	 */
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	/**
	 * @return Returns the pageNum.
	 */
	public int getPageNum() {
		return pageNum;
	}
	/**
	 * @param pageNum The pageNum to set.
	 */
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	/**
	 * @return Returns the rowInOnePage.
	 */
	public int getRowInOnePage() {
		return rowInOnePage;
	}
	/**
	 * @param rowInOnePage The rowInOnePage to set.
	 */
	public void setRowInOnePage(int rowInOnePage) {
		this.rowInOnePage = rowInOnePage;
	}
	/**
	 * @return Returns the total.
	 */
	public long getTotal() {
		return total;
	}
	/**
	 * @param total The total to set.
	 */
	public void setTotal(long total) {
		this.total = total;
	}
	public int getStartNum() {
		startNum=(pageNum-1)*rowInOnePage;
		return startNum;
	}

}
