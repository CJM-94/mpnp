package kr.co.mpnp.user.dao;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import kr.co.mpnp.handler.MyBatisHandler;
import kr.co.mpnp.user.domain.MyOrderDomain;
//����
//��� ���� ���� �Ϸ�
public class MyOrderDAO {
	private static MyOrderDAO moDAO;

	// �̱���
	private MyOrderDAO() {

	}// AdminOrderDAO

	public static MyOrderDAO getInstance() {
		if (moDAO == null) {
			moDAO = new MyOrderDAO();
		}

		return moDAO;
	}// getInstance()

	//����
	// �Ⱓ�� �ֹ�������ȸ
	//��翡���� ���� �� �����µ� �� ����� �κ������� �������� �𸣰ڴ�
	public List<MyOrderDomain> selectOrderAList(String orID) {
		List<MyOrderDomain> list = null;
		
		// MyBatisHandler���
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getHandler();
	

		try {
			// ���� ����
			list = ss.selectList("kr.co.mpnp.myOrderMapper.selectOrderAllList", orID);
			System.out.println(list);
		} catch (PersistenceException pe) {
			pe.printStackTrace();
		}

		// �������
		mbh.closeHandler(ss);


		return list;
	}// selectOrderList

	//�����Ϸ�
	// �ֹ������� ����ȸ(�ֹ��ڵ�)
	public MyOrderDomain selectOrderDetail(String ordId) {
		MyOrderDomain moDom = null;
		
		// �ڵ鷯 ���
		// MyBatisHandler���
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getHandler();
		
		//���� ����
		moDom = ss.selectOne("kr.co.mpnp.myOrderMapper.selectOrderDetail", ordId);
		System.out.println(moDom);
		// �������
		mbh.closeHandler(ss);
		

		return moDom;
	}// selectOrderDetail
	
	//�� ��ǰ��
	public  List<MyOrderDomain> selectOrderPrdDetail(String orId) {
		List<MyOrderDomain> list = null;
		
		// �ڵ鷯 ���
		// MyBatisHandler���
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getHandler();
		
		//���� ����
		list = ss.selectList("kr.co.mpnp.myOrderMapper.selectOrderPrdDetail", orId);
		System.out.println(list);
		// �������
		mbh.closeHandler(ss);
		

		return list;
	}// selectOrderDetail
	
	//�ֹ��󼼹����
	public  MyOrderDomain selectOrderShip(String orId) {
		MyOrderDomain orDom = null;
		
		// �ڵ鷯 ���
		// MyBatisHandler���
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getHandler();
		
		//���� ����
		orDom = ss.selectOne("kr.co.mpnp.myOrderMapper.selectOrderShip", orId);
		System.out.println(orDom);
		// �������
		mbh.closeHandler(ss);
		

		return orDom;
	}// selectOrderDetail
	
	
	//������ ����
	public int selectDiscountRate(String id) {
		int dRate =0;
		
		// �ڵ鷯 ���
				// MyBatisHandler���
				MyBatisHandler mbh = MyBatisHandler.getInstance();
				SqlSession ss = mbh.getHandler();
				
				//���� ����
				dRate= ss.selectOne("kr.co.mpnp.myOrderMapper.selectDiscountRate", id);
				System.out.println(dRate);
				// �������
				mbh.closeHandler(ss);
				
				return dRate;
		
	}
	
	
	///�����Ϸ�
	// �Ⱓ �� �ֹ����� ��ȸ - count(��¥, �ֹ�����)
	//--�ش� �ֹ��ڵ��� �� �ֹ�����... (�𸣰ڴ�..)
	//�ϴ� ���⼭�� count�ϴ°� ���� �ȵǰ�, �ֹ����¸� ��ȸ��
	//�׸��� java����  �� �ֹ������� ������ŭ �ݺ����� ������ countģ ���� ��¤���
	public List<String> selectOrderStatusCnt(String id) {
		List<String> orderStatus = null;
	    
	 // MyBatisHandler���
	 		MyBatisHandler mbh = MyBatisHandler.getInstance();
	 		SqlSession ss = mbh.getHandler();
	 	

	 		try {
	 			// ���� ����
	 			orderStatus= ss.selectList("kr.co.mpnp.myOrderMapper.selectOrderStatusCnt", id);
	 			System.out.println(orderStatus);
	 		} catch (PersistenceException pe) {
	 			pe.printStackTrace();
	 		}

	 		// �������
	 		mbh.closeHandler(ss);
	    
	    

		return orderStatus;

	} // selectOrderStatusCnt
	
