package kr.co.mpnp.user.dao;

import java.util.List;

import kr.co.mpnp.user.domain.CartDomain;
import kr.co.mpnp.user.vo.CartVO;

public class CartDAO {
	
	// ��ٱ��� ��ȸ
	public List<CartDomain> selectCartList(String id){
		List<CartDomain> list = null;
		
		
		return list;
	}
	
	// ��ٱ��ϰ�������
	public boolean updateCartCnt(CartVO cVO){
		boolean updateFlag = false;
		
		return updateFlag;
	}
	
	
	// ��ٱ��� ����
	public boolean deleteCart(String id, String[] cartIds){
		boolean deleteFlag = false;
		
		
		return deleteFlag;
	}
	
	
}
