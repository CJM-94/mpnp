package kr.co.mpnp.user.domain;

import java.sql.Date;
import java.util.List;

public class ProductReviewDomain {
	
	private String id,productid,contents,pfimg,nick,reviewid;
	private int starscore,price,totalCnt,totalpeople,reviewcnt;
	private Double staravg;
	
	private Date reviewdate;
	private List<String> reviewimg;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getProductid() {
		return productid;
	}
	public void setProductid(String productid) {
		this.productid = productid;
	}

	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getPfimg() {
		return pfimg;
	}
	public void setPfimg(String pfimg) {
		this.pfimg = pfimg;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public String getReviewid() {
		return reviewid;
	}
	public void setReviewid(String reviewid) {
		this.reviewid = reviewid;
	}
	public int getStarscore() {
		return starscore;
	}
	public void setStarscore(int starscore) {
		this.starscore = starscore;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getTotalCnt() {
		return totalCnt;
	}
	public void setTotalCnt(int totalCnt) {
		this.totalCnt = totalCnt;
	}
	public int getTotalpeople() {
		return totalpeople;
	}
	public void setTotalpeople(int totalpeople) {
		this.totalpeople = totalpeople;
	}
	public Double getStaravg() {
		return staravg;
	}
	public void setStaravg(Double staravg) {
		this.staravg = staravg;
	}
	public Date getReviewdate() {
		return reviewdate;
	}
	public void setReviewdate(Date reviewdate) {
		this.reviewdate = reviewdate;
	}
	public List<String> getReviewimg() {
		return reviewimg;
	}
	public void setReviewimg(List<String> reviewimg) {
		this.reviewimg = reviewimg;
	}
	@Override
	public String toString() {
		return "ProductReviewDomain [id=" + id + ", productid=" + productid 
				+ ", contents=" + contents + ", pfimg=" + pfimg + ", nick=" + nick + ", reviewid=" + reviewid
				+ ", starscore=" + starscore + ", price=" + price + ", totalCnt=" + totalCnt + ", totalpeople="
				+ totalpeople + ", staravg=" + staravg + ", reviewdate=" + reviewdate + ", reviewimg=" + reviewimg
				+ "]";
	}
	
	
	
	

}//class
