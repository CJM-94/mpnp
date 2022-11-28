package kr.co.mpnp.user.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.mpnp.user.domain.DestinationDomain;
import kr.co.mpnp.user.service.DestinationService;
import kr.co.mpnp.user.vo.DestinationVO;

@Controller
public class DestinationContoller {

	// ���������Ʈ ��ȸ
	@RequestMapping(value="/des_list.do", method=RequestMethod.GET)
	public String desList(HttpSession session, Model model) {
		
		String id = (String)session.getAttribute("id");
		System.out.println("DestinationController : id - "+id);
		
		DestinationService desService = new DestinationService(); 
		// 2022-11-28 ������ ���� ���̵� �׽�Ʈ
		//List<DestinationDomain> desList = desService.searchDes("test1126");
		List<DestinationDomain> desList = desService.searchDes(id);
		
		
		//for(DestinationDomain dd : desList) {
			//System.out.println("DestinationContoller : destinationId - "+dd.getDestinationId());
			//System.out.println("DestinationContoller : destinationId - "+dd.getDefaultFlag());
		//}
		model.addAttribute("desList",desList);
		
		
		return "/user/mypage/delivery";
	}
	
	// ����� �߰�
	@ResponseBody
	@RequestMapping(value="/des_add_process.do", method=RequestMethod.GET)
	public String desAddProcess(HttpSession session, DestinationVO dtVO, Model model) {
		
		//System.out.println(dtVO.toString());
		//String id = "id005";
		// 2022-11-28 ������ ���� ���̵� �׽�Ʈ
		String id = (String)session.getAttribute("id");
		//dtVO.setId("test1126");
		dtVO.setId(id);
		
		//System.out.println("������߰� ����Ʈ�÷��� : "+dtVO.getDefaultFlag());
		
		DestinationService desService = new DestinationService(); 
		//desService.addDes(dtVO);
		//if("O".equals(dtVO.getDefaultFlag())) {
//			desService.editDefault(dtVO);
		//} Ʈ�����ó�� �׽�Ʈ�Ϸ��� ����  �����ϸ� ��Ǯ����
		
		
		//return "des_list.do";
		return desService.addDes(dtVO);
	}
	
	// ����� ��������
	@ResponseBody
	@RequestMapping(value="/des_modify_process.do", method=RequestMethod.GET)
	public String desLModifyProcess(HttpSession session, DestinationVO dtVO, Model model) {
		
		
		// 2022-11-28 ������ ���� ���̵� �׽�Ʈ
		String id = (String)session.getAttribute("id");
		dtVO.setId(id);
		//dtVO.setId("test1126");
		//System.out.println("������������� dtVO : "+dtVO.toString());
		//System.out.println("��������� ����Ʈ�÷���  : "+dtVO.getDefaultFlag());
		
		DestinationService desService = new DestinationService(); 
		//if("O".equals(dtVO.getDefaultFlag())) {
//			desService.editDefault(dtVO);
		//} Ʈ�����ó�� �׽�Ʈ�Ϸ��� ����  �����ϸ� ��Ǯ����
		
		return desService.modifyDes(dtVO);
	}
	
	// ����� ����
	@ResponseBody
	@RequestMapping(value="/des_remove_process.do", method=RequestMethod.GET)
	public String desRemoveProcess(HttpSession session, String dtId, Model model) {
		
		DestinationService desService = new DestinationService(); 
		return desService.removeDes(dtId);
	}
	
	
}
