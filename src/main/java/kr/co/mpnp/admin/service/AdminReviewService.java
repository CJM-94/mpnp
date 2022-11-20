package kr.co.mpnp.admin.service;

import java.util.List;

import org.json.simple.JSONObject;

import kr.co.mpnp.admin.dao.AdminReviewDAO;
import kr.co.mpnp.admin.domain.AdminReviewDomain;
import kr.co.mpnp.admin.vo.AdminReviewVO;

public class AdminReviewService {
	
	// ��ü, ������ȸ
	public List<AdminReviewDomain> searchReviewList(AdminReviewVO arVO){
		List<AdminReviewDomain> list = null;
		
		System.out.println("AdminReviewService : "+arVO.toString());
		
		AdminReviewDAO aDAO = AdminReviewDAO.getInstance();
		list = aDAO.selectReviewList(arVO);
		
		return list;
	}
	
	// ���� �󼼺���
	public AdminReviewDomain searchReviewDetail(String reviewId) {
		AdminReviewDomain arDomain = null; 
		
		// �̸޼��常 �ʿ��ѰԾƴϰ� ���� �����ڵ�� �ֹ����ڵ带 Ÿ���� �� ��ǰ�ڵ� ��� �� �����;ߵǳ�?? 
		
		AdminReviewDAO aDAO = AdminReviewDAO.getInstance();
		arDomain = aDAO.selectReviewDetail(reviewId);
		
		System.out.println("���� �� : "+arDomain.toString());
		//���� �� : AdminReviewDomain [reviewId=rev_000001, nick=nick002, contents=����insert�׽�Ʈ���Դϴ�, productId=p0001, reviewImgs=testtesttest.jpg,testtesttest2.jpg,testtesttest3.jpg, reviewImgArr=null, starScore=5, inputDate=Wed Nov 16 22:27:28 KST 2022]
		
		if(arDomain.getReviewImgs() != null) { // �����̹����� �ִٸ�
			arDomain.setReviewImgArr(arDomain.getReviewImgs().split(","));
		}
		
		System.out.println("���� �� : "+arDomain.toString());
		//���� �� : AdminReviewDomain [reviewId=rev_000001, nick=nick002, contents=����insert�׽�Ʈ���Դϴ�, productId=p0001, reviewImgs=testtesttest.jpg,testtesttest2.jpg,testtesttest3.jpg, reviewImgArr=[testtesttest.jpg, testtesttest2.jpg, testtesttest3.jpg], starScore=5, inputDate=Wed Nov 16 22:27:28 KST 2022]
		
		
		return arDomain;
	}
	
	
	// �������
	/*public boolean removeReview(String reviewId) {
		boolean removeFlag = false;
		String json = "";
		
		AdminReviewDAO aDAO = AdminReviewDAO.getInstance();
		removeFlag = aDAO.deleteReview(reviewId)==1?true:false;
		
		return removeFlag;
	}*/
	
	public String removeReview(String reviewId) {
		
		AdminReviewDAO aDAO = AdminReviewDAO.getInstance();
		boolean removeFlag = aDAO.deleteReview(reviewId)==1?true:false;
		
		JSONObject jsonFlag = new JSONObject();
		jsonFlag.put("removeFlag", removeFlag);
		
		return jsonFlag.toJSONString();
	}
	
	
}