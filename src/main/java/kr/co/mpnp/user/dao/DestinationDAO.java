package kr.co.mpnp.user.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.co.mpnp.handler.MyBatisHandler;
import kr.co.mpnp.user.domain.DestinationDomain;
import kr.co.mpnp.user.vo.DestinationVO;

public class DestinationDAO {

	private static DestinationDAO desDAO;

	private DestinationDAO() {
	}

	public static DestinationDAO getInstance() {
		if (desDAO == null) {
			desDAO = new DestinationDAO();
		}

		return desDAO;
	}
	
	// �������ȸ
	public List<DestinationDomain> selectDes(String id){
		List<DestinationDomain> list = null;
				
		// 1. Mybatis Handler �ޱ�
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getHandler();
		System.out.println("DestinationDAO : ssesion - "+ss);
		
		// 2. ��������
		list = ss.selectList("kr.co.mpnp.user.mapper.destinationMapper.selectDesList",id);
		
		// 3. ����
		mbh.closeHandler(ss);
				
		return list;
	}
	
	// ������߰�
	//public int insertDes(DestinationVO dtVO){
	public boolean insertDes(DestinationVO dtVO){
		
		
		int cnt = 0;// ������������ 
		
		
		//return cnt;
		return cnt!=0?true:false; 
	}
	
	// �������������
	public boolean updatetDes(DestinationVO dtVO){
		
		int cnt = 0;
		
		return cnt!=0?true:false; 
	}
	
	// ���������
	public boolean deleteDes(DestinationVO dtVO){
		
		int cnt = 0;
		
		return cnt!=0?true:false; 
	}
	
	
	
}
