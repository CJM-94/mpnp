package kr.co.mpnp.admin.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.co.mpnp.admin.domain.AdminMemberDomain;
import kr.co.mpnp.admin.vo.AdminMemberVO;


public class AdminMemberService {
	
	//������-ȸ����ȸ
	public List<AdminMemberDomain> searchMember(AdminMemberVO amVO){
		List<AdminMemberDomain> list= new ArrayList<AdminMemberDomain>();
		return  list;
	}

	//������-ȸ��������
	public AdminMemberDomain searchMemberDetail(String id){
		AdminMemberDomain amDomain=null;
		return amDomain;
	}
	
	//������-ȸ������
	public int modifyMember(String id) {
		int cnt=0;
		
		return cnt;
	}
	
	
	//������-��޺���
	//�Ű������� VO�����°� ���ظ��߾�
	public int modifyMemberGrade(AdminMemberVO amVO) {
		int cnt=0;
		return cnt;
		
	}

}
