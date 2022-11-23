package kr.co.mpnp.user.service;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;

import kr.co.mpnp.user.dao.OrderDAO;
import kr.co.mpnp.user.domain.MyOrderDomain;
import kr.co.mpnp.user.domain.OrderDomain;
import kr.co.mpnp.user.domain.OrderShipDomain;
import kr.co.mpnp.user.vo.OrderPrdVO;
import kr.co.mpnp.user.vo.OrderVO;
import kr.co.mpnp.user.vo.OrdersInfoVO;
import kr.co.mpnp.user.vo.ShipNameVO;

//����
public class OrderService {
	OrderDAO oDAO = OrderDAO.getInstance();

	// �������������(���̵�)
	public String searchOrderChk(String id) {
		String flag = "";

		flag = oDAO.selectOrderChk(id);

		return flag;
	}// selectOrderChk

	// �⺻������� �ִ� ���, �ش� ���̵��� ����� ��Ī ��ȸ
	public List<String> searchShipName(String id) {
		List<String> list = null;

		list = oDAO.selectShipName(id);

		return list;
	}


	//DB��ǰó��(��ٱ��Ͽ����� OK,��ǰ�������� X)
	public List<OrderPrdVO>searchProduct(OrdersInfoVO orders){
		List<OrderPrdVO> list = new ArrayList<OrderPrdVO>();
		//System.out.println("����@@@@@:"+ orders.getOrders()); //���� �־�
		OrderPrdVO opvo =null; // null�̴�..?
		//System.out.println(opvo.toString());
		for(OrderPrdVO oVO : orders.getOrders()) {
		//System.out.println("��ǰ���� ����:" +oVO.getPrdCnt());//�� ����
		//System.out.println("��ǰ�ڵ� ����:" +oVO.getPrdId());//�� ����
		opvo =	oDAO.selectProduct(oVO.getPrdId());
		opvo.setPrdCnt(oVO.getPrdCnt()); 
		System.out.println("########3"+ opvo.toString());
		//System.out.println("����@@@@"+ opvo.getPrdCnt());
		if(oVO.getCartId() != null || "".equals(oVO.getCartId())) {
		opvo.setCartId(oVO.getCartId()); 
		}
		opvo.initSaleTotal();
		 
		 list.add(opvo);
		}
		//System.out.println("����@@@@:" + opvo);
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

	//�ֹ� & �ֹ��� Ʈ����� ó��
	public void searchOrer( OrderVO oVO ) {
		String orId = "";

		orId = oDAO.selectOrderId();// �ֹ��ڵ� ��ȸ
		oVO.setOrderId(orId);  //vo�� �ڵ� ����
		if(oVO.getOrderId() != null) {
			oDAO.insertOrderInfo(oVO); //�ֹ����̺� �߰�& �ֹ������̺� �߰�
		}

	}// searchOrerDetailId
	
	
	// ������߰�-destinatioVO��뿹��
	public int addShipAddr(OrderVO dVO) {
		int cnt = 0;

		cnt = oDAO.insertShipAddr(dVO);

		return cnt;
	}// insertShipAddr
	
	//////////////////////////////////////////////////////////////////////////////////

	// �ֹ��Ϸ᳻����ȸ
	public MyOrderDomain searchOrderCompleteM(String orderID) {
		MyOrderDomain orDom = null;

		orDom = oDAO.selectOrderCompleteM(orderID);

		return orDom;
	}// selectOrderComplete
	
	// �ֹ��Ϸ᳻����ȸ(��ǰ)
	public List<MyOrderDomain>  searchOrderCompleteP(String orderID) {
		List<MyOrderDomain>  orDom = null;

		orDom = oDAO.selectOrderCompleteP(orderID);

		return orDom;
	}// selectOrderComplete
	
	
	// �ֹ��Ϸ᳻����ȸ(���)
	public MyOrderDomain searchOrderCompleteD(String orderID) {
		MyOrderDomain orDom = null;

		orDom = oDAO.selectOrderCompleteD(orderID);

		return orDom;
	}// selectOrderComplete
	
	////////////////////////////////////////////////////////////////////////////////

	// �ֹ��� ��ٱ��Ͽ��� �ش��ǰ���� - ��ǰ�ڵ�- cartVO, cartDomiain��� ��

	public int removeCartItem(OrderVO orVO) {
		int cnt = 0;

		cnt = oDAO.deleteCartItem();

		return cnt;
	}// deleteCartItem

}
