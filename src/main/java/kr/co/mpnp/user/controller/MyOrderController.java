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

@Controller
public class MyOrderController {

	// �ֹ����� ������ ����(���̵�)
	@RequestMapping(value = "/order_information_form.do", method = GET)
	public String searchOrderList(HttpSession session, String id, Model model) {
	   
		List<MyOrderDomain> list = null;
	   MyOrderService moServ = new MyOrderService();
	   list = moServ.searchOrderList("id001") ;
	   model.addAttribute("list",list);
	  
		return "/user/mypage/order_information";
	}// searchOrderList
	

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
	public String searchOrderDetailForm(String orderId, Model model) {
		System.out.println(orderId);
		
		MyOrderService mSer = new MyOrderService();
		MyOrderDomain moDom = new MyOrderDomain();
		MyOrderDomain moDOM2 = new MyOrderDomain();
		List<MyOrderDomain> list = new ArrayList<MyOrderDomain>();
		moDom= mSer.searchOrderDetail(orderId); //�ֹ���
		list = mSer.searchOrderPrdDetail(orderId); //��ǰ
		moDOM2 = mSer.searchOrderShip(orderId);//�����
		int prdPrice = mSer.searchPriceIndivisual(orderId);//��ǰ �Ѱ���
		int actualPrce = mSer.selectPriceTotal(orderId);// ���� �����ݾ�
		int discountRate = mSer.selectDiscountRate("id001");// ������
		
		model.addAttribute("prdPrice",prdPrice); //��ǰ �Ѱ���
		model.addAttribute("actualPrce",actualPrce); //���������ݾ�(����� ����)
		model.addAttribute("discountRate", discountRate);//������
		model.addAttribute("moDOM2",moDOM2);
		model.addAttribute("moDom", moDom);
		model.addAttribute("list",list);

		
		return "/user/mypage/myorder_detail";
		

	}// searchOrderDetailForm

}
