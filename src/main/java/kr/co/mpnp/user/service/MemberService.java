package kr.co.mpnp.user.service;

import org.apache.ibatis.session.SqlSession;

import kr.co.mpnp.user.dao.MemberDAO;
import kr.co.mpnp.user.domain.MemberDomain;
import kr.co.mpnp.user.vo.MemberVO;


public class  MemberService {
	
	//�����-�α���
	public boolean searchLogin(MemberVO mVO) {
		boolean flag=false;
		
		MemberDAO mDAO=MemberDAO.getInstance();
		flag=mDAO.selectLogin(mVO);
		
		return flag;
		
	}
	
	//�����-���̵�ã��
	public MemberDomain searchMemberId(MemberVO mVO) {
		MemberDomain md=null;
		
		MemberDAO mDAO=MemberDAO.getInstance();
		md=mDAO.selectMemberId(mVO);
		
		return md;
	}
	
	
	//�����-��й�ȣã��
	public MemberDomain searchMemberPass(MemberVO mVO) {
		MemberDomain md=null;
		
		MemberDAO mDAO=MemberDAO.getInstance();
		md=mDAO.selectMemberPass(mVO);
		
		return md;
	}
	
	
	//�����-�������
	public int modifyMemberPass(MemberVO mVO) {
		int cnt=0;
		
		MemberDAO mDAO=MemberDAO.getInstance();
		cnt=mDAO.updateMemberPass(mVO);
		
		return cnt;
	}
	
	
	
}
