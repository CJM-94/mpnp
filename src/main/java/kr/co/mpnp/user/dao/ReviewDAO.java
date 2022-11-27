package kr.co.mpnp.user.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		//System.out.println("ReviewDAO : session - "+ss);
		
		// 2. ��������
		list = ss.selectList("kr.co.mpnp.user.mapper.reviewMapper.selectWritableReview",id);
		
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
		//System.out.println("ReviewDAO : session - "+ss);
		
		// 2. ��������
		list = ss.selectList("kr.co.mpnp.user.mapper.reviewMapper.selectWritenReview",id);
		
		// 3. ����
		mbh.closeHandler(ss);
		
		return list;
	}
	
/////////////////// Ʈ������׽�Ʈ ����//////////////////////////////	
	// �����ۼ�
	public boolean insertReviewTest(ReviewVO rVO){
		boolean finalFlag = false;
		
		//System.out.println("ReviewDAO - Ʈ������׽�Ʈ rVO�� �ִ� ��� �� : "+rVO);
		//for(String imgName : rVO.getReviewImg()) {
//			System.out.println("�̹����� : "+imgName);
		//}
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getHandler();
		
		//cnt = ss.insert("kr.co.mpnp.user.mapper.reviewMapper.insertReview",rVO);
		
		//System.out.println("�Ѿ�� �̹��� ������Ȯ�� : "+rVO.getReviewImg().size());
		// �Ѿ�� ������Ȯ�� 1������ : 1
		// �̼��� : 0, Ǯ���� Ǯ��� : 0
		// Ǯ���� : 3, Ǯ���� Ǯ��� Ǯ���� : 3
		// �׷��ϴ� rVO �̹��� Ȯ���Ҽ��ִٴ°Ŵϱ� ����
		boolean reviewAddFlag = ss.insert("kr.co.mpnp.user.mapper.reviewMapper.insertReview",rVO)!=0?true:false;
		boolean imgAddFlag = false;
		boolean chkUpdateFlag = ss.update("kr.co.mpnp.user.mapper.reviewMapper.updateReviewChk",rVO.getOrderDetailId())!=0?true:false;
		
		if(reviewAddFlag && chkUpdateFlag) { // ��. ����insert, ����chk����update ����
			// ���䰡 ���������� ���� reviewId�� �����°Ŵϱ� ����
			
			if(rVO.getReviewImg().size()>0) { // ��. ���̼����߰� �̹����� �������
			
				String reviewId = ss.selectOne("kr.co.mpnp.user.mapper.reviewMapper.selectReviewId",rVO.getOrderDetailId());
				rVO.setReviewId(reviewId);
				
				Map<String,Object> paramMap2 = null;
				List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
				List<String> imgList = rVO.getReviewImg();
				String rId = rVO.getReviewId();
				for(String img : imgList) {
					paramMap2 = new HashMap<String,Object>();
					//System.out.println("����� : "+img);
					paramMap2.put("reviewId", rId);
					paramMap2.put("reviewImg",img);
					list.add(paramMap2);
				}
				imgAddFlag = ss.insert("kr.co.mpnp.user.mapper.reviewMapper.insertReviewImg",list)==list.size()?true:false;
				
				if(imgAddFlag) { // ��. ���� �����߰� �̹����� ��� �� �ö������
					finalFlag = true;
				}
				
				
			}else { // ��-2. ���� �����߰� �̹����� �������
				finalFlag = true;
			}
			
		}else { 
			finalFlag = false;
		}
		
		if(finalFlag) {
			ss.commit();
			//System.out.println("ReviewDAO : Ŀ�ԿϷ�");
		}else {
			ss.rollback();
			//System.out.println("ReviewDAO : �ѹ�Ф�");
		}
		
		mbh.closeHandler(ss);
		return finalFlag;
		
//		if(rVO.getReviewImg().size()>0 && reviewAddFlag && chkUpdateFlag) { // �̹����� �ִ°��
//			// ���䰡 ���������� ���� reviewId�� �����°Ŵϱ� ����
//			String reviewId = ss.selectOne("kr.co.mpnp.user.mapper.reviewMapper.selectReviewId",rVO.getOrderDetailId());
//			rVO.setReviewId(reviewId);
//			
//			Map<String,Object> paramMap2 = null;
//			List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
//			List<String> imgList = rVO.getReviewImg();
//			String rId = rVO.getReviewId();
//			for(String img : imgList) {
//				paramMap2 = new HashMap<String,Object>();
//				System.out.println("����� : "+img);
//				paramMap2.put("reviewId", rId);
//				paramMap2.put("reviewImg",img);
//				list.add(paramMap2);
//			}
//			imgAddFlag = ss.insert("kr.co.mpnp.user.mapper.reviewMapper.insertReviewImg",list)==list.size()?true:false;
//			
//			if(imgAddFlag) {
//				finalFlag = true;
//			}
//			
//		}else { // �̹����� ���°��
//			
//		}
	
	}
	
