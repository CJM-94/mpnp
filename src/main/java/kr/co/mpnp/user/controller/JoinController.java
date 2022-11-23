package kr.co.mpnp.user.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kr.co.mpnp.user.service.JoinService;
import kr.co.mpnp.user.vo.MemberVO;


@Controller
public class JoinController {
	
	@RequestMapping(value = "/join_terms.do", method=GET )
	public String joinTerms() {
		//�����ž���
		return "user/join/terms";
	}//joinTerms
	
	@RequestMapping(value = "/join_form.do", method=GET )
	public String joinForm() {
		//�����ž���
		return "user/join/signUp";
	}//joinForm
	
	@RequestMapping(value = "/join_idchk_process.do", method=GET )
	public String joinDupChk(String str, Model model) {
		
		return "";
	}//joinDupChk
	
	@RequestMapping(value = "/join_add_process.do", method=POST )
	public String joinAddProcess(HttpServletRequest request, Model model) {
		
		MemberVO mVO=new MemberVO();
		File saveDir=new File("C:/Users/user/git/mpnp/src/main/webapp/upload_pf");
		int maxSize=1024*1024*20;
		
		System.out.println("try ��");
		
		//DB�� �����ʹ� ���µ� ...���丮���� ������ �ȵ��� �ذ�Ϸ� jsp form �±׸� ���ɤ���.. Post������� �޾ƾ��ϴ°͵�
		try {
			System.out.println("try �ٷξƷ�"); 
			MultipartRequest mr=new MultipartRequest(request, saveDir.getAbsolutePath(),
					maxSize,"UTF-8", new DefaultFileRenamePolicy());
			mVO.setPfimg(mr.getFilesystemName("pfimg"));
			
			mVO.setId(mr.getParameter("id"));
			mVO.setPass(mr.getParameter("pass"));
			mVO.setName(mr.getParameter("name"));
			mVO.setPhone(mr.getParameter("phone"));
			mVO.setNick(mr.getParameter("nick"));
			mVO.setStatus(mr.getParameter("status"));
			mVO.setGradeid(mr.getParameter("gradeid"));
			
			model.addAttribute("join",mVO);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
//		mVO.setId(request.getParameter("id"));
//		mVO.setPass(request.getParameter("pass"));
//		mVO.setName(request.getParameter("name"));
//		mVO.setPhone(request.getParameter("phone"));
//		mVO.setNick(request.getParameter("nick"));
//		mVO.setStatus(request.getParameter("status"));
//		mVO.setGradeid(request.getParameter("gradeid"));
		
		
		JoinService js= new JoinService();
		js.addMember(mVO);
		
		
		
//		File savePfImg=new File("E:/dev/workspace_spring/mpnp/src/main/webapp/upload_pfimg");
//		int maxSize=1024*1024*20; //Byte, KB, MB, GB
//		String responseURL="";
//		try {
//			MultipartRequest mr=new MultipartRequest(request, saveDir.getAbsolutePath(),
//					maxSize,"UTF-8", new DefaultFileRenamePolicy());
//			//3.�Ķ���� �ޱ�(VO�� �־���Ѵٸ� VO�� �����Ͽ� �� �ִ´�)
//			UploadVO uVO=new UploadVO();
//			uVO.setUploader(mr.getParameter("uploader"));
//			uVO.setAge(Integer.parseInt(mr.getParameter("age")));
//			uVO.setUpfile(mr.getFilesystemName("upfile"));
//			
//			//JSP���� �Է°��� �����ֱ� ���� model�� VO�� �ִ´�
//			model.addAttribute("viewData",uVO);
//			
//			responseURL="/day1104/upload_success";
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
		
		
		return "user/join/signUp_result";
	}//joinAddProcess
	
	
	

}
