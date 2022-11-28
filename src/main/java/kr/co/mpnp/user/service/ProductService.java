package kr.co.mpnp.user.service;


import java.util.List;

import org.json.simple.JSONObject;

import kr.co.mpnp.user.dao.ProductDAO;
import kr.co.mpnp.user.domain.ProductDomain;
import kr.co.mpnp.user.domain.WishDomain;
import kr.co.mpnp.user.vo.ProductCartVO;
import kr.co.mpnp.user.vo.ProductVO;
import kr.co.mpnp.user.vo.WishListVO;

	
public class ProductService {

	ProductDAO pDAO = ProductDAO.getInstance();

	//��ǰ�󼼺���
	public ProductDomain  searchPrdDetail(String productid) {
		
		ProductDomain pd=pDAO.selectPrdDetail(productid);
		return pd;
	}//
	
	
	//��ǰ �ߺз�
	public List<ProductDomain> searchPrdList(ProductVO pVO){
		List<ProductDomain> list = pDAO.selectprdList(pVO);
		return list;
	}
	
	//��ǰ�̹���
	public List<ProductDomain> searchPrdImg(String productid){
		List<ProductDomain> list=pDAO.selectPrdImg(productid);
		return list;
	}
	
	//��ǰ�� ����
	public int searchPrdCnt (ProductVO pVO) {
		int cnt=pDAO.selectprdCnt(pVO);
		
		
		return cnt;
		
	}
	
	//����¡
	
	
	//������ ������ ��
	public int lastPage(int searchPrdCnt) {
		int lastPage=(int)Math.ceil((double) searchPrdCnt /8);
		
		return lastPage;
	}
	
	//���������� ���۹�ȣ
	public int startNum(int curPage) {
		int startNum=curPage-(curPage-1)%3;
		return startNum;
		
	}
	//���������� ������ ��������
	public int isLast(int lastPage,int startNum) {
		int isLast =2; //0,1,2, 3��������
		if(startNum+3>lastPage) {
			isLast= lastPage-startNum;
			
		}
		return isLast;
		
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
		int addWish=pDAO.insertWishList(cVO);
		
		return addWish;
			
	}//addCart
	
	//�򿩺� Ȯ��
	public int checkWish(WishListVO wVO) {
		int check=pDAO.selectcheckWish(wVO);
		
		return check;
	}
	

	
	
	

}//class

