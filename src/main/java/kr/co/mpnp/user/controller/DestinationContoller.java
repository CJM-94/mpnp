package kr.co.mpnp.user.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.mpnp.user.vo.DestinationVO;

@Controller
public class DestinationContoller {

	// ���������Ʈ ��ȸ
	@RequestMapping(value="/des_list.do", method=RequestMethod.GET)
	public String desList(HttpSession session, Model model) {
		
		return "/user/mypage/delivery";
	}
	
	// ����� �߰�
	@RequestMapping(value="/des_add_process.do", method=RequestMethod.GET)
	public String desAddProcess(HttpSession session, DestinationVO dtVO, Model model) {
		
		return "";
	}
	
	// ����� ��������
	@RequestMapping(value="/des_modify_process.do", method=RequestMethod.GET)
	public String desLModifyProcess(HttpSession session, DestinationVO dtVO, Model model) {
		
		return "";
	}
	
	// ����� ����
	@RequestMapping(value="/des_remove_process.do", method=RequestMethod.GET)
	public String desRemoveProcess(HttpSession session, String dtId, Model model) {
		
		return "";
	}
	
}
