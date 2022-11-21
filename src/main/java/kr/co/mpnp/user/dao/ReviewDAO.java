package kr.co.mpnp.user.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.co.mpnp.handler.MyBatisHandler;
import kr.co.mpnp.user.domain.ReviewDomain;
import kr.co.mpnp.user.vo.ReviewVO;

public class ReviewDAO {

	private static ReviewDAO reviewDAO;

	private ReviewDAO() {
	}

	public static ReviewDAO getInstance() {
		if (reviewDAO == null) {
			reviewDAO = new ReviewDAO();
		}

		return reviewDAO;
	}
	
	
	// �ۼ������ı� ��ȸ
	public List<ReviewDomain> selectWritableReview(String id){
		
		List<ReviewDomain> list = null;
		// 1. Mybatis Handler �ޱ�
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getHandler();
		System.out.println("ReviewDAO : session - "+ss);
		
		// 2. ��������
		list = ss.selectList("kr.co.mpnp.user.mapper.reviewMapper.writableReview",id);
		
		// 3. ����
		mbh.closeHandler(ss);
		
		return list;
	}
	
	// �ۼ��ı� ��ȸ
	public List<ReviewDomain> selectWritenReview(String id){
		List<ReviewDomain> list = null;
		
		// 1. Mybatis Handler �ޱ�
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getHandler();
		System.out.println("ReviewDAO : session - "+ss);
		
		// 2. ��������
		list = ss.selectList("kr.co.mpnp.user.mapper.reviewMapper.writenReview",id);
		
		// 3. ����
		mbh.closeHandler(ss);
		
		return list;
	}
	
	// �����ۼ�
	public boolean insertReview(ReviewVO rVO){
		
		
		int cnt = 0; // ������������ ��� ?? ���⿡�ϴ°� �´���
		
		return cnt!=0?true:false;
	}
	
	// �������
	public boolean updateReview(ReviewVO rVO){
		
		int cnt = 0; // ������������ ��� ?? ���⿡�ϴ°� �´���
		
		return cnt!=0?true:false;
	}
	
	// �������
	public boolean deleteReview(String rId){
		
		int cnt = 0; // ������������ ��� ?? ���⿡�ϴ°� �´���
		
		return cnt!=0?true:false;
	}
	
}
