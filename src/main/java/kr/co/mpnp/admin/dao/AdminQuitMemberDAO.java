package kr.co.mpnp.admin.dao;

import org.apache.ibatis.session.SqlSession;

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
		System.out.println("�ڵ鷯�� ��� "+mbh);
		SqlSession ss=mbh.getHandler();
		System.out.println("sql ������ ��� "+ss);
		
		//2.����������
		int cnt=ss.insert("kr.co.nyangpoom.admin.dao.mapper.adminMemberMapper.insertQuitMember",id);
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

	public static void main(String[] args) {
		AdminQuitMemberDAO qmDAO=new AdminQuitMemberDAO();
		qmDAO.insertQuitMember("");
		

	}

}
