package kr.co.mpnp.user.service;

import java.util.List;

import kr.co.mpnp.user.dao.DestinationDAO;
import kr.co.mpnp.user.domain.DestinationDomain;
import kr.co.mpnp.user.vo.DestinationVO;

public class DestinationService {

	// �������ȸ
	public List<DestinationDomain> searchDes(String id){
		List<DestinationDomain> list = null;
		
		System.out.println("DestinationService : id - "+id);
		DestinationDAO desDAO = DestinationDAO.getInstance();
		list = desDAO.selectDes(id);
		
		return list;
	}
	
	// ������߰�
	public boolean addDes(DestinationVO dtVO){
		boolean addFlag = false;
		
		
		return addFlag;
	}
	
	// �������������
	public boolean modifyDes(DestinationVO dtVO){
		boolean modifyFlag = false;
		
		
		return modifyFlag;
	}
	
	// ���������
	public boolean removeDes(DestinationVO dtVO){
		boolean removeFlag = false;
		
		
		return removeFlag;
	}
	
	
	
	
}
