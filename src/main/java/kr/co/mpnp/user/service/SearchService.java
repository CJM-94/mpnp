package kr.co.mpnp.user.service;

import java.util.ArrayList;
import java.util.List;

import kr.co.mpnp.user.dao.SearchDAO;
import kr.co.mpnp.user.domain.SearchDomain;

public class SearchService {

	SearchDAO searchDAO = SearchDAO.getInstance();
	
	//�˻����
	public List<SearchDomain> searchProduct(String productname){
		
		List<SearchDomain> list = searchDAO.selectProduct(productname);
	
		
		
		return list;
	}
	
	//�˻���� �� ����
	public int TotalCnt(String productname) {
		int cnt=searchDAO.selectTotalCnt(productname);
		return cnt;
		
	}
	
	public int pageScale() {
		int pageScale=6;
		
		return pageScale;
	}
	
	
	//���������� 6���� ������ �� ������ ��
	public int totalPage(int TotalCnt,int pageScale) {
		int totalPage=0;
	
		
		totalPage=(int)Math.ceil((double)TotalCnt/pageScale);
		return totalPage;
	}
	//���۹�ȣ
	public int StartNum(int currentPage,int pageScale) {
		int startNum=1;
		
		if(currentPage<1) {
			currentPage=1;
		}//end if
		startNum=currentPage*pageScale-pageScale+1;
		
		return startNum;
	}//startNum
	
	//����ȣ 
	public int endNum(int startNum , int pageScale) {
		int endNum=startNum+pageScale-1;
		return endNum;
	}
	
	
	//����Ʈ5��
	public List<SearchDomain> searchBestFive(){
		
		List<SearchDomain> list = searchDAO.selectBestFive();
		
		return list;
	}
	
	
	
}//class
