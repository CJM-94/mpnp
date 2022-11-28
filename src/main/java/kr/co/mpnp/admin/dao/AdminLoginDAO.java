package kr.co.mpnp.admin.dao;

import org.apache.ibatis.session.SqlSession;

import kr.co.mpnp.admin.vo.AdminLoginVO;
import kr.co.mpnp.handler.MyBatisHandler;

public class AdminLoginDAO {
	private static AdminLoginDAO alDAO;
	
	private AdminLoginDAO() {
			
	}

	public static AdminLoginDAO getInstance(){
			if(alDAO==null) {
				alDAO= new AdminLoginDAO();
			}
			return alDAO;
	}
	
	
	
	//������-�α���
	public boolean selectAdminLogin(AdminLoginVO alVO){
		boolean flag=false;
		
		//1.MyBatis Handler���
		MyBatisHandler mbh=MyBatisHandler.getInstance();
		SqlSession ss=mbh.getHandler();
		//System.out.println(alVO.getId()+"/"+alVO.getPass()); //�� �� �޾���
				
		//2.����������
		int cnt=ss.selectOne("kr.co.mpnp.admin.mapper.adminLoginMapper.selectAdminLogin",alVO);
		if(cnt!=0) {
			//ss.commit();//select�Ҷ� �ʿ���� �žƴϾ� ?  
			flag=true;
		}else {
			//System.out.println("�α��ο� �����Ͽ����ϴ�");
		}
		//cnt �׽�Ʈ
		//System.out.println(cnt+"��");
				
		//3.MyBatis Handler ����
		mbh.closeHandler(ss);
				
		return flag;
	}
	
	
	//������- �������
	public int updateAdminPass(AdminLoginVO alVO) {
		//1.MyBatis Handler���
		MyBatisHandler mbh=MyBatisHandler.getInstance();
		SqlSession ss=mbh.getHandler();
		//System.out.println("���ǿ� �ִ� ���̵�..."+alVO.getId()); //null�ε� �����ڴ� ��
		
		//2.����������
		int cnt=ss.update("kr.co.mpnp.admin.mapper.adminLoginMapper.updateAdminPass",alVO);
		if(cnt!=0) {
			//System.out.println(alVO.getNewpass()+"���� ��� ����Ϸ�");
			ss.commit();//�� �̰� �������� .... 
		}else {
			//System.out.println("�����Ͽ����ϴ�");
		}
		//cnt �׽�Ʈ
		//System.out.println(cnt+"��");
		
		//3.MyBatis Handler ����
		mbh.closeHandler(ss);
		
		return cnt;
	}

	public static void main(String[] args) {

	}

}
