package kr.co.mpnp.user.controller;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

public class WishListController {

	
	//�� ����Ʈ ���(���̵�)
	@RequestMapping(value="wishList.do",method=GET)
	public String searchWishLishForm(HttpSession session,Model model){
		
		
		
		return"user/cart/wishList";
	}
	
}//class
