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
	  System.out.println("requestUrl : "+requestUrl);
	  // ������ �α��� ����
	  String adminId = (String)request.getSession().getAttribute("adminId"); 
	  String[] passPages = {"/login","/index","mainList","search","/prd","find","join","admin_login"};
	  
	  boolean passFlag = false;
	  for(String page : passPages) {
		  System.out.println(requestUrl+" ��� "+page+" ��� ��");
		  if(requestUrl.contains(page)) {
			  //adminFlag = true;
			  passFlag = true;
			  break;
		  }
	  }
	  if(passFlag) {
		  return true;
	  }
	  // ���� ��û���� �ƴѾֵ�
	  
	  if(requestUrl.contains("/admin") || requestUrl.contains("/dashboard")) {
		  
		  if(adminId==null) {
			  response.sendRedirect("http://localhost/mpnp/3rdAdmin/interceptor_test_admin.jsp");
			  return false;
		  }else {
			  return true;
		  }
	  }
	  
	  // ���̵� ��� �����¾ֵ��� �ƴϸ鼭 �������������� �ƴѰ��
	  if(id==null) {
		  response.sendRedirect("http://localhost/mpnp/3rdDesign/interceptor_test.jsp");
	      return false; 
	  }else {
		  return true;
	  }
	  
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
