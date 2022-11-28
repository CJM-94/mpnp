package kr.co.mpnp.admin.controller;

import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
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
	@RequestMapping(value = "/admin_g_list.do",  method = {GET,POST})
	public String adminGList(HttpSession session, Model model) {
		
		String url = "redirect:admin_login_form.do";
		
		if(session.getAttribute("adminId")!=null) {
		AdminGradeService ags = new AdminGradeService();
		List<AdminGradeDomain> list = ags.searchGrade();
		model.addAttribute("gradeList",list);
		 url ="/admin/grade/gradeList";
		}
		return url;
	}// adminGList
	
	/////////////////////////////////////////////////////////////////////////////////////

	// ����߰� ��(�Ϸ�)
	@RequestMapping(value = "/admin_g_add_form.do",  method = {GET,POST})
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
	
	@RequestMapping(value = "/admin_g_add_process.do", method = {GET,POST},produces = "application/json;charset=UTF-8")
	public String adminGAddProcess(HttpSession session, HttpServletRequest hrs,Model model) {
		
		String gradeId=hrs.getParameter("gradeId");
		String gradeName=hrs.getParameter("gradeName");
		String level=hrs.getParameter("level");
		int discountRate= Integer.parseInt(hrs.getParameter("discountRate")) ;
		int minPrice=Integer.parseInt(hrs.getParameter("minPrice"));
		int maxPrice=Integer.parseInt(hrs.getParameter("maxPrice"));
		String gradeInfo = hrs.getParameter("gradeInfo");
		
		AdminGradeVO agVO = new AdminGradeVO();
		agVO.setGradeId(gradeId);
		agVO.setGradeName(gradeName);
		agVO.setLevel(level);
		agVO.setDiscountRate(discountRate);
		agVO.setMinPrice(minPrice);
		agVO.setMaxPrice(maxPrice);
		agVO.setGradeInfo(gradeInfo);
		AdminGradeService ags = new AdminGradeService();
		ags.addGrade(agVO); 
	
		
		return "/admin/grade/grade_add_process";
	}// adminGAddProcess
	
	/////////////////////////////////////////////////////////////////////////////////////

	// ��޻󼼺��������� �̵�(�Ϸ�)
	@RequestMapping(value = "/admin_g_detail_form.do",  method = {GET,POST})
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
	@RequestMapping(value = "/admin_g_modify_process.do",  method = {GET,POST})
	public String adminGModifyProcess(HttpSession session,AdminGradeVO agVO,Model model) {
	
		 // System.out.println("������Ʈ �׽�Ʈ"+agVO);
		  AdminGradeService agServ = new AdminGradeService(); 
		  int cnt = agServ.modifyGradeInfo(agVO);
		 // System.out.println(cnt + "�� ����");
		 model.addAttribute("cnt ",cnt );
		  
		return "/admin/grade/gradeDetail_modify_process";
	}// adminGModifyProcess



}//class
