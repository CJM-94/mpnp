package kr.co.mpnp.user.service;

import java.util.ArrayList;
import java.util.List;

import kr.co.mpnp.user.dao.SearchDAO;
import kr.co.mpnp.user.domain.SearchDomain;
import kr.co.mpnp.user.vo.SearchVO;

public class SearchService {

	SearchDAO searchDAO = SearchDAO.getInstance();
	
	//�˻����
	public List<SearchDomain> searchProduct(SearchVO sVO){
		
		List<SearchDomain> list = searchDAO.selectProduct(sVO);
	
		
		
		return list;
	}
	
	//�˻���� �� ����
	public int TotalCnt(SearchVO sVO) {
		int cnt=searchDAO.selectTotalCnt(sVO);
		return cnt;
		
	}
	
	//������ ��������
	public int lastPage(int TotalCnt) {
		int lastPage=(int)Math.ceil((double) TotalCnt / 6);
		//6���� �����ٰŴ� ������ 6
		return lastPage;
		
	}
	
	//���������� ���۹�ȣ
	public int startNum(int curPage) {
		int startNum=curPage-(curPage-1)%3;
//		012 3�����°�
		return startNum;
	}
	
	//���������� ������ ��������
	public int isLast(int lastPage,int startNum) {
		int isLast =2; //0,1,2, 3��������
		if(startNum+3>lastPage) {
			isLast= lastPage-startNum;
			
		}
		return isLast;
		
	}
	
	
//	
//	public int pageScale() {
//		int pageScale=6;
//		
//		return pageScale;
//	}
//	
//	
//	//���������� 6���� ������ �� ������ ��
//	public int totalPage(int TotalCnt,int pageScale) {
//		int totalPage=0;
//	
//		
//		totalPage=(int)Math.ceil((double)TotalCnt/pageScale);
//		return totalPage;
//	}
//	//���۹�ȣ
//	public int StartNum(int currentPage,int pageScale) {
//		int startNum=1;
//		
//		if(currentPage<1) {
//			currentPage=1;
//		}//end if
//		startNum=currentPage*pageScale-pageScale+1;
//		
//		return startNum;
//	}//startNum
//	
//	//����ȣ 
//	public int endNum(int startNum , int pageScale) {
//		int endNum=startNum+pageScale-1;
//		return endNum;
//	}
	
	
	//����Ʈ5��
	public List<SearchDomain> searchBestFive(){
		
		List<SearchDomain> list = searchDAO.selectBestFive();
		
		return list;
	}
	public static void main(String[] args) {
		
		
		SearchVO sVO =new SearchVO();
		sVO.setName("g");
		SearchService ss =new SearchService();
		System.out.println(ss.TotalCnt(sVO));
		 
		
		
	}
	
	
}//class
