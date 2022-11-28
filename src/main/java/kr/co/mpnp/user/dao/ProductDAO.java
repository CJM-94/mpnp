package kr.co.mpnp.user.dao;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import kr.co.mpnp.admin.domain.AdminProductDomain;
import kr.co.mpnp.handler.MyBatisHandler;
import kr.co.mpnp.user.domain.CartDomain;
import kr.co.mpnp.user.domain.ProductDomain;
import kr.co.mpnp.user.vo.CartVO;
import kr.co.mpnp.user.vo.ProductCartVO;
import kr.co.mpnp.user.vo.ProductVO;
import kr.co.mpnp.user.vo.WishListVO;


public class ProductDAO {
	
private static ProductDAO pDAO;
	
	private ProductDAO() {
		
	}
	
	public static ProductDAO getInstance() {
		if(pDAO==null) {
			pDAO=new ProductDAO();
		}
	return pDAO;
	}
	//��ǰ�󼼺���
	public ProductDomain selectPrdDetail(String productid) {
		
		ProductDomain pd = null;
		
		//1.MyBatisHandler���
				MyBatisHandler mbh = MyBatisHandler.getInstance();
				SqlSession ss= mbh.getHandler();
				try {
				//2.������ ����
				pd=ss.selectOne("kr.co.mpnp.user.mapper.ProductMapper.selectPrddetail", productid);
				
				}catch(PersistenceException pe) {
					pe.printStackTrace();
				}
				//3.�������
				mbh.closeHandler(ss);
				
		return pd;
	}
	
	//��ǰ�ߺз�����Ʈ
	public List<ProductDomain> selectprdList(ProductVO pVO) {
		
		List<ProductDomain> list= null;
		
		//1.MyBatisHandler���
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss= mbh.getHandler();
		try {
		//2.������ ����
		list=ss.selectList("kr.co.mpnp.user.mapper.ProductMapper.selectprdList", pVO);
		
		}catch(PersistenceException pe) {
			pe.printStackTrace();
		}
		//3.�������
		mbh.closeHandler(ss);
		
		return list;
	}
	
	
	//��ǰ �� ����
	public int selectprdCnt(ProductVO pVO) {
		int cnt=0;
		
		//1.MyBatisHandler���
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss= mbh.getHandler();
		//2.������ ����
		cnt=ss.selectOne("kr.co.mpnp.user.mapper.ProductMapper.selectprdCnt",pVO);
		//3.�������
		mbh.closeHandler(ss);
		
		
		return cnt;
	}
	
	
	//��ǰ�̹��� 
	public List<ProductDomain> selectPrdImg(String productid){
		
		List<ProductDomain> list= null;
		
		//1.MyBatisHandler���
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss= mbh.getHandler();
		try {
		//2.������ ����
		list=ss.selectList("kr.co.mpnp.user.mapper.ProductMapper.selectImg", productid);
		
		}catch(PersistenceException pe) {
			pe.printStackTrace();
		}
		//3.�������
		mbh.closeHandler(ss);
		
		return list;
		
		
	}
	
	
	//��ٱ��� �߰�
	
	public int insertCart(ProductCartVO cVO) {
		int cnt=0;
		//1.MyBatisHandler���
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss= mbh.getHandler();
		try {
			cnt=ss.insert("kr.co.mpnp.user.mapper.ProductMapper.insertCart",cVO);
			ss.commit();
		}catch(PersistenceException pe) {
			pe.printStackTrace();
		}
		//3.�������
		mbh.closeHandler(ss);
		
		
		return cnt;
	}
	
	//��ٱ��ϸ�Ͽ� ���ִ��� Ȯ��
	public int  checkCart(ProductCartVO cVO) {
		
		//1.MyBatisHandler���
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss= mbh.getHandler();
	
		int check=0;
		try {
		check=	ss.selectOne("kr.co.mpnp.user.mapper.ProductMapper.selectConfirmCart",cVO);
		if(check!=0) {
		
			ss.commit();
		}
		}catch(PersistenceException pe) {
			pe.printStackTrace();
		}
		//3.�������
		mbh.closeHandler(ss);
		
		return check;
	
		
	}
	
	//���߰�
	public int insertWishList(ProductCartVO cVO) {
		int check=0;
		int cnt=0;
		int delete=0;
		boolean Flag=false;
		//1.MyBatisHandler���
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss= mbh.getHandler();
		try {
			check=ss.selectOne("kr.co.mpnp.user.mapper.ProductMapper.selectConfirmWish",cVO);
			System.out.println("Ȯ��"+check);
			if(check==0) {
			cnt=ss.insert("kr.co.mpnp.user.mapper.ProductMapper.insertWishList",cVO);
			System.out.println("----���߰�"+cnt);
			Flag=true;	
			}else if(check>=1) {
				WishListVO wVO =new WishListVO();
				wVO.setId(cVO.getId());
				wVO.setProductid(cVO.getProductid());
				System.out.println(wVO);
			delete=ss.delete("kr.co.mpnp.user.mapper.ProductMapper.deleteWish",wVO);
			if(delete!=0) {
			System.out.println("��������"+delete);
			Flag=true;	
			}else {
			System.out.println("��������+"+delete);
			}
		
			}
			if(Flag=true) {
				
				ss.commit();
			}
		}catch(PersistenceException pe) {
			pe.printStackTrace();
		}
		//3.�������
		mbh.closeHandler(ss);
		
		
		return cnt;
	}
	
	//�� ����
	public int  selectcheckWish(WishListVO wVO) {
		int check=0;
	
		//1.MyBatisHandler���
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss= mbh.getHandler();
		

		check=	ss.selectOne("kr.co.mpnp.user.mapper.ProductMapper.selectConfirmWish",wVO);
	
		
	
		//3.�������
		mbh.closeHandler(ss);
		
		return check;
	
		
	}

	
	
	
	public static void main(String[] args) {
		
		ProductDAO pDAO= new ProductDAO();
		ProductVO pVO= new ProductVO();
		WishListVO wVO= new WishListVO();
		ProductCartVO cVO = new ProductCartVO();
		wVO.setId("id001");
		wVO.setProductid("p00");
		pVO.setsub_id("s0001");
//System.out.println(pDAO.selectprdList(pVO));
//System.out.println(pDAO.selectprdCnt(pVO));
//System.out.println(pDAO.selectcheckWish(wVO));
//		System.out.println(pDAO.selectPrdDetail("p0001"));
//		System.out.println(pDAO.selectprdCnt(pVO));
		
		System.out.println(pDAO.selectcheckWish(wVO));
	}

}//class

