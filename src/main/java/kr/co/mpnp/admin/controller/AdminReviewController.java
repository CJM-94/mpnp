package kr.co.mpnp.admin.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.mpnp.admin.vo.AdminReviewVO;

@Controller
public class AdminReviewController {
	
	// ���丮��Ʈ��ȸ
	@RequestMapping(value="/admin_review_list.do", method=RequestMethod.GET)
	public String adminReviewList(HttpSession session, AdminReviewVO arVO, Model model) {
		
		
		
		
		return "/admin/review/reviewBoard";
	}
	
	// �������ȸ
	@RequestMapping(value="/admin_review_detail_form.do", method=RequestMethod.GET)
	public String adminReviewDetailForm(HttpSession session, String reviewId, Model model) {
		
		
		
		
		return "reviewDetail";
	}
	
	// �������
	@RequestMapping(value="/admin_review_delete_process.do", method=RequestMethod.GET)
	public String adminReviewRemoveProcess(HttpSession session, String reviewId, Model model) {
		
		
		// model���� ���� �Ǿ����� �ȵǾ����� flag�־ ����� ���� �ٸ��� alert���� ������������ �ϸ��
		
		return "���ΰ��� �����ϰ� �׳� ���� list��ȸ forward�ɸ� �Ǵ°žƴѰ�?";
	}
	
	
}