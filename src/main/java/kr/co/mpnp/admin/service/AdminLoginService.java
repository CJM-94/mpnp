package kr.co.mpnp.admin.service;

import kr.co.mpnp.admin.dao.AdminLoginDAO;
import kr.co.mpnp.admin.vo.AdminLoginVO;

public class AdminLoginService {
	//������-�α���
	public boolean searchAdminLogin(AdminLoginVO alVO){
		boolean flag=false;
		
		AdminLoginDAO aDAO=AdminLoginDAO.getInstance();
		flag=aDAO.selectAdminLogin(alVO); 
		
		return  flag;
	}
	
	//������-�������
	public int modifyAdminPass(AdminLoginVO alVO) {
		int cnt=0;
	
		AdminLoginDAO aDAO=AdminLoginDAO.getInstance();
		cnt=aDAO.updateAdminPass(alVO);
		
		return cnt;
	}
}

