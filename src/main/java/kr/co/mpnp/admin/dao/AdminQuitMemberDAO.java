package kr.co.mpnp.admin.dao;

import org.apache.ibatis.session.SqlSession;

import kr.co.mpnp.admin.domain.AdminMemberDomain;
import kr.co.mpnp.handler.MyBatisHandler;

public class  AdminQuitMemberDAO {
	private static AdminQuitMemberDAO aqmDAO;
	
	private AdminQuitMemberDAO() {
			
	}

	public static AdminQuitMemberDAO getInstance(){
			if(aqmDAO==null) {
				aqmDAO= new AdminQuitMemberDAO();
			}
			return aqmDAO;
	}
	
	
	public int insertQuitMember(String id) {
		//1.MyBatis Handler���
		MyBatisHandler mbh=MyBatisHandler.getInstance();
		SqlSession ss=mbh.getHandler();
		System.out.println("Ż���Ϸ��� ȸ�� "+id);
		
		//2.����������
		int cnt=ss.insert("kr.co.mpnp.adminMemberMapper.insertQuitMember",id);
		if(cnt!=0) {
			System.out.println("���̵�: "+id+" Ż��ȸ������ ���Դ�");
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
	
	
	public AdminMemberDomain selectQuitMember(String id) {
		//1.MyBatis Handler���
		AdminMemberDomain amd=null;
		MyBatisHandler mbh=MyBatisHandler.getInstance();
		SqlSession ss=mbh.getHandler();
		
		//2.����������
		amd=ss.selectOne("kr.co.mpnp.adminMemberMapper.selectQuitMember",id);

		//3.MyBatis Handler ����
		mbh.closeHandler(ss);
		
		return amd;
	}

}//
