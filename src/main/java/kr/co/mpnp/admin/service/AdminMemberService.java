package kr.co.mpnp.admin.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.co.mpnp.admin.dao.AdminMemberDAO;
import kr.co.mpnp.admin.domain.AdminMemberDomain;
import kr.co.mpnp.admin.vo.AdminMemberVO;


public class AdminMemberService {
	
	//������-ȸ����ȸ
	public List<AdminMemberDomain> searchMember(AdminMemberVO amVO){
		AdminMemberDAO amd=AdminMemberDAO.getInstance();
		List<AdminMemberDomain> list= amd.selectMember(amVO);
		return  list;
	}

	//������-ȸ��������
	public AdminMemberDomain searchMemberDetail(String id){
		
		AdminMemberDAO amDAO=AdminMemberDAO.getInstance();
		AdminMemberDomain amDomain=amDAO.selectMemberDetail(id);
		
		return amDomain;
	}
	
	//������-ȸ������
	public int modifyMember(String id) {
		int cnt=0;
		AdminMemberDAO amDAO=AdminMemberDAO.getInstance();
		cnt=amDAO.updateMember(id);
		
		return cnt;
	}
	
	
	//������-��޺���
	//�Ű������� VO�����°� ���ظ��߾�
	public int modifyMemberGrade(AdminMemberVO amVO) {
		int cnt=0;
		
		AdminMemberDAO amDAO=AdminMemberDAO.getInstance();
		cnt=amDAO.updateMemberGrade(amVO);
		
		return cnt;
	}

}
