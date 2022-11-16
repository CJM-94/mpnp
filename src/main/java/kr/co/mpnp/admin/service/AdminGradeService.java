package kr.co.mpnp.admin.service;

import java.util.List;

import kr.co.mpnp.admin.dao.AdminGradeDAO;
import kr.co.mpnp.admin.domain.AdminGradeDomain;
import kr.co.mpnp.admin.vo.AdminGradeVO;

public class AdminGradeService {
	AdminGradeDAO agDAO = AdminGradeDAO.getInstance();
	public AdminGradeService() {

	}

	// ��ް��� ��ü��ȸ
	public List<AdminGradeDomain> searchGrade() {
		List<AdminGradeDomain> list = null;

//		AdminGradeDAO agDAO = AdminGradeDAO.getInstance();
		 list =agDAO.selectGrade();

		return list;
	}// searchGrade

	// ����߰�
	public int addGrade(AdminGradeVO agVO) {
		int cnt =0;
		
//		AdminGradeDAO agDAO = AdminGradeDAO.getInstance();
		cnt = agDAO.insertGrade(agVO);

		return cnt;

	}// addGrade

	// ��޻󼼺���
	public AdminGradeDomain searchGrade(String gradeID) {
		AdminGradeDomain agDom = null;
		
//		AdminGradeDAO agDAO = AdminGradeDAO.getInstance();
		agDom = agDAO.selectGradeDetail(gradeID);
		
		return agDom;
	}// searchGrade

	// �����������
	public int modifyGradeInfo(AdminGradeVO agVO) {
		int cnt = 0;
		
		cnt = agDAO.updateGradeInfo(agVO);
		
		return  cnt;
	}// modifyGradeInfo

	// ��޻���
	public int removeGrade(AdminGradeVO agVO) {
		int cnt = 0;
		
		cnt = agDAO.updateGrade(agVO);

		return cnt;
	}// modifyGradeInfo

}
