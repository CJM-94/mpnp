package kr.co.mpnp.user.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.mpnp.user.domain.OrderDomain;
import kr.co.mpnp.user.domain.OrderShipDomain;
import kr.co.mpnp.user.service.OrderService;
import kr.co.mpnp.user.vo.OrderPrdVO;
import kr.co.mpnp.user.vo.OrderVO;
import kr.co.mpnp.user.vo.ShipNameVO;


@Controller
public class OrderController {
     OrderService ordSer = new OrderService();
     List<String> list = null;
     
     //�ӽ�- ������ �̵�,�Ķ���� �� �Ѱܹ޴� �� ��������
     //��ٱ��� �������� �̵�
     @RequestMapping(value="/test.do",method=GET)
     public String temp(Model model) {
    	 
    	 
    	 return "/user/order/product_info_test";
    	 
     }
     
	// �ֹ��������� �̵�(ok)
	@RequestMapping(value = "/orderPayment_form.do", method = GET)
	public String orderPayment(HttpSession session ,String shipName,
			OrderVO oVO,@RequestParam(required = false) OrderPrdVO opVO,  Model model) {
	
		
		opVO.getPrdCnt();
		opVO.getPrdName();
		opVO.getPrdId();
		
		
		String url="";
		System.out.println("��ǰ��ȸ"+opVO);
		
		System.out.println(shipName);
		oVO.setId("id008");
		oVO.setDefaultFlag("O");
		String flag = ordSer.searchOrderChk(oVO);
		 String id= oVO.getId();
		//������ȸ
		 OrderDomain orDom = null;
		orDom = ordSer.searchOrderInfo(id);
		model.addAttribute("orDom", orDom); 
		
		 if(flag == null || "".equals(flag)) { // �⺻����������� �ȵ� ȸ���� ���
			 url ="/user/order/orderPayment";
		 }else { // �⺻����� ������ �� ȸ���� ���
			 url ="/user/order/orderPayment_after" ;
			 
			OrderShipDomain osDom = null;
			OrderDomain oDom2 = null;
			//DestinationVO dVO = new DestinationVO();
			//dVO.setId(id);
	        //dVO.setName(shipName);
			
			osDom =ordSer.searchDestination(oVO); //�⺻����� �ּ� ��ȸ
			list = ordSer.searchShipName(id);//�ش���̵��� ����� ��Ī ��ȸ
			//oDom2 = ordSer.seachChangeDestination(dVO); // ����� ����
			model.addAttribute("oDom2", oDom2);
			model.addAttribute("list",list);
			model.addAttribute("osDom",osDom);
			
		 }//end else
		 
		return url;
	}// end orderPayment
	
	//����������ư(ajax)
	@ResponseBody
	@RequestMapping(value = "/order_ship_addr.do", method = GET, produces = "application/json;charset=UTF-8")
	public String changeShipAddr(HttpSession session, String shipName,Model model) {
		ShipNameVO snVO = new ShipNameVO();
		snVO.setId("id008");
		snVO.setName(shipName);
		//System.out.println(shipName);
		String jsonObj =ordSer.seachChangeDestination(snVO);
		// System.out.println(jsonObj );
		return jsonObj;
	}
	
	
//
//	// ����������ư(ajax�� ����)
//	@ResponseBody
//	@RequestMapping(value = "/order_ship_addr.do", method = GET, produces = "application/json;charset=UTF-8")
//	public void changeShipAddr(HttpSession session, String shipName,Model model) {
//		OrderDomain shipDom = null;
//		DestinationVO dVO = new DestinationVO();
//	System.out.println(shipName);
//		dVO.setId("id008");
//		dVO.setName(shipName);
//		shipDom =ordSer.seachChangeDestination(dVO);
//		System.out.println(shipDom);
//		model.addAttribute("shipDom",shipDom);
//		
//		//return orDOM;
//	}// changeShipAddr


	
	


	
	/*@RequestMapping(value = "/order_ship_addr.do", method = GET, produces = "application/json;charset=UTF-8")
	public String changeShipAddr(HttpSession session, String shipName,Model model) {
		DestinationVO dVO = new DestinationVO();
		
		return "/user/order/change_ship_process";
	}// changeShipAddr*/

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
