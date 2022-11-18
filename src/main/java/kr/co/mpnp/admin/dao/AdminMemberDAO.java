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
		List<AdminMemberDomain> list= new ArrayList<AdminMemberDomain>();
		return list;
	}

	//������-ȸ��������
	public AdminMemberDomain selectMemberDetail(String id){
		AdminMemberDomain amDomain=null;
		return amDomain;
	}
	
	//������-ȸ������
	public int updateMember(String id) {
		//1.MyBatis Handler���
		MyBatisHandler mbh=MyBatisHandler.getInstance();
		System.out.println("�ڵ鷯�� ��� "+mbh);
		SqlSession ss=mbh.getHandler();
		System.out.println("sql ������ ��� "+ss);
		
		//2.����������
		int cnt=ss.update("kr.co.nyangpoom.admin.dao.mapper.adminMemberMapper.updateMember",id);
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
		
		//2.����������
		int cnt=ss.update("kr.co.nyangpoom.admin.dao.mapper.adminMemberMapper.updateMemberGrade",amVO);
		if(cnt!=0) {
			System.out.println(amVO.getGradeid()+"���� ȸ����޺���");
			ss.commit();
		}else {
			System.out.println("ȸ�� ������ �����Ͽ����ϴ�");
		}
		//cnt �׽�Ʈ
		System.out.println(cnt+"��");
		
		//3.MyBatis Handler ����
		mbh.closeHandler(ss);
		
		return cnt;
		
	}

	public static void main(String[] args) {
		AdminMemberDAO amDAO=new AdminMemberDAO();
		//amDAO.updateMember("id007");
		AdminMemberVO amVO=new AdminMemberVO("id001","1","G4","1","1");
		amDAO.updateMemberGrade(amVO);

	}

}
