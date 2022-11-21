package kr.co.mpnp.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.mpnp.user.domain.ProductDomain;
import kr.co.mpnp.user.domain.ProductReviewDomain;
import kr.co.mpnp.user.service.ProductReviewService;
import kr.co.mpnp.user.service.ProductService;
import kr.co.mpnp.user.vo.MemberVO;
import kr.co.mpnp.user.vo.ProductCartVO;
import kr.co.mpnp.user.vo.ProductVO;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.security.ProtectionDomain;
import java.util.List;

import javax.servlet.http.HttpSession;

@Controller
public class ProductController {
//��ǰ�ߺз�
@RequestMapping(value="/prdList.do", method=GET)
public String searchPrdList(String subid,Model model) {
	
	ProductService ps=new ProductService();
	List<ProductDomain> list=ps.searchPrdList(subid);
	int cnt =ps.searchPrdCnt(subid);
	model.addAttribute("sub", list);
	model.addAttribute("prdcnt", cnt);
	System.out.println(subid);
	
	
	return "user/product/prdList";
}

//��ǰ�󼼺���
@RequestMapping(value="/prddetail.do", method=GET)
public String searchPrdDetail(@RequestParam(value="productid")  String productid,HttpSession session,Model model) {
	//���� �� Ȯ��
	if(session.getAttribute("id")!=null) {
		String id =(String)session.getAttribute("id");
		model.addAttribute("id",id);
	}
	
	ProductService ps= new ProductService();
	ProductReviewService pr = new ProductReviewService();
	
	ProductDomain pd=ps.searchPrdDetail(productid);
	List<ProductReviewDomain> list = pr.searchProductReview(productid);
	List<ProductReviewDomain > slist=pr.searchStarCnt(productid);
	
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

	if(session.getAttribute("id")!=null) {
		
		result=ps.addCart(cVO);
	} else {//���ǿ� ���̵� ������
		result=-1;
	}
	
	
	
	return result+" ";

	
	

}//addCart
//���� : ajax���� parameter�� �޾ƿö� @ResponseBody�� ����ϸ� �ȴ�!
@ResponseBody
@RequestMapping(value="addWish.do",method=POST)
public String addWish(ProductCartVO cVO,HttpSession session) throws Exception {
	
	ProductService ps=new ProductService();
	//�α��� Ȯ�� : ���߿� session�޾ƿ���..!
	int result=0;
	if(session.getAttribute("id")!=null) {
		
		result=ps.addWish(cVO);
	} else {//���ǿ� ���̵� ������
		result=-1;
	}
	
	
	
	return result+" ";
	
	
	
	
}//addCart

	
}//class
