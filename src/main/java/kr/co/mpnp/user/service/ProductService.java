package kr.co.mpnp.user.service;


import java.util.List;

import kr.co.mpnp.user.dao.ProductDAO;
import kr.co.mpnp.user.domain.ProductDomain;
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
		int cnt=pDAO.insertCart(cVO);
	
		return cnt;
	}
	


}//class

