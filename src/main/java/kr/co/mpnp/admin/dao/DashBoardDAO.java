package kr.co.mpnp.admin.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.co.mpnp.admin.domain.DashCategoryDomain;
import kr.co.mpnp.admin.domain.DashDailySalesDomain;
import kr.co.mpnp.admin.domain.DashMemberDomain;
import kr.co.mpnp.admin.domain.DashMonthlySalesDomain;
import kr.co.mpnp.handler.MyBatisHandler;

public class DashBoardDAO {

	private static DashBoardDAO dbDAO;
	
	private DashBoardDAO() {
	}
	
	public static DashBoardDAO getInstance() {
		if(dbDAO==null) {
			dbDAO = new DashBoardDAO();
		}
		return dbDAO;
	}
	
	// ��޺� ȸ���� ��ȸ
	public List<DashMemberDomain> selectMemByGrade(){
		List<DashMemberDomain> list = null;
		
		// 1. MyBatis Handler ���
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getHandler();
		
		// 2. �������� insert("Mapper���̵�",��)
		
		list = ss.selectList("kr.co.mpnp.admin.mapper.dashBoardMapper.selectMemByGrade");
		//System.out.println("��ġ AdminReviewDAO : "+list.hashCode());
		
		// 3. MyBatis Handler ����
		mbh.closeHandler(ss);
		
		return list;
	}
	
	// ī�װ��� ��ȸ
	public List<DashCategoryDomain> selectCountByCategory(String category){
		List<DashCategoryDomain> list = null;
		
		// 1. MyBatis Handler ���
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getHandler();
		
		// 2. �������� insert("Mapper���̵�",��)
		
		list = ss.selectList("kr.co.mpnp.admin.mapper.dashBoardMapper.selectCountByCategory",category);
		//System.out.println("��ġ AdminReviewDAO : "+list.hashCode());
		
		// 3. MyBatis Handler ����
		mbh.closeHandler(ss);
		
		return list;
	}
	
	
	
	
	
	
	
	// �Ϻ����� ��ȸ
	public List<DashDailySalesDomain> selectDailySales(){
		List<DashDailySalesDomain> list = null;
		
		// 1. MyBatis Handler ���
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getHandler();
		
		// 2. �������� insert("Mapper���̵�",��)
		
		list = ss.selectList("kr.co.mpnp.admin.mapper.dashBoardMapper.selectDailySales");
		//System.out.println("��ġ AdminReviewDAO : "+list.hashCode());
		
		// 3. MyBatis Handler ����
		mbh.closeHandler(ss);
		
		return list;
	}
	
	// �������� ��ȸ
	public List<DashMonthlySalesDomain> selectMonthlySales(){
		List<DashMonthlySalesDomain> list = null;
		
		// 1. MyBatis Handler ���
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getHandler();
		
		// 2. �������� insert("Mapper���̵�",��)
		
		list = ss.selectList("kr.co.mpnp.admin.mapper.dashBoardMapper.selectMonthlySales");
		//System.out.println("��ġ AdminReviewDAO : "+list.hashCode());
		
		// 3. MyBatis Handler ����
		mbh.closeHandler(ss);
		
		return list;
	}
	
	
}
