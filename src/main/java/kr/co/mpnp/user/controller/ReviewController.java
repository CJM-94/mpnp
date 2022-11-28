package kr.co.mpnp.user.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kr.co.mpnp.user.domain.ReviewDomain;
import kr.co.mpnp.user.service.ReviewService;
import kr.co.mpnp.user.vo.ReviewVO;

@Controller
public class ReviewController {
	
	// �ۼ����� ����
	@RequestMapping(value="/writable_review_list.do",method=RequestMethod.GET)
	public String writableReviewList(HttpSession session, Model model) {
		
		String id = (String)session.getAttribute("id");
		//System.out.println("ReviewController : id - "+id);
		
		ReviewService reviewService = new ReviewService(); 
		// 2022-11-28 ������ ���� ���̵� �׽�Ʈ
		//List<ReviewDomain> writableList = reviewService.searchWritableReview("id005");
		List<ReviewDomain> writableList = reviewService.searchWritableReview(id);
		
		
		
		//System.out.println("�ۼ������� ���� ���� Ȯ�� "+writableList.size());
		//for(ReviewDomain rd : writableList) {
			//System.out.println("ReviewController :  - "+rd.getPurchaseDate());
		//}
		model.addAttribute("writableList",writableList);
		////////////////////////////////////////////////////////////////////////
		
		//List<ReviewDomain> writenList = reviewService.searchWritenReview("id001");
		//model.addAttribute("writenList",writenList);
		
		
		/////////////////////////////////////////////////////////////////////////
		return "/user/review/writable_review";
	}
	
	// �����ۼ� ��
	@RequestMapping(value="/add_review_form.do",method=RequestMethod.POST)
	public String addReviewForm(HttpSession session, String orderDetailId,String name, String thImg, Model model) {
		
		//System.out.println(orderDetailId+" / "+name+" / "+thImg);
		
		model.addAttribute("odId",orderDetailId);
		model.addAttribute("prdName",name);
		model.addAttribute("prdImg",thImg);
		
		//return "/user/review/write_review";
		return "/user/review/write_review";
	}
	
	// �����ۼ�
	@RequestMapping(value="/add_review_process.do",method=RequestMethod.POST)//post
	public String addReviewProcess(HttpServletRequest request, HttpSession session, Model model) throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		
		//File saveDir = new File("E:/dev/workspace_spring/upfileTest/"); // �����ξ��
		File saveDir = new File("E:/dev/workspace_spring/mpnp/src/main/webapp/upload/review/"); // �����ξ��
		
		int maxSize = 1024 * 1024 * 20 ; // byte * kb * mb * gb
		String responseURL = "/day1104/upload_err";
		
