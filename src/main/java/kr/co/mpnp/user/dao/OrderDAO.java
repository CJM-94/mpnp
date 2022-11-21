package kr.co.mpnp.user.dao;
import java.util.List;

//��ǰ�� �߰� ����
import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import kr.co.mpnp.handler.MyBatisHandler;
import kr.co.mpnp.user.domain.MyOrderDomain;
import kr.co.mpnp.user.domain.OrderDomain;
import kr.co.mpnp.user.domain.OrderShipDomain;
import kr.co.mpnp.user.vo.MyOrderVO;
import kr.co.mpnp.user.vo.OrderPrdVO;
import kr.co.mpnp.user.vo.OrderVO;
import kr.co.mpnp.user.vo.ShipNameVO;

//���� [��� ���� �Ϸ�]
public class OrderDAO {
	private static OrderDAO orDAO;

	// �̱���
	private OrderDAO() {

	}// OrderDAO

	public static OrderDAO getInstance() {
		if (orDAO == null) {
			orDAO = new OrderDAO();
		}

		return orDAO;
	}// getInstance()

	// �����Ϸ�
 //�⺻����� ���� ��ȸ (������ ��ȸ ����
	public String selectOrderChk(OrderVO oVO) {
		String flag = "";

		// �ڵ鷯 ���
		// MyBatisHandler���
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getHandler();
	

		try {
			// ���� ����
			flag = ss.selectOne("kr.co.mpnp.orderMapper.selectOrderChk", oVO);
			System.out.println(flag + "/n");
		} catch (PersistenceException pe) {
			pe.printStackTrace();
		}

		// �������
		mbh.closeHandler(ss);

		return flag;
	}// selectOrderChk(
	
	//�����Ϸ�
	//�⺻������� �ִ� ���, �ش� ���̵��� ����� ��Ī ��ȸ
	public List<String> selectShipName(String id){
		List<String> list = null;
		
		// �ڵ鷯 ���
		// MyBatisHandler���
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getHandler();
	

		try {
			// ���� ����
			 list = ss.selectList("kr.co.mpnp.orderMapper.selectShipName", id);
			System.out.println( list + "/n");
		} catch (PersistenceException pe) {
			pe.printStackTrace();
		}

		// �������
		mbh.closeHandler(ss);
		
		
		
		return list;
		
	} 
	

	// �����Ϸ�
	// ����������ư - �����vo,�����dao ��� �ҵ�
	public OrderDomain selectChangeDestination(ShipNameVO snVO) {
		OrderDomain orDOM = null;

		// �ڵ鷯 ���
		// MyBatisHandler���
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getHandler();

		try {
			// ���� ����
			System.out.println("------"+snVO);
			orDOM = ss.selectOne("kr.co.mpnp.orderMapper.selectChangeDestination", snVO);
			System.out.println("===="+orDOM);
		} catch (PersistenceException pe) { 
			pe.printStackTrace();
		}

		// �������
		mbh.closeHandler(ss);

		return orDOM;
	}

	// �����Ϸ�
	// �ֹ��⺻������ȸ
	public OrderDomain selectOrderInfo(String id) {
		OrderDomain orDom = null;

		// �ڵ鷯 ���
		// MyBatisHandler���
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getHandler();
		try {
			// ���� ����
			orDom = ss.selectOne("kr.co.mpnp.orderMapper.selectOrderInfo", id);
			System.out.println(orDom);
		} catch (PersistenceException pe) {
			pe.printStackTrace();
		}
		// �������
		mbh.closeHandler(ss);

		return orDom;
	}// selectOrderInfo
	
	//�⺻����� ��ȸ
	public OrderShipDomain selectDestination(OrderVO oVO) {
		OrderShipDomain orDom = null;

		// �ڵ鷯 ���
		// MyBatisHandler���
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getHandler();
		try {
			// ���� ����
			orDom = ss.selectOne("kr.co.mpnp.orderMapper.selectDestination",  oVO);
			System.out.println(orDom);
		} catch (PersistenceException pe) {
			pe.printStackTrace();
		}
		// �������
		mbh.closeHandler(ss);

		return orDom;
	}
	
