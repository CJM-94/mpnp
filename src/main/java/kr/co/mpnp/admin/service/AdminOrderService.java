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

		//AdminOrderDAO roDAO = AdminOrderDAO.getInstance();
		// list =roDAO.selectOrderList();

		return list;
	}// searchOrderList

	// �ش��ֹ��ڵ� ��ǰ(�ֹ��ڵ�)
	public List<AdminOrderPrdDomain> searchOrderPrdDetail(String orID) {
		List<AdminOrderPrdDomain> list = null;
		
		

		return list;
	}// searchOrderDetail

	// �ֹ���(�ֹ��ڵ�)
	public AdminOrderDomain searchOrderDetail(String orID) {
		AdminOrderDomain aoDom = null;
		
		AdminOrderDAO roDAO = AdminOrderDAO.getInstance();
	//	aoDom= roDAO.selectOrderDetail(orID);

		return aoDom;
	}// selectOrderDetail

	// �ֹ����º���
	public int modifyOrderStatus(AdminOrderVO aoVO) {
		int cnt = 0;

		return cnt;
	}// modifyOrderStatus

}// class
