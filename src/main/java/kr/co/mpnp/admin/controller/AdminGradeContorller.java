package kr.co.mpnp.admin.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.mpnp.admin.domain.AdminGradeDomain;
import kr.co.mpnp.admin.service.AdminGradeService;
import kr.co.mpnp.admin.vo.AdminGradeVO;
//����
@Controller
public class AdminGradeContorller {

	// ��ް��� ��ü��ȸ(�Ϸ�)
	@RequestMapping(value = "/admin_g_list.do", method = GET)
	public String adminGList(HttpSession session, Model model) {
		
		AdminGradeService ags = new AdminGradeService();
		List<AdminGradeDomain> list = ags.searchGrade();
		model.addAttribute("gradeList",list);
		
		return "/admin/grade/gradeList";
	}// adminGList
	
	/////////////////////////////////////////////////////////////////////////////////////

	// ����߰� ��(�Ϸ�)
	@RequestMapping(value = "/admin_g_add_form.do", method = GET)
	public String adminGAddForm(HttpSession session) {

		return "/admin/grade/grade_add";
	}// adminGAddForm

//	////DB���� �Ϸ�
//	// ����߰���ưŬ��(�Ϸ�)
//	@ResponseBody
//	@RequestMapping(value = "/admin_g_add_process.do", method = GET,produces = "application/json;charset=UTF-8")
//	public String adminGAddProcess(HttpSession session, AdminGradeVO agVO) {
//
//		// System.out.println(agVO);
//		AdminGradeService ags = new AdminGradeService();
//		// agVO.getMaxPrice() //�Ľ���Ʈ
//
//		return ags.addGrade(agVO);
//	}// adminGAddProcess
	////DB���� �Ϸ�
	// ����߰���ưŬ��(�Ϸ�)
	
	@RequestMapping(value = "/admin_g_add_process.do",method = GET,produces = "application/json;charset=UTF-8")
	public String adminGAddProcess(HttpSession session, AdminGradeVO agVO) {
		int cnt = 0;
		// System.out.println(agVO);
		AdminGradeService ags = new AdminGradeService();
		cnt =ags.addGrade(agVO); 
		// agVO.getMaxPrice() //�Ľ���Ʈ
		
		return "/admin/grade/grade_add_process";
	}// adminGAddProcess
	
	/////////////////////////////////////////////////////////////////////////////////////

	// ��޻󼼺��������� �̵�(�Ϸ�)
	@RequestMapping(value = "/admin_g_detail_form.do", method = GET)
	public String adminGDetailForm(String gradeId ,HttpSession session,Model model) {
		  model.addAttribute("gradeId", gradeId);
		  AdminGradeService agServ = new AdminGradeService(); 
		  AdminGradeDomain agDom =agServ.searchGrade(gradeId); 
		  model.addAttribute("agDom",agDom);
		 return "/admin/grade/gradeDetailList";
	}// adminGDetailForm
	
	////////////////////////////////////////////////////////////////////////////////////////

	//DB���� �Ϸ�
	// ��޻���������
	@RequestMapping(value = "/admin_g_modify_process.do", method = GET)
	public String adminGModifyProcess(HttpSession session,AdminGradeVO agVO,Model model) {
	
		  System.out.println("������Ʈ �׽�Ʈ"+agVO);
		  AdminGradeService agServ = new AdminGradeService(); 
		  int cnt = agServ.modifyGradeInfo(agVO);
		  System.out.println(cnt + "�� ����");
		 model.addAttribute("cnt ",cnt );
		  
		return "/admin/grade/gradeDetail_modify_process";
	}// adminGModifyProcess

	// ��޻���(������) - ������ �ʿ� ������ �𸣰��� ������ ���������ѵ� ���⼭ �� �� �����ؾ�����..?
	@RequestMapping(value = "/admin_g_remove_process.do", method = GET)
	public String adminGRemoveProcess(HttpSession session,AdminGradeVO agVO) {
		
		AdminGradeService agServ = new AdminGradeService(); 
		int cnt = agServ.removeGrade(agVO);
		System.out.println(cnt + "�� ������");
		
		return "/admin/grade/grade_remove_process";
	}// adminGModifyProcess

}//class
