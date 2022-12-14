package kr.co.mpnp.user.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.mpnp.user.domain.MyOrderDomain;
import kr.co.mpnp.user.domain.OrderDomain;
import kr.co.mpnp.user.domain.OrderShipDomain;
import kr.co.mpnp.user.service.OrderService;
import kr.co.mpnp.user.vo.OrderPrdVO;
import kr.co.mpnp.user.vo.OrderVO;
import kr.co.mpnp.user.vo.OrdersInfoVO;
import kr.co.mpnp.user.vo.ShipNameVO;


@Controller
public class OrderController {
     OrderService ordSer = new OrderService();
     List<String> list = null;
     
     
     //임시- 페이지 이동,파라미터 값 넘겨받는 거 연습땜시
     //장바구니 페이지로 이동
     @RequestMapping(value="/test.do",method=GET)
     public String temp(Model model) {
    	 
    	 
    	return "/user/order/product_info_test";
     }

	// 주문페이지로 이동(ok)
	@RequestMapping(value = "/orderPayment_form.do", method = POST)
	public String orderPayment(HttpSession session,OrderVO oVO,OrdersInfoVO oIfVO ,  Model model) {
		String url="redirect:login_form.do";
		String id = (String) session.getAttribute("id");
		
		if(id != null) {
		List<OrderPrdVO> opvo = ordSer.searchProduct(oIfVO);
	    model.addAttribute("opvo", opvo);
		oVO.setId(id);
		oVO.setDefaultFlag("O");
		 String flag = ordSer.searchOrderChk(id);
		 //oVO.getId();
		//내역조회
		  OrderDomain orDom = ordSer.searchOrderInfo(id);
		model.addAttribute("orDom", orDom); 
		
		 if(flag == null || "".equals(flag)) { // 기본배송지설정이 안된 회원일 경우
			 url ="/user/order/orderPayment";
		 }else { // 기본배송지 설정이 된 회원인 경우
			 url ="/user/order/orderPayment_after" ;
			 
			OrderShipDomain osDom = null;
			OrderDomain oDom2 = null;
			osDom =ordSer.searchDestination(oVO); //기본배송지 주소 조회
			List<OrderShipDomain> list = null;
			list = ordSer.searchShipName(id);//해당아이디의 배송지 별칭 조회
			
			model.addAttribute("oDom2", oDom2);
			model.addAttribute("list",list);
			model.addAttribute("osDom",osDom);
			
		 }//end else
		}//end 대왕 if
		 
		return url;
	}// end orderPayment
	
	//배송지변경버튼(ajax)
	@ResponseBody
	@RequestMapping(value = "/order_ship_addr.do", method = GET, produces = "application/json;charset=UTF-8")
	public String changeShipAddr(HttpSession session, String desid,Model model) {
		ShipNameVO snVO = new ShipNameVO();
		String id = (String) session.getAttribute("id");
		snVO.setId(id);
		snVO.setDesId(desid);
		String jsonObj =ordSer.seachChangeDestination(snVO);
		return jsonObj;
	}
	
	// 결제완료버튼
	@RequestMapping(value = "/orderPayment_process.do", method = POST)
	public String orderCompleteProcess(HttpSession session, OrderVO oVO,Model model) {
		String id = (String) session.getAttribute("id");
		session.setAttribute("discountPrice", oVO.getDiscountPrice());
		session.setAttribute("totalPrice", oVO.getTotalPrice());
		oVO.setId(id);
		 
		ordSer.searchOrer(oVO); //트랜잭션
		//System.out.println("오더-22222---" +oVO.getOrderId()); // 트랜잭션 처리 후 주문코드가 들어옴
		session.setAttribute("orderId", oVO.getOrderId()); //트랜잭션 처리 후 주문코드값 들어옴
		return "/user/order/orderPayment_process";
	}// end orderComplete

	// 결제완료페이지(주문코드)
	@RequestMapping(value = "/orderPayment_complete.do", method = {GET,POST})
	public String orderCompletePage(HttpSession session, Model model) {
	
		int discountPrice = (Integer) session.getAttribute("discountPrice");
		int totalPrice = (Integer) session.getAttribute("totalPrice");
		String orderId = (String) session.getAttribute("orderId");
		MyOrderDomain mod = new MyOrderDomain();
		mod = ordSer.searchOrderCompleteM(orderId);
		List<MyOrderDomain> mod2 =new ArrayList<MyOrderDomain>();
		mod2 = ordSer.searchOrderCompleteP(orderId);
		MyOrderDomain mod3 = new MyOrderDomain();
		mod3 = ordSer.searchOrderCompleteD(orderId);
		
		model.addAttribute("mod1", mod);
		model.addAttribute("mod2", mod2);
		model.addAttribute("mod3", mod3);
		
		return "/user/order/orderComplete";
	}// orderCompletePage

}
