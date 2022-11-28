package kr.co.mpnp.admin.controller;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import kr.co.mpnp.admin.domain.AdminMemberDomain;
import kr.co.mpnp.admin.service.AdminMemberService;
import kr.co.mpnp.admin.service.AdminQuitMemberService;
import kr.co.mpnp.admin.vo.AdminMemberVO;

@Controller
public class AdminMemberController {
	
	//�����ȸ(�˻���ȸ-��� ����)
	@RequestMapping(value = "/admin_m_list.do", method=GET )
	public String adminMList(HttpSession session, AdminMemberVO amVO, Model model) {
		
		String url="admin/login/adminLogin";
		
		if(session.getAttribute("adminId")!=null) {
			AdminMemberService ams=new AdminMemberService();
			
			List<AdminMemberDomain> list= ams.searchMember(amVO);
			model.addAttribute("memberList",list);
			
			List<AdminMemberDomain> gradeList= ams.searchGrade(amVO);
			model.addAttribute("gradeList",gradeList);
			
			url="admin/member/memberBoard";
		}
		
		
		return url;
	}//adminMList
	
	//����󼼺���
	@RequestMapping(value = "/admin_m_detail_form.do", method=GET )
	public String adminMDetailForm(@RequestParam(value="id") String id,HttpSession session, Model model) {
		
		AdminMemberService ams=new AdminMemberService();
		AdminMemberDomain amd=ams.searchMemberDetail(id);
		model.addAttribute("member",amd);
		
		//Ż���� ȸ���϶�
		AdminQuitMemberService aqs=new AdminQuitMemberService();
		AdminMemberDomain amd2=aqs.searchQuitMember(id);
		model.addAttribute("quitmember",amd2);
		
		//member id�� ���ǿ� �÷��� ������ ���� �ʰڴ�
		session.setMaxInactiveInterval(60*2); //2��
		session.setAttribute("id", id); 
		
		return "admin/member/memberDetail";
		
	}// adminMDetailForm
	
	//�������
	@RequestMapping(value = "/admin_m_remove_process.do", method=GET )
	public String adminMRemoveProcess(String id, HttpSession session, Model model) {
		System.out.println("������� !"+id);
		
		//member table ���� 'Ż��'�� update
		AdminMemberService ams=new AdminMemberService();
		ams.modifyMember(id);
		
		//�׸��� quitMember table�� insert�ϱ�
		AdminQuitMemberService aqs=new AdminQuitMemberService();
		aqs.addQuitMember(id);
		
		return "redirect:admin_m_list.do"; //return�� �������� ����Ʈ ��ȸ�� ����� ���°ɱ�
	}//adminMRemoveProcess
	
	//�����޺���
	@RequestMapping(value = "/admin_m_grade_process.do", method = GET)
	public String adminGradeProcess(HttpSession session, AdminMemberVO amVO, Model model) {
		session.getAttribute("adminId"); 
		System.out.println("��޼��� !"+amVO.getGradeid());
		System.out.println("������ ���̵� !"+session.getAttribute("adminId")); //�ҷ���
		
		AdminMemberService ams=new AdminMemberService();
		ams.modifyMemberGrade(amVO);
		
		return "redirect:admin_m_list.do";
	}//adminGradeProcess
	
	

}//class
