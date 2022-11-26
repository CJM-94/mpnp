package kr.co.mpnp.user.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kr.co.mpnp.user.dao.MypageDAO;
import kr.co.mpnp.user.domain.MypageDomain;
import kr.co.mpnp.user.service.MypageService;
import kr.co.mpnp.user.vo.MypageVO;

@Controller
public class MypageController {
	
	//���������� ����
	@RequestMapping(value = "/mypage_form.do", method=GET )
	public String mypageForm(HttpSession session, Model model) {
		boolean flag=false;
		
		String	url="user/member/login";//�α��� �������� �α���â���� ������
		
		flag=session.getAttribute("id")!=null?true:false; //���� ?�̰� �Ҹ��� �ȴٰ�? �ٺ���...���� �������ݾ� ...
		
		//System.out.println("���� id "+session.getAttribute("id")); //��
		String id=(String) session.getAttribute("id");
		
		if(flag) {//�α��� ���� ��
			url="user/mypage/mypage_main";
			MypageService ms=new MypageService();
			MypageDomain md=ms.searchMypageMember(id);
			model.addAttribute("mypageMain",md);
		}
		
		System.out.println("���Ǿ��̵�"+session.getAttribute("id"));
		
		return url;
	}//mypageForm
	
	
	
//	//���Ȯ�� �� //��������
//	@RequestMapping(value = "/mypage_pass_confirm.do", method=GET )
//	public String mypagePassForm(HttpSession session) {
//		session.getAttribute("id");
//		System.out.println("���ǿ� ���̵�: "+session.getAttribute("id")); //������
//		
//		return "user/mypage/pass_confirm";
//	}//mypagePassForm
	
	
	//���Ȯ�� �� //�̰� process���� ��������� �׷� ��� ���� ? 
	//hidden�� mdodel ������ �̰� �³�
	@RequestMapping(value = "/mypage_pass_confirm.do", method=GET )
	public String mypagePassForm(HttpSession session, String what, Model model) {
		String id=(String)session.getAttribute("id");
		MypageService ms=new MypageService();
		MypageDomain md= ms.searchMemberInfo(id);
		
		model.addAttribute("onlyForPass", md);
		
		System.out.println("���ǿ� ���̵�: "+session.getAttribute("id")); //������
		
		System.out.println("��"+what); //����
		
		//String url="user/mypage/pass_confirm_Pass";
		//if("updateMemberInfo".equals(what)) { //ȸ������ ���� ������ ��
			//System.out.println("����");
			//url="user/mypage/pass_confirm_MemberInfo";
		//} �̰� ���⼭ ó���ϴ� �� �ƴ�. ���� �޾ƿ��� process���� ������ ������
			
		
		return "user/mypage/pass_confirm";
	}//mypagePassForm
	
	//���Ȯ�� 
	@RequestMapping(value = "/pass_confirm_process.do", method=GET )
	public String mypagePassProcess(HttpSession session, MypageVO mVO, String what, Model model) {
		//���⼭ ȸ������ ��������, ����������� ������ url ������
		//�װ� ��� �ϴ°ɱ� �� ����
		//���� �ڵ� �����ϱ� ��������
		String url="";
		
		System.out.println("���μ��� ��"+what); //���¤� ��!
		
		//���Ȯ��
		MypageService ms=new MypageService();
		String id=(String) session.getAttribute("id");
		mVO.setId(id);
		
		
		//ȸ������ �������� �� �����ֱ�
		MypageDomain md= ms.searchMemberInfo(id);
		System.out.println("myController �ڵ�����ȣ"+md.getPhone());
		System.out.println("myController �̸�"+md.getName());
		System.out.println("myController ���̵�"+md.getId());
		model.addAttribute("mypage",md);  
		
		boolean passChkFlag= ms.searchPass(mVO); // ������ ��� �޶� ����. ó���ϱ� 
		
		System.out.println(ms.searchPass(mVO));
		
		if("updatePass".equals(what)) {//�������
			System.out.println("��� �°� ��� ������");
			model.addAttribute("passFind", md);
			url="user/member/pass_modify";
		}else{//ȸ����������
			//("updateMemberInfo".equals(what))
			System.out.println("��� �°� ȸ������������");
			url="user/mypage/mypage_info_modify";
		}
		//�̰��Ұ� 
//		if(!passChkFlag) {  
//			url=ms.searchPass(mVO); //�� �ι� ����Ǵ°ž� ? 
//			System.out.println("��� �Ϻη� Ʋ������ "); //���´�
//		}else if("updatePass".equals(what)) {//�������
//			System.out.println("��� �°� ��� ������");
//			url="user/member/pass_modify";
//		}else{//ȸ����������
//			//("updateMemberInfo".equals(what))
//			System.out.println("��� �°� ȸ������������");
//			url="user/mypage/mypage_info_modify";
//		}
		
//		
		//if(!passChkFlag) {
//			url=ms.searchPass(mVO); //����� alertâ ������ �ϸ� ajax�� ó���ؾ��ϳ� .. json Service���� �ϰ�?
//		}
		
		return url;
	}//mypagePassProcess
	
