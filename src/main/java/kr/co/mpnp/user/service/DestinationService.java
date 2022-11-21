package kr.co.mpnp.user.service;

import java.util.List;

import org.json.simple.JSONObject;

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
	public String addDes(DestinationVO dtVO){
		
		System.out.println("����� Service : "+dtVO.toString());
		
		JSONObject jsonData = new JSONObject();
		DestinationDAO desDAO = DestinationDAO.getInstance();
		//desDAO.insertDes(dtVO);
		boolean addFlag = desDAO.insertDes(dtVO)==1?true:false;
		jsonData.put("addFlag", addFlag);
		
		
		return jsonData.toJSONString();
	}
	
	// ����� �߰�,����� �⺻����� OX�� ���� update,,,,
	public boolean editDefault(DestinationVO dtVO){
		boolean flag = false;
		System.out.println("����� Service dtVO�� id�� : "+dtVO.getId());
		
		DestinationDAO desDAO = DestinationDAO.getInstance();
		flag = desDAO.updateDefault(dtVO.getId())!=0?true:false;
		
		return flag;
	}
	
	// �������������
	public String modifyDes(DestinationVO dtVO){
		
		JSONObject jsonData = new JSONObject();
		DestinationDAO desDAO = DestinationDAO.getInstance();
		//desDAO.insertDes(dtVO);
		boolean editFlag = desDAO.updateDes(dtVO)!=0?true:false;
		jsonData.put("editFlag", editFlag);
		
		return jsonData.toJSONString();
	}
	
	// ���������
	public String removeDes(String dtId){
		
		System.out.println("����� Service : "+dtId);
		
		JSONObject jsonData = new JSONObject();
		DestinationDAO desDAO = DestinationDAO.getInstance();
		//desDAO.insertDes(dtVO);
		boolean removeFlag = desDAO.deleteDes(dtId)==1?true:false;
		jsonData.put("removeFlag", removeFlag);
		
		return jsonData.toJSONString();
	}
	
	
	
	
}
