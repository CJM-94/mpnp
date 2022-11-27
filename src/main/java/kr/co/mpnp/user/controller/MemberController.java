package kr.co.mpnp.user.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
	
	@RequestMapping(value = "/login_process.do", method=GET )
	public String loginProcess(HttpSession session,MemberVO mVO,Model model) {
		
		MemberService ms=new MemberService();
		boolean flag=ms.searchLogin(mVO);
		
		String url="redirect:/index.do"; //���������� ó���������.. ������ ����̾��� ����
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
	
	@RequestMapping(value = "/m_findid_process.do", method=GET )
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
	
	@RequestMapping(value = "/m_findpass_process.do", method=GET )
	public String findPassProcess(HttpSession session, MemberVO mVO, Model model) {
		
		MemberService ms=new MemberService();
		MemberDomain md=ms.searchMemberPass(mVO);
		model.addAttribute("passFind", md);
		
		System.out.println("m_findpass_process-id: "+mVO.getId());
		
		if(md!=null) {
			session.setMaxInactiveInterval(60*3); //10��
			session.setAttribute("id", mVO.getId()); 
		}
		
		return "user/member/pass_modify"; 
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
	
	
	
	//���� �ؿ����ʹ� ��� ... 
//	@RequestMapping(value = "/m_info_chk.do", method=GET )
//	public String memberChkForm() {
//		
//		return "";
//	}//memberChkForm
//	
//	@RequestMapping(value = "/m_info_form.do", method=GET )
//	public String memberForm(HttpSession session, String str, Model model) {
//		
//		return "";
//	}//memberForm
	
//	@RequestMapping(value = "/m_info_modify_process.do", method=GET )
//	public String memberModifyProcess(HttpServletRequest request, Model model) {
//		
//		return "";
//	}//memberModifyProcess
//	
//	@RequestMapping(value = "/m_quit_form.do", method=GET )
//	public String memberQuitForm() {
//		
//		return "";
//	}//memberQuitForm
//	
//	@RequestMapping(value = "/m_quit_process.do", method=GET )
//	public String memberQuitProcess(HttpSession session, String str, Model model) {
//		
//		return "";
//	}//memberQuitProcess
	
	
	//// �� Ż���ϰ� ���� �߰���� Ż�� ������ ���ִ� ��Ʈ�ѷ��� �߰��ؾ��ҵ� 
	
	

}//class
