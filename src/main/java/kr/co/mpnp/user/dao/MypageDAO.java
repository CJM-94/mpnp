package kr.co.mpnp.user.dao;

import org.apache.ibatis.session.SqlSession;

import kr.co.mpnp.handler.MyBatisHandler;
import kr.co.mpnp.user.domain.MypageDomain;
import kr.co.mpnp.user.vo.MemberVO;


public class MypageDAO {
	private static MypageDAO  mDAO;
	
	private MypageDAO() {
			
	}

	public static MypageDAO getInstance(){
			if(mDAO==null) {
				mDAO= new MypageDAO();
			}
			return mDAO;
	}
	
	//1.�����-���������� ùȭ�� �̸�,��� ��ȸ
	public MypageDomain selectMypageMember(MemberVO mVO) {
		MypageDomain md=null;
		
		return md;
		
	}
	
	//1.�����-���������� ���Ȯ��
	public boolean selectPass(MemberVO mVO) {
		boolean flag=false;
		
		return flag;
		
	}

	
	//2.�����-���������� �������
	public int updatePass(MemberVO mVO) {
		//1.MyBatis Handler���
		MyBatisHandler mbh=MyBatisHandler.getInstance();
		SqlSession ss=mbh.getHandler();
		
		//2.����������
		int cnt=ss.update("kr.co.mpnp.user.dao.mapper.mypageMapper.updatePass",mVO);
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
