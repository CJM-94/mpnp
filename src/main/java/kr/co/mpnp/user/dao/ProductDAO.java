package kr.co.mpnp.user.dao;

import org.apache.ibatis.session.SqlSession;

import kr.co.mpnp.handler.MyBatisHandler;
import kr.co.mpnp.user.domain.ProductDomain;


public class ProductDAO {

	public ProductDomain selectPrdDetail(String productid) {
		
		ProductDomain pd = null;
		
		//1.MyBatisHandler���
				MyBatisHandler mbh = MyBatisHandler.getInstance();
				SqlSession ss= mbh.getHandler();
				//2.������ ����
				pd=ss.selectOne("kr.co.mpnp.use.dao.mapper.ProductMapper.selectPrddetail", productid);
				//3.�������
				mbh.closeHandler(ss);
				
		return pd;
	}
	


}//class

