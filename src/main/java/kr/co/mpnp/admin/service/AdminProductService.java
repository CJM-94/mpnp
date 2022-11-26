package kr.co.mpnp.admin.service;


import java.sql.SQLException;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import kr.co.mpnp.admin.dao.AdminProductDAO;
import kr.co.mpnp.admin.domain.AdminCategoryDomain;
import kr.co.mpnp.admin.domain.AdminProductDomain;
import kr.co.mpnp.admin.vo.AdminProductVO;

public class AdminProductService {
	
	AdminProductDAO apDAO =AdminProductDAO.getInstance();
	
	
	
	
	
	//��ǰī�װ� : json

	 public String SubCategory(String mainid) throws SQLException{ 
		 JSONObject jsonObj = new JSONObject(); 
		 boolean resultFlag=false;
	 
	 List<AdminCategoryDomain> list= apDAO.selectCategory(mainid);
	
	 	JSONObject jsonTemp=null; 
	 	JSONArray jsonArr = new JSONArray();
	 //db��ȸ����� JsonObject�� �Ҵ�
	 for(AdminCategoryDomain ad : list) {
		
		 jsonTemp = new JSONObject();
		 //DB��ȸ����� JSONObject�� �Ҵ�
		 jsonTemp.put("subname", ad.getSubname());
		 jsonTemp.put("subid", ad.getSubid());
		 //���� ���� JSONObject�� JSONArray�Ҵ�
		 jsonArr.add(jsonTemp);
	 }//end for 

	 //�����ȸ����� ���� JSONArray�� JSONObject�� �Ҵ�
	 	jsonObj.put("subData", jsonArr);
		 jsonObj.put("resultFlag", !resultFlag);
		 jsonObj.put("main", mainid);
	 
	 
	 return jsonObj.toJSONString(); 
	 }//SubCategory
	 
	 //��ǰī�װ� : 
	 public List<AdminCategoryDomain> searchCategory2(String mainid){
		 
		 List<AdminCategoryDomain> list= apDAO.selectCategory(mainid);
		 
		 return list;
	 }
	 
	 //��ǰ���
	public List<AdminProductDomain> SearchPrdList(AdminProductVO apVO){
		List<AdminProductDomain> list=apDAO.selectPrd(apVO);
		
		System.out.println(list);
		return list;
	}
	//��ǰ�󼼺���
	public AdminProductDomain searchPrdDetail(String productid) {
		AdminProductDomain ap =apDAO.selectPrdDetail(productid);
		return ap;
	}
	
	//��ǰ�̹���
	public List<AdminProductDomain> searchPrdImg(String productid){
		
		List<AdminProductDomain> list= apDAO.selectPrdImg(productid);
	
		
		return list;
		
	}

	//��ǰ �߰�
	public void addProduct(AdminProductVO apVO) {
		String prID="";
	
		prID=apDAO.selectProductId();
		
		apVO.setProductid(prID); //vo�� �ڵ� ����
		if(apVO.getProductid()!=null) {
			apDAO.insertProduct(apVO);
			
		}
		
	
	
	}//addProduct
	
	public void modifyProduct(AdminProductVO apVO) {
		apDAO.updateProduct(apVO);
		
	}
	
	//��ǰ�̹���

	public static void main(String[] args) {
		AdminProductService as=new AdminProductService();
		try {
			System.out.println(as.SubCategory("m0001"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	
}
