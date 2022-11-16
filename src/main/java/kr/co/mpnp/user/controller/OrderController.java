package kr.co.mpnp.user.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.mpnp.user.domain.OrderDomain;
import kr.co.mpnp.user.service.OrderService;
import kr.co.mpnp.user.vo.OrderVO;


@Controller
public class OrderController {
     OrderService ordSer = new OrderService();
     List<String> list = null;
  
	// �ֹ��������� �̵�(ok)
	@RequestMapping(value = "/orderPayment_form.do", method = GET)
	public String orderPayment(HttpSession session,OrderVO oVO, Model model) {
		String url="";
	
		oVO.setId("id002");
		oVO.setDefaultFlag("O");
		String flag = ordSer.searchOrderChk(oVO);
		 String id= oVO.getId();
		//������ȸ
		 OrderDomain orDom = null;
		orDom = ordSer.searchOrderInfo(id);
		model.addAttribute("orDom", orDom); 
		System.out.println(orDom);
		 if(flag == null || "".equals(flag)) { // �⺻����������� �ȵ� ȸ���� ���
			 url ="/user/order/orderPayment";
		 }else { // �⺻����� ������ �� ȸ���� ���
			 url ="/user/order/orderPayment_after" ;
			 OrderDomain orDom2 = null;
			 orDom2 =ordSer.searchDestination(oVO); 
			 list = ordSer.searchShipName(id);//�ش���̵��� ����� ��Ī ��ȸ
			model.addAttribute("list",list);
			model.addAttribute("orDom2",orDom);
			 System.out.println(orDom2);
		 }//end else
		 
		 
	
		return url;
	}// end orderPayment

	// ����������ư(ajax�� ����)
	@ResponseBody
	@RequestMapping(value = "/order_ship_addr.do", method = GET, produces = "application/json;charset=UTF-8")
	public String changeShipAddr(HttpSession session, String shipName) {
		String jsonObj = "";

		return jsonObj;
	}// changeShipAddr

	// �����Ϸ��ư
	@RequestMapping(value = "/orderPayment_process.do", method = GET)
	public String orderCompleteProcess(HttpSession session, OrderVO oVO, Model model) {

		return "/user/order/orderPayment_process";
	}// end orderComplete

	// �����Ϸ�������(�ֹ��ڵ�)
	@RequestMapping(value = "/orderPayment_complete.do", method = GET)
	public String orderCompletePage(String orderId, OrderVO oVO, Model model) {

		return "/user/order/orderComplete";
	}// orderCompletePage

}
