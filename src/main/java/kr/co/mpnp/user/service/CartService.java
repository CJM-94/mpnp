package kr.co.mpnp.user.service;

import java.util.List;

import org.json.simple.JSONObject;

import kr.co.mpnp.user.dao.CartDAO;
import kr.co.mpnp.user.dao.ReviewDAO;
import kr.co.mpnp.user.domain.CartDomain;
import kr.co.mpnp.user.vo.CartVO;

public class CartService {

	// �α��ν� ��ٱ��� ������ȸ
	public int searchCartTotalCnt(String id) {
		int cnt = 0;
		
		
		return cnt;
	}
	
	// ��ٱ��� ��ȸ
	public List<CartDomain> searchCartList(String id){
		List<CartDomain> list = null;
		
		//System.out.println("CartService : id - "+id);
		CartDAO cartDAO = CartDAO.getInstance();
		list = cartDAO.selectCartList(id);
		
		return list;
	}
	
	
	// ��ٱ��� ���� ���ϻ���
	public String removeCart(String cartId) {
		boolean removeFlag = false;
		CartDAO cartDAO = CartDAO.getInstance();
		removeFlag = cartDAO.deleteCart(cartId);
		
		JSONObject jsonData = new JSONObject();
		jsonData.put("removeFlag", removeFlag);
		
		return jsonData.toJSONString();
		
	}
	
	// ��ٱ��� ���� ���ϻ���
	public String removeChkCart(List<CartVO> list) {
		boolean removeFlag = false;
		CartDAO cartDAO = CartDAO.getInstance();
		//System.out.println("�ٿ� ������");
		removeFlag = cartDAO.deleteChkCart(list);
		//System.out.println("�ٿ� ������");
		
		JSONObject jsonData = new JSONObject();
		jsonData.put("removeFlag", removeFlag);
		
		return jsonData.toJSONString();
		
	}
	
	
	// ��ٱ��� ��������
	public String modifyCartItemCnt(CartVO cVO) {
		boolean modifyFlag = false;
		CartDAO cartDAO = CartDAO.getInstance();
		//System.out.println("�ٿ� ������");
		modifyFlag = cartDAO.updateCartCnt(cVO);
		//System.out.println("�ٿ� ������");
		
		JSONObject jsonData = new JSONObject();
		jsonData.put("modifyFlag", modifyFlag);
		////////////////////////////////////
		// ���� �ѱ氪 ¥����
		jsonData.put("test", "�׽�Ʈ�Դϴ�");
		
		/////////////////////////////////////
		
		
		return jsonData.toJSONString();
	}
	
	
}
