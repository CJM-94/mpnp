package kr.co.mpnp.user.dao;

import org.apache.ibatis.session.SqlSession;

import kr.co.mpnp.handler.MyBatisHandler;
import kr.co.mpnp.user.domain.MemberDomain;
import kr.co.mpnp.user.vo.MemberVO;


public class MemberDAO {
	private static MemberDAO mDAO;
	
	private MemberDAO() {
			
	}

	public static MemberDAO getInstance(){
			if(mDAO==null) {
				mDAO= new MemberDAO();
			}
			return mDAO;
	}
	
	
	//1. �����-�α���
	public boolean selectLogin(MemberVO mVO) {
		boolean flag=false;
		
		return flag;
		
	}
	
	//1.�����-�ߺ�Ȯ��
	public boolean selectDupChk(String id) {
		boolean flag=false;
		
		return flag;
	}
	
	
	//2.�����-ȸ������
	public int insertMember(MemberVO mVO) {
		//1.MyBatis Handler���
				MyBatisHandler mbh=MyBatisHandler.getInstance();
				SqlSession ss=mbh.getHandler();
				
				//2.����������
				int cnt=ss.insert("kr.co.mpnp.user.dao.mapper.memberMapper.insertMember",mVO);
				if(cnt!=0) {
					System.out.println("");
					ss.commit();//�� �̰� �������� .... 
				}else {
					System.out.println("�����Ͽ����ϴ�");
				}
				//cnt �׽�Ʈ
				System.out.println(cnt+"��");
				
				//3.MyBatis Handler ����
				mbh.closeHandler(ss);
				
				return cnt;
	}
	
	
	//3.�����-���̵�ã��
	public MemberDomain selectMemberId(MemberVO mVO) {
		MemberDomain mD=null;
		
		return mD;
	}
	
	
	//4.�����-��й�ȣã��
	public boolean selectMemberPass(MemberVO mVO) {
		boolean flag=false;
		
		return flag;
	}
	
	
	//5.�����-�������
	public int updateMemberPass(MemberVO mVO) {
		//1.MyBatis Handler���
		MyBatisHandler mbh=MyBatisHandler.getInstance();
		SqlSession ss=mbh.getHandler();
		
		//2.����������
		int cnt=ss.update("kr.co.mpnp.user.dao.mapper.memberMapper.updateMemberPass",mVO);
		if(cnt!=0) {
			System.out.println("");
			ss.commit();//�� �̰� �������� .... 
		}else {
			System.out.println("�����Ͽ����ϴ�");
		}
		//cnt �׽�Ʈ
		System.out.println(cnt+"��");
		
		//3.MyBatis Handler ����
		mbh.closeHandler(ss);
		
		return  cnt;
	}
	
	
	//6.�����-ȸ��������ȸ
	public MemberDomain selectMemberInfo(MemberVO mVO) {
		MemberDomain mD=null;
		
		return mD;
	}
	
	
	//7.�����-ȸ����������
	public int updateMemberInfo(MemberVO mVO) {
		//1.MyBatis Handler���
		MyBatisHandler mbh=MyBatisHandler.getInstance();
		SqlSession ss=mbh.getHandler();
		
		//2.����������
		int cnt=ss.update("kr.co.mpnp.user.dao.mapper.memberMapper.updateMemberInfo",mVO);
		if(cnt!=0) {
			System.out.println("");
			ss.commit();//�� �̰� �������� .... 
		}else {
			System.out.println("�����Ͽ����ϴ�");
		}
		//cnt �׽�Ʈ
		System.out.println(cnt+"��");
		
		//3.MyBatis Handler ����
		mbh.closeHandler(ss);
		
		return cnt;
		
	}
	
	
	//8.�����-ȸ��Ż��1
	public boolean selectMember(MemberVO mVO) {
		boolean flag=false;
		
		return flag;
	}
	
	
	//9.�����-ȸ��Ż��2
	public int updateMemberStatus(MemberVO mVO) {
		//1.MyBatis Handler���
		MyBatisHandler mbh=MyBatisHandler.getInstance();
		SqlSession ss=mbh.getHandler();
		
		//2.����������
		int cnt=ss.update("kr.co.mpnp.user.dao.mapper.memberMapper.updateMemberStatus",mVO);
		if(cnt!=0) {
			System.out.println("");
			ss.commit();//�� �̰� �������� .... 
		}else {
			System.out.println("�����Ͽ����ϴ�");
		}
		//cnt �׽�Ʈ
		System.out.println(cnt+"��");
		
		//3.MyBatis Handler ����
		mbh.closeHandler(ss);
		
		return cnt;
	}
	
	

	public static void main(String[] args) {

	}

}
