package kr.co.mpnp.user.service;

import org.apache.ibatis.session.SqlSession;


import kr.co.mpnp.user.domain.MemberDomain;
import kr.co.mpnp.user.vo.MemberVO;


public class  MemberService {
	
	//1. �����-�α���
	public boolean searchLogin(MemberVO mVO) {
		boolean flag=false;
		
		return flag;
		
	}
	
	//3.�����-���̵�ã��
	public MemberDomain searchMemberId(MemberVO mVO) {
		MemberDomain mD=null;
		
		return mD;
	}
	
	
	//4.�����-��й�ȣã��
	public boolean searchMemberPass(MemberVO mVO) {
		boolean flag=false;
		
		return flag;
	}
	
	
	//5.�����-�������
	public int modifyMemberPass(MemberVO mVO) {
		int cnt=0;
		
		return cnt;
	}
	
	
	//6.�����-ȸ��������ȸ
	public MemberDomain searchMemberInfo(MemberVO mVO) {
		MemberDomain mD=null;
		
		return mD;
	}
	
	
	//7.�����-ȸ����������
	public int modifyMemberInfo(MemberVO mVO) {
		int cnt=0;
		return cnt;
		
	}
	
	
	//8.�����-ȸ��Ż��1
	public boolean searchMember(MemberVO mVO) {
		boolean flag=false;
		
		return flag;
	}
	
	
	//9.�����-ȸ��Ż��2
	public int modifyMemberStatus(MemberVO mVO) {
		int cnt=0;
		
		return cnt;
	}
	
	

	public static void main(String[] args) {

	}

}
