package kr.co.mpnp.user.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.mpnp.user.domain.ReviewDomain;
import kr.co.mpnp.user.service.ReviewService;
import kr.co.mpnp.user.vo.ReviewVO;

@Controller
public class ReviewController {
	
	// �ۼ����� ����
	@RequestMapping(value="/writable_review_list.do",method=RequestMethod.GET)
	public String writableReviewList(HttpSession session, Model model) {
		
		String id = (String)session.getAttribute("id");
		System.out.println("ReviewController : id - "+id);
		
		ReviewService reviewService = new ReviewService(); 
		
		List<ReviewDomain> writableList = reviewService.searchWritableReview("id001");
		for(ReviewDomain rd : writableList) {
			System.out.println("ReviewController :  - "+rd.getPurchaseDate());
		}
		model.addAttribute("writableList",writableList);
		
		return "/user/review/writable_review";
	}
	
	// �����ۼ� ��
	@RequestMapping(value="/add_review_form.do",method=RequestMethod.GET)
	public String addReviewForm(HttpSession session, String orderDetailId, Model model) {
		
		
		return "";
	}
	
	// �����ۼ�
	@RequestMapping(value="/add_review_process.do",method=RequestMethod.GET)
	public String addReviewProcess(HttpServletRequest request, HttpSession session, Model model) {
		
		
		return "";
	}
	
	/////////////////////////////////////////////////////////
	
	// �ۼ��� ����
	@RequestMapping(value="/writen_review_list.do",method=RequestMethod.GET)
	public String writenReviewList(ReviewVO rVO, HttpSession session, Model model) {
		
		
		return "";
	}
	
	// �ۼ����� �󼼺���   writen_review_detail_form.do ���
	@RequestMapping(value="/modify_review_form.do",method=RequestMethod.GET)
	public String modifyReviewForm(ReviewVO rVO, HttpSession session, Model model) {
		// reviewDetailForm ���
		
		return "";
	}
	
	// �ۼ����� ����
	@RequestMapping(value="/modify_review_process.do",method=RequestMethod.GET)
	public String modifyReviewProcess(HttpServletRequest request, HttpSession session, Model model) {

		
		return "";
	}
	
	// ���� ����
	@RequestMapping(value="/remove_review_process.do",method=RequestMethod.GET)
	public String removeReviewProcess(String reviewId, HttpSession session, Model model) {
		
		
		return "";
	}
	
}
