package kr.co.mpnp.admin.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import kr.co.mpnp.admin.service.AdminLoginService;
import kr.co.mpnp.admin.vo.AdminLoginVO;

@Controller
public class AdminLoginController {
	
	@RequestMapping(value = "/admin_login_form.do", method=GET )
	public String adminLoginForm(HttpSession session) {
		
		//���⿡ ������ �޾ƾ���? ���̵� �ȵ��Դµ� ? 
		//������ ���� ���ǿ� �ִ� id ����� ��
		session.removeAttribute("id");
		session.invalidate();
		
		return  "admin/login/adminLogin";
	}//adminLoginForm
	
	@RequestMapping(value = "/admin_login_process.do", method=GET )
	public String adminLoginProcess(HttpSession session,AdminLoginVO alVO, Model model) {
		
		//System.out.println(alVO.getId()+"/"+alVO.getPass()); //Ȯ�οϷ�
		AdminLoginService als=new AdminLoginService();
		boolean flag=als.searchAdminLogin(alVO); 
		
		String url="admin/login/adminLogin_fail";
		
		if(flag) {
			session.setMaxInactiveInterval(60*10); //10��
			session.setAttribute("id", alVO.getId()); 
			url="admin/dashboard/dashboardHJYtest";
		}
		
		return url; 
	}//adminLoginProcess
	
	@RequestMapping(value = "/admin_logout_process.do", method=GET )
	public String adminLogoutProcess(HttpSession session) {
		session.removeAttribute("id");
		
		session.invalidate();
		
		//return "redirect:/admin/login/adminLogin"; //�ȵ�. view�ٱ����� ������ �̵������ѵ�
		return "redirect:/indexHJY.jsp"; //�׽�Ʈ��1-����
		//return "admin/login/adminLogoutTest"; //�׽�Ʈ��2-�Ȳ���. �̵��� ��
	}//adminLogoutProcess
	
	@RequestMapping(value = "/admin_modify_pass_form.do", method=GET )
	public String adminModifyPassForm(HttpSession session) {
		
		return "admin/login/adminModifyPass";
	}//adminModifyPassForm
	
	@RequestMapping(value = "/admin_modify_pass_process.do", method=GET )
	public String adminModifyPassProcess(HttpSession session,AdminLoginVO alVO) {
		//System.out.println("������Ʈ�ѷ� �Ӵ�");
		
		AdminLoginService als=new AdminLoginService();
		als.modifyAdminPass(alVO);
		
		return "admin/login/adminLogin";
	}//adminModifyPassProcess
	

}//class
