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
		
		//1.MyBatis Handler���
		MyBatisHandler mbh=MyBatisHandler.getInstance();
		SqlSession ss=mbh.getHandler();
		System.out.println(mVO.getId()+"/"+mVO.getPass()); //�� �� �޾���
				
		//2.����������
		int cnt=ss.selectOne("kr.co.mpnp.user.mapper.memberMapper.selectLogin",mVO);
		if(cnt!=0) {
			flag=true;
		}else {
			System.out.println("�α��ο� �����Ͽ����ϴ�");
		}
		//cnt �׽�Ʈ
		System.out.println(cnt+"��");
				
		//3.MyBatis Handler ����
		mbh.closeHandler(ss);
		
		return flag;
	}
	
	
	//�����-���̵�ã��
	//��ȯ�� boolean���� �ٲٰ� ���̵�ã�� ���� ó���ϱ�...? 
	//������ domain�� �ʿ��ϴϱ� ��ȯ�� ���������� ���°ǰ�?  �׷� ���д� ��� ó����
	//�׳� null���϶��� ó���ϸ� �ǳ�? 
	public MemberDomain selectMemberId(MemberVO mVO) {
		MemberDomain md=null;
		
		//1.MyBatis Handler���
		MyBatisHandler mbh=MyBatisHandler.getInstance();
		SqlSession ss=mbh.getHandler();
		System.out.println(mVO.getId()+"/"+mVO.getPass()); 
				
		//2.����������
		md=ss.selectOne("kr.co.mpnp.user.mapper.memberMapper.selectMemberId",mVO);
		//3.MyBatis Handler ����
		mbh.closeHandler(ss);
		
		return md;
	}
	
	
	//�����-��й�ȣã��
	//boolean -> Domain���� �ٲ� session�� id �÷�����ؼ�
	public MemberDomain selectMemberPass(MemberVO mVO) {
		MemberDomain md=null;
		
		//1.MyBatis Handler���
		MyBatisHandler mbh=MyBatisHandler.getInstance();
		SqlSession ss=mbh.getHandler();
		System.out.println(mVO.getId()+"/"+mVO.getPass()); 
				
		//2.����������
		md=ss.selectOne("kr.co.mpnp.user.mapper.memberMapper.selectMemberPass",mVO);
				
		//3.MyBatis Handler ����
		mbh.closeHandler(ss);
		
		return md;
	}
	
	
	//�����-�������
	public int updateMemberPass(MemberVO mVO) {
		//1.MyBatis Handler���
		MyBatisHandler mbh=MyBatisHandler.getInstance();
		SqlSession ss=mbh.getHandler();
		
		//2.����������
		int cnt=ss.update("kr.co.mpnp.user.mapper.memberMapper.updateMemberPass",mVO);
		if(cnt!=0) {
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
	
	
	//�����-ȸ������
		public int insertMember(MemberVO mVO) {
			//1.MyBatis Handler���
			MyBatisHandler mbh=MyBatisHandler.getInstance();
			SqlSession ss=mbh.getHandler();
			System.out.println("DAO ���̵�"+mVO.getId()); //�ߵ���
			
			//2.����������
			int cnt=ss.insert("kr.co.mpnp.user.mapper.memberMapper.insertMember",mVO);
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
		
		
		//�����-�ߺ�Ȯ��
		public boolean selectDupChk(String id) {
			boolean flag=false;
			
			return flag;
		}
		


}
