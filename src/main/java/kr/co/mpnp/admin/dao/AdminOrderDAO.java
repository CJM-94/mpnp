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

	//����
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
	// �ش� �ֹ��ڵ��� ��ǰ��ȸ
	public List<AdminOrderPrdDomain> selectOrderPrdList(String odID) {
		List<AdminOrderPrdDomain> list = null;
		
		// MyBatisHandler���
					MyBatisHandler mbh = MyBatisHandler.getInstance();
					SqlSession ss = mbh.getHandler();
					// ���� ����
					list = ss.selectList("kr.co.mpnp.adminOrderMapper.selectOrderPrdDetail",odID);
					System.out.println(list);
					// �������
					mbh.closeHandler(ss);
		return list;
	}// selectOrderPrdList

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

	// �ֹ����º���
	//�ֹ� �Ϸ�,��ۿϷ�, ����Ȯ��
	public int updateOrderStatus(AdminOrderVO aoVO) {
		int cnt = 0;

		// MyBatisHandler���
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getHandler();
		
		cnt = ss.update("kr.co.mpnp.adminOrderMapper.updateOrderStatus", aoVO);
		
		if(cnt == 1) { //���� �� �ƴ�?
			ss.commit();
			System.out.println(aoVO.getOrderStatus()+"�� ���°� ����Ǿ����ϴ�");
			
		}else {
			System.out.println("�ش� �ֹ��ڵ尡 �������� �ʽ��ϴ�");
		}//en else

		// �������
		mbh.closeHandler(ss);
		

		return cnt;

	}// updateOrderStatus
	
	//�����Ϸ�
	//�ֹ����°� ����Ȯ���� ��� ����Ȯ���� ������Ʈ(�ֹ��ڵ�)
	public int updateCompletionDate(String orID) {
		int cnt = 0;
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getHandler();
		
		cnt = ss.update("kr.co.mpnp.adminOrderMapper.updateCompletionDate",orID);
		
		if(cnt == 1) { //���� �� �ƴ�?
			ss.commit();
			System.out.println("����Ȯ������ �߰��Ǿ����ϴ�.");
			
		}else {
			System.out.println("����Ȯ�� ����� �ƴմϴ�. ");
		}//en else

		// �������
		mbh.closeHandler(ss);
		
		return cnt;
		
	}//
	
	//�����Ϸ�
	//����Ȯ���� �ֹ��ڵ�� �ֹ��󼼿��� �ֹ��ı⸦ 'N''�� �ٲ�
	public int updateReviewChk() {
		int cnt=0;
		
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getHandler();
		
		cnt = ss.update("kr.co.mpnp.adminOrderMapper.updateReviewChk");
		
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
////		String id = "or_0000037";
//		AdminOrderDAO aod = new AdminOrderDAO();
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
