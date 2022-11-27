package kr.co.mpnp.admin.dao;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import kr.co.mpnp.admin.domain.AdminOrderDomain;
import kr.co.mpnp.admin.domain.AdminOrderPrdDomain;
import kr.co.mpnp.admin.vo.AdminOrderVO;
import kr.co.mpnp.handler.MyBatisHandler;
//���̳������� ����. �� �� �����Ϸ�
//����Ȯ������ ���� �� ������ �߰��Ǵ� ������ ����ڿ����� �� �� ����
//����
public class AdminOrderDAO {
	private static AdminOrderDAO aoDAO;

	// �̱���
	private AdminOrderDAO() {

	}// AdminOrderDAO

	public static AdminOrderDAO getInstance() {
		if (aoDAO == null) {
			aoDAO = new AdminOrderDAO();
		}

		return aoDAO;
	}// getInstance()

	
	  // �ֹ���ȸ(���̳���) 
	public List<AdminOrderDomain> selectOrderList(AdminOrderVO aoVO) {
	       List<AdminOrderDomain> list = null;
	    // MyBatisHandler���
			MyBatisHandler mbh = MyBatisHandler.getInstance();
			SqlSession ss = mbh.getHandler();
			// ���� ����
			list = ss.selectList("kr.co.mpnp.adminOrderMapper.selectOrderList",aoVO);

			System.out.println(list);

			// �������
			mbh.closeHandler(ss);
	  return list;
	  
	  }// end selectOrderList
	
	//////////////////////////
	 


	//����
	// �ֹ�����ȸ
	public AdminOrderDomain selectOrderDetail(String orID) {
		AdminOrderDomain aoDom = null;

		// MyBatisHandler���
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getHandler();
		try {
			aoDom = ss.selectOne("kr.co.mpnp.adminOrderMapper.selectOrderDetail", orID);
			System.out.println(aoDom);
		} catch (PersistenceException pe) {
			pe.printStackTrace();
		}
		// �������
		mbh.closeHandler(ss);

		return aoDom;
	}// selectOrderDetail
	
	//o
	//�ӽ� ������ ��ȸ
	public int selectDiscountRate(String id) {
		int discount = 0;
		
		// MyBatisHandler���
				MyBatisHandler mbh = MyBatisHandler.getInstance();
				SqlSession ss = mbh.getHandler();
				try {
					discount = ss.selectOne("kr.co.mpnp.adminOrderMapper.selectDiscountRate", id);
					System.out.println(discount);
				} catch (PersistenceException pe) {
					pe.printStackTrace();
				}
				// �������
				mbh.closeHandler(ss);
		
		
		return discount;
	}//
	
	//�ֹ� �� ��ǰ��ȸ
	public List<AdminOrderPrdDomain> selectOrderPrdDetail(String orId){
		List<AdminOrderPrdDomain> list = null;
		
		// MyBatisHandler���
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getHandler();
		try {
			list = ss.selectList("kr.co.mpnp.adminOrderMapper.selectOrderPrdDetail",orId);
			System.out.println(list);
		} catch (PersistenceException pe) {
			pe.printStackTrace();
		}
		// �������
		mbh.closeHandler(ss);
		
		return list;
	}
	
