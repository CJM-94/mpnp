package kr.co.mpnp.user.dao;

import java.util.List;

import kr.co.mpnp.user.domain.ReviewDomain;
import kr.co.mpnp.user.vo.ReviewVO;

public class ReviewDAO {

	// �ۼ������ı� ��ȸ
	public List<ReviewDomain> selectWritableReview(ReviewVO rVO){
		List<ReviewDomain> list = null;
		
		
		return list;
	}
	
	// �ۼ��ı� ��ȸ
	public List<ReviewDomain> selectWritenReview(ReviewVO rVO){
		List<ReviewDomain> list = null;
		
		
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
