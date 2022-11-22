package kr.co.mpnp.admin.service;

import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import kr.co.mpnp.admin.dao.AdminProductDAO;
import kr.co.mpnp.admin.domain.AdminCategoryDomain;
import kr.co.mpnp.admin.domain.AdminProductDomain;

public class AdminProductService {
	
	AdminProductDAO apDAO =AdminProductDAO.getInstance();
	
	
	
	
	
	//��ǰ�ߺз�
	/*
	 * public String SubCategory(String mainid){ JSONObject category = new
	 * JSONObject(); boolean resultFlag=false;
	 * 
	 * try { List<AdminCategoryDomain> list= apDAO.selectCategory(mainid);
	 * 
	 * JSONObject jsonTemp=null; JSONArray jsonArr = new JSONArray();
	 * }catch(SQLException e) { resultFlag=true; e.printStackTrace(); }//end Catch
	 * 
	 * 
	 * return category.toJSONString(); }//SubCategory
	 */	//��ǰ���
	public List<AdminProductDomain> SearchPrdList(){
		List<AdminProductDomain> list=apDAO.selectPrd();
		
		return list;
	}
	//��ǰ�󼼺���
	public AdminProductDomain searchPrdDetail(String productid) {
		AdminProductDomain ap =apDAO.selectPrdDetail(productid);
		return ap;
	}

	
	public static void main(String[] args) {
		

	}
	
	
}
