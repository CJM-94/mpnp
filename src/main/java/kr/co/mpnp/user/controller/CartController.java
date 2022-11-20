package kr.co.mpnp.user.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.mpnp.user.domain.CartDomain;
import kr.co.mpnp.user.service.CartService;
import kr.co.mpnp.user.vo.CartVO;

@Controller
public class CartController {

	// ��ٱ��� ����Ʈ��ȸ
	@RequestMapping(value="/cart_list.do",method=RequestMethod.GET)
	public String searchCartList(HttpSession session, Model model) {
		
		String id = (String)session.getAttribute("id");
		System.out.println("CartController : id - "+id);
		
		CartService cartService = new CartService(); 
		
		List<CartDomain> cartList = cartService.searchCartList("id001");
		for(CartDomain cd : cartList) {
			System.out.println("CartController : cartId - "+cd.getCartId());
		}
		model.addAttribute("cartList",cartList);
		
		
		
		return "/user/cart/cart";
	}
	
	// ��ٱ��� ��������
	// ��ٱ��� ������ ��ư���� ó���Ѵ��ĵ� ������ư�̾��µ� ��Բ��� ����� ��??
	// �޼������ ajax�� �ǳ��̰�? �ø��°ſ����� ���ݵ� �ǽð����� �ٲ��ߵ��ݾ� ������ư���� �׳� ���⼭ ó���ؾ��ϳ�?????????????????????????????????????????????????????????????
	// ����
	@RequestMapping(value="/cart_modify_process.do",method=RequestMethod.GET)
	public String modifyCartCnt(HttpSession session, CartVO cVO, Model model) {
		
		
		return "";
	}
	
	// ��ٱ��� ����
	@RequestMapping(value="/cart_remove_process.do",method=RequestMethod.GET)
	public String removeCart(HttpSession session, String[] id, Model model) {
									// �����Ǿ������� ��������ϴϱ� model�� �־���ϳ�..?
		
		
		return "";
	}
}
