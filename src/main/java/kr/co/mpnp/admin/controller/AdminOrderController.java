package kr.co.mpnp.admin.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.mpnp.admin.domain.AdminOrderDomain;
import kr.co.mpnp.admin.domain.AdminOrderPrdDomain;
import kr.co.mpnp.admin.service.AdminOrderService;
import kr.co.mpnp.admin.vo.AdminOrderVO;
//����
@Controller
public class AdminOrderController {
	
	// �ֹ���ȸ������
	@RequestMapping(value = "/orderMain_list.do", method = GET)
	public String orderList(HttpSession session, AdminOrderVO adVO, Model model) {
		List<AdminOrderDomain> list = null;

	     AdminOrderService aoService = new AdminOrderService();
		 list = aoService.searchOrderList(adVO);
		 model.addAttribute("orderList", list);
		 
		return "/admin/order/orderBoard";

	}// orderList

	// �ֹ�����ȸ(�ֹ��ڵ�)
	@RequestMapping(value = "/orderDetail_form.do", method = GET)
	public String orderListDetail(HttpSession session, String memberId, String orderId, Model model) {

		AdminOrderService aoService = new AdminOrderService();
		
		 AdminOrderDomain aoDom = aoService.searchOrderDetail(orderId); //�ֹ���
		List<AdminOrderPrdDomain> list = aoService.searchOrderPrdDetail(orderId);//�ֹ���ǰ ��
		AdminOrderDomain aoDom2 = aoService.searchOrderShip(orderId); //�ֹ��� �����
		int discountRate = aoService.searchDiscountRate(memberId);//������
		int totlaPrdPrice = aoService.searchPriceIndivisual(orderId);//�ֹ���ǰ �� ����
		System.out.println("@@@@@@22"+ discountRate);
		model.addAttribute("aoDom", aoDom); //�ֹ��ڻ�
		model.addAttribute("list", list); //��ǰ��
		model.addAttribute("aoDom2",aoDom2); //�������
		model.addAttribute("discountRate",discountRate); //������
		model.addAttribute("totlaPrdPrice",totlaPrdPrice); // ��ǰ �� ����
		
		return "/admin/order/orderDetail";
	}// orderListDetail

	// �ֹ����º���

	@RequestMapping(value = "/orderModify_process.do", method = GET)
	public String modifyOrderStatus(AdminOrderVO adVO, Model model) {
      
		System.out.println("�ֹ����� @@@2" + adVO);
		AdminOrderService aoService = new AdminOrderService(); 
		int cnt = aoService.modifyOrderStatus(adVO);
		//int cnt2 = aoService.modifyReviewChk(orderId);
		if(cnt ==1) {
		System.out.println("@@@@@@@cnt" + cnt + "�� �����");
		};
		
		return "/admin/order/orderModify_process";
	}// modifyOrderStatus

}
