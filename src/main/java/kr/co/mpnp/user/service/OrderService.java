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
	public List<OrderPrdVO>searchProduct(List<OrderPrdVO> orders){
		List<OrderPrdVO> list = new ArrayList<OrderPrdVO>();
		
		OrderPrdVO opvo = new OrderPrdVO();
		for(OrderPrdVO oVO : orders) {
		opvo =	oDAO.selectProduct(oVO.getPrdId());
		 opvo.setPrdCnt(oVO.getPrdCnt()); 
		 opvo.setCartId(oVO.getCartId()); 
		 opvo.initSaleTotal();
		 
		 list.add(oVO);
		}
		return list;
	}

	
	 //��ǰ�Ѱܹ����� ó�� 
	 public List<OrderPrdVO> getPrdInfo(OrdersInfoVO orders){
	  List<OrderPrdVO> result = null;
	
	  OrderPrdVO oVO = new OrderPrdVO();
	 // OrderPrdVO oVO2 = new OrderPrdVO();
	  result = new ArrayList<OrderPrdVO>();
	  for(OrderPrdVO opVO : orders.getOrders()) {
		  oVO.setPrdId(opVO.getPrdId()); // DB�� where��
		  oVO.setPrdCnt(opVO.getPrdCnt()); //DB�ʹ� ������ �Ѿ���� ��
		  oVO.setCartId(opVO.getCartId());  // DB�ʹ� ������ �Ѿ���� ��

		  result.add(oVO);
	  }

	  return result;
  
	  }
	 //��ǰ ����, ��ٱ����ڵ��Ķ���� ���� ó��(�ȵż�..�Ф�)
	 public List<OrderPrdVO> getPrdInFoOther(List<OrderPrdVO> orders){
		  List<OrderPrdVO> result = null;
		  OrderPrdVO oVO = new OrderPrdVO();
		  
		  result = new ArrayList<OrderPrdVO>();
		  for(OrderPrdVO opVO : orders) {
			  oVO.setPrdCnt(opVO.getPrdCnt());
			  oVO.setCartId(opVO.getCartId());
			  oVO.setPrdPrice(opVO.getPrdPrice());
			  oVO.initSaleTotal();
			  oVO.getTotalProductPrice();

			  result.add(oVO);
		  }


		 return result;
		  
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
		jsonShipName.put("addr_detail", orD.getAddrDetail());

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

	// ����� �ڵ� ��ȸ
	public String searchDestinationId() {
		String dId = "";

		dId = oDAO.selectdestinationId();

		return dId;
	}

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
