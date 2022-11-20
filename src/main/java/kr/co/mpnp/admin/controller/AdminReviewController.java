package kr.co.mpnp.admin.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.mpnp.admin.domain.AdminReviewDomain;
import kr.co.mpnp.admin.service.AdminReviewService;
import kr.co.mpnp.admin.vo.AdminReviewVO;

@Controller
public class AdminReviewController {
	
	// ���丮��Ʈ��ȸ
	@RequestMapping(value="/admin_review_list.do", method=RequestMethod.GET)
	public String adminReviewList(HttpSession session, AdminReviewVO arVO, Model model) {
		boolean loginFlag = false;
		// session�� ���̵� null�� �ƴϾ����
		loginFlag = session.getAttribute("id")!=null?true:false;
		System.out.println("AdminReviewController : "+arVO.toString());
		
		List<AdminReviewDomain> list = null;
		//if(loginFlag) {
			AdminReviewService arService = new AdminReviewService();
			
			list = arService.searchReviewList(arVO);
		//}
		System.out.println("Ȯ�ο� : "+list);
		model.addAttribute("reviewList",list);
			
		return "/admin/review/reviewBoard";
	}
	
	// �������ȸ
	@RequestMapping(value="/admin_review_detail_form.do", method=RequestMethod.GET)
	public String adminReviewDetailForm(HttpSession session, String reviewId, Model model) {
		
		boolean loginFlag = false;
		loginFlag = session.getAttribute("id")!=null?true:false;
		
		System.out.println(reviewId);
		
		//if(loginFlag) {
			AdminReviewService arService = new AdminReviewService();
			
			AdminReviewDomain reviewDetail = arService.searchReviewDetail(reviewId);
		//}
		System.out.println("Ȯ�ο� : "+reviewDetail);
		model.addAttribute("reviewDetail",reviewDetail);
		
		return "/admin/review/reviewDetail";
	}
	
	// �������
	@ResponseBody
	@RequestMapping(value="/admin_review_delete_process.do", method=RequestMethod.GET)
	public String adminReviewRemoveProcess(HttpSession session, String reviewId, Model model) {
		
		System.out.println("�Ѿ�����ϳ� "+reviewId);
		AdminReviewService arService = new AdminReviewService();
		return arService.removeReview(reviewId);
		//if(arService.removeReview(reviewId)) { // ������ �ƴ� alert�� ��� ���ǵ� AJAX...?
			
		//}
		
		//return "forward:admin_review_list.do";
	}
	
	
}