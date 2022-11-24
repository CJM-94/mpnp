package kr.co.mpnp.admin.dao;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import kr.co.mpnp.admin.domain.AdminCategoryDomain;
import kr.co.mpnp.admin.domain.AdminProductDomain;
import kr.co.mpnp.admin.vo.AdminProductVO;
import kr.co.mpnp.handler.MyBatisHandler;

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
public List<AdminProductDomain> selectPrd (AdminProductVO apVO){
	List<AdminProductDomain> list =null;
	
	//1.MyBatis Handler���
	MyBatisHandler mbh=MyBatisHandler.getInstance();
	SqlSession ss= mbh.getHandler();
	//2.����������
	try {
		
		
		
	list=ss.selectList("kr.co.mpnp.admin.mapper.AdminProductMapper.selectPrd",apVO);
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
//��ǰ�ڵ� ��ȸ
public String selectProductId() {
String prID="";
// �ڵ鷯 ���
// MyBatisHandler���
MyBatisHandler mbh = MyBatisHandler.getInstance();
SqlSession ss = mbh.getHandler();
try {
	// ���� ����
	prID = ss.selectOne("kr.co.mpnp.admin.mapper.AdminProductMapper.selectPrdId");
	// System.out.println(orID);
} catch (PersistenceException pe) {
	pe.printStackTrace();
}
// �������
mbh.closeHandler(ss);

return prID;
	
	
}


//��ǰ�߰�
public int insertProduct(AdminProductVO apVO) {
	int cnt=0;
	int img=0;
	//1.MyBatis Handler���
		MyBatisHandler mbh=MyBatisHandler.getInstance();
		SqlSession ss= mbh.getHandler();
		//2.����������
		try {
			cnt=ss.insert("kr.co.mpnp.admin.mapper.AdminProductMapper.insertPrd",apVO);
	if(cnt==1) {		
			
			img+=ss.insert("kr.co.mpnp.admin.mapper.AdminProductMapper.insertPrdImg", apVO);
		ss.commit();
		
	}
	}catch(PersistenceException pe) {
			pe.printStackTrace();
		
		}
		//3.MyBatis Handler�ݱ�
		mbh.closeHandler(ss);
	
	
	return cnt;
}

	public static void main(String[] args) {
		
		AdminProductDAO apDAO = new AdminProductDAO();
		AdminProductVO apVO = new AdminProductVO();
		//apVO.setname("��");
		apVO.setmain_id("m0001");
		//apVO.setsub_id("s000");
	System.out.println(apDAO.selectPrd(apVO));
//System.out.println(apDAO.selectPrdDetail("p0001"));
//	apVO.setname("�׽�Ʈ");
//	apVO.setPrice(123);
//	apVO.setth_img("TEST1");
//	apVO.setinfo_img("TESTB1");
//	apVO.setStatus("Y");
//	apVO.setsub_id("s0005");
//	apVO.setProductid("p12345678");
//	System.out.println(apDAO.insertProduct(apVO));
//System.out.println(apDAO.selectProductId());
	}

}
