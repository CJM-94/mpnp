package kr.co.mpnp.admin.service;

import java.util.List;

import kr.co.mpnp.admin.dao.DashBoardDAO;
import kr.co.mpnp.admin.domain.DashCategoryDomain;
import kr.co.mpnp.admin.domain.DashDailySalesDomain;
import kr.co.mpnp.admin.domain.DashMemberDomain;
import kr.co.mpnp.admin.domain.DashMonthlySalesDomain;

public class DashBoardService {

	// ��޺� ȸ����
	public List<DashMemberDomain> searchMemByGrade() {
		List<DashMemberDomain> list = null;
		
		DashBoardDAO dbDAO = DashBoardDAO.getInstance();
		list = dbDAO.selectMemByGrade();
		
		return list;
	}
	
	// ī�װ��� �Ǹ����� 
	public List<DashCategoryDomain> searchCategorySales(String category) {
		List<DashCategoryDomain> list = null;
		
		DashBoardDAO dbDAO = DashBoardDAO.getInstance();
		list = dbDAO.selectCountByCategory(category);
		
		return list;
	}
	
	// �Ϻ�����
	public List<DashDailySalesDomain> searchDailySales() {
		List<DashDailySalesDomain> list = null;
		
		DashBoardDAO dbDAO = DashBoardDAO.getInstance();
		list = dbDAO.selectDailySales();
		
		return list;
	}
	
	// ��������
	public List<DashMonthlySalesDomain> searchMonthlySales() {
		List<DashMonthlySalesDomain> list = null;
		DashBoardDAO dbDAO = DashBoardDAO.getInstance();
		list = dbDAO.selectMonthlySales();
		return list;
	}
	
}
