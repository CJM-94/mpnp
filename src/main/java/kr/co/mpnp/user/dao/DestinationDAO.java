package kr.co.mpnp.user.dao;

import java.util.List;

import kr.co.mpnp.user.domain.DestinationDomain;
import kr.co.mpnp.user.vo.DestinationVO;

public class DestinationDAO {

	// �������ȸ
	public List<DestinationDomain> selectDes(String id){
		List<DestinationDomain> list = null;
				
				
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
