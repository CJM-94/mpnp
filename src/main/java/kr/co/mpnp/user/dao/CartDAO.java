package kr.co.mpnp.user.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.co.mpnp.handler.MyBatisHandler;
import kr.co.mpnp.user.domain.CartDomain;
import kr.co.mpnp.user.vo.CartVO;

public class CartDAO {
	private static CartDAO cartDAO;

	private CartDAO() {
	}

	public static CartDAO getInstance() {
		if (cartDAO == null) {
			cartDAO = new CartDAO();
		}

		return cartDAO;
	}
	
	// ��ٱ��� ��ȸ
	public List<CartDomain> selectCartList(String id){
		List<CartDomain> list = null;
		
		// 1. Mybatis Handler �ޱ�
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getHandler();
		System.out.println("CartDAO : ssesion - "+ss);
		
		// 2. ��������
		list = ss.selectList("kr.co.mpnp.user.mapper.cartMapper.selectCartList",id);
		
		// 3. ����
		mbh.closeHandler(ss);

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
