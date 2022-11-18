package kr.co.mpnp.user.service;

import java.util.List;

import kr.co.mpnp.user.dao.ProductReviewDAO;
import kr.co.mpnp.user.domain.ProductReviewDomain;

public class ProductReviewService {

		ProductReviewDAO prDAO = new ProductReviewDAO();
	//��ǰ�� ���� �ҷ�����
	public List<ProductReviewDomain> searchProductReview(String productid){
		List<ProductReviewDomain> list= prDAO.selectProductReview(productid);
		
		
		return list;
	}
	
	//��ǰ�� ���� �ο��� 
	public List<ProductReviewDomain> searchStarCnt(String productid){
		List<ProductReviewDomain> slist=prDAO.selectStarCnt(productid);
		return slist;
	}
	
	
}
