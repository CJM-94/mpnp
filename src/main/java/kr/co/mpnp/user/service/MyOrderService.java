package kr.co.mpnp.user.service;

import java.sql.SQLException;
import java.util.List;

import org.json.simple.JSONArray;
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
	public List<MyOrderDomain> searchOrderList(MyOrderVO mvo) {
		List<MyOrderDomain> list = null;
		
		MyOrderDAO oDAO =MyOrderDAO.getInstance();
		list = oDAO.selectOrderAList(mvo);

		return list;
	}// searchOrderList
	
	//�Ⱓ�� ���� ��¥ �Ⱓ ��ȸ
	public String searchDate(MyOrderVO mvo) {
		//����
		JSONObject jsonOrder = new JSONObject();
		boolean resultFalg = false;
		MyOrderDAO mDAO = MyOrderDAO.getInstance();
		List<MyOrderDomain> list = mDAO.selectOrderAList(mvo);
		//����
		JSONObject jsonTemp = null;
		//�θ�
		JSONArray jsonArr = new JSONArray();
		
		for(MyOrderDomain mod : list) {
			jsonTemp = new JSONObject();
			//db��ȸ����� jsonObject�� �Ҵ�
			jsonTemp.put("orderId",mod.getOrderId());
			jsonTemp.put("inputDateS",mod.getInputDateS());
			jsonTemp.put("status",mod.getStatus());
			jsonTemp.put("prdPrice",mod.getPrdPrice());
			jsonTemp.put("totalCnt",mod.getTotalCnt());
			jsonTemp.put("prdName",mod.getPrdName());
			jsonTemp.put("thImg",mod.getThImg());
			jsonTemp.put("orDetailId",mod.getOrDetailId());
			//����  ���� jsonObject�� array�� �Ҵ�
			jsonArr.add(jsonTemp);
			
		}//end for
		//��� ��ȸ����� ���� jsonArray�� jsonObject�� ����
		jsonOrder.put("orderDate", jsonArr);
		jsonOrder.put("resultFalg", !resultFalg);
		jsonOrder.put("findStartDate", mvo.getFindStartDate());		
		jsonOrder.put("findEndDate", mvo.getFindEndDate());		
		jsonOrder.put("findMemberID", mvo.getId());		
	
		return jsonOrder.toJSONString();
		
	}// searchDate

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
		
		
		
		return discountRate;
		
	}
	
	
	

	//////////////////////////////////////////////// ����¡////////////////////////////
	// ��ü �Խù���(�� adminProductVO?)
	public int totalCount(MyOrderVO moVO) {
		int totalCnt =oDAO.selectTotalPageCount(moVO);

		return totalCnt;
	}// totalCount
	
	//������ ������ ��
	public int lastPage(int totalCount) {
		int lastPage=(int)Math.ceil((double) totalCount /4);
		
		return lastPage;
	}
	
	//���������� ���۹�ȣ
	public int startNum(int curPage) {
		int startNum=curPage-(curPage-1)%3;
		return startNum;
		
	}
	//���������� ������ ��������
	public int isLast(int lastPage,int startNum) {
		int isLast =2; //0,1,2, 3��������
		if(startNum+3>lastPage) {
			isLast= lastPage-startNum;
			
		}
		return isLast;
		
	}
	

}// class
