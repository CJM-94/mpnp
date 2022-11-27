package kr.co.mpnp.user.service;

import java.util.List;

import org.json.simple.JSONObject;

import kr.co.mpnp.user.dao.DestinationDAO;
import kr.co.mpnp.user.dao.ReviewDAO;
import kr.co.mpnp.user.domain.ReviewDomain;
import kr.co.mpnp.user.vo.ReviewVO;

public class ReviewService {
	
	// �ۼ������ı� ��ȸ
	public List<ReviewDomain> searchWritableReview(String id){
		List<ReviewDomain> list = null;
		
		//System.out.println("ReviewService : id - "+id);
		ReviewDAO reviewDAO = ReviewDAO.getInstance();
		list = reviewDAO.selectWritableReview(id);
		
		return list;
	}
	
 	// �ۼ��ı� ��ȸ
	public List<ReviewDomain> searchWritenReview(String id){
		List<ReviewDomain> list = null;
		
		//System.out.println("ReviewService : id - "+id);
		ReviewDAO reviewDAO = ReviewDAO.getInstance();
		list = reviewDAO.selectWritenReview(id);
		
		return list;
	}
	
	// �����ۼ�
//	public String addReview(ReviewVO rVO){
	public boolean addReview(ReviewVO rVO){
		boolean finalFlag = false;
		//System.out.println("DAO�����Դ�.");
		//System.out.println(rVO.getId());
		//System.out.println(rVO.getOrderDetailId());
		//System.out.println(rVO.getContents());
		//System.out.println(rVO.getStarScore());
		//for(String imgName : rVO.getReviewImg()) {
//			System.out.println(imgName);
		//}
		//System.out.println("������Ͼ��ϸ� null�ΰ�? �ϴ� null�� �ƴ����ʳ� "+rVO.getReviewImg()==null); // ���� null�� �ƴ�
		//System.out.println("������Ͼ��ص� �ϴ� �����ϱ� size �� 1 �ƴѰ�?"+rVO.getReviewImg().size());
		// 0�̳� �ϳ�����ߴٰ� ����� �ص� 0��
		
		// ����Ʈ�� �ϴ� �����Ű����� �� �ε����� null�� �ƴѰ�츸 �ؾ߰ڴ� ����
		
		ReviewDAO reviewDAO = ReviewDAO.getInstance();
		
		// �����ۼ�
		finalFlag = reviewDAO.insertReviewTest(rVO);
		// �ۼ��� �����ڵ���ȸ
		// �̹������̺� �߰����� rVO�� set
//		String rId = reviewDAO.selectReviewId(rVO.getOrderDetailId());
//		rVO.setReviewId(rId);
//		System.out.println("��ȸ�� ���� id");
//		boolean imgFlag = false;
//		if(rVO.getReviewImg().size()>0){
//			imgFlag = reviewDAO.insertReviewImgs(rVO);
//		}
//		
//		boolean chkFlag = reviewDAO.updateReviewChk(rVO.getOrderDetailId());
//		
//		if(rVO.getReviewImg().size()>0){
//			if(rFlag&&imgFlag&&chkFlag) {
//				finalFlag = true;
//			}
//		}else {
//			if(rFlag&&chkFlag) {
//				finalFlag = true;
//			}
//		}
		
		// �̹��� ���������
//		if(rVO.getReviewImg().size()>0) {
//			// �̹����� �������� �����ϴ°� ������?
//			
//			if(rFlag&&imgFlag&&chkFlag) {
//				reviewDAO.commit();
//				System.out.println("Ŀ�Ե�");
//				finalFlag = true;
//			}else {
//				System.out.println("�ѹ��");
//				reviewDAO.rollback();
//			}
//		}else {
//			if(rFlag&&chkFlag) {
//				reviewDAO.commit();
//				System.out.println("Ŀ�Ե�");
//				finalFlag = true; 
//			}else {
//				System.out.println("�ѹ��");
//				reviewDAO.rollback();
//			}
//		}
		
		//JSONObject jsonData = new JSONObject();
		//jsonData.put("addFlag", finalFlag);
		
		//return jsonData.toJSONString();
		return finalFlag;
		
	}
	
	
	
	// ������������� �����ֱ�
	public ReviewDomain searchReviewDetail(String rId){
		
		ReviewDAO reviewDAO = ReviewDAO.getInstance();
		ReviewDomain rDomain = reviewDAO.selectDetail(rId);
		rDomain.setReviewId(rId);
		//System.out.println("ReviewService : 119 ���� : �̹��� �迭�� �������� "+rDomain);
		List<String> imgList = null;
		// �̹����� ���°�츦 �ϴ� �ĺ��ؾ���
		// ���ٸ� empty�ϱ� null�ϱ� null��
		//System.out.println("".equals(rDomain.getReviewImgs())?"oo":"xx"); // xx
		//System.out.println((rDomain.getReviewImgs()==null?"oo":"xx")); // oo
		if(rDomain.getReviewImgs()!=null) {
			String[] imgArr = rDomain.getReviewImgs().split(",");
			rDomain.setReviewImg(imgArr);
		}
		//System.out.println("��������� �������� ������ rDomain : "+rDomain.toString());
		return rDomain;
	}
	
	// �������
	public boolean modifyReview(ReviewVO rVO){
		boolean flag = false;
		
		
		return flag;
	}
	
	// �������
	public String removeReview(String reviewId){
		boolean flag = false;
		ReviewDAO reviewDAO = ReviewDAO.getInstance();
		flag = reviewDAO.deleteReview(reviewId);
		
		JSONObject jsonData = new JSONObject();
		jsonData.put("removeFlag", flag);
		
		return jsonData.toJSONString();
	}
	
}