	// �ֹ��� �������ȸ
	public AdminOrderDomain selectOrderShip(String orID) {
		AdminOrderDomain aoDom = null;

		// MyBatisHandler���
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getHandler();
		try {
			aoDom = ss.selectOne("kr.co.mpnp.adminOrderMapper.selectOrderShip", orID);
			System.out.println(aoDom);
		} catch (PersistenceException pe) {
			pe.printStackTrace();
		}
		// �������
		mbh.closeHandler(ss);

		return aoDom;
	}// selectOrderDetail
	


	
	//�ֹ����� ����(Ʈ�����)
	public int updateOrderStatus(AdminOrderVO aoVO) {
		int cnt = 0;
		
		 //MyBatisHandler���
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getHandler();
		
		try {
		cnt = ss.update("kr.co.mpnp.adminOrderMapper.updateOrderStatus", aoVO);// �ֹ����º���
		System.out.println(cnt);
		if(cnt == 1) { //���� �� �ƴ�?
			ss.commit();
			System.out.println(cnt);
			int cnt2=0;
			int cnt3 = 0;
		 if("����Ȯ��".equals(aoVO.getStatus())) {
			 
			cnt2 = ss.update("kr.co.mpnp.adminOrderMapper.updateCompletionDate",aoVO); //����Ȯ�� �� ��¥ ������Ʈ
			System.out.println(cnt2);
			cnt3 = ss.update("kr.co.mpnp.adminOrderMapper.updateReviewChk",aoVO); // ����Ȯ�� �� �ı�üũ ������Ʈ
		   System.out.println(cnt3);
		}//end if
		   if(cnt2 !=0 && cnt3 !=0) {
			  ss.commit();
			  System.out.println("Ʈ����� ����");
		  }else {
			  ss.rollback();
			  System.out.println("Ʈ����� ����");
		  }//end else
		
		}//end ���if
		}catch(PersistenceException pe) {
			pe.printStackTrace();
		}//end catch	
		mbh.closeHandler(ss);
		
		return cnt;
	}//
	
	
	//�����Ϸ�
		//�ֹ����°� ����Ȯ���� ��� ����Ȯ���� ������Ʈ(�ֹ��ڵ�)
		public int updateCompletionDate(AdminOrderVO aoVO) {
			int cnt = 0;
			MyBatisHandler mbh = MyBatisHandler.getInstance();
			SqlSession ss = mbh.getHandler();
			
			try {
			cnt = ss.update("kr.co.mpnp.adminOrderMapper.updateCompletionDate",aoVO);
			
			if(cnt == 1) { //���� �� �ƴ�?
				int cnt2=0;
				cnt2 = ss.update("kr.co.mpnp.adminOrderMapper.updateReviewChk",aoVO);
				if(cnt2 == 1) {
					ss.commit();
					System.out.println("����Ȯ���ϰ� �ı�üũ�� ����Ǿ����ϴ�.");
				}else {
					ss.rollback();
					System.out.println("����Ȯ�� ��� �ı�üũ��� �ƴմϴ�. ");
				}//end else
			}//end if	
			}catch(PersistenceException pe) {
				pe.printStackTrace();
			}//end catch	
		

			// �������
			mbh.closeHandler(ss);
			
			return cnt;
			
		}//
	
	
	//���� ��������
	public int selectPriceIndivisual(String orderId) {
		int price = 0;
		
		// MyBatisHandler���
				MyBatisHandler mbh = MyBatisHandler.getInstance();
				SqlSession ss = mbh.getHandler();
				
				try {
					price= ss.selectOne("kr.co.mpnp.adminOrderMapper.selectPriceIndivisual", orderId);
					System.out.println(price);
				} catch (PersistenceException pe) {
					pe.printStackTrace();
				}
				// �������
				mbh.closeHandler(ss);
				
		
		return price;
	}//
	
	
	
	/////////////////////////
	
	
	
	//�����Ϸ�
	//����Ȯ���� �ֹ��ڵ�� �ֹ��󼼿��� �ֹ��ı⸦ 'N''�� �ٲ�
	public int updateReviewChk(AdminOrderVO aoVO) {
		int cnt=0;
		
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getHandler();
		
		cnt = ss.update("kr.co.mpnp.adminOrderMapper.updateReviewChk",aoVO);
		
		if(cnt > 1) { //���� �� �ƴ�?
			ss.commit();
			System.out.println("N���� ������Ʈ");
			
		}else {
			System.out.println("����Ȯ�� �ƴ� ");
		}//en else

		// �������
		mbh.closeHandler(ss);
		
		
		
		return cnt;
		
	}//

//	public static void main(String[] args) {
//		String o = "or_0000144";
//		String b = "id005";
//		AdminOrderDAO aod = new AdminOrderDAO();
	    //aod.selectDiscountRate(b);
	   /// aod.selectOrderDetail(o);
	   // aod.selectOrderPrdDetail(o);
	    //aod.selectOrderShip(o);
	   // aod.selectPriceIndivisual(o);
//		AdminOrderVO aVO = new AdminOrderVO();
//		aVO.setOrderStatus("����Ȯ��");
//		aVO.setOrderID("or_0000028");
//		//aod.updateOrderStatus(aVO);
//	//	aod.updateCompletionDate("or_0000028");
//		aod.updateReviewChk();
////		//aod.selectOrderDetail(id);
////		//aod.selectOrderPrdList(id);
////		AdminOrderVO aVO = new AdminOrderVO();
////		 aVO.setOrderStatus("����Ȯ��");
////		aVO.setOrderID(id);
////		//aod.updateOrderStatus(aVO);
//////		String a = aVO.getOrderStatus();
//////		if(a.equals("����Ȯ��")) {
//////		aod.updateCompletionDate();
//////		}else {
//////			System.out.println("����");
//////		}
////		
////		aod.selectOrderList(aVO);
//		
		

	//}//main

}