		String reviewMsg = "";
		String reviewUrl = "";
		try {
			// MultipartRequest,,,?
			MultipartRequest mr = new MultipartRequest(request, saveDir.getAbsolutePath(),
					maxSize,"UTF-8",new DefaultFileRenamePolicy());
			// 3. �Ķ���͸� �޴´�. ( VO�� �־���Ѵٸ� VO�� ��üȭ�Ͽ� setter�� �־��ش� )
			/////////////////////////////////////////////
			List<String> imgList = new ArrayList<String>();
			Enumeration name = mr.getFileNames();
			while(name.hasMoreElements()) {
				String testname = (String)name.nextElement();
				//System.out.println("file�±׵��� �̸� : "+testname);
				String fileName = mr.getFilesystemName(testname);
				if(fileName!=null) {
					imgList.add(fileName);
				}
				//System.out.println("file�±׵��� �̸����� upload�� ���ϸ� : "+fileName);
			}
			
			String odId = mr.getParameter("orderDetailId");
			String contents = mr.getParameter("reviewContents");
			//System.out.println("������ contents"+contents);
			//contents = contents.replace("\r\n","<br>");
			//System.out.println("������ contents"+contents);
			String starScore = mr.getParameter("starScore");
			//System.out.println("odId : "+odId);
			//System.out.println("contents : "+contents);
			//System.out.println("starScore : "+starScore);
			
			// 2022-11-28 ������ ���� ���̵� �׽�Ʈ
			String id = (String)session.getAttribute("id");
			//String id = "id005";
			
			ReviewVO rVO = new ReviewVO();
			rVO.setId(id);
			rVO.setContents(contents);
			rVO.setOrderDetailId(odId);
			//rVO.setOrderDetailId("od_0000001");
			rVO.setStarScore(Integer.parseInt(starScore));
			rVO.setReviewImg(imgList);
			
			
			ReviewService rService = new ReviewService();
			boolean addFlag = rService.addReview(rVO);
			
			if(addFlag) {
				reviewMsg = "�ı��ۼ��� �Ϸ��ϼ̽��ϴ�.";
				reviewUrl = "writable_review_list.do";
			}else {
				reviewMsg = "�ı��ۼ� �� ������ �߻��߽��ϴ�. ��� �� �ٽ� �õ����ּ���.";
				reviewUrl = "writable_review_list.do";
			}
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		model.addAttribute("reviewMsg",reviewMsg);
		model.addAttribute("reviewUrl",reviewUrl);
		
		return "/user/review/write_review_alert";
	}
	
	
	// �������̵� alert �׽�Ʈ
//	@RequestMapping(value="/add_review_processt_testttttttt.do",method=RequestMethod.GET)//post
//	public String addReviewProcessTesttttttttttt(Model model) {
//		boolean addFlag = true;
//		String reviewMsg = "";
//		String reviewUrl = "";
//		if(addFlag) {
//			reviewMsg = "�ı��ۼ��� �Ϸ��ϼ̽��ϴ�.";
//			reviewUrl = "writable_review_list.do";
//		}else {
//			reviewMsg = "�ı��ۼ� �� ������ �߻��߽��ϴ�. ��� �� �ٽ� �õ����ּ���.";
//			reviewUrl = "writable_review_list.do";
//		}
//		System.out.println(reviewMsg);
//		System.out.println(reviewUrl);
//		model.addAttribute("reviewMsg",reviewMsg);
//		model.addAttribute("reviewUrl",reviewUrl);
//		return "/user/review/write_review_alert";
//		
//	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	// ���Ͼ��ε� �׽�Ʈ�� �޼��� ������ 11-23
//	@RequestMapping(value="/add_review_process_test.do",method=RequestMethod.POST)//post
//	public String addReviewProcessTest(HttpServletRequest request, HttpSession session, Model model) throws UnsupportedEncodingException {
//		request.setCharacterEncoding("UTF-8");
//		
//		File saveDir = new File("E:/dev/workspace_spring/upfileTest/"); // �����ξ��
//		int maxSize = 1024 * 1024 * 20 ; // byte * kb * mb * gb
//		String responseURL = "/day1104/upload_err";
//		//////
//		
//		try {
//			// MultipartRequest,,,?
//			MultipartRequest mr = new MultipartRequest(request, saveDir.getAbsolutePath(),
//					maxSize,"UTF-8",new DefaultFileRenamePolicy());
//			
//			/////////////////////////////////////////////
//			Enumeration name = mr.getFileNames();
//			while(name.hasMoreElements()) {
//				String testname = (String)name.nextElement();
//				System.out.println("file�±׵��� �̸� : "+testname);
//				String fileName = mr.getFilesystemName(testname);
//				System.out.println("file�±׵��� �̸����� upload�� ���ϸ� : "+fileName);
//			}
//			//System.out.println(name);
//			//////////////////////////////////////
//			// �������� ����?? �����µ�?
//			
//		}catch(IOException e) {
//			e.printStackTrace();
//		}
//		
//		return "";
//		
//	}
	
	/////////////////////////////////////////////////////////
	
	// �ۼ��� ����
	@RequestMapping(value="/writen_review_list.do",method=RequestMethod.GET)
	public String writenReviewList(ReviewVO rVO, HttpSession session, Model model) {
		
		String id = (String)session.getAttribute("id");
		//System.out.println("ReviewController : id - "+id);
		
		ReviewService reviewService = new ReviewService(); 
		// 2022-11-28 ������ ���� ���̵� �׽�Ʈ
		//List<ReviewDomain> writenList = reviewService.searchWritenReview("id005");
		List<ReviewDomain> writenList = reviewService.searchWritenReview(id);
		
		
		//System.out.println("�ۼ��Ѹ��� ���� Ȯ�� "+writenList.size());
		///////////////////////////////////
		// ��¥ ���Ĺٲٱ� �׽�Ʈ
		/////////////////////////////////
		//for(ReviewDomain rd : writenList) {
			//System.out.println("ReviewController : �ۼ��Ѹ��� - "+rd.getWriteDate());
		//}
		model.addAttribute("writenList",writenList);
		
		return "/user/review/writen_review";
	}
	
	// �ۼ����� �󼼺���   
	@RequestMapping(value="/writen_review_detail_form.do",method=RequestMethod.GET)
	public String reviewDetailForm(String selReviewId, HttpSession session, Model model) {
		//System.out.println("�Գ�"+selReviewId);
		
		// ���ݹ����ɷ� ��ǰ����, ��ǰ��, ����, ����, �̹����� �޾ƿ;���
		ReviewService reviewService = new ReviewService(); 
		
		ReviewDomain rDomain = reviewService.searchReviewDetail(selReviewId);
		// �׳� �����������ϰ��ұ� ;;;;;;;;;;;;;;;;;;;
		//System.out.println("ReviewController : 239 ���� : "+rDomain);
		model.addAttribute("reviewDetail",rDomain);
		return "/user/review/writen_review_edit_impossible";
	}
	
	// �ۼ����� ����
//	@RequestMapping(value="/modify_review_process.do",method=RequestMethod.GET)
//	public String modifyReviewProcess(HttpServletRequest request, HttpSession session, Model model) {
//
//		// ����
//		
//		return "";
//	}
	
	// ���� ����
	@ResponseBody
	@RequestMapping(value="/remove_review_process.do",method=RequestMethod.GET)
	public String removeReviewProcess(String selReviewId, HttpSession session, Model model) {
		//System.out.println("���� selReviewId : "+selReviewId);
		ReviewService reviewService = new ReviewService(); 
		return reviewService.removeReview(selReviewId);
	}
	
}
