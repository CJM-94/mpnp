package kr.co.mpnp.user.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.co.mpnp.handler.MyBatisHandler;
import kr.co.mpnp.user.domain.DestinationDomain;
import kr.co.mpnp.user.vo.DestinationVO;

public class DestinationDAO {

	private static DestinationDAO desDAO;

	private DestinationDAO() {
	}

	public static DestinationDAO getInstance() {
		if (desDAO == null) {
			desDAO = new DestinationDAO();
		}

		return desDAO;
	}
	
	// �������ȸ
	public List<DestinationDomain> selectDes(String id){
		List<DestinationDomain> list = null;
				
		// 1. Mybatis Handler �ޱ�
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getHandler();
		System.out.println("DestinationDAO : ssesion - "+ss);
		
		// 2. ��������
		list = ss.selectList("kr.co.mpnp.user.mapper.destinationMapper.selectDesList",id);
		
		// 3. ����
		mbh.closeHandler(ss);
				
		return list;
	}
	
	// ������߰�
	//public int insertDes(DestinationVO dtVO){
	public int insertDes(DestinationVO dtVO){
		
		System.out.println("�����DAO : "+dtVO.toString());
		int cnt = 0;// ������������ 
		
		// 1. Mybatis Handler �ޱ�
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getHandler();
		System.out.println("DestinationDAO : ssesion - "+ss);
		
		// 2. ��������
		cnt = ss.insert("kr.co.mpnp.user.mapper.destinationMapper.insertDes",dtVO);
		if(cnt==1) {
			System.out.println(cnt+"�� �߰�");
			ss.commit();
		}else {
			System.out.println("�������߰�X");
		}
		// 3. ����
		mbh.closeHandler(ss);
						
		
		//return cnt;
		return cnt; 
	}
	
	public int updateDefault(String id){
		
		int cnt = 0;// ������������ 
		
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getHandler();
		
		System.out.println("updateDefault�� ���� id : "+id);
		cnt = ss.update("kr.co.mpnp.user.mapper.destinationMapper.updateDefault",id);
		if(cnt!=0) {
			ss.commit();
		}else {
			System.out.println("�������߰�X");
			ss.rollback();
		}
		mbh.closeHandler(ss);
		
		return cnt; 
	}
	
	// �������������
	public int updateDes(DestinationVO dtVO){
		
		int cnt = 0;
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getHandler();
		System.out.println("DestinationDAO : ssesion - "+ss);
		System.out.println("����ٿ�::::::::::::::::::::::"+dtVO.toString());
		// 2. ��������
		cnt = ss.update("kr.co.mpnp.user.mapper.destinationMapper.updateDes",dtVO);
		System.out.println(cnt);
		if(cnt!=0) {
			System.out.println(cnt+"�� �߰�");
			ss.commit();
		}else {
			System.out.println("�������߰�X");
		}
		// 3. ����
		mbh.closeHandler(ss);
		
		
		return cnt; 
	}
	
	
	// ���������
	public int deleteDes(String dtId){
		
		System.out.println("�����DAO : "+dtId);
		int cnt = 0;// ������������ 
		
		// 1. Mybatis Handler �ޱ�
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getHandler();
		System.out.println("DestinationDAO : ssesion - "+ss);
		
		// 2. ��������
		cnt = ss.insert("kr.co.mpnp.user.mapper.destinationMapper.deleteDes",dtId);
		if(cnt==1) {
			ss.commit();
		}else {
			System.out.println("�����ͻ���X");
		}
		// 3. ����
		mbh.closeHandler(ss);
		
		return cnt;
	}
	
	
	
}
