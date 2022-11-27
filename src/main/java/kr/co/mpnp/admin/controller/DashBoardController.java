package kr.co.mpnp.admin.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.mpnp.admin.domain.DashCategoryDomain;
import kr.co.mpnp.admin.domain.DashDailySalesDomain;
import kr.co.mpnp.admin.domain.DashMemberDomain;
import kr.co.mpnp.admin.domain.DashMonthlySalesDomain;
import kr.co.mpnp.admin.service.DashBoardService;

@Controller
public class DashBoardController {

	@RequestMapping(value="/dashboard_main.do",method=RequestMethod.GET)
	public String dashBoard(HttpSession session, Model model) {
		
		DashBoardService dbService = new DashBoardService();
		
		List<DashMemberDomain> memberList = dbService.searchMemByGrade();
		List<DashCategoryDomain> dogList  = dbService.searchCategorySales("������");
		List<DashCategoryDomain> catList  = dbService.searchCategorySales("�����");
		List<DashDailySalesDomain> dailyList = dbService.searchDailySales();
		List<DashMonthlySalesDomain> monthlyList = dbService.searchMonthlySales();
		
		//for(DashMemberDomain dd : listMember) {
			//System.out.println("��ú��� ��Ʈ�ѷ� �׽�Ʈ�� : "+dd.getMinPrice());
		//}
		//for(DashDailySalesDomain ddd : dailyList) {
			//System.out.println("��ú��� ��Ʈ�ѷ� �׽�Ʈ�� : "+ddd.toString());
		//}
		//for(DashMonthlySalesDomain dmd : monthlyList) {
			//System.out.println("��ú��� ��Ʈ�ѷ� �׽�Ʈ�� : "+dmd.toString());
		//}
		//for(DashCategoryDomain dcd : dogList) {
			//System.out.println("��ú��� ��Ʈ�ѷ� �׽�Ʈ�� ������ : "+dcd.toString());
		//}
		//for(DashCategoryDomain dcd : catList) {
			//System.out.println("��ú��� ��Ʈ�ѷ� �׽�Ʈ�� ����� : "+dcd.toString());
		//}
		
		model.addAttribute("memberList",memberList);
		model.addAttribute("dogList",dogList);
		model.addAttribute("catList",catList);
		model.addAttribute("dailyList",dailyList);
		model.addAttribute("monthlyList",monthlyList);
		
		
		return "/admin/dashboard/dashboard";
	}
	
}
