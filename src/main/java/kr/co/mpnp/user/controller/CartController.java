package kr.co.mpnp.user.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
		
		List<CartDomain> cartList = cartService.searchCartList("id002");
		//for(CartDomain cd : cartList) {
			//System.out.println("CartController : cartId - "+cd.getCartId());
			//System.out.println("�����ֳ� ? CartController : productId - "+cd.getProductId());
		//}
		model.addAttribute("cartList",cartList);
		
		
		
		//return "/user/cart/cart_test";
		return "/user/cart/cart";
	}
	
	
	// ��ٱ��� ���� ���ϰ� XŬ��  �׳� �޼����ϳ��� �ϸ� �ȵǳ�??
	@ResponseBody
	@RequestMapping(value="/cart_remove_process.do",method=RequestMethod.GET)
	public String removeCart(HttpSession session, String cartId, Model model) {
									// �����Ǿ������� ��������ϴϱ� model�� �־���ϳ�..?
		System.out.println("cartId : "+cartId);
		CartService cartService = new CartService(); 
		return cartService.removeCart(cartId);
		
	}
	
	
	// ��ٱ��� ���� üũ�ڽ��� ������ ���û���
	// ���ڳ� �׷� ���������� ���õ�üũ�ڽ��� �� �����ؾߵǴ°��ݾ�
	@ResponseBody
	@RequestMapping(value="/cart_chk_remove_process.do",method=RequestMethod.POST)
	public String removeCart(HttpSession session, @RequestParam(value="chkBox[]") List<String> chkArr, Model model) {
		// �����Ǿ������� ��������ϴϱ� model�� �־���ϳ�..?
		//System.out.println("�üũ�Ƴ��� : "+chkArr.size());
		//for(String chk : chkArr) {
			//System.out.println("���õȰ� �� ���Գ� : "+chk);
		//}
		
		List<CartVO> list = new ArrayList<CartVO>();
		String id = "id002"; // session.getAttribute("id");
		CartVO cVO = null;
		for(String chk : chkArr) {
			cVO = new CartVO();
			cVO.setMemberId(id);
			cVO.setCartId(chk);
			//System.out.println("for���ȿ��� �����ִ� cVO : "+cVO.toString());
			list.add(cVO);
		}
		//System.out.println("������� list ���� : "+list.size());
		
		CartService cartService = new CartService(); 
		
		return cartService.removeChkCart(list);
	}
	
	
	
	

	// ��ٱ��� ��������
	// ��ٱ��� ������ ��ư���� ó���Ѵ��ĵ� ������ư�̾��µ� ��Բ��� ����� ��??
	// ����
	@ResponseBody
	@RequestMapping(value="/cart_modify_process.do",method=RequestMethod.POST)
	//public String modifyCartCnt(HttpSession session, @RequestBody CartVO cVO, Model model) {
	public String modifyCartCnt(HttpSession session, @RequestParam Map<String,String> cMap, Model model) {
		//System.out.println(cVO.getCartId());
		//System.out.println(cVO.getCnt());
		//System.out.println(cMap.get("cartId").getClass());
		//System.out.println(cMap.get("cnt"));
		//System.out.println("cartId : "+cMap.get("cartId"));
		//System.out.println("cnt : "+cMap.get("cnt"));
		
		String cartId = cMap.get("cartId");
		int cnt = Integer.parseInt(cMap.get("cnt"));
		CartVO cVO = new CartVO();
		//cVO.setMemberId((String)session.getAttribute("id"));
		cVO.setMemberId("id002");
		cVO.setCartId(cartId);
		cVO.setCnt(cnt);
		
		CartService cartService = new CartService();
		//return "";
		return cartService.modifyCartItemCnt(cVO);
	}
	
	
	
	
	
}
