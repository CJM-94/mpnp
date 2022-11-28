package kr.co.mpnp.user.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.mpnp.user.domain.MyOrderDomain;
import kr.co.mpnp.user.service.MyOrderService;
import kr.co.mpnp.user.vo.MyOrderVO;

@Controller
public class MyOrderController {

	// �ֹ����� ������ ����(���̵�)
	@RequestMapping(value = "/order_information_form.do", method = GET)
	public String searchOrderList(HttpSession session,MyOrderVO mvo, Model model) {
		String url="user/member/login";
		
		   MyOrderService moServ = new MyOrderService();
		String id=(String)session.getAttribute("id");
		if(id!=null) {
		mvo.setId(id);
		mvo.getFindStartDate();
		mvo.getFindEndDate();
		mvo.getId();
	   List<MyOrderDomain> list = moServ.searchOrderList(mvo);
	   model.addAttribute("list",list);
		 url = "/user/mypage/order_information";
		}
		
		//����¡
		//����¡����
		int totalData =moServ.totalCount(mvo);
		int lastPage = moServ.lastPage(totalData);
		int curPage = mvo.getPageFlag();
		int startNum = moServ.startNum(curPage);
		int isLast = moServ.isLast(lastPage, startNum);
				
		//view�� ����
		model.addAttribute("totalData", totalData);
		model.addAttribute("lastPage", lastPage);
		model.addAttribute("startNum", startNum);
		model.addAttribute("isLast", isLast);
		model.addAttribute("curPage", curPage);
	
		
		
		
		return url;
	}// searchOrderList
	
	/*
	 * //��¥ ��ȸ
	 * 
	 * @ResponseBody
	 * 
	 * @RequestMapping(value="/order_date_process.do", method=GET) public String
	 * searchDate(HttpSession session,MyOrderVO mvo,Model model) { MyOrderService
	 * moServ = new MyOrderService(); mvo.setId("test1126"); String jsonObj =
	 * moServ.searchDate(mvo); return jsonObj; }//
	 */	

	// �����ֹ����(,�ֹ����ڵ�)
	@ResponseBody
	@RequestMapping(value = "/order_can_process.do", method = GET)
	public String removeOrderProcess(HttpSession session, String orDetailId, Model model) {
			
		 MyOrderService moServ = new MyOrderService();
		 
		return moServ.removeCancelIndivisual(orDetailId);
	}// removeOrderProcess
	
	//��ü�ֹ����(�ֹ��ڵ�)
	@ResponseBody
	@RequestMapping(value = "/order_totalCan_process.do", method = GET)
	public String removeAllOrderProcess(HttpSession session, String orderId, Model model) {
		
		 MyOrderService moServ = new MyOrderService();
		 
		return moServ.removeCancelTotal(orderId);
	}// removeOrderProcess
	

	// �ֹ��������� ����(�ֹ��ڵ��)
	@RequestMapping(value = "/order_detail_form.do", method = GET)
	public String searchOrderDetailForm(HttpSession session,String orderId, Model model) {

	String url="user/member/login";
		
		String id=(String)session.getAttribute("id");
		if(id!=null) {
		
		MyOrderService mSer = new MyOrderService();
		MyOrderDomain moDom = new MyOrderDomain();
		MyOrderDomain moDOM2 = new MyOrderDomain();
		List<MyOrderDomain> list = new ArrayList<MyOrderDomain>();
		moDom= mSer.searchOrderDetail(orderId); //�ֹ���
		list = mSer.searchOrderPrdDetail(orderId); //��ǰ
		moDOM2 = mSer.searchOrderShip(orderId);//�����
		int prdPrice = mSer.searchPriceIndivisual(orderId);//��ǰ �Ѱ���
		int actualPrce = mSer.selectPriceTotal(orderId);// ���� �����ݾ�
		int discountRate = mSer.selectDiscountRate(id);// ������
		
		model.addAttribute("prdPrice",prdPrice); //��ǰ �Ѱ���
		model.addAttribute("actualPrce",actualPrce); //���������ݾ�(����� ����)
		model.addAttribute("discountRate", discountRate);//������
		model.addAttribute("moDOM2",moDOM2);
		model.addAttribute("moDom", moDom);
		model.addAttribute("list",list);
		
		url ="/user/mypage/myorder_detail";
		}
		
		return url;
		

	}// searchOrderDetailForm

}
