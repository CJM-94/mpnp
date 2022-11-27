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
		//System.out.println("CartDAO : ssesion - "+ss);
		
		// 2. ��������
		list = ss.selectList("kr.co.mpnp.user.mapper.cartMapper.selectCartList",id);
		
		// 3. ����
		mbh.closeHandler(ss);

		return list;
	}

	
	
	// ��ٱ��� ���� ���ϻ���
	public boolean deleteCart(String cartId){
		boolean deleteFlag = false;
		int cnt = 0;
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getHandler();
		cnt = ss.delete("kr.co.mpnp.user.mapper.cartMapper.deleteCart",cartId);
		if(cnt!=0) {
			deleteFlag = true;
			ss.commit();
		}else {
			ss.rollback();
		}
		
		mbh.closeHandler(ss);
		return deleteFlag;
	}
	
	// ��ٱ��� ���� ���߻���
	public boolean deleteChkCart(List<CartVO> list){
		boolean deleteFlag = false;
		int cnt = 0;
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getHandler();
		
		//System.out.println("DAO���� �� list ���� : "+list.size());
		cnt = ss.delete("kr.co.mpnp.user.mapper.cartMapper.deleteChkCart",list);
		//System.out.println("cnt�� : "+cnt);
		
		if(cnt==list.size()) {
			deleteFlag = true;
			ss.commit();
		}else {
			ss.rollback();
		}
		
		mbh.closeHandler(ss);
		return deleteFlag;
	}
	
	
	// 2022-11-25 ����6�� ������
	
	// ��ٱ��ϰ�������
	public boolean updateCartCnt(CartVO cVO){
		boolean updateFlag = false;
		int cnt = 0;
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getHandler();
		cnt = ss.delete("kr.co.mpnp.user.mapper.cartMapper.updateCartCnt",cVO);
		//System.out.println(cnt);
		if(cnt!=0) {
			updateFlag = true;
			ss.commit();
		}else {
			ss.rollback();
		}
		return updateFlag;
	}
	
	
	
}