	//�ش� ��ǰ�ڵ��� ��ǰ ��ȸ
	public OrderPrdVO selectProduct(String prdId){ 
			OrderPrdVO opVO = null;
	
	MyBatisHandler mbh = MyBatisHandler.getInstance();
	SqlSession ss = mbh.getHandler();
	try {
		// ���� ����
		opVO = ss.selectOne("kr.co.mpnp.orderMapper.selectProduct", prdId);
		//System.out.println(orDom);
	} catch (PersistenceException pe) {
		pe.printStackTrace();
	}
	// �������
	mbh.closeHandler(ss);
	
			return opVO;

 }//
	
	// �����Ϸ�
	// �ֹ��ڵ���ȸ
	public String selectOrderId() {
		String orID = "";

		// �ڵ鷯 ���
		// MyBatisHandler���
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getHandler();
		try {
			// ���� ����
			orID = ss.selectOne("kr.co.mpnp.orderMapper.selectOrderId");
			// System.out.println(orID);
		} catch (PersistenceException pe) {
			pe.printStackTrace();
		}
		// �������
		mbh.closeHandler(ss);

		return orID;
	}// selectOrderId

	// �����Ϸ�
	// �ֹ����������߰�
	public int insertOrderInfo(OrderVO orVO) {
		int cnt = 0;
		// �ڵ鷯 ���
		// MyBatisHandler���
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getHandler();
		try {
			// ���� ����
			cnt = ss.insert("kr.co.mpnp.orderMapper.insertOrderInfo", orVO);
			if (cnt == 1) {
				ss.commit();
				System.out.println(cnt + "�� �߰�(�ֹ�)");
			}
		} catch (PersistenceException pe) {
			pe.printStackTrace();
		}
		// �������
		mbh.closeHandler(ss);

		return cnt;

	}

	

	//
	// � ������ �������� �ѹ���,�װ͵� �ڵ�ȭ�ؼ��߰����Ѿ��ϴ����� �𸣰ڴ�
	// ��ǰ������ŭ �ݺ��� ������.. �� �ȿ��� ���ڵ� ��ȸ �� insert�۾� �����ϸ� �Ǵ°ǰ�?
	// �ֹ����߰�-- mypageOrderVO��뿹��
	//�����Ϸ�
	public int insertOrderDetail(OrderVO oVO) {
		int cnt = 0;

		// �ڵ鷯 ���
		// MyBatisHandler���
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getHandler();
		try {
			// ���� ����
			cnt = ss.insert("kr.co.mpnp.orderMapper.insertOrderDetail", oVO);
			if (cnt == 1) {
				System.out.println(cnt + "�� �߰�(�ֹ���)");
				ss.commit();
			}
			;
		} catch (PersistenceException pe) {
			pe.printStackTrace();
		}
		// �������
		mbh.closeHandler(ss);

		return cnt;
	} // insertOrderDetail

	// �����Ϸ�


	// �����Ϸ�
	// ������߰�-destinatioVO��뿹��
	public int insertShipAddr(OrderVO dVO) {
		int cnt = 0;

		// �ڵ鷯 ���
		// MyBatisHandler���
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getHandler();
		try {
			// ���� ����
			cnt = ss.insert("kr.co.mpnp.orderMapper.insertShipAddr", dVO);
			cnt++;
			if (cnt == 1) {
				System.out.println(cnt + "�� �߰�(�����)");
				ss.commit();
			}
		} catch (PersistenceException pe) {
			pe.printStackTrace();
		}
		// �������
		mbh.closeHandler(ss);

		return cnt;

	}// insertShipAddr

