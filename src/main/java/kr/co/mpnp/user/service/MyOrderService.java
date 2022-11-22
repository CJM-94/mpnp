package kr.co.mpnp.user.service;

import java.util.List;

import kr.co.mpnp.user.dao.MyOrderDAO;
import kr.co.mpnp.user.domain.MyOrderDomain;
import kr.co.mpnp.user.vo.MyOrderVO;
//����
public class MyOrderService {
	MyOrderDAO oDAO = MyOrderDAO.getInstance();
	public MyOrderService() {

	}//

	// �Ⱓ�� �ֹ�������ȸ
	public List<MyOrderDomain> searchOrderList(String id) {
		List<MyOrderDomain> list = null;
		
		MyOrderDAO oDAO =MyOrderDAO.getInstance();
		list = oDAO.selectOrderAList(id);

		return list;
	}// searchOrderList

	// �ֹ����� ����ȸ
	public MyOrderDomain searchOrderDetail(String orID) {
		MyOrderDomain moDom = null;
		
		moDom = oDAO.selectOrderDetail(orID);
		

		return moDom;
	}// searchOrderDetail
	
	//�ֹ���ǰ ��
	public List<MyOrderDomain> searchOrderPrdDetail(String orID){
		List<MyOrderDomain> list = null;
		
		list = oDAO.selectOrderPrdDetail(orID);
		
		return list;
	}
	
	//�ֹ������ ��
	public MyOrderDomain searchOrderShip(String orID) {
		MyOrderDomain moDom = null;
		
		moDom = oDAO.selectOrderShip(orID);
		
		return moDom;
	}// searchOrderDetail
	
	
	

	// �ֹ�������ȸ
	public int[] searchOrderStatusCnt(String id) {
		int[] cnt  = {0,0,0};
		
		List<String> list = null;
		String[] staArr = {"�ֹ��Ϸ�","��ۿϷ�","����Ȯ��"};
		
		
		//id= "id010";
		MyOrderDAO  oDAO =MyOrderDAO.getInstance();
		list = oDAO.selectOrderStatusCnt(id);
	
		
		for(String sta : list) {
			if(sta.equals(staArr[0])) {
				cnt[0]++;
			}else if(sta.equals(staArr[1])) {
				cnt[1]++;
			}else {
				cnt[2]++;
			}
		}//end for

		return cnt;
	}// searchOrderStatusCnt

	// �ֹ����(���̵�,�ֹ��ڵ�)
	public int modifyOrderProcess(String id, String orID) {
		int cnt = 0;

		return cnt;
	}// modifyOrderProcess

	//////////////////////////////////////////////// ����¡////////////////////////////
	// ��ü �Խù���(�� adminProductVO?)
	public int totalCount(MyOrderVO moVO) {
		int totalCnt = 0;

		return totalCnt;
	}// totalCount

	// �� ȭ�鿡 n���� ������ �� ������ ��(totalcount,pageCale)
	public int totalPage(MyOrderVO moVO) {
		int totalPage = 0;

		return totalPage;

	}// totalPage

	// ���۹�ȣ(����������(currentPage), ��ȭ�鿡 ������ ������ ��(pageScale))
	public int startNum(MyOrderVO moVO) {
		int startNum = 0;

		return startNum;
	} // startNum

	// ����ȣ(���۹�ȣ(startnum),��ȭ�鿡 ������ ��(pagescale)
	public int endNum(MyOrderVO moVO) {
		int endNum = 0;

		return endNum;

	}// endNum

}// class
