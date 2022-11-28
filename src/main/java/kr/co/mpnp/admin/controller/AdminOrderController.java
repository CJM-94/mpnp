package kr.co.mpnp.admin.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.mpnp.admin.domain.AdminOrderDomain;
import kr.co.mpnp.admin.domain.AdminOrderPrdDomain;
import kr.co.mpnp.admin.service.AdminOrderService;
import kr.co.mpnp.admin.vo.AdminOrderVO;
//����
@Controller
public class AdminOrderController {
	
	// �ֹ���ȸ������
	@RequestMapping(value = "/admin_orderMain_list.do", method = GET)
	public String orderList(HttpSession session, AdminOrderVO adVO, Model model) {
		
		String url = "redirect:admin_login_form.do";
		
		if(session.getAttribute("adminId")!=null) {

	     AdminOrderService aoService = new AdminOrderService();
	     List<AdminOrderDomain> list  = aoService.searchOrderList(adVO);
		 model.addAttribute("orderList", list);
		 url ="/admin/order/orderBoard";
		}
		return url;

	}// orderList

	// �ֹ�����ȸ(�ֹ��ڵ�)
	@RequestMapping(value = "/admin_orderDetail_form.do", method = GET)
	public String orderListDetail(HttpSession session, String memberId, String orderId, Model model) {

		AdminOrderService aoService = new AdminOrderService();
		
		 AdminOrderDomain aoDom = aoService.searchOrderDetail(orderId); //�ֹ���
		List<AdminOrderPrdDomain> list = aoService.searchOrderPrdDetail(orderId);//�ֹ���ǰ ��
		AdminOrderDomain aoDom2 = aoService.searchOrderShip(orderId); //�ֹ��� �����
		int discountRate = aoService.searchDiscountRate(memberId);//������
		int totlaPrdPrice = aoService.searchPriceIndivisual(orderId);//�ֹ���ǰ �� ����
		model.addAttribute("aoDom", aoDom); //�ֹ��ڻ�
		model.addAttribute("list", list); //��ǰ��
		model.addAttribute("aoDom2",aoDom2); //�������
		model.addAttribute("discountRate",discountRate); //������
		model.addAttribute("totlaPrdPrice",totlaPrdPrice); // ��ǰ �� ����
		
		return "/admin/order/orderDetail";
	}// orderListDetail

	// �ֹ����º���

	@RequestMapping(value = "/admin_orderModify_process.do", method = GET)
	public String modifyOrderStatus(AdminOrderVO adVO, Model model) {
      
		AdminOrderService aoService = new AdminOrderService(); 
		 int cnt=aoService.modifyOrderStatus(adVO); //�ֹ����º���
		 model.addAttribute("cnt",cnt);
		
		return "/admin/order/orderModify_process";
	}// modifyOrderStatus

}
