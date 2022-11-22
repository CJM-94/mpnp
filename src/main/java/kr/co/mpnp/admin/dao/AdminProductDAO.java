package kr.co.mpnp.admin.dao;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import kr.co.mpnp.admin.vo.AdminProductVO;
import kr.co.mpnp.admin.vo.AdminProductVO2;
import kr.co.mpnp.handler.MyBatisHandler;
import kr.co.mpnp.admin.domain.AdminCategoryDomain;
import kr.co.mpnp.admin.domain.AdminProductDomain;

public class AdminProductDAO {
	
	private static AdminProductDAO apDAO;
	private AdminProductDAO() {
		
	}
	public static AdminProductDAO getInstance() {
		
	if(apDAO==null) {
		apDAO = new AdminProductDAO();
	}
	return apDAO;
	}
	
	//ī�װ�
public List<AdminCategoryDomain> selectCategory(String mainid){
	List<AdminCategoryDomain> list =null;
	
	//1.MyBatis Handler���
	MyBatisHandler mbh=MyBatisHandler.getInstance();
	SqlSession ss= mbh.getHandler();
	//2.����������
	try {
	list=ss.selectList("kr.co.mpnp.admin.mapper.AdminProductMapper.selectCategory",mainid);
	}catch(PersistenceException pe) {
		pe.printStackTrace();
	}
	//3.MyBatis Handler�ݱ�
	mbh.closeHandler(ss);
	
	
	return list;
	
}
	//��ǰ ����Ʈ
public List<AdminProductDomain> selectPrd (){
	List<AdminProductDomain> list =null;
	
	//1.MyBatis Handler���
	MyBatisHandler mbh=MyBatisHandler.getInstance();
	SqlSession ss= mbh.getHandler();
	//2.����������
	try {
	list=ss.selectList("kr.co.mpnp.admin.mapper.AdminProductMapper.selectPrd");
	}catch(PersistenceException pe) {
		pe.printStackTrace();
	}
	//3.MyBatis Handler�ݱ�
	mbh.closeHandler(ss);
	
	
	return list;
	
	
}
	//��ǰ �󼼺���
public AdminProductDomain selectPrdDetail(String productid) {
	AdminProductDomain ap =null;
	//1.MyBatis Handler���
	MyBatisHandler mbh=MyBatisHandler.getInstance();
	SqlSession ss= mbh.getHandler();
	//2.����������
	try {
	ap=ss.selectOne("kr.co.mpnp.admin.mapper.AdminProductMapper.selectPrdDetail",productid);
	}catch(PersistenceException pe) {
		pe.printStackTrace();
	}
	//3.MyBatis Handler�ݱ�
	mbh.closeHandler(ss);
	
	
	return ap;
	
	
}
	public static void main(String[] args) {
		
		AdminProductDAO adDAO = new AdminProductDAO();
		

		System.out.println(adDAO.selectPrdDetail("p0001"));
		System.out.println(adDAO.selectCategory("m0001"));
		
	
	}

}
