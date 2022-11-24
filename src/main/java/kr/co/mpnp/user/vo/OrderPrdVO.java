package kr.co.mpnp.user.vo;

import java.util.Arrays;

//����
public class OrderPrdVO {
	
	//��ٱ��Ͽ��� �Ѿ�� �� (view�κ��� ���޹��� ��)
 private String prdName, prdId, cartId;
 private int prdCnt, prdPrice;

 //���� ��
 private int totalPrice,totalProductPrice;

 
 
public OrderPrdVO() {

}




public OrderPrdVO(String prdName, String prdId, String cartId, int prdCnt, int prdPrice, int totalPrice,
		int totalProductPrice) {
	this.prdName = prdName;
	this.prdId = prdId;
	this.cartId = cartId;
	this.prdCnt = prdCnt;
	this.prdPrice = prdPrice;
	this.totalPrice = totalPrice;
	this.totalProductPrice = totalProductPrice;
}



//���� ��ǰ�� �� ���� ���ϴ� �޼���
//��ǰ�� ����, ���� [�������� ���ǿ� �����ص� ���¿��� �� ������ ����� �� �׿� ���� ���ΰ����� ����� �ϰ� �Ѱܾ� �Ϸ���?]
//�ƴϸ� �ֹ����������� �� �� �ֳ�?
public int initSaleTotal() {
	
	return this.totalPrice = this.prdPrice *this.prdCnt ;
	
}

//��ǰ������ ���� ���ϴ� �޼���
public int totalProduct() {
	return this.totalProductPrice = this.totalPrice++;
}




public String getPrdName() {
	return prdName;
}




public void setPrdName(String prdName) {
	this.prdName = prdName;
}




public String getPrdId() {
	return prdId;
}




public void setPrdId(String prdId) {
	this.prdId = prdId;
}




public String getCartId() {
	return cartId;
}




public void setCartId(String cartId) {
	this.cartId = cartId;
}




public int getPrdCnt() {
	return prdCnt;
}




public void setPrdCnt(int prdCnt) {
	this.prdCnt = prdCnt;
}




public int getPrdPrice() {
	return prdPrice;
}




public void setPrdPrice(int prdPrice) {
	this.prdPrice = prdPrice;
}




public int getTotalPrice() {
	return totalPrice;
}




public void setTotalPrice(int totalPrice) {
	this.totalPrice = totalPrice;
}




public int getTotalProductPrice() {
	return totalProductPrice;
}




public int  setTotalProductPrice(int totalProductPrice) {
	return this.totalProductPrice = totalProductPrice;
}




@Override
public String toString() {
	return "OrderPrdVO [prdName=" + prdName + ", prdId=" + prdId + ", cartId=" + cartId + ", prdCnt=" + prdCnt
			+ ", prdPrice=" + prdPrice + ", totalPrice=" + totalPrice + ", totalProductPrice=" + totalProductPrice
			+ "]";
}














 
}
