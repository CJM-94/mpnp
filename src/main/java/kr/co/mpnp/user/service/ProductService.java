package kr.co.mpnp.user.service;


import java.util.List;

import kr.co.mpnp.user.dao.ProductDAO;
import kr.co.mpnp.user.domain.ProductDomain;
import kr.co.mpnp.user.domain.WishDomain;
import kr.co.mpnp.user.vo.ProductCartVO;

	
public class ProductService {

	ProductDAO pDAO = ProductDAO.getInstance();

	//��ǰ�󼼺���
	public ProductDomain  searchPrdDetail(String productid) {
		
		ProductDomain pd=pDAO.selectPrdDetail(productid);
		return pd;
	}//
	
	
	//��ǰ �ߺз�
	public List<ProductDomain> searchPrdList(String subid){
		List<ProductDomain> list = pDAO.selectprdList(subid);
		return list;
	}
	//��ǰ�� ����
	public int searchPrdCnt (String subid) {
		int cnt=pDAO.selectprdCnt(subid);
		
		
		return cnt;
		
	}
	
	//��ٱ��� �߰�
	public int addCart(ProductCartVO cVO) {
		
		//��ٱ��� ������ üũ
		int check=pDAO.checkCart(cVO);
		if(check!=0){	//��ٱ��Ͽ� �̹� ����ִ°�� 2�ι�ȯ
			return 2;
		}
		//��ٱ��� ���&������ 0��ȯ
		try {//��ٱ��Ͽ� ��ϿϷ� =>1
			return pDAO.insertCart(cVO);
		}catch(Exception e) { //����==>0
			return 0;
		}
	

	}//addCart
	
	//���߰�
	public int addWish(ProductCartVO cVO) {
		
		//�� ������ üũ
		int check=pDAO.checkWish(cVO);
		//�� ����
	
		if(check!=0){	//�� �̹� ����ִ°�� 2�ι�ȯ
			return 2;
		}
		//��ٱ��� ���&������ 0��ȯ
		try {//��ٱ��Ͽ� ��ϿϷ� =>1
			return pDAO.insertWishList(cVO);
		}catch(Exception e) { //����==>0
			return 0;
		}
		
		
	}//addCart
	

	
	public static void main(String[] args) {
	ProductService ps=new ProductService();	
	ProductCartVO	cVO= new ProductCartVO();
			cVO.setId("id010");
			cVO.setProductid("p0001");
			
		
			
			int result=ps.addWish(cVO);
			//int check=ps.addCart(cVO);
			System.out.println("result : "+result);
			//System.out.println("result : "+check);
			
		
	}

	

}//class

