package kr.co.mpnp.user.vo;

public class ReviewVO {

//	- productid : String
//	totalcount(��ü�Խù���),totalpage(��ü��������),
//	currentpage(����������),startnum(���۹�ȣ),endnum(����ȣ),
//	pagescale(�� �������� ������ �Խù���) : int
	
	private String productid;

	
	
public ReviewVO() {

}

public ReviewVO(String productid) {
	
	this.productid = productid;
}

public String getProductid() {
	return productid;
}

public void setProductid(String productid) {
	this.productid = productid;
}

@Override
public String toString() {
	return "ReviewVO [productid=" + productid + "]";
}

	
	
}//class
