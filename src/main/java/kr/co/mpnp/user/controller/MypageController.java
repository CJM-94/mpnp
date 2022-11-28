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

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

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
		
		//System.out.println("���Ǿ��̵�"+session.getAttribute("id"));
		
		return url;
	}//mypageForm
	
	
	//���Ȯ�� �� //�̰� process���� ��������� �׷� ��� ���� ? 
	//hidden�� mdodel ������ �̰� �³�
	@RequestMapping(value = "/mypage_pass_confirm.do", method=GET )
	public String mypagePassForm(HttpSession session, String what, Model model) {
		String id=(String)session.getAttribute("id");
		String url="user/member/login";
		
		
		if(id!=null) {
			MypageService ms=new MypageService();
			MypageDomain md= ms.searchMemberInfo(id);
			model.addAttribute("onlyForPass", md);
//			System.out.println("���ǿ� ���̵�: "+session.getAttribute("id")); //������
//			System.out.println("��"+what); //����
			
			url="user/mypage/pass_confirm";
		}
		
		return url;
	}//mypagePassForm
	
	//���Ȯ�� 
	@RequestMapping(value = "/pass_confirm_process.do", method=POST )
	public String mypagePassProcess(HttpSession session, MypageVO mVO, String what, Model model) {
		//���⼭ ȸ������ ��������, ����������� ������ url ������
		//�װ� ��� �ϴ°ɱ� -> �� ����
		//���� �ڵ� �����ϱ� �������� -> ���ó� ���޴� ���� �־���
		String url="";
		String id=(String) session.getAttribute("id");
		
//		System.out.println("���μ��� ��"+what); //���¤� ��!
		
		//���Ȯ��
		MypageService ms=new MypageService();
		//mVO.setId(id);
		
		//ȸ������ �������� �� �����ֱ�
		MypageDomain md= ms.searchMemberInfo(id);
		mVO.setId(id);
//		System.out.println("myController �ڵ�����ȣ"+md.getPhone());
//		System.out.println("myController ���̵�"+md.getId()); 
//		System.out.println("myController �̸�"+md.getName());
//		System.out.println("myController ����"+md.getPfimg());
//		System.out.println("myController ���"+md.getGradeid());
		
		if("updatePass".equals(what)) {//�������
//			System.out.println("��� �°� ��� ������");
			model.addAttribute("passFind", md);
			url="user/member/pass_modify";
		}else{//ȸ����������
			//("updateMemberInfo".equals(what))
//			System.out.println("��� �°� ȸ������������");
			model.addAttribute("mypage",md);  
			url="user/mypage/mypage_info_modify";
		}
		//�̰��Ұ� 
		
		return url;
	}//mypagePassProcess
	
	//��������� member�� ���� �ȵǳ�? �׷���
	
	
	//ȸ������ ����
	@RequestMapping(value = "/m_info_modify_process.do", method=POST )
	public String mypageModifyProcess(HttpServletRequest request, Model model) {
		
		MypageVO mVO=new MypageVO();
//		System.out.println("ȸ���������� ���̵�!!"+request.getAttribute("id"));//null

		
		File saveDir=new File("C:/Users/user/git/mpnp/src/main/webapp/upload/pfimg");
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
			
//			System.out.println("ȸ���������� pfimg"+mVO.getPfimg());
//			System.out.println("ȸ���������� gid"+mVO.getGradeid());
			model.addAttribute("mypageMain",mVO);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		MypageService ms=new MypageService();
		ms.modifyMemberInfo(mVO);
		
		return "user/mypage/mypage_main";
	}//memberModifyProcess
	
	//ȸ��Ż�� ��
	@RequestMapping(value = "/m_quit_form.do", method=GET )
	public String memberQuitForm(HttpSession session,Model model) {
		String id=(String)session.getAttribute("id");
		MypageService ms=new MypageService();
		MypageDomain md= ms.searchMemberInfo(id);
		
		model.addAttribute("quitMemChk", md);
		return "user/mypage/quitMember";
	}//memberQuitForm
	
	//ȸ��Ż��
	@RequestMapping(value = "/m_quit_process.do", method=POST )
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
		
		return "user/mypage/quitMemberComfirm";
	}//memberQuitProcess
	
	

}//class
