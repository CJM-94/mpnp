package kr.co.mpnp.user.dao;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import kr.co.mpnp.handler.MyBatisHandler;
import kr.co.mpnp.user.domain.MainDomain;
import kr.co.mpnp.user.vo.MainVO;


public class MainDAO {
	
	private static MainDAO mainDAO;
	
	private MainDAO() {
		
	}
	
	public static MainDAO getInstance() {
		if(mainDAO==null) {
			mainDAO =new MainDAO();
		}
	return mainDAO;
	}
	

	

//상품 리스트	
	public List<MainDomain> selectPrdList(String mainid){
		List<MainDomain> list=null;
		
		//1.MyBatisHandler?뼸湲?
		MyBatisHandler mbh= MyBatisHandler.getInstance();
		SqlSession ss= mbh.getHandler();
		//2.
		
		try {
			
			list=ss.selectList("kr.co.mpnp.user.mapper.MainMapper.selectPrdList",mainid);
			ss.commit();
			
		}catch(PersistenceException pe) {
			pe.printStackTrace();
		}
		
		//3.
		mbh.closeHandler(ss);
		return list;
	}
	//페이징 상품 전체보기
	public List<MainDomain> selectAllList(MainVO mVO){
		List<MainDomain> list=null;
		
		//1.MyBatisHandler?뼸湲?
		MyBatisHandler mbh= MyBatisHandler.getInstance();
		SqlSession ss= mbh.getHandler();
		//2.
		
		try {
			
			list=ss.selectList("kr.co.mpnp.user.mapper.MainMapper.selectAllList",mVO);
			ss.commit();
			
		}catch(PersistenceException pe) {
			pe.printStackTrace();
		}
		
		//3.
		mbh.closeHandler(ss);
		return list;
	}
	
	//상품 총 갯수
	public int selectprdCnt(MainVO mVO) {
		int cnt=0;
		
		//1.MyBatisHandler얻기
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss= mbh.getHandler();
		//2.쿼리문 실행
		cnt=ss.selectOne("kr.co.mpnp.user.mapper.MainMapper.selectprdCnt", mVO);
		//3.연결끊기
		mbh.closeHandler(ss);
		
		
		return cnt;
	}
	
	//장바구니 갯수
	public int TotalCnt(String id) {
	int cnt=0;
		
		//1.MyBatisHandler얻기
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss= mbh.getHandler();
		//2.쿼리문 실행
		cnt=ss.selectOne("kr.co.mpnp.user.mapper.MainMapper.selectCart", id);
		//3.연결끊기
		mbh.closeHandler(ss);
		
		
		return cnt;
		
		
	}
	
	

	


}//class
