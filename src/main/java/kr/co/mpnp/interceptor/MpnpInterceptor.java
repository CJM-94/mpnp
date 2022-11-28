package kr.co.mpnp.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class MpnpInterceptor implements HandlerInterceptor{

	@Override 
	public boolean preHandle(HttpServletRequest request,HttpServletResponse response, Object handler) throws Exception { 
	  
	  //�α��� ������ ���ٸ� login �������� �̵� 
	  String id = (String)request.getSession().getAttribute("id"); 
	  String requestUrl = request.getRequestURL().toString(); 
	  
	  System.out.println("preHandle ����");
	  System.out.println("id : "+id);
//	  System.out.println("requestUrl : "+requestUrl);
	
	  
	  // ������ �α��� ����
//	  String adminId = (String)request.getSession().getAttribute("adminId"); 
////	  // ���������� ��� �ĺ��ؼ� ������?
////	  // �̷��ԵǸ� 
	  String[] adminPages = {"admin","dashboard"};
	  //boolean adminFlag = false;
	  //boolean adminFinalFlag = false;
	  for(String adminPage : adminPages) {
		  System.out.println(requestUrl+" ��� "+adminPage+" ��� ��");
		  if(requestUrl.contains(adminPage)) {
			  //adminFlag = true;
			  return true;
		  }
	  }
	  
//	  if(adminFlag) { // �ϴ� ������������ �ϰ��
//		  if(adminId == null) {
//			  response.sendRedirect("http://localhost/mpnp/3rdAdmin/interceptor_test_admin.jsp");
//			  //return false;
//			  adminFinalFlag = false;
//		  }else if(requestUrl.contains("admin_login")){
//			  //return true;
//			  adminFinalFlag = true;
//		  }
//	  }
//	  if(adminFinalFlag) {
//		  return true;
//	  }
	  
	  
	  						// id�� ��� �Ǵ¾ֵ�
	  String[] notChkPages = {"/login","/index","mainList","search","/prd","find","join"};
	  boolean passFlag = false;
	  for(String passPages : notChkPages) { 
		  System.out.println(requestUrl+" ��� "+passPages+" ��� ��");
		  if(requestUrl.contains(passPages)) {
			  passFlag = true;
			  break;
		  }
	  }
	  // ����� �α׾ƿ��� ��� ó������??
	  
	  // ���̵� ���̵������� ������� �������̴�.
	  if(passFlag) {
		  
		  //System.out.println("�α��ξ��ص� �Ǵ���������");
		  return true;
	  }
	  
	  // ������������������� �ɷ����� ���̵� null�̴�.
	  if(id==null){
		  //response.sendRedirect("/WEB-INF/views/user/member/login.jsp");
		  response.sendRedirect("http://localhost/mpnp/3rdDesign/interceptor_test.jsp");
	      return false; 
	  }
	  
	  // ���̵� ������ login,,,find,,,join �� �ƴѾֵ� 
	  // �� ���� �α����� ����ڵ�
	  return true; 
	  
	  
	  
	  
	  // id�� null�� �ƴϴ� = �α����� �Ǿ��ִ�. �׷� �ٷ� true�� ©�󵵵��ݾ�
	  
	  


	  
	  

	  
	  
	  
	  //�α��� ��� ���� 
//	  if(requestUrl.contains("/login")){ 
//		  System.out.println("if login Ž");
//	      return true;
//	  } 
//	  //���ҽ� ��� ���� 
//	  if(requestUrl.contains("/review")){ 
//		  System.out.println("if review Ž");
//	      return true;
//	  } 
//	  if(requestUrl.contains("review")){ 
//		  System.out.println("if review Ž");
//		  return true;
//	  } 
	  
	  
	  
	  
	  
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		  //System.out.println("postHandle ����");

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		 // System.out.println("afterCompletion ����");

	} 

}
