package kr.co.mpnp.user.service;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;

import kr.co.mpnp.user.dao.OrderDAO;
import kr.co.mpnp.user.domain.MyOrderDomain;
import kr.co.mpnp.user.domain.OrderDomain;
import kr.co.mpnp.user.domain.OrderShipDomain;
import kr.co.mpnp.user.vo.MyOrderVO;
import kr.co.mpnp.user.vo.OrderPrdVO;
import kr.co.mpnp.user.vo.OrderVO;
import kr.co.mpnp.user.vo.OrdersInfoVO;
import kr.co.mpnp.user.vo.ShipNameVO;

//����
public class OrderService {
	OrderDAO oDAO = OrderDAO.getInstance();

	// �������������(���̵�)
	public String searchOrderChk(OrderVO oVO) {
		String flag = "";

		flag = oDAO.selectOrderChk(oVO);

		return flag;
	}// selectOrderChk

	// �⺻������� �ִ� ���, �ش� ���̵��� ����� ��Ī ��ȸ
	public List<String> searchShipName(String id) {
		List<String> list = null;

		list = oDAO.selectShipName(id);

		return list;
	}


	//DB��ǰó��
	public List<OrderPrdVO>searchProduct(OrdersInfoVO orders){
		List<OrderPrdVO> list = new ArrayList<OrderPrdVO>();
		
		
		for(OrderPrdVO oVO : orders.getOrders()) {
		OrderPrdVO opvo =	oDAO.selectProduct(oVO.getPrdId());
		opvo.setPrdCnt(oVO.getPrdCnt()); 
		opvo.setCartId(oVO.getCartId()); 
		opvo.initSaleTotal();
		 
		 list.add(opvo);
		}
		return list;
	}


	// ����������ư - �����vo,�����dao ��� �ҵ�
	public String seachChangeDestination(ShipNameVO snVO) {
		// 1.����
		JSONObject jsonShipName = new JSONObject();

		boolean resultFlag = false;
		OrderDomain orD = oDAO.selectChangeDestination(snVO);
		resultFlag = orD != null;
		// 2.����
		jsonShipName.put("resultFlag", resultFlag);
		jsonShipName.put("searchKeyword", snVO.getId());
		jsonShipName.put("name", snVO.getName());
		jsonShipName.put("zipcode", orD.getZipcode());
		jsonShipName.put("addr", orD.getAddr());
		jsonShipName.put("addrDetail", orD.getAddrDetail());

		return jsonShipName.toJSONString();
	}//

	// �ֹ��⺻������ȸ
	public OrderDomain searchOrderInfo(String id) {
		OrderDomain orDom = null;

		orDom = oDAO.selectOrderInfo(id);

		return orDom;
	}// selectOrderInfo(

	// �⺻����� ��ȸ
	public OrderShipDomain searchDestination(OrderVO oVO) {
		OrderShipDomain orDom = null;

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

	//Ʈ����� ó��
	public void searchOrerDetailId(OrderVO oVO) {
		String orId = "";

		orId = oDAO.selectOrderId();// �ֹ��ڵ� ��ȸ
		oVO.setOrderId(orId);  //vo�� �ڵ� ����
		if(oVO.getOrderId() != null) {
			oDAO.insertOrderInfo(oVO); //�ֹ����̺� �߰�
			for(OrderPrdVO opVO :oVO.getOrders()) {
				oVO.setTotalPrdCnt(opVO.getPrdCnt());
				oVO.setPrdId(opVO.getPrdId());
				oVO.setOrderId(orId);
				
			oDAO.insertOrderDetail(oVO); //�ֹ� �����̺� �߰�
			}//end for
			oDAO.deleteCartItem(); //�ֹ��� �ش� ������ ��ٱ��Ͽ��� ����
			oDAO.insertShipAddr(oVO); // ����� �߰�
		}//end if
		
	}// searchOrerDetailId

	// �ֹ����߰�-- mypageOrderVO��뿹��
	public int addOrderDetail(OrderVO oVO) {
		int cnt = 0;

		cnt = oDAO.insertOrderDetail(oVO);

		return cnt;
	} // insertOrderDetail



	// ������߰�-destinatioVO��뿹��
	public int addShipAddr(OrderVO dVO) {
		int cnt = 0;

		cnt = oDAO.insertShipAddr(dVO);

		return cnt;
	}// insertShipAddr

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
