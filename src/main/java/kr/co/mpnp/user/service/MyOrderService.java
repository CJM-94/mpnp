package kr.co.mpnp.user.service;

import java.util.List;

import kr.co.mpnp.user.domain.MyOrderDomain;
import kr.co.mpnp.user.vo.MyOrderVO;
//����
public class MyOrderService {
	public MyOrderService() {

	}//

	// �Ⱓ�� �ֹ�������ȸ
	public List<MyOrderDomain> searchOrderList(MyOrderVO moVO) {
		List<MyOrderDomain> list = null;

		return list;
	}// searchOrderList

	// �ֹ����� ����ȸ
	public MyOrderDomain searchOrderDetail(String id, String orID) {
		MyOrderDomain moDom = null;

		return moDom;
	}// searchOrderDetail

	// �Ⱓ�� �ֹ�������ȸ
	public int searchOrderStatusCnt(MyOrderVO moVO) {
		int cnt = 0;

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
