package kr.co.mpnp.user.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.mpnp.user.domain.OrderDomain;
import kr.co.mpnp.user.domain.OrderShipDomain;
import kr.co.mpnp.user.service.OrderService;
import kr.co.mpnp.user.vo.MyOrderVO;
import kr.co.mpnp.user.vo.OrderPrdVO;
import kr.co.mpnp.user.vo.OrderVO;
import kr.co.mpnp.user.vo.OrdersInfoVO;
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
     //�� ������ �ѱ�°� �����ߴµ� �Ѹ��°� ����
	@RequestMapping(value = "/orderPayment_form.do", method = GET)
	public String orderPayment(HttpSession session,OrderVO oVO,OrdersInfoVO oIfVO ,  Model model) {
		String url="";
		
		//prdCnt�� ���񽺿��� ������������ �����������ʴ´�.....
	    OrderPrdVO ovo = new OrderPrdVO();
		List<OrderPrdVO> opvo = new ArrayList<OrderPrdVO>();
		List<OrderPrdVO> opvoO = new ArrayList<OrderPrdVO>();
		opvo = ordSer.searchProduct(oIfVO.getOrders()); //DB
		opvoO = ordSer.getPrdInFoOther(oIfVO.getOrders()); //�Ķ����
		model.addAttribute("opvo",opvo);
		model.addAttribute("opvoO",opvoO);
		System.out.println("��!" +oIfVO);
		System.out.println("�߾߾߾߾߾����ߤ��� ���Ŷ�" + opvo);
		System.out.println("�߾߾߾߾߾�" + opvoO);
		/////////////////////////////////////////////////////////
		oVO.setId("id001");
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
			osDom =ordSer.searchDestination(oVO); //�⺻����� �ּ� ��ȸ
			list = ordSer.searchShipName(id);//�ش���̵��� ����� ��Ī ��ȸ
			
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
		String jsonObj =ordSer.seachChangeDestination(snVO);
		return jsonObj;
	}
	
	// �����Ϸ��ư
	@RequestMapping(value = "/orderPayment_process.do", method = GET)
	public String orderCompleteProcess(HttpSession session, OrderVO oVO,OrdersInfoVO oIfVO,MyOrderVO moVO, Model model) {
		System.out.println("����" +oVO);
		System.out.println("��ǰ�迭" +oIfVO);
		System.out.println("��"+moVO);
		oVO.setId("id001");
		moVO.setId("id001");
	
		//�ֹ��ڵ� ��ȸ
		oVO.setOrderId(ordSer.searchOrderId());
		// �ֹ��������� �߰�
		ordSer.addOrderInfo(oVO);
		
		//�ֹ����߰�
		ordSer.addOrderDetail(moVO);
		//����� �߰�
		ordSer.addShipAddr(oVO);		
		return "/user/order/orderPayment_process";
	}// end orderComplete

	// �����Ϸ�������(�ֹ��ڵ�)
	@RequestMapping(value = "/orderPayment_complete.do", method = GET)
	public String orderCompletePage(String orderId, OrderVO oVO, Model model) {

		return "/user/order/orderComplete";
	}// orderCompletePage

}
