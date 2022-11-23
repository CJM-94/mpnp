package kr.co.mpnp.user.dao;

import org.apache.ibatis.session.SqlSession;

import kr.co.mpnp.handler.MyBatisHandler;
import kr.co.mpnp.user.domain.MemberDomain;
import kr.co.mpnp.user.domain.MypageDomain;
import kr.co.mpnp.user.vo.MemberVO;
import kr.co.mpnp.user.vo.MypageVO;


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
	
	//���������� ùȭ�� �̸�,��� ��ȸ
	public MypageDomain selectMypageMember(MemberVO mVO) {
		MypageDomain md=null;
		
		return md;
		
	}
	
	//���������� ���Ȯ��
	public boolean selectPass(MypageVO mVO) {
		boolean flag=false;
		
		//1.MyBatis Handler���
		MyBatisHandler mbh=MyBatisHandler.getInstance();
		SqlSession ss=mbh.getHandler();
		
		System.out.println("���Ȯ�� id "+mVO.getId()); //��� ���� �ȳѿ��´�? jsp���� form ������
		System.out.println("���Ȯ�� pass "+mVO.getPass()); //����
				
		//2.����������
		int cnt=ss.selectOne("kr.co.mpnp.user.mapper.mypageMapper.selectPass",mVO);
		if(cnt!=0) {
			flag=true;
		}else {
			System.out.println("�����Ͽ����ϴ�");
		}
		//cnt �׽�Ʈ
		System.out.println(cnt+"��");
				
		//3.MyBatis Handler ����
		mbh.closeHandler(ss);
		
		return flag;
		
	}

	
	//���������� �������
	public int updatePass(MypageVO mVO) {
		//1.MyBatis Handler���
		MyBatisHandler mbh=MyBatisHandler.getInstance();
		SqlSession ss=mbh.getHandler();
		
		//2.����������
		int cnt=ss.update("kr.co.mpnp.user.mapper.mypageMapper.updatePass",mVO);
		if(cnt!=0) {
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
	
	
	//�����-ȸ��������ȸ
	public MypageDomain selectMemberInfo(String id) {
		MypageDomain md=null;
		
		//1.MyBatis Handler���
		MyBatisHandler mbh=MyBatisHandler.getInstance();
		SqlSession ss=mbh.getHandler();
		
//		System.out.println("Ⱥ������ȸ id "+mVO.getId()); //�� ���´�
//		System.out.println("Ⱥ������ȸ pass "+mVO.getPass());
//		System.out.println("Ⱥ������ȸ name "+mVO.getName()); //�� ���� 
				
		//2.����������
		md=ss.selectOne("kr.co.mpnp.user.mapper.mypageMapper.selectMemberInfo",id);
				
		//3.MyBatis Handler ����
		mbh.closeHandler(ss);
		
		
		return md;
	}


	
	
	//�����-ȸ����������
	public int updateMemberInfo(MypageVO mVO) {
		//1.MyBatis Handler���
		MyBatisHandler mbh=MyBatisHandler.getInstance();
		SqlSession ss=mbh.getHandler();
		
		System.out.println("ȸ���������� id "+mVO.getId()); 
		System.out.println("ȸ���������� pass "+mVO.getPass());
		
		//2.����������
		int cnt=ss.update("kr.co.mpnp.user.mapper.mypageMapper.updateMemberInfo",mVO);
		if(cnt!=0) {
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
	
	
	//�����-ȸ��Ż��1
	public boolean selectMember(MypageVO mVO) {
		boolean flag=false;
		
		return flag;
	}
	
	
	//�����-ȸ��Ż��2
	public int updateMemberStatus(MypageVO mVO) {
		//1.MyBatis Handler���
		MyBatisHandler mbh=MyBatisHandler.getInstance();
		SqlSession ss=mbh.getHandler();
		
		//2.����������
		int cnt=ss.update("",mVO);
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
	

}