	//�����Ϸ�
	//////////////////////////���ݰ����� ���� ����
	public int selectPriceIndivisual(String orId) {
		int price = 0;
		
		// MyBatisHandler���
 		MyBatisHandler mbh = MyBatisHandler.getInstance();
 		SqlSession ss = mbh.getHandler();
 	

 		try {
 			// ���� ����
 			price= ss.selectOne("kr.co.mpnp.myOrderMapper.selectPriceIndivisual", orId);
 			System.out.println(price);
 		} catch (PersistenceException pe) {
 			pe.printStackTrace();
 		}

 		// �������
 		mbh.closeHandler(ss);
		
		return price;
	}//selectPriceIndivisual
	
	//�����Ϸ�
	/////////�ش� �ֹ��ڵ��� �ֹ���ü ������ȸ(�ֹ��ڵ�)
	public int selectPriceTotal(String orID) {
		int totalPrice=0;
		
		// MyBatisHandler���
		 		MyBatisHandler mbh = MyBatisHandler.getInstance();
		 		SqlSession ss = mbh.getHandler();

		 		try {
		 			// ���� ����
		 			totalPrice= ss.selectOne("kr.co.mpnp.myOrderMapper.selectPriceTotal", orID);
		 			System.out.println(totalPrice);
		 		} catch (PersistenceException pe) {
		 			pe.printStackTrace();
		 		}

		 		// �������
		 		mbh.closeHandler(ss);
		return totalPrice;
		
	}
	
	////////////�ֹ���� ������
	//�����Ϸ�
	//1) �ֹ� ���� ���-�ֹ����ڵ� (cascade������ ����- �ֹ��� ~������� (�ֹ����ڵ�)
	public int deleteCancelIndivisual(String orDId) {
		int cnt = 0;
		
		// MyBatisHandler���
 		MyBatisHandler mbh = MyBatisHandler.getInstance();
 		SqlSession ss = mbh.getHandler();

 		try {
 			// ���� ����
 			 cnt= ss.delete("kr.co.mpnp.myOrderMapper.deleteCancelIndivisual", orDId);
 			if(cnt==1) {
 			 System.out.println(cnt + "�� ����(����)");
 			ss.commit();
 			}else {
 				System.out.println("���� ����(����)");
 			}
 		} catch (PersistenceException pe) {
 			pe.printStackTrace();
 		}

 		// �������
 		mbh.closeHandler(ss);
		
		return cnt;
	}
	
	//�����Ϸ�
	//2) �ֹ���ü��� �ֹ��ڵ�) -  ((cascade������ ����- �ֹ����̺� ~ ������� ������) -->
	public int deleteCancelTotal(String orId) {
		int cnt = 0;;
		
		// MyBatisHandler���
 		MyBatisHandler mbh = MyBatisHandler.getInstance();
 		SqlSession ss = mbh.getHandler();

 		try {
 			// ���� ����
 			 cnt= ss.delete("kr.co.mpnp.myOrderMapper.deleteCancelTotal", orId);
 			if(cnt==1) {
 			 System.out.println(cnt + "�� ����(��ü �ֹ�)");
 			 ss.commit();
 			}else {
 				System.out.println("���� ����(��ü �ֹ�)");
 			}
 		} catch (PersistenceException pe) {
 			pe.printStackTrace();
 		}

 		// �������
 		mbh.closeHandler(ss);
		return cnt;
		
	} 
	

	//�����Ϸ�
	/////////// ����¡
	// ��ü �Խù� �� ��ȸ
	public int selectTotalPageCount() {
		int totalCnt = 0;
		
		 // MyBatisHandler���
 		MyBatisHandler mbh = MyBatisHandler.getInstance();
 		SqlSession ss = mbh.getHandler();
 	

 		try {
 			// ���� ����
 			totalCnt = ss.selectOne("kr.co.mpnp.myOrderMapper.selectTotalPageCount");
 			System.out.println(totalCnt);
 		} catch (PersistenceException pe) {
 			pe.printStackTrace();
 		}

 		// �������
 		mbh.closeHandler(ss);

		return totalCnt;
	}// selectTotalCount
	
	 public static void main(String[] args) {
 MyOrderDAO od = MyOrderDAO.getInstance();
//  od.selectOrderAList("id010");
//  od.selectOrderDetail("or_0000045");
  
//	//moDAO.deleteCancelIndivisual("od_0000005");
//	 // moDAO.deleteCancelTotal("or_0000039");
////	  MyOrderVO m = new MyOrderVO();
////	  m.setFindStartDate("2022-11-01");
////	  m.setFindEndDate("2022-11-15");
////	  m.setId("id001");
////	  moDAO.selectOrderStatusCnt(m);
// // moDAO.selectPriceIndivisual("od_0000005");
////	  moDAO.selectPriceTotal("or_0000004");
	
 od.selectDiscountRate("id001");
	  
	 }//main
}// class