	//��������� member�� ���� �ȵǳ�? �׷���
	
//	//ȸ������ ���� ��!!
//	@RequestMapping(value = "/m_info_modify_form.do", method=GET )
//	public String mypageModifyForm(HttpServletRequest request, Model model) {
//		
//		return "";
//	}
	
	
	//ȸ������ ����
	@RequestMapping(value = "/m_info_modify_process.do", method=POST )
	public String mypageModifyProcess(HttpServletRequest request, Model model) {
		
		MypageVO mVO=new MypageVO();
		System.out.println("ȸ���������� ���̵�!!"+request.getAttribute("id"));//null

		
		File saveDir=new File("C:/Users/user/git/mpnp/src/main/webapp/upload_pf");
		int maxSize=1024*1024*20;
		
		
		try {
			MultipartRequest mr=new MultipartRequest(request, saveDir.getAbsolutePath(),
					maxSize,"UTF-8", new DefaultFileRenamePolicy());
			mVO.setPfimg(mr.getFilesystemName("pfimg"));
			mVO.setId(mr.getParameter("id"));
			mVO.setPass(mr.getParameter("pass"));
			mVO.setName(mr.getParameter("name"));
			mVO.setPhone(mr.getParameter("phone"));
			mVO.setNick(mr.getParameter("nick"));
			mVO.setGradeid(mr.getParameter("gradeid"));
			
			System.out.println("ȸ���������� pfimg"+mVO.getPfimg());
			System.out.println("ȸ���������� gid"+mVO.getGradeid());
			model.addAttribute("mypageMain",mVO);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		MypageService ms=new MypageService();
		ms.modifyMemberInfo(mVO);
		
//		mVO.setPfimg(request.getParameter("pfimg"));
//		mVO.setId(request.getParameter("id"));
//		mVO.setPass(request.getParameter("pass"));
//		mVO.setName(request.getParameter("name"));
//		mVO.setPhone(request.getParameter("phone"));
//		mVO.setNick(request.getParameter("nick"));
//		
//		System.out.println(request.getParameter("pfimg"));
//		System.out.println(request.getParameter("id"));
//		System.out.println(request.getParameter("pass"));
//		System.out.println(request.getParameter("name"));
//		System.out.println(request.getParameter("phone"));
//		System.out.println(request.getParameter("nick"));
		
		return "user/mypage/mypage_main";
	}//memberModifyProcess
	
	//ȸ��Ż�� ��
	@RequestMapping(value = "/m_quit_form.do", method=GET )
	public String memberQuitForm() {
		
		return "user/mypage/quitMember";
	}//memberQuitForm
	
	//ȸ��Ż��
	@RequestMapping(value = "/m_quit_process.do", method=GET )
	public String memberQuitProcess(HttpSession session, MypageVO mVO, Model model) {
		
		MypageService ms=new MypageService();
		//���̵�,����� �´��� Ȯ��
		String id=(String) session.getAttribute("id");
		mVO.setId(id);
		ms.searchMember(mVO);
		
		//Ż����� update
		ms.modifyMemberStatus(mVO);
		
		//Ż�����̺� insert
		ms.addQuitMember(mVO);
		
		model.addAttribute("passChk",mVO);
		
		
		return "user/mypage/quitMemberComfirm";
	}//memberQuitProcess
	
	

}//class
