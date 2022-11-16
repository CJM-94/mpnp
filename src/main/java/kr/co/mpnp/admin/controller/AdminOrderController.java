package kr.co.mpnp.admin.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.mpnp.admin.domain.AdminOrderDomain;
import kr.co.mpnp.admin.service.AdminOrderService;
import kr.co.mpnp.admin.vo.AdminOrderVO;
//����
@Controller
public class AdminOrderController {
	
	// �ֹ���ȸ������
	@RequestMapping(value = "/orderMain_list.do", method = GET)
	public String orderList(HttpSession session, AdminOrderVO adVO, Model model) {
		List<AdminOrderDomain> list = null;

	//	AdminOrderService aoService = new AdminOrderService();
		//list = aoService.searchOrderList();
		//model.addAttribute("orderList", list);
		return "/admin/order/orderBoard";

	}// orderList

	// �ֹ�����ȸ(�ֹ��ڵ�)
	@RequestMapping(value = "/orderDetail_form.do", method = GET)
	public String orderListDetail(HttpSession session, String orderId, Model model) {
		AdminOrderDomain aoDom = null;
		
		AdminOrderService aoService = new AdminOrderService();
		 aoDom = aoService.searchOrderDetail("or_0000004");
		model.addAttribute("orderDetail", aoDom);
		
		return "/admin/order/orderDetail";
	}// orderListDetail

	// �ֹ����º���
	@RequestMapping(value = "/orderModify_process.do", method = GET)
	public String modifyOrderStatus(AdminOrderVO adVO, Model model) {

		return "/admin/order/orderModify_process";
	}// modifyOrderStatus

}
