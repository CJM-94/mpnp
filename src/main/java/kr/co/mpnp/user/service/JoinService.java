package kr.co.mpnp.user.service;

import kr.co.mpnp.user.dao.MemberDAO;
import kr.co.mpnp.user.vo.MemberVO;


public class  JoinService {
	
	//1.�����-�ߺ�Ȯ��
	public boolean searchDupChk(String id) {
		boolean flag=false;
		
		return flag;
	}
	
	
	//2.�����-ȸ������
	public int addMember(MemberVO mVO) {
		int cnt=0;
		
		MemberDAO mDAO=MemberDAO.getInstance();
		cnt=mDAO.insertMember(mVO);
		
		return cnt;
	}
	
	
}
