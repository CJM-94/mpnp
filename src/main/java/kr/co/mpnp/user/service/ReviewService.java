package kr.co.mpnp.user.service;

import java.util.List;

import kr.co.mpnp.user.dao.ReviewDAO;
import kr.co.mpnp.user.domain.ReviewDomain;
import kr.co.mpnp.user.vo.ReviewVO;

public class ReviewService {

	// �ۼ������ı� ��ȸ
	public List<ReviewDomain> searchWritableReview(String id){
		List<ReviewDomain> list = null;
		
		System.out.println("ReviewService : id - "+id);
		ReviewDAO reviewDAO = ReviewDAO.getInstance();
		list = reviewDAO.selectWritableReview(id);
		
		return list;
	}
	
 	// �ۼ��ı� ��ȸ
	public List<ReviewDomain> searchWritenReview(String id){
		List<ReviewDomain> list = null;
		
		System.out.println("ReviewService : id - "+id);
		ReviewDAO reviewDAO = ReviewDAO.getInstance();
		list = reviewDAO.selectWritenReview(id);
		
		return list;
	}
	
	// �����ۼ�
	public boolean addReview(ReviewVO rVO){
		boolean flag = false;
		
		
		return flag;
	}
	
	// �������
	public boolean modifyReview(ReviewVO rVO){
		boolean flag = false;
		
		
		return flag;
	}
	
	// �������
	public boolean deleteReview(ReviewVO rVO){
		boolean flag = false;
		
		
		return flag;
	}
	
}
