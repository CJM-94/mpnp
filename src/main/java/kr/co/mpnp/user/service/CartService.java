package kr.co.mpnp.user.service;

import java.util.List;

import kr.co.mpnp.user.domain.CartDomain;
import kr.co.mpnp.user.vo.CartVO;

public class CartService {

	// �α��ν� ��ٱ��� ������ȸ
	// �׷� ��� �α�����Ʈ�ѷ����� �θ�����
	public int searchCartTotalCnt(String id) {
		int cnt = 0;
		
		
		return cnt;
	}
	
	// ��ٱ��� ��ȸ
	public List<CartDomain> searchCartList(String id){
		List<CartDomain> list = null;
		
		return list;
	}
	
	// ��ٱ��� ��������
	public boolean modifyCartItemCnt(CartVO cVO) {
		
		
		int cnt = 0;
		
		return cnt!=0?true:false;
	}
	
	// ��ٱ��� ����
	public boolean removeCart(String id, String[] cartId) {
		boolean removeFlag = false;
		
		
		
		return removeFlag;
	}
	
}
