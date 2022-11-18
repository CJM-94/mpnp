package kr.co.mpnp.admin.dao;

import org.apache.ibatis.session.SqlSession;

import kr.co.mpnp.admin.vo.AdminReviewVO;
import kr.co.mpnp.handler.MyBatisHandler;


public class AdminReviewDAO {

	public AdminReviewDAO() {
		
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
		
		// ������ ������ ���ٰ� DAO���� ������ �̸޼��带 service���� �θ���ȴ�.
		
	}
	
	public void deleteReview(String reviewId){
		
		// ������ �޼���ȿ��� Ŀ�ؼǾ�� �������� �ߴµ� ���� MyBatis��´�
		// 1. MyBatis Handler ���
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		System.out.println("AdminReviewDAO mbh : "+ mbh);
		
		SqlSession ss = mbh.getHandler();
		System.out.println("AdminReviewDAO ss : "+ss);
		
		// 2. �������� insert("Mapper���̵�",��)
		System.out.println("���⼭?");
		int cnt = ss.delete("kr.co.mpnp.admin.dao.mapper.reviewMapper.deleteReview",reviewId);
		
		if(cnt==1) {
			System.out.println(reviewId+"�� �ı� ����");
			ss.commit();
		}else {
			System.out.println("�������߰�X");
		}
		
		// 3. MyBatis Handler ����
		mbh.closeHandler(ss);
		
		// ������ ������ ���ٰ� DAO���� ������ �̸޼��带 service���� �θ���ȴ�.
		
	}
	
	
	
	public static void main(String[] args) {
		
		//AdminReviewDAO arDAO = new AdminReviewDAO();
		//System.out.println(arVO.toString());
		
		AdminReviewDAO arDAO = new AdminReviewDAO();
		AdminReviewVO arVO = new AdminReviewVO("AdminReviewDAO123123123","123123","55555","od0003");
		System.out.println("��������������"+arVO);
		arDAO.insertReview(arVO);
		//arDAO.deleteReview("r0013");
		
		
	}
	
	
	
	
	
}