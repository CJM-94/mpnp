package kr.co.mpnp.user.vo;



//����¡ ���� vo��..!!!!
public class SearchVO {
	
//	totalcount(��ü�Խù���),totalpage(��ü��������),
//	currentpage(����������),startnum(���۹�ȣ),endnum(����ȣ),
//	pagescale(�� �������� ������ �Խù���) 
	
	private int  startNum,endNum,totalcount,totalpage,currentpage,pagescale;

	public SearchVO() {
		
	}

	public SearchVO(int startNum, int endNum, int totalcount, int totalpage, int currentpage, int pagescale) {
	
		this.startNum = startNum;
		this.endNum = endNum;
		this.totalcount = totalcount;
		this.totalpage = totalpage;
		this.currentpage = currentpage;
		this.pagescale = pagescale;
	}

	public int getStartNum() {
		return startNum;
	}

	public void setStartNum(int startNum) {
		this.startNum = startNum;
	}

	public int getEndNum() {
		return endNum;
	}

	public void setEndNum(int endNum) {
		this.endNum = endNum;
	}

	public int getTotalcount() {
		return totalcount;
	}

	public void setTotalcount(int totalcount) {
		this.totalcount = totalcount;
	}

	public int getTotalpage() {
		return totalpage;
	}

	public void setTotalpage(int totalpage) {
		this.totalpage = totalpage;
	}

	public int getCurrentpage() {
		return currentpage;
	}

	public void setCurrentpage(int currentpage) {
		this.currentpage = currentpage;
	}

	public int getPagescale() {
		return pagescale;
	}

	public void setPagescale(int pagescale) {
		this.pagescale = pagescale;
	}

	@Override
	public String toString() {
		return "SearchVO [startNum=" + startNum + ", endNum=" + endNum + ", totalcount=" + totalcount + ", totalpage="
				+ totalpage + ", currentpage=" + currentpage + ", pagescale=" + pagescale + "]";
	}
	
	
	

}//class 
