package kr.co.mpnp.user.service;

import java.util.List;

import kr.co.mpnp.user.dao.OrderDAO;
import kr.co.mpnp.user.domain.MyOrderDomain;
import kr.co.mpnp.user.domain.OrderDomain;
import kr.co.mpnp.user.vo.DestinationVO;
import kr.co.mpnp.user.vo.MyOrderVO;
import kr.co.mpnp.user.vo.OrderVO;

//����
public class OrderService {
	OrderDAO oDAO = OrderDAO.getInstance();
	// �������������(���̵�)
	public String searchOrderChk(OrderVO oVO) {
		String flag = "";
		
		flag =oDAO.selectOrderChk(oVO);

		return flag;
	}// selectOrderChk
	
	//�⺻������� �ִ� ���, �ش� ���̵��� ����� ��Ī ��ȸ
	public List<String>searchShipName(String id){
		List<String> list = null;
		
		list = oDAO.selectShipName(id);
		
		return list;
	}
	

	//����������ư - �����vo,�����dao ��� �ҵ�
	public   OrderDomain seachChangeDestination(DestinationVO dVO) {
		OrderDomain orDOM = null;
		
		orDOM = oDAO.selectChangeDestination(dVO);
		
		return orDOM;
	}

	// �ֹ��⺻������ȸ
	public OrderDomain searchOrderInfo(String id) {
		OrderDomain orDom = null;
		
		orDom = oDAO.selectOrderInfo(id);

		return orDom;
	}// selectOrderInfo(
	
	//�⺻����� ��ȸ
	public OrderDomain  searchDestination(OrderVO oVO) {
		OrderDomain orDom = null;
		
		orDom = oDAO.selectDestination(oVO);
		
		return orDom;
				
	}

	// �ֹ��ڵ���ȸ
	public String searchOrderId() {
		String orID = "";
		
		orID = oDAO.selectOrderId();

		return orID;
	}// selectOrderId

	// �ֹ����������߰�
	public int addOrderInfo(OrderVO orVO) {
		int cnt = 0;
		
		cnt = oDAO.insertOrderInfo(orVO);
		
		return cnt;
	}// insertOrderInfo

	// �ֹ����ڵ���ȸ
	public String searchOrerDetailId() {
		String ordId = "";
		
		ordId = oDAO.selectOrerDetailId();

		return ordId;
	}// searchOrerDetailId

	// �ֹ����߰�-- mypageOrderVO��뿹��
	public int addOrderDetail(MyOrderVO moVO) {
		int cnt = 0;
		
		cnt = oDAO.insertOrderDetail(moVO);

		return cnt;
	} // insertOrderDetail
	
	//����� �ڵ� ��ȸ
	public String searchDestinationId() {
		String dId = "";
		
		dId = oDAO.selectdestinationId();
		
		return dId;
	}

	//������߰�-destinatioVO��뿹��
	public  int insertShipAddr(DestinationVO dVO) {
		int cnt = 0;
		
		cnt = oDAO.insertShipAddr(dVO);
		
		return cnt;
	}//insertShipAddr

	// �ֹ��Ϸ᳻����ȸ
	public MyOrderDomain searchOrderComplete(OrderVO orVO) {
		MyOrderDomain orDom = null;
		
		orDom = oDAO.selectOrderComplete(orVO);

		return orDom;
	}// selectOrderComplete

	// �ֹ��� ��ٱ��Ͽ��� �ش��ǰ���� - ��ǰ�ڵ�- cartVO, cartDomiain��� ��

	public int removeCartItem(OrderVO orVO) {
		int cnt = 0;
		
		cnt = oDAO.deleteCartItem();

		return cnt;
	}// deleteCartItem

}
