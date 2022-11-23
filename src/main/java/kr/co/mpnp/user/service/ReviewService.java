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
		System.out.println("DAO�����Դ�.");
		System.out.println(rVO.getId());
		System.out.println(rVO.getOrderDetailId());
		System.out.println(rVO.getContents());
		System.out.println(rVO.getStarScore());
		for(String imgName : rVO.getReviewImg()) {
			System.out.println(imgName);
		}
		
		// ���⼭ �ؾ��� �۾�
		// �������̺� ���������� insert
		// rVO�� �̹�������Ʈ�� ���̰� 0���� ũ�ٸ�
		// ��� insert�� �����ȣ select 0�����۰ų� ���� ������ ���� ���ʿ���� ����
		// select�� �����ȣ�� �����̹������̺� �̹���������ŭ insert
		// od���̵�� order_detail���̺� review_chk Y�� update
		
		// �� ����۾��� ���������� �������� commit�� ��ȯ
		
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
