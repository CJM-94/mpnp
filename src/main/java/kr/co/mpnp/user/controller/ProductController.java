package kr.co.mpnp.user.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.mpnp.user.domain.ProductDomain;
import kr.co.mpnp.user.domain.ProductReviewDomain;
import kr.co.mpnp.user.service.ProductReviewService;
import kr.co.mpnp.user.service.ProductService;
import kr.co.mpnp.user.vo.ProductCartVO;
import kr.co.mpnp.user.vo.ProductVO;
import kr.co.mpnp.user.vo.WishListVO;

@Controller
public class ProductController {
//��ǰ�ߺз�
@RequestMapping(value="/prdList.do", method=GET)
public String searchPrdList(ProductVO pVO,Model model) {
	
	ProductService ps=new ProductService();
	List<ProductDomain> list=ps.searchPrdList(pVO);

	model.addAttribute("sub", list);

	
	
	//����¡����
	int totalData =ps.searchPrdCnt(pVO);
	int lastPage = ps.lastPage(totalData);
	int curPage = pVO.getPageFlag();
	int startNum = ps.startNum(curPage);
	int isLast = ps.isLast(lastPage, startNum);
			
	//view�� ����
	model.addAttribute("totalData", totalData);
	model.addAttribute("lastPage", lastPage);
	model.addAttribute("startNum", startNum);
	model.addAttribute("isLast", isLast);
	model.addAttribute("curPage", curPage);
	
	
	return "user/product/prdList";
}

//��ǰ�󼼺���
@RequestMapping(value="/prddetail.do", method=GET)
public String searchPrdDetail( String reviewid,@RequestParam(value="productid") String productid,
		HttpSession session,Model model) {
	
	WishListVO wVO= new WishListVO();
	ProductCartVO cVO = new ProductCartVO();
	ProductService ps= new ProductService();
	ProductReviewService pr = new ProductReviewService();
	//���� �� Ȯ��
	String id =(String)session.getAttribute("id");
	if(id!=null) {
		wVO.setId(id);
		wVO.setProductid(productid);
		
		model.addAttribute("wishFlag",ps.checkWish(wVO));
		System.out.println(ps.checkWish(wVO));
	}

	System.out.println(wVO);



	ProductDomain pd=ps.searchPrdDetail(productid);
	List<ProductReviewDomain> list = pr.searchProductReview(productid);
	List<ProductReviewDomain > slist=pr.searchStarCnt(productid);	
	System.out.println(pd);

	model.addAttribute("prdImg", ps.searchPrdImg(productid));

	model.addAttribute("id",id);
	model.addAttribute("data", pd);
	model.addAttribute("review", list);
	model.addAttribute("star",slist);
	
	
	return "user/product/productInfo2";

}//searchPrdDetail

//īƮ��� : ajax���� parameter�� �޾ƿö� @ResponseBody�� ����ϸ� �ȴ�!
@ResponseBody
@RequestMapping(value="cart_insert.do",method=POST)
public String addCart(ProductCartVO cVO,HttpSession session) throws Exception {

	ProductService ps=new ProductService();
	//�α��� Ȯ�� : ���߿� session�޾ƿ���..!
	int result=0;
	String id =(String)session.getAttribute("id");
	if(id!=null) {
		
		result=ps.addCart(cVO);
	} else {//���ǿ� ���̵� ������
		result=-1;
	}
	
	
	
	return result+" ";

	
	

}//addCart
//���� : ajax���� parameter�� �޾ƿö� @ResponseBody�� ����ϸ� �ȴ�!
@ResponseBody
@RequestMapping(value="addWish.do",method=POST)
public String addWish(ProductCartVO cVO,HttpSession session,Model model) throws Exception {
	
	ProductService ps=new ProductService();
	String id=(String)session.getAttribute("id");
	//�α��� Ȯ�� : ���߿� session�޾ƿ���..!
	int result=0;
	if(id!=null) {
		result= ps.addWish(cVO);
	} else {//���ǿ� ���̵� ������
		model.addAttribute("msg", "�α��� �Ŀ� �õ����ּ���.");
	}
	return result+" ";
	
	
	
	
}//addCart

	
}//class
