package kr.co.mpnp.user.service;

import java.util.List;

import org.json.simple.JSONObject;

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

	//�ֹ� �������
	public String removeCancelIndivisual(String orDId) {
	
		MyOrderDAO moD = MyOrderDAO.getInstance();
		
		JSONObject jsonObject = new JSONObject();
		boolean removeFlag =moD.deleteCancelIndivisual(orDId)==1?true:false;
		jsonObject.put("removeFlag", removeFlag);
		
		return jsonObject.toString();
	}//end 
	
	//�ֹ� ��ü���
	public String removeCancelTotal(String orDId) {
		
		MyOrderDAO moD = MyOrderDAO.getInstance();
		JSONObject jsonObject = new JSONObject();
	    boolean removeFlag = moD.deleteCancelTotal(orDId)==1?true:false;
	    jsonObject.put("removeFlag", removeFlag);
	    System.out.println("���̿�������@@@@:" +removeFlag);
		return jsonObject.toString();
	}//end 
	
	//��ǰ �Ѱ���
	
	//��ǰ �Ѱ���
	public int searchPriceIndivisual(String orId) {
		int price =0;
		
		MyOrderDAO moD = MyOrderDAO.getInstance();
		price= moD.selectPriceIndivisual(orId);
		
		return price; 
		
	}//
	
	//�� �����ݾ�
	public int selectPriceTotal(String orId) {
		int price =0;
		
		MyOrderDAO moD = MyOrderDAO.getInstance();
		int prdPrice = moD.selectPriceIndivisual(orId);
		int actualprice= moD.selectPriceTotal(orId);
		price =actualprice - prdPrice;
		
		return price; 
		
	}//
	
	//������ ���ϱ�
	public int selectDiscountRate(String id) {
		int discountRate =0;
		
		MyOrderDAO moD = MyOrderDAO.getInstance();
		discountRate = moD.selectDiscountRate(id);
		;
		
		
		return discountRate;
		
	}
	
	
	

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
