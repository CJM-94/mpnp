package kr.co.mpnp.user.service;

import java.util.ArrayList;

import java.util.List;

import kr.co.mpnp.user.dao.MainDAO;
import kr.co.mpnp.user.domain.MainDomain;

public class MainService {
	
	
	MainDAO mainDAO = MainDAO.getInstance();
	
	//���� ����Ʈ
	 public List<MainDomain> searchPrdList(String mainid){
		
		 List<MainDomain> list =mainDAO.selectPrdList(mainid);
	 
	 return list;
	 
	 }
	 //�� �Խù� ��
		public int searchPrdCnt (String mainid) {
			int cnt=mainDAO.selectprdCnt(mainid);
			
			return cnt;
			
		}
		

		//��ٱ��� ����
		public int CartTotalCnt(String id) {
			int cnt =mainDAO.TotalCnt(id);
			return cnt;
		}
		
		
//		
//		//������ ������ ��
//		public int lastPage(int searchPrdCnt) {
//			int lastPage=(int)Math.ceil((double) searchPrdCnt /8);
//			
//			return lastPage;
//		}
//		
//		//���������� ���۹�ȣ
//		public int startNum(int curPage) {
//			int startNum=curPage-(curPage-1)%8;
//			return startNum;
//			
//		}
//		//���������� ������ ��������
//		public int isLast(int lastPage,int startNum) {
//			int isLast =2; //0,1,2, 3��������
//			if(startNum+3>lastPage) {
//				isLast= lastPage-startNum;
//				
//			}
//			return isLast;
//			
//		}
		public static void main(String[] args) {
			
	MainService ms= new MainService();
			System.out.println(ms.CartTotalCnt("id001"));
			
		}

	


}// class
