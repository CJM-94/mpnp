package kr.co.mpnp.admin.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.co.mpnp.admin.domain.AdminMemberDomain;
import kr.co.mpnp.admin.vo.AdminMemberVO;
import kr.co.mpnp.handler.MyBatisHandler;


public class  AdminMemberDAO {
	private static AdminMemberDAO amDAO;
	
	private AdminMemberDAO() {
			
	}

	public static AdminMemberDAO getInstance(){
			if(amDAO==null) {
				amDAO= new AdminMemberDAO();
			}
			return amDAO;
	}
	
	//������-ȸ����ȸ
	public List<AdminMemberDomain> selectMember(AdminMemberVO amVO){
		//List<AdminMemberDomain> list= new ArrayList<AdminMemberDomain>();
		List<AdminMemberDomain> list= null;
		
	    // MyBatisHandler���
			MyBatisHandler mbh = MyBatisHandler.getInstance();
			SqlSession ss = mbh.getHandler();
			// ���� ����
			list = ss.selectList("kr.co.mpnp.adminMemberMapper.selectMember",amVO);

			System.out.println(list);

			// �������
			mbh.closeHandler(ss);
		
		return list;
	}
	
	//������-ȸ����ȸ-�����ȸ
	public List<AdminMemberDomain> selectGrade(AdminMemberVO amVO){
		//List<AdminMemberDomain> list= new ArrayList<AdminMemberDomain>();
		List<AdminMemberDomain> list= null;
		
		// MyBatisHandler���
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getHandler();
		// ���� ����
		list = ss.selectList("kr.co.mpnp.adminMemberMapper.selectGrade",amVO);
		
		System.out.println(list);
		
		// �������
		mbh.closeHandler(ss);
		
		return list;
	}

	//������-ȸ��������
	public AdminMemberDomain selectMemberDetail(String id){
		AdminMemberDomain amd=null;
		
		// MyBatisHandler���
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getHandler();
		// ���� ����
		amd = ss.selectOne("kr.co.mpnp.adminMemberMapper.selectMemberDetail",id);

		System.out.println(amd);

		// �������
		mbh.closeHandler(ss);
	
		
		return amd;
	}
	
	//������-ȸ������
	public int updateMember(String id) {
		//1.MyBatis Handler���
		MyBatisHandler mbh=MyBatisHandler.getInstance();
		SqlSession ss=mbh.getHandler();
		
		//2.����������
		int cnt=ss.update("kr.co.mpnp.adminMemberMapper.updateMember",id);
		if(cnt!=0) {
			System.out.println("���̵�: "+id+" Ż��ó���Ǿ����ϴ�");
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
	
	
	//������-ȸ����޺���
	//�Ű������� VO�����°� ���ظ��߾�
	public int updateMemberGrade(AdminMemberVO amVO) {
		//1.MyBatis Handler���
		MyBatisHandler mbh=MyBatisHandler.getInstance();
		SqlSession ss=mbh.getHandler();
		
		//session���� �޾ƿ� id�� null �̴� ? ��� �ذ��ؾ�����? jsp form�ȿ� hidden���� �� ��
		System.out.println("DAO�� "+amVO.getId()+"/"+amVO.getGradeid());
		
		//2.����������
		int cnt=ss.update("kr.co.mpnp.adminMemberMapper.updateMemberGrade",amVO);
		if(cnt!=0) {
			System.out.println(amVO.getGradeid()+"���� ȸ����޺���");
			ss.commit();
		}else {
			System.out.println("��޺��濡 �����Ͽ����ϴ�");
		}
		//cnt �׽�Ʈ
		System.out.println(cnt+"��");
		
		//3.MyBatis Handler ����
		mbh.closeHandler(ss);
		
		return cnt;
	}

}
