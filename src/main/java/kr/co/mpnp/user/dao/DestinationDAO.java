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
		//System.out.println("DestinationDAO : ssesion - "+ss);
		
		// 2. ��������
		list = ss.selectList("kr.co.mpnp.user.mapper.destinationMapper.selectDesList",id);
		
		// 3. ����
		mbh.closeHandler(ss);
				
		return list;
	}
	
	// ������߰�
	//public int insertDes(DestinationVO dtVO){
	public boolean insertDes(DestinationVO dtVO){
		
		//System.out.println("�����DAO : "+dtVO.toString());
		int cnt = 0;// ������������ 
		
		// 1. Mybatis Handler �ޱ�
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getHandler();
		//System.out.println("DestinationDAO : ssesion - "+ss);
		
		// 2. ��������
		
		
		
		boolean defaultFlag = false;
		boolean insertFlag = false;
		boolean finalFlag = false;
		if("O".equals(dtVO.getDefaultFlag())){
			defaultFlag = ss.update("kr.co.mpnp.user.mapper.destinationMapper.updateDefault",dtVO.getId())!=0?true:false;
			insertFlag = ss.insert("kr.co.mpnp.user.mapper.destinationMapper.insertDes",dtVO)!=0?true:false;
			if(insertFlag && defaultFlag) {
				//System.out.println("Ŀ�Ե�");
				ss.commit();
				finalFlag = true;
			}else {
				//System.out.println("�ѹ��");
				ss.rollback();
			}
		}else { // O�� �ƴҰ�쿡�� update�⺻����� �̰� �� �ʿ䰡���� ����
			insertFlag = ss.insert("kr.co.mpnp.user.mapper.destinationMapper.insertDes",dtVO)!=0?true:false;
			if(insertFlag) {
				//System.out.println("Ŀ�Ե�");
				ss.commit();
				finalFlag = true;
			}else {
				//System.out.println("�ѹ��");
				ss.rollback();
			}
		}
		
		// 3. ����
		mbh.closeHandler(ss);
		//return cnt;
		return finalFlag; 
	}
	
//	public int updateDefault(String id){
//		
//		int cnt = 0;// ������������ 
//		
//		MyBatisHandler mbh = MyBatisHandler.getInstance();
//		SqlSession ss = mbh.getHandler();
//		
//		System.out.println("updateDefault�� ���� id : "+id);
//		cnt = ss.update("kr.co.mpnp.user.mapper.destinationMapper.updateDefault",id);
//		if(cnt!=0) {
//			ss.commit();
//		}else {
//			System.out.println("�������߰�X");
//			ss.rollback();
//		}
//		mbh.closeHandler(ss);
//		
//		return cnt; 
//	}
	
	// �������������
	public boolean updateDes(DestinationVO dtVO){
		
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getHandler();
		//System.out.println("DestinationDAO : ssesion - "+ss);
		
		// 2. ��������
		
		
		boolean defaultFlag = false;
		boolean updateFlag = false;
		boolean finalFlag = false;
		if("O".equals(dtVO.getDefaultFlag())){
			//System.out.println("������� ��1");
			defaultFlag = ss.update("kr.co.mpnp.user.mapper.destinationMapper.updateDefault",dtVO.getId())!=0?true:false;
			//System.out.println("������� ��2");
			updateFlag = ss.update("kr.co.mpnp.user.mapper.destinationMapper.updateDes",dtVO)!=0?true:false;
			//System.out.println("������� ��3");
			if(updateFlag && defaultFlag) {
				//System.out.println("Ŀ�Ե�");
				ss.commit();
				finalFlag = true;
			}else {
				//System.out.println("�ѹ��");
				ss.rollback();
			}
		}else {
			updateFlag = ss.update("kr.co.mpnp.user.mapper.destinationMapper.updateDes",dtVO)!=0?true:false;
			if(updateFlag) {
				//System.out.println("Ŀ�Ե�");
				ss.commit();
				finalFlag = true;
			}else {
				//System.out.println("�ѹ��");
				ss.rollback();
			}
		}
		
		// 3. ����
		mbh.closeHandler(ss);
		
		
		return finalFlag; 
	}
	
	
	// ���������
	public int deleteDes(String dtId){
		
		//System.out.println("�����DAO : "+dtId);
		int cnt = 0;// ������������ 
		
		// 1. Mybatis Handler �ޱ�
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getHandler();
		//System.out.println("DestinationDAO : ssesion - "+ss);
		
		// 2. ��������
		cnt = ss.insert("kr.co.mpnp.user.mapper.destinationMapper.deleteDes",dtId);
		if(cnt==1) {
			ss.commit();
		}else {
			//System.out.println("�����ͻ���X");
			ss.rollback();
		}
		// 3. ����
		mbh.closeHandler(ss);
		
		return cnt;
	}
	
	
	
}
