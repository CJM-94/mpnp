package kr.co.mpnp.user.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.mpnp.user.domain.MainDomain;
import kr.co.mpnp.user.service.MainService;
import kr.co.mpnp.user.vo.MainVO;


@Controller
public class mainController {
	//����ȭ��
	

	
	@RequestMapping(value="/index.do", method=GET)
	public String main(HttpSession session,Model model,String mainid ) {
		 
	MainService ms = new MainService(); 
	//session.setAttribute("id", "id001");
		 String id=(String)session.getAttribute("id");
	if(id!=null) {
		int cnt=ms.CartTotalCnt(id);
		model.addAttribute("CartCnt", cnt);
	}
		if(mainid==null) {
		 mainid="m0001";
		}
		 List<MainDomain> list =ms.searchPrdList(mainid);

		
				
						
				//view�� ����
				model.addAttribute("prdList",list);
			
		
		System.out.println(session.getAttribute("id"));
		return"user/main/index";
	}
	
	
	//����-> ��ǰ��ü����
	
	@RequestMapping(value="/mainList.do", method=GET)
	public String mainList(HttpSession session,Model model,MainVO mVO) {
		
		MainService ms= new MainService();
		 List<MainDomain> list =
		 ms.searchAllList(mVO); 
		 int cnt=ms.searchPrdCnt(mVO);

		 model.addAttribute("prdList",list);
		 model.addAttribute("cnt", cnt);
		
			//����¡����
			int totalData =ms.searchPrdCnt(mVO);
			int lastPage = ms.lastPage(totalData);
			int curPage = mVO.getPageFlag();
			int startNum = ms.startNum(curPage);
			int isLast = ms.isLast(lastPage, startNum);
					
			//view�� ����
			model.addAttribute("totalData", totalData);
			model.addAttribute("lastPage", lastPage);
			model.addAttribute("startNum", startNum);
			model.addAttribute("isLast", isLast);
			model.addAttribute("curPage", curPage);
		
		
		
		return "user/main/mainList";
	}
	
}
