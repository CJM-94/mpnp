package kr.co.mpnp.admin.service;

import java.util.List;

import kr.co.mpnp.admin.dao.AdminOrderDAO;
import kr.co.mpnp.admin.domain.AdminOrderDomain;
import kr.co.mpnp.admin.domain.AdminOrderPrdDomain;
import kr.co.mpnp.admin.vo.AdminOrderVO;

public class AdminOrderService {
	
	public AdminOrderService() {
		
	}
	
	// �ֹ���ȸ ����
	public List<AdminOrderDomain> searchOrderList(AdminOrderVO aoVO) {
		List<AdminOrderDomain> list = null;

		AdminOrderDAO roDAO = AdminOrderDAO.getInstance();
		list =roDAO.selectOrderList(aoVO);

		return list;
	}// searchOrderList
	
	//�ӽ� ������
	public int searchDiscountRate(String id) {
		int discount = 0;
		
		AdminOrderDAO roDAO = AdminOrderDAO.getInstance();
		discount = roDAO.selectDiscountRate(id);
		
		return discount;
	}//

	// �ش��ֹ��ڵ� ��ǰ(�ֹ��ڵ�)
	public List<AdminOrderPrdDomain> searchOrderPrdDetail(String orID) {
		List<AdminOrderPrdDomain> list = null;
		
		AdminOrderDAO roDAO = AdminOrderDAO.getInstance();
		list = roDAO.selectOrderPrdDetail(orID);
	
		return list;
	}// searchOrderDetail

	// �ֹ���(�ֹ��ڵ�)
	public AdminOrderDomain searchOrderDetail(String orID) {
		AdminOrderDomain aoDom = null;
		
		AdminOrderDAO roDAO = AdminOrderDAO.getInstance();
		aoDom = roDAO.selectOrderDetail(orID);

		return aoDom;
	}// selectOrderDetailr
	
	//�ֹ��� �����
	public AdminOrderDomain searchOrderShip(String orID) {
        AdminOrderDomain aoDom = null;
		
		AdminOrderDAO roDAO = AdminOrderDAO.getInstance();
		aoDom = roDAO.selectOrderShip(orID);
		
		return aoDom;
	}

	// �ֹ����º���(Ʈ�����)
	public int modifyOrderStatus(AdminOrderVO aoVO) {
		int cnt = 0;
		
		AdminOrderDAO roDAO = AdminOrderDAO.getInstance();
		cnt = roDAO.updateOrderStatus(aoVO);

		return cnt;
	}// modifyOrderStatus
	
	//���� ��������
	public int searchPriceIndivisual(String orderId) {
		int price = 0;
		
		AdminOrderDAO roDAO = AdminOrderDAO.getInstance();
		price = roDAO.selectPriceIndivisual(orderId);
		
		return price;
		
	}//
	
	//����Ȯ���� ������Ʈ
	public int modifyCompletionDate(AdminOrderVO aoVO) {
		int cnt =0;
		
		AdminOrderDAO roDAO = AdminOrderDAO.getInstance();
		cnt = roDAO.updateCompletionDate(aoVO);
		
		return cnt;
	}//
	
	//����Ȯ���� �ֹ��ڵ� �ֹ��ı� ������Ʈ(Ʈ�����)
	public int modifyReviewChk(AdminOrderVO aoVO) {
		int cnt =0;
		
		AdminOrderDAO roDAO = AdminOrderDAO.getInstance();
		cnt =roDAO.updateReviewChk(aoVO);
		
		return cnt;
	}

}// class