/////////////////// Ʈ������׽�Ʈ �� //////////////////////////////	

	
	
	// �����ۼ�
	public boolean insertReview(ReviewVO rVO){
		boolean flag = false;
		int cnt = 0; // ������������ ��� ?? ���⿡�ϴ°� �´���
		
		
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getHandler();
		///////////////////////////////////////
		//System.out.println("insertReview�� ss : "+ss);
		///////////////////////////////////////
		cnt = ss.insert("kr.co.mpnp.user.mapper.reviewMapper.insertReview",rVO);
		// �ٵ� ���⼭ �ϳ��ϳ� Ŀ�� �ѹ��ϸ� Ʈ������� �ƴ����ʳ�??
		// ���񽺿��� DAO�� ��üȭ�ؼ� ��� �޼��带 �����ų������ �־�����ϳ�?? �ƴѰŰ�����..
		// commit, rollback�� ss���ִ°ǵ� ���� �޼��带 �����?? rDAO.commit()�ϸ� 
		// public void commit(
		//   ss.commit() �̷���..? �̰� �¾�?
		//}
		//
		if(cnt!=0) {
			flag = true;
			//ss.commit();
		}
		//else {
		//	ss.rollback();
		//}
		
		mbh.closeHandler(ss);
		return flag;
	}
	
	
	
	
	
	
	
	
	// �����ڵ���ȸ select
	public String selectReviewId(String odId) {
		String rid = "";
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getHandler();
		
		///////////////////////////////////////
		//System.out.println("selectReviewId�� ss : "+ss);
		///////////////////////////////////////
		
		//System.out.println("����� dao �� selectReviewId :"+odId);
		rid = ss.selectOne("kr.co.mpnp.user.mapper.reviewMapper.selectReviewId",odId);
		
		mbh.closeHandler(ss);
		return rid;
	}
	
	// �����̹��� �߰�
	public boolean insertReviewImgs(ReviewVO rVO) {
		boolean flag = false;
		int cnt = 0;
		
		
		Map<String,Object> paramMap2 = null;
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		List<String> imgList = rVO.getReviewImg();
		String rId = rVO.getReviewId();
		for(String img : imgList) {
			paramMap2 = new HashMap<String,Object>();
			//System.out.println("����� : "+img);
			paramMap2.put("reviewId", rId);
			paramMap2.put("reviewImg",img);
			list.add(paramMap2);
		}
		//paramMap.put("imgList", list);
		
		
		//for(int i=0;i<list.size();i++) {
			//System.out.println("����� : "+list.get(i));
		//}
		
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getHandler();
		
		///////////////////////////////////////
		//System.out.println("insertReviewImgs�� ss : "+ss);
		///////////////////////////////////////
		
		//System.out.println("DAO123line �����������");
		cnt = ss.insert("kr.co.mpnp.user.mapper.reviewMapper.insertReviewImg",list);
		if(cnt==list.size()) {
			flag = true;
		//	ss.commit();
		}
		//else {
		//	ss.rollback();
		//}
		
		
		mbh.closeHandler(ss);
		return flag;
	}
	
	// �����÷��� Y�� update
	public boolean updateReviewChk(String odId) {
		boolean flag = false;
		int cnt = 0;
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getHandler();
		
		///////////////////////////////////////
		//System.out.println("updateReviewChk�� ss : "+ss);
		///////////////////////////////////////
		
		
		cnt = ss.update("kr.co.mpnp.user.mapper.reviewMapper.updateReviewChk",odId);
		if(cnt!=0) {
			flag = true;
		//	ss.commit();
		}
		//else {
		//	ss.rollback();
		//}
		
		mbh.closeHandler(ss);
		return flag;
	}
	
	
	
	
	
	// �����������
	public ReviewDomain selectDetail(String reviewId){
		ReviewDomain rDomain = null;
		
		
		
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getHandler();
		rDomain = ss.selectOne("kr.co.mpnp.user.mapper.reviewMapper.selectReviewDetail",reviewId);
		
		mbh.closeHandler(ss);
		return rDomain;
	}
	
	// �������
	
	
	
	public boolean updateReview(ReviewVO rVO){
		
		int cnt = 0; // ������������ ��� ?? ���⿡�ϴ°� �´���
		
		return cnt!=0?true:false;
	}
	
	
	
	
	
	// �������
	public boolean deleteReview(String rId){
		int cnt = 0; // ������������ ��� ?? ���⿡�ϴ°� �´���
		boolean flag = false;
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getHandler();
		cnt = ss.update("kr.co.mpnp.user.mapper.reviewMapper.deleteReview",rId);
		if(cnt!=0) {
			flag = true;
			ss.commit();
		}
		else {
			ss.rollback();
		}
		
		
		mbh.closeHandler(ss);
		return flag;
	}
	
	
	
	
	
	
	
	
	
//	public void commitTest() {
//		MyBatisHandler mbh = MyBatisHandler.getInstance();
//		SqlSession ss = mbh.getHandler();
//		ss.commit();
//		//System.out.println("DAO�� �ִ� commit ���� ��");
//		mbh.closeHandler(ss);
//	}
//	public void rollback() {
//		MyBatisHandler mbh = MyBatisHandler.getInstance();
//		SqlSession ss = mbh.getHandler();
//		ss.rollback();
//		mbh.closeHandler(ss);
//	}
	
}
