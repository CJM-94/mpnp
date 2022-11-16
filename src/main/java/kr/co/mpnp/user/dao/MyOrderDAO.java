package kr.co.mpnp.user.dao;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import kr.co.mpnp.handler.MyBatisHandler;
import kr.co.mpnp.user.domain.MyOrderDomain;
import kr.co.mpnp.user.vo.MyOrderVO;
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
	public List<MyOrderDomain> selectOrderAList(MyOrderVO moVO) {
		List<MyOrderDomain> list = null;
		
		// MyBatisHandler���
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getHandler();
	

		try {
			// ���� ����
			list = ss.selectList("kr.co.nyangpoom.myOrderMapper.selectOrderAList", moVO);
			System.out.println(list);
		} catch (PersistenceException pe) {
			pe.printStackTrace();
		}

		// �������
		mbh.closeHandler(ss);


		return list;
	}// selectOrderList

	//�����Ϸ�
	// �ֹ������� ����ȸ(���̵�, �ֹ��ڵ�)
	public MyOrderDomain selectOrderDetail(String ordId) {
		MyOrderDomain moDom = null;
		
		// �ڵ鷯 ���
		// MyBatisHandler���
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getHandler();
		
		//���� ����
		moDom = ss.selectOne("kr.co.nyangpoom.myOrderMapper.selectOrderDetail", ordId);
		System.out.println(moDom);
		// �������
		mbh.closeHandler(ss);
		

		return moDom;
	}// selectOrderDetail

	///�����Ϸ�
	// �Ⱓ �� �ֹ����� ��ȸ - count(��¥, �ֹ�����)
	//--�ش� �ֹ��ڵ��� �� �ֹ�����... (�𸣰ڴ�..)
	//�ϴ� ���⼭�� count�ϴ°� ���� �ȵǰ�, �ֹ����¸� ��ȸ��
	//�׸��� java����  �� �ֹ������� ������ŭ �ݺ����� ������ countģ ���� ��¤���
	public List<String> selectOrderStatusCnt(MyOrderVO moVO) {
		List<String> orderStatus = null;
	    
	 // MyBatisHandler���
	 		MyBatisHandler mbh = MyBatisHandler.getInstance();
	 		SqlSession ss = mbh.getHandler();
	 	

	 		try {
	 			// ���� ����
	 			orderStatus= ss.selectList("kr.co.nyangpoom.myOrderMapper.selectOrderStatusCnt", moVO);
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
	public int selectPriceIndivisual(String ordId) {
		int price = 0;
		
		// MyBatisHandler���
 		MyBatisHandler mbh = MyBatisHandler.getInstance();
 		SqlSession ss = mbh.getHandler();
 	

 		try {
 			// ���� ����
 			price= ss.selectOne("kr.co.nyangpoom.myOrderMapper.selectPriceIndivisual", ordId);
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
		 			totalPrice= ss.selectOne("kr.co.nyangpoom.myOrderMapper.selectPriceTotal", orID);
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
	//1) �ֹ� ���� ��� (cascade������ ����- �ֹ��� ~������� (�ֹ����ڵ�)
	public int deleteCancelIndivisual(String ordId) {
		int cnt = 0;
		
		// MyBatisHandler���
 		MyBatisHandler mbh = MyBatisHandler.getInstance();
 		SqlSession ss = mbh.getHandler();

 		try {
 			// ���� ����
 			 cnt= ss.delete("kr.co.nyangpoom.myOrderMapper.deleteCancelIndivisual", ordId);
 			if(cnt==1) {
 			 System.out.println(cnt + "�� ����");
 			ss.commit();
 			}else {
 				System.out.println("���� ����");
 			}
 		} catch (PersistenceException pe) {
 			pe.printStackTrace();
 		}

 		// �������
 		mbh.closeHandler(ss);
		
		return cnt;
	}
	
	//�����Ϸ�
	//2) �ֹ���ü��� (�ֹ��ڵ�) -  ((cascade������ ����- �ֹ����̺� ~ ������� ������) -->
	public int deleteCancelTotal(String orID) {
		int cnt = 0;;
		
		// MyBatisHandler���
 		MyBatisHandler mbh = MyBatisHandler.getInstance();
 		SqlSession ss = mbh.getHandler();

 		try {
 			// ���� ����
 			 cnt= ss.delete("kr.co.nyangpoom.myOrderMapper.deleteCancelTotal", orID);
 			if(cnt==1) {
 			 System.out.println(cnt + "�� ����");
 			 ss.commit();
 			}else {
 				System.out.println("���� ����");
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
 			totalCnt = ss.selectOne("kr.co.nyangpoom.myOrderMapper.selectTotalPageCount");
 			System.out.println(totalCnt);
 		} catch (PersistenceException pe) {
 			pe.printStackTrace();
 		}

 		// �������
 		mbh.closeHandler(ss);

		return totalCnt;
	}// selectTotalCount
	
//	 public static void main(String[] args) {
//	  MyOrderDAO moDAO = MyOrderDAO.getInstance();
//	//moDAO.deleteCancelIndivisual("od_0000005");
//	 // moDAO.deleteCancelTotal("or_0000039");
////	  MyOrderVO m = new MyOrderVO();
////	  m.setFindStartDate("2022-11-01");
////	  m.setFindEndDate("2022-11-15");
////	  m.setId("id001");
////	  moDAO.selectOrderStatusCnt(m);
// // moDAO.selectPriceIndivisual("od_0000005");
////	  moDAO.selectPriceTotal("or_0000004");

	  
	// }//main
}// class
