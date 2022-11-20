package kr.co.mpnp.admin.service;

import org.apache.ibatis.session.SqlSession;

import kr.co.mpnp.admin.dao.AdminQuitMemberDAO;
import kr.co.mpnp.admin.domain.AdminMemberDomain;

public class AdminQuitMemberService {
	
	public int addQuitMember(String id) {
		int cnt=0;
		
		//status�� 'Ż��'���� ��ȿ�� �˻��ؾ���
		AdminQuitMemberDAO aqmDAO=AdminQuitMemberDAO.getInstance();
		cnt=aqmDAO.insertQuitMember(id);
		
		return  cnt;
	}
	
	public AdminMemberDomain searchQuitMember(String id) {
		
		AdminQuitMemberDAO aqmDAO=AdminQuitMemberDAO.getInstance();
		AdminMemberDomain amDomain=aqmDAO.selectQuitMember(id);
		
		return  amDomain;
	}
	
	

}//class
