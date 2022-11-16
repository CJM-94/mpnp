package kr.co.mpnp.admin.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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

	// ����߰���ưŬ��(�Ϸ�)
	@RequestMapping(value = "/admin_g_add_process.do", method = GET)
	public String adminGAddProcess(HttpSession session, AdminGradeVO agVO) {

		// System.out.println(agVO);
		AdminGradeService ags = new AdminGradeService();
		int cnt = ags.addGrade(agVO);
		System.out.println(cnt + "�� �߰�");

		return "/admin/grade/grade_add_process";
	}// adminGAddProcess
	
	/////////////////////////////////////////////////////////////////////////////////////

	// ��޻󼼺��������� �̵�(�Ϸ�)
	@RequestMapping(value = "/admin_g_detail_form.do", method = GET)
	public String adminGDetailForm(String gradeId ,HttpSession session,Model model) {
		  model.addAttribute("gradeId", gradeId);
		  //String gId=request.getParameter("gradeId");
		 // System.out.println(gradeId);
		  AdminGradeService agServ = new AdminGradeService(); 
		  AdminGradeDomain agDom =agServ.searchGrade(gradeId); 
		  model.addAttribute("agDom",agDom);
		 return "/admin/grade/gradeDetailList";
	}// adminGDetailForm
	
	////////////////////////////////////////////////////////////////////////////////////////

	// ��޻���������
	@RequestMapping(value = "/admin_g_modify_process.do", method = GET)
	public String adminGModifyProcess(HttpSession session) {
		//�Ķ���Ͱ� �޾ƾ� �ҵ�..   
		AdminGradeVO agVO = new AdminGradeVO();
		   //agVO.setDiscountRate("discountRate");
		  System.out.println("������Ʈ �׽�Ʈ"+agVO);
		  AdminGradeService agServ = new AdminGradeService(); 
		  int cnt = agServ.modifyGradeInfo(agVO);
		  System.out.println(cnt + "�� ����");
		  
		return "/admin/grade/gradeDetail_modify_process";
	}// adminGModifyProcess

	// ��޻���(������)
	@RequestMapping(value = "/admin_g_remove_process.do", method = GET)
	public String adminGRemoveProcess(HttpSession session,AdminGradeVO agVO) {
		
		AdminGradeService agServ = new AdminGradeService(); 
		int cnt = agServ.removeGrade(agVO);
		System.out.println(cnt + "�� ������");
		
		return "/admin/grade/grade_remove_process";
	}// adminGModifyProcess

}//class
