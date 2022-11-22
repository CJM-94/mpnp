package kr.co.mpnp.user.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.mpnp.user.domain.MyOrderDomain;
import kr.co.mpnp.user.service.MyOrderService;

@Controller
public class MyOrderController {

	// �ֹ����� ������ ����(���̵�)
	@RequestMapping(value = "/order_information_form.do", method = GET)
	public String searchOrderList(HttpSession session, Model model) {
	   
		List<MyOrderDomain> list = null;
	   MyOrderService moServ = new MyOrderService();
	   list = moServ.searchOrderList("id010") ; //�ֹ�������ȸ
	   System.out.println("@@@@@@@@"+list);
	   model.addAttribute("list",list);
	  
		return "/user/mypage/order_information";
	}// searchOrderList
	
	
	/////////////////////////////////

	// �����ֹ����(,�ֹ��ڵ�)
	@RequestMapping(value = "/order_can_process.do", method = GET)
	public String removeOrderProcess(HttpSession session, String orderId, Model model) {
			
		
		return "/user/mypage/order_can_process";
	}// removeOrderProcess
	
	//��ü�ֹ����(���̵�)
	@RequestMapping(value = "/order_totalCan_process.do", method = GET)
	public String removeAllOrderProcess(HttpSession session, String orderDId, Model model) {

		return "/user/mypage/order_totalCan_process";
	}// removeOrderProcess
	

	// �ֹ��������� ����(�ֹ��ڵ��)
	@RequestMapping(value = "/order_detail_form.do", method = GET)
	public String searchOrderDetailForm(HttpSession session, String orderId, Model model) {
		System.out.println(orderId);
		
		MyOrderService mSer = new MyOrderService();
		MyOrderDomain moDom = new MyOrderDomain();
		MyOrderDomain moDOM2 = new MyOrderDomain();
		List<MyOrderDomain> list = new ArrayList<MyOrderDomain>();
		moDom= mSer.searchOrderDetail(orderId); //�ֹ���
		list = mSer.searchOrderPrdDetail(orderId); //��ǰ
		moDOM2 = mSer.searchOrderShip(orderId);//�����
		model.addAttribute("moDOM2",moDOM2);
		model.addAttribute("moDom", moDom);
		model.addAttribute("list",list);
		System.out.println("@@@@@@�ֹ���" +moDom);
		System.out.println("@@@@@@��ǰ��" +list);
		System.out.println("@@@@@@�������" +moDOM2);
		return "/user/mypage/myorder_detail";
		

	}// searchOrderDetailForm

}
