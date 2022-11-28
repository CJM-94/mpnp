package kr.co.mpnp.user.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.mpnp.user.domain.MemberDomain;
import kr.co.mpnp.user.service.MemberService;
import kr.co.mpnp.user.vo.MemberVO;

@Controller
public class MemberController {
	
	@RequestMapping(value = "/login_form.do", method=GET )
	public String loginForm(HttpSession session) {
		
		session.removeAttribute("id");
		session.invalidate();
		
		return "user/member/login";
	}//loginForm
	
	@RequestMapping(value = "/login_process.do", method=POST )
	public String loginProcess(HttpSession session,MemberVO mVO,Model model) {
		
		MemberService ms=new MemberService();
		boolean flag=ms.searchLogin(mVO);
		
		String url="user/member/login_fail"; //������ �̵� ���̴°� ���� �ȵ����� ...
		if(flag) {
			session.setMaxInactiveInterval(60*10); //10��
			session.setAttribute("id", mVO.getId()); 
			url="redirect:/index.do";
		}
		
		return url;//������ �������� �� ��
	}//loginProcess
	
	@RequestMapping(value = "/logout_process.do", method=GET )
	public String logoutPcoess(HttpSession session) {
		
		session.removeAttribute("id");
		session.invalidate();
		
		return "redirect:/index.do"; //�������� �� ��
	}//logoutPcoess
	
	@RequestMapping(value = "/m_findid_form.do", method=GET )
	public String findIdForm() {
		
		
		return "user/member/find_id";
	}//findIdForm
	
	@RequestMapping(value = "/m_findid_process.do", method=POST )
	public String findIdProcess(MemberVO mVO, Model model) {
		
		MemberService ms=new MemberService();
		MemberDomain md=ms.searchMemberId(mVO);
		model.addAttribute("idFind", md);
		
		return "user/member/find_id_result";
	}//findIdProcess
	
	@RequestMapping(value = "/m_findpass_form.do", method=GET )
	public String findPassForm() {
		
		
		return "user/member/find_pass";
	}//findPassForm
	
	@RequestMapping(value = "/m_findpass_process.do", method=POST )
	public String findPassProcess(HttpSession session, MemberVO mVO, Model model) {
		String url="user/member/find_pass_fail";
		MemberService ms=new MemberService();
		MemberDomain md=ms.searchMemberPass(mVO);
		model.addAttribute("passFind", md);
		
		System.out.println("m_findpass_process-id: "+mVO.getId());
		
		if(md!=null) {
			session.setMaxInactiveInterval(60*3); //10��
			session.setAttribute("id", mVO.getId()); 
			url="user/member/pass_modify";
		}
		
		return url; 
	}//findPassProcess
	
	
	
	@RequestMapping(value = "/m_modifypass_form.do", method=GET )
	public String passModifyForm() {
		
		return "user/member/pass_modify";
	}//passModifyForm
	
	@RequestMapping(value = "/m_modifypass_process.do", method=GET )
	public String passModifyProcess(HttpSession session,MemberVO mVO) {		
		//System.out.println("������ ���̵�"+mVO.getId());
		// param���� ������ �ȵǰ� ���ǲ��� �޾ƿ;��� > �������������� �н� �����Ҷ� ���̾�
		
		String id=(String)session.getAttribute("id");
		System.out.println("���������� ��� ���� ���μ��� ���̵� "+id);
		
		mVO.setId(id);
		
		
		MemberService ms=new MemberService();
		ms.modifyMemberPass(mVO);
		
		return "user/member/login"; //
	}//passModifyProcess

}//class
