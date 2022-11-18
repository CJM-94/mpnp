package kr.co.mpnp.admin.dao;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import kr.co.mpnp.admin.domain.AdminGradeDomain;
import kr.co.mpnp.admin.vo.AdminGradeVO;
import kr.co.mpnp.handler.MyBatisHandler;

//����
public class AdminGradeDAO {
	private static AdminGradeDAO agDAO;

	// �̱���
	private AdminGradeDAO() {

	}// AdminOrderDAO

	public static AdminGradeDAO getInstance() {
		if (agDAO == null) {
			agDAO = new AdminGradeDAO();
		}

		return agDAO;
	}// getInstance()

//////////////////////////////////////////////////////////////////////////////////
	//����
	// ��� ��ü��ȸ
	public List<AdminGradeDomain> selectGrade() {
		List<AdminGradeDomain> list = null;

		// MyBatisHandler���
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getHandler();
		// ���� ����
		list = ss.selectList("kr.co.mpnp.gradeMapper.selectGrade");

		for (AdminGradeDomain aod : list) {
			System.out.println(aod);
		}

		// �������
		mbh.closeHandler(ss);

		return list;
	}// selectGrade

//////////////////////////////////////////////////////////////////////////////////
	//����
	// ����߰�
	public int insertGrade(AdminGradeVO agVO) {
		int cnt = 0;

		// MyBatisHandler���
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getHandler();

		// ��������
		cnt = ss.insert("kr.co.mpnp.gradeMapper.insertGrade", agVO);
		if (cnt == 1) {
			ss.commit();
			System.out.println(cnt + "�߰�");
		} else {
			System.out.println("��� �߰� ����");
		}
		// �������
		mbh.closeHandler(ss);

		return cnt;
	}// insertGrade

//////////////////////////////////////////////////////////////////////////////////
	//����
	// ��޻󼼺���(����ڵ�)
	public AdminGradeDomain selectGradeDetail(String gId) {
		AdminGradeDomain agDom = null;

		// MyBatisHandler���
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getHandler();

		try {
			agDom = ss.selectOne("kr.co.mpnp.gradeMapper.selectGradeDetail", gId);
			System.out.println(agDom);
		} catch (PersistenceException pe) {
			pe.printStackTrace();
		}

		// �������
		mbh.closeHandler(ss);

		return agDom;
	}// selectGrade

	//////////////////////////////////////////////////////////////////////////////////
	// �����������
	public int updateGradeInfo(AdminGradeVO agVO) {
		int cnt = 0;
		
		// MyBatisHandler���
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getHandler();
		
		cnt = ss.update("kr.co.mpnp.gradeMapper.updateGradeInfo",agVO);
		if(cnt==1) {
			ss.commit();
			System.out.println(cnt+"�� ����Ǿ����ϴ�");
		}
		// �������
		mbh.closeHandler(ss);

		return cnt;
	}// updateGradeInfo

//////////////////////////////////////////////////////////////////////////////////
	//������
	// ��޻���(��޺���)
	public int updateGrade(AdminGradeVO agVO) {
		int cnt = 0;
		
		// MyBatisHandler���
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getHandler();
		
		cnt = ss.update("kr.co.mpnp.gradeMapper.updateGrade",agVO);
		if(cnt==1) {
			ss.commit();
			System.out.println(cnt+"�� ����Ǿ����ϴ�");
		}
		// �������
		mbh.closeHandler(ss);		
		

		return cnt;
	}// updateGrade

	  public static void main(String[] args) { 
		AdminGradeDAO ag = new AdminGradeDAO(); 
	  // AdminGradeVO aVO = new AdminGradeVO();
	  //aVO.setGradeName("VVIP");
	 // aVO.setGradeId("G4");
	  //ag.selectGradeDetail("G1");
	 
	  
	 // ag.updateGrade(aVO);
	  
	  }//main

}// class
