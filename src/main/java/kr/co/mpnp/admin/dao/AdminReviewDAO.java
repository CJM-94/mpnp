package kr.co.mpnp.admin.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.co.mpnp.admin.domain.AdminReviewDomain;
import kr.co.mpnp.admin.vo.AdminReviewVO;
import kr.co.mpnp.handler.MyBatisHandler;


public class AdminReviewDAO {

	private static AdminReviewDAO arDAO;
	
	private AdminReviewDAO() {
	}
	
	public static AdminReviewDAO getInstance() {
		if(arDAO==null) {
			arDAO = new AdminReviewDAO();
		}
		return arDAO;
	}
	
	// ������ȸ
	public List<AdminReviewDomain> selectReviewList(AdminReviewVO arVO){
		List<AdminReviewDomain> list = null;
		
		// 1. MyBatis Handler ���
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getHandler();
		
		// 2. �������� insert("Mapper���̵�",��)
		System.out.println("AdminReviewDAO : "+arVO);
		
		list = ss.selectList("kr.co.mpnp.admin.mapper.reviewMapper.selectReviewList",arVO);
		//System.out.println("��ġ AdminReviewDAO : "+list.hashCode());
		
		// 3. MyBatis Handler ����
		mbh.closeHandler(ss);
		
		return list;
	}
	
	// ����󼼺���
	public AdminReviewDomain selectReviewDetail(String reviewId){
		
		// 1. MyBatis Handler ���
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getHandler();
		
		// 2. �������� insert("Mapper���̵�",��)
		System.out.println("AdminReviewDAO : "+reviewId);
		
		AdminReviewDomain arDomain = ss.selectOne("kr.co.mpnp.admin.mapper.reviewMapper.selectReviewDetail",reviewId);
		System.out.println(arDomain.toString());
		
		// 3. MyBatis Handler ����
		mbh.closeHandler(ss);
		
		return arDomain;
	}
	
	
	public void insertReview(AdminReviewVO arVO){
		
		// ������ �޼���ȿ��� Ŀ�ؼǾ�� �������� �ߴµ� ���� MyBatis��´�
		// 1. MyBatis Handler ���
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		System.out.println("AdminReviewDAO mbh : "+ mbh);
		
		SqlSession ss = mbh.getHandler();
		System.out.println("AdminReviewDAO ss : "+ss);
		
		// 2. �������� insert("Mapper���̵�",��)
		System.out.println("���⼭?");
		System.out.println("arVO : "+arVO);
		
		//int cnt = ss.insert("kr.co.mpnp.admin.dao.mapper.reviewMapper.insertReview",arVO);
		int cnt = ss.insert("kr.co.mpnp.admin.dao.mapper.reviewMapper.insertReview");
		System.out.println(cnt);
		//System.out.println(ss.insert("kr.co.mpnp.admin.dao.mapper.reviewMapper.insertReview",arVO)==null?"oo":"xx");

		// autocommit�� �ȵǱ⶧���� ���� ������Ѵ�.
		// �������Ѹ�ŭ ����������� ���ϱ����� cnt==1 ����
		if(cnt==1) {
			System.out.println(cnt+"�� �߰�");
			ss.commit();
		}else {
			System.out.println("�������߰�X");
		}
		
		// 3. MyBatis Handler ����
		mbh.closeHandler(ss);
		
		
	}
	
	public int deleteReview(String reviewId){
		int cnt = 0;
		
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getHandler();
		
		cnt = ss.delete("kr.co.mpnp.admin.mapper.reviewMapper.deleteReview",reviewId);
		
		if(cnt==1) {
			System.out.println(reviewId+" �ı� ����");
			ss.commit();
		}else {
			System.out.println("��������");
			// �����Ұ�찡 ��������?
		}
		
		// 3. MyBatis Handler ����
		mbh.closeHandler(ss);
		
		return cnt;
	}
	
	
	
	
	
	
	
}