package kr.co.mpnp.user.service;

import java.sql.SQLException;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import kr.co.mpnp.user.dao.OrderDAO;
import kr.co.mpnp.user.domain.MyOrderDomain;
import kr.co.mpnp.user.domain.OrderDomain;
import kr.co.mpnp.user.domain.OrderShipDomain;
import kr.co.mpnp.user.vo.DestinationVO;
import kr.co.mpnp.user.vo.MyOrderVO;
import kr.co.mpnp.user.vo.OrderVO;
import kr.co.mpnp.user.vo.ShipNameVO;

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
	
//	//����������ư - �����vo,�����dao ��� �ҵ�
//		public   OrderDomain seachChangeDestination(DestinationVO dVO) {
//			OrderDomain orDOM = null;
//			
//			orDOM = oDAO.selectChangeDestination(dVO);
//			
//			return orDOM;
//		}
	
	

	//����������ư - �����vo,�����dao ��� �ҵ�
	public  String seachChangeDestination(ShipNameVO snVO) {
		//1.����
			JSONObject jsonShipName = new JSONObject();
		 
		boolean resultFlag = false;
		OrderDomain orD= oDAO.selectChangeDestination(snVO);
		resultFlag= orD!=null;
		//2.����
		jsonShipName.put("resultFlag", resultFlag);
		jsonShipName.put("searchKeyword", snVO.getId());
		jsonShipName.put("name", snVO.getName());
		jsonShipName.put("zipcode", orD.getZipcode());
		jsonShipName.put("addr", orD.getAddr());
		jsonShipName.put("addr_detail", orD.getAddrDetail());
		 
		return jsonShipName.toJSONString();
	}//
	public static void main(String[] a) {
		OrderService os =new OrderService();
		System.out.println(os.seachChangeDestination(new ShipNameVO("��","id008")) );
	}
		

	// �ֹ��⺻������ȸ
	public OrderDomain searchOrderInfo(String id) {
		OrderDomain orDom = null;
		
		orDom = oDAO.selectOrderInfo(id);

		return orDom;
	}// selectOrderInfo(
	
	//�⺻����� ��ȸ
	public OrderShipDomain  searchDestination(OrderVO oVO) {
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
