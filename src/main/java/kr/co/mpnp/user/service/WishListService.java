package kr.co.mpnp.user.service;

import java.util.List;

import kr.co.mpnp.user.dao.WishListDAO;
import kr.co.mpnp.user.domain.WishDomain;
import kr.co.mpnp.user.vo.WishListVO;

public class WishListService {
	
	WishListDAO wDAO=WishListDAO.getInstance();
	//�� ����Ʈ 
	public List<WishDomain> searchWishList(String id){
		List<WishDomain> list = wDAO.selectWish(id);
		
		return list;
	}
	//�� ����
	public int removeWishList(WishListVO wVO) {
	
		int check=wDAO.deleteWishList(wVO);
		
		return check;
	}

	
	

}