	// �����Ϸ�
	// �ֹ��Ϸ᳻����ȸ
	public MyOrderDomain selectOrderComplete(OrderVO orVO) {
		MyOrderDomain orDom = null;

		// �ڵ鷯 ���
		// MyBatisHandler���
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getHandler();
		try {
			// ���� ����
			orDom = ss.selectOne("kr.co.mpnp.orderMapper.selectOrderComplete", orVO);
			System.out.println(orDom);
		} catch (PersistenceException pe) {
			pe.printStackTrace();
		}
		// �������
		mbh.closeHandler(ss);

		return orDom;
	}// selectOrderComplete
	
	

	// �����Ϸ�
	// �ֹ��� ��ٱ��Ͽ��� �ش��ǰ���� - ��ǰ�ڵ�- cartVO, cartDomiain��� ��
	public int deleteCartItem() {
		int cnt = 0;

		// �ڵ鷯 ���
		// MyBatisHandler���
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getHandler();
		try {
			// ���� ����
			cnt = ss.delete("kr.co.mpnp.orderMapper.deleteCartItem");
			if (cnt == 1) {
				System.out.println(cnt + "�� ����");
				ss.commit();
			} else {
				System.out.println("��������");
			}
		} catch (PersistenceException pe) {
			pe.printStackTrace();
		}
		// �������
		mbh.closeHandler(ss);

		return cnt;
	}// deleteCartItem

	public static void main(String[] args) {
	//	OrderDAO oD = OrdSerDAO.getInstance();
		//OrderVO ov = new OrderVO();
		//oD.selectShipName("id002");
		//ov.setId("id002");
		//ov.setDefaultFlag("O");
		//oD.selectOrderChk(ov);
	//	oD.selectOrderChk("id010");
//		 DestinationVO d = new DestinationVO();
//		 d.setId("id008");
//		 d.setName("��");

		// String dId = oD.selectdestinationId();
//		 String ord = oD.selectOrderId();
//		 OrderVO ov = new OrderVO();
//        ov.setOrderId(ord);
//        ov.setId("id010");
//        ov.setShipReq("11-16�׽�Ʈ");
//       ov.setActualPrice(90000);
//		 ov.setStatus("�ֹ��Ϸ�");
//		oD.insertOrderInfo(ov);
//		// oD.selectChangeDestination(d);
//		// oD.selectOrderChk("id002");
//		// oD.selectOrerDetailId();
		
//		 MyOrderVO mov = new MyOrderVO();
//		String[] prdArr = {"p0004","p0001"};
//		int[] prdcnt = {1,2};
//		   mov.setOrderId(ord);
//		for(int i=0;i<prdArr.length;i++) {
//			String odid = oD.selectOrerDetailId();
//			mov.setOrderDetailId(odid);
//			 mov.setTotalPrdCnt(prdcnt[i]);
//			 mov.setPrdtId(prdArr[i]);
//			 oD.insertOrderDetail(mov);
//		}
		
//		 mov.setOrderDetailId(odid);
//		 mov.setTotalPrdCnt(2);
//		 mov.setOrderId(ord);
//		 mov.setPrdtId("p0001");

		// oD.selectdestinationId();
//		 DestinationVO d = new DestinationVO();
//		 //d.setDestinationId(dId);
//		 d.setId("id002");
//		 d.setName("�б�");
//		 d.setReceiver("�׽�Ʈ");
//		 d.setPhone("010-1111-1111");
//		 d.setZipcode("12345");
//		 d.setAddr("���� �׽�Ʈ��");
//		 d.setAddrDetail("�׽�Ʈ����");
//		 d.setDeafaultFlag("X");
		// oD.insertShipAddr(d);

		// OrderVO o2 = new OrderVO();
		// o2.setOrderId("or_0000004");
		// o2.setProductId("p0002");
		// oD.selectOrderComplete(o2);
		// oD.deleteCartItem();

	}

}// class
