package kr.co.mpnp.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.mpnp.user.domain.SearchDomain;
import kr.co.mpnp.user.service.SearchService;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.text.SimpleDateFormat;
import java.util.List;

@Controller
public class SearchController {
	
	

	
	@RequestMapping(value="/search_prd_list.do", method=GET)
	public String searchPrdList(Model model, String  productname) {
		SearchService ss = new SearchService();
		//�˻����
		List<SearchDomain> list =  ss.searchProduct(productname);
		model.addAttribute( "result",list);
		//����Ʈ5��
		model.addAttribute("best",ss.searchBestFive());

		
		//���糯¥ ���ϱ�
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		model.addAttribute("today", sdf1.format(System.currentTimeMillis()));
		//�˻���� �� ����(���������̼� �ʹ���ƴ�........ )
		int CurrentPage=0; //���߿� �����....
		int totalCount=ss.TotalCnt(productname);
		int pageScale=ss.pageScale();
		int totalPage=ss.totalPage(totalCount, pageScale);
		int startNum=ss.StartNum(CurrentPage, pageScale);
		int endNum= ss.endNum(startNum, pageScale);
		model.addAttribute("cnt",totalCount );
		model.addAttribute("CurrentPage", CurrentPage);
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("pageScale", pageScale);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("startNum", startNum);
		model.addAttribute("endNum", endNum);
		
		
		
		return "user/main/search_result";
	}
	
	
}//class
