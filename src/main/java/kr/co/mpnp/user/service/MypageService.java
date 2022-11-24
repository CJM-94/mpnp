package kr.co.mpnp.user.service;

import kr.co.mpnp.user.dao.MypageDAO;
import kr.co.mpnp.user.domain.MemberDomain;
import kr.co.mpnp.user.domain.MypageDomain;
import kr.co.mpnp.user.vo.MemberVO;
import kr.co.mpnp.user.vo.MypageVO;


public class  MypageService {
	
	//���������� ùȭ�� �̸�,��� ��ȸ
	public MypageDomain searchMypageMember(MypageVO mVO) {
		MypageDomain md=null;
		
		return md;
		
	}
	
	//���������� ���Ȯ��
	public boolean searchPass(MypageVO mVO) {
		boolean flag=false;
		
		MypageDAO mDAO=MypageDAO.getInstance();
		flag=mDAO.selectPass(mVO);
		
		return flag;
		
	}

	
	//���������� �������
	public int modifyPass(MypageVO mVO) {
		int cnt=0;
		
		return cnt;
	}
	
	//�����-ȸ��������ȸ
		public MypageDomain searchMemberInfo(String id) {
			MypageDomain md=null;
			
			MypageDAO mDAO=MypageDAO.getInstance();
			md=mDAO.selectMemberInfo(id);
			
			return md;
		}
		
		
		//�����-ȸ����������
		public int modifyMemberInfo(MypageVO mVO) {
			int cnt=0;
			
			MypageDAO mDAO=MypageDAO.getInstance();
			cnt=mDAO.updateMemberInfo(mVO);
			
			return cnt;
			
		}
		
		
		//�����-ȸ��Ż��1 .. �̰� �� �ʿ��ұ�
		public boolean searchMember(MypageVO mVO) {
			boolean flag=false;
			
			MypageDAO mDAO=MypageDAO.getInstance();
			flag=mDAO.selectMember(mVO);
			
			return flag;
		}
		
		
		//�����-ȸ��Ż��2
		public int modifyMemberStatus(MypageVO mVO) { //Ż��2,3�� id�� �޾Ƶ������ʳ�
			int cnt=0;
			
			MypageDAO mDAO=MypageDAO.getInstance();
			cnt=mDAO.updateMemberStatus(mVO);
			
			return cnt;
		}
		
		//�����-ȸ��Ż��3
		public int addQuitMember(MypageVO mVO) {//id�� �ް�, inputdate�� sysdate�� 
			int cnt=0;
			
			MypageDAO mDAO=MypageDAO.getInstance();
			cnt=mDAO.insertQuitMember(mVO);
			
			return cnt;
		}

	


}
