package kr.co.mpnp.user.dao;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import kr.co.mpnp.handler.MyBatisHandler;
import kr.co.mpnp.user.domain.SearchDomain;
import kr.co.mpnp.user.vo.SearchVO;

public class SearchDAO {
	
private static SearchDAO searchDAO;
	
	private  SearchDAO() {
		
	}
	
	public static SearchDAO getInstance() {
		if(searchDAO==null) {
			searchDAO=new SearchDAO();
		}
	return searchDAO;
	}
	
	
	//�˻����
	public List<SearchDomain> selectProduct(SearchVO sVO){
		List<SearchDomain> list=null;
		MyBatisHandler mbh= MyBatisHandler.getInstance();
		SqlSession ss= mbh.getHandler();
		//2.
		
		try {
			
			list=ss.selectList("kr.co.mpnp.user.mapper.SearchMapper.searchPrd",sVO);
			ss.commit();
			
		}catch(PersistenceException pe) {
			pe.printStackTrace();
		}
		
		//3.
		mbh.closeHandler(ss);
		
		
		return list;
	}
	
	//�˻���� �� ����
	public int selectTotalCnt(SearchVO sVO) {
		int cnt=0;
		
		//1.MyBatisHandler���
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss= mbh.getHandler();

		try {
		//2.������ ����
		cnt=ss.selectOne("kr.co.mpnp.user.mapper.SearchMapper.selectTotalCnt", sVO);
		
		}catch(PersistenceException pe) {
		pe.printStackTrace();
		}
		
		
		//3.�������
		mbh.closeHandler(ss);
		
		
		return cnt;
		
	}
	
	
	//����Ʈ 5��
	public  List<SearchDomain> selectBestFive() {
		
		List<SearchDomain> list=null;
		MyBatisHandler mbh= MyBatisHandler.getInstance();
		SqlSession ss= mbh.getHandler();
		//2.
		
		try {
			
			list=ss.selectList("kr.co.mpnp.user.mapper.SearchMapper.selectBest");
			ss.commit();
			
		}catch(PersistenceException pe) {
			pe.printStackTrace();
		}
		
		//3.
		mbh.closeHandler(ss);
		return list;
		
		

	}
	

	
	
}
