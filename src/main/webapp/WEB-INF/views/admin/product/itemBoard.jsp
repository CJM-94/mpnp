<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" info=""%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%-- <%
 //로그인되어있지 않은 경우 로그인페이지로 이동
if( session.getAttribute("adminId") == null){
   response.sendRedirect("admingLogin.jsp");
}
%> --%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>상품관리-메인</title>
        <link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" />
        <link href="http://localhost/mpnp/3rdAdmin/css/styles.css" rel="stylesheet" />
        
        <script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js" crossorigin="anonymous"></script>
        <!--제이쿼리-->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
        <script type="text/javascript">

		$(function(){
    		
			//추가버튼 클릭
	    	$("#addBtn").click(function(){
				location.href = "admin_prdList.do"; //안가는데 ? 제이쿼리 js 안받아서 그랬던것
			});
    	
			//공연명 검색
	    	$("#nameSearchBtn").click(function() {
	    		$("#nameFrm").submit();
			});
			
	    	//장르 검색
	    	$("#genreSearchBtn").click(function() {
	    	
	    		$("#mainFrm").submit();
			});
			
	    	//상태 검색
	    	$("#statusSearchBtn").click(function() {
	    		$("#subFrm").submit();
	    	});
	    	
   		});//ready
		   	
	
   		//카테고리
   		$(function(){
   			
   			$("#main").change(function(){
   				console.log( $("select[name=main]").val())
   				if($("select[name=main]").val()!="none"){
   					
   					setSub();
   				}//end if 
   				
   				
   			});//change
   			
   			
   			
   	
   		});//ready
   		
   		function setSub(){
   			
   			var data ={
   				mainid : $("select[name=main_id]").val()
   			}
   			
   			$.ajax({
   				
   				url: "admin_category.do",
   				data : data,
   				dataType: "json",
   				type:"get",
   				contentType: "application/x-www-form-urlencoded; charset=UTF-8",
   				error : function(xhr){
   					alert("잠시후 다시 시도해주세요")
   					console.log("에러 : " + xhr.status);
   		
   				},
   				success : function(jsonObj){
   					if(jsonObj.resultFlag){
   						var categorySel=document.subFrm.sub_id;
   						
   						categorySel.length=1;
   						$.each(jsonObj.subData,function(i,json){
   							categorySel.options[i+1]=new Option(json.subname,json.subid)
   							
   						});
   						
   						console.log(Option)
   					}
   					
   				}
   				
   				
   			});//ajax 
   			
   		}//subid
        </script>
      
        
    </head>
    <body class="sb-nav-fixed">
  <!-- 여기서부터 <nav>-->
 <c:import url="http://localhost/mpnp/3rdAdmin/admin_common_header.jsp"/>
<!-- -여기까지 <div id="layoutSidenav_content"> 전  -->
            <div id="layoutSidenav_content">
                    <div class="container-fluid px-4">
                        <h1 class="mt-4">상품관리</h1>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item active">item management board</li>
                        </ol>
                        <div class="card mb-4">
                            <div class="card-header">
                                <i class="fas fa-table me-1"></i>
                                상품 조회
                            </div>
                            <div class="card-body">
                               
                               <!-- 뭐 추가하면 템플릿 양식을 깨트림;;; -->
                               <!-- 해결 </table> 바로 밑에 버튼 만들면 됨 -->
                           
                        	<form name="nameFrm" id="nameFrm" >
                           	 <div class="dataTable-top"></div>
                                <label>상품명　</label>
                           	  	<input type="text"  name="name" class="dataTable-input" style="width: auto; display: inline-block;"> 
                                <input type="button" id="nameSearchBtn" name="nameSearchBtn" value="검색">
                             </form>
                              
                        	<form name="mainFrm" id="mainFrm" >
                           	 <div class="dataTable-top">  </div>
                               <div>
                                <label>분류1</label>
                                <select id="main" name="main_id" class="dataTable-selector" aria-label="Default select example">
                       			<option value="none">---분류1---<option>
                                	<option value="m0001">강아지</option>
                                	<option value="m0002">고양이</option>
								</select>
								<input type="button" id="genreSearchBtn" name="genreSearchBtn" value="검색">
                               </div>
                             
                              </form>
                           
                        	 <form name="subFrm" id="subFrm" >
                                <div class="dataTable-top"></div>
                                <label>분류2　</label>
                                  <select name="sub_id" id="sub" class="dataTable-selector" aria-label="Default select example">
            
                                	<option value="none">---분류2---<option>
	                         	 
								  </select>
                                  <input type="button" id="statusSearchBtn" name="statusSearchBtn" value="검색">
                           		</form>
                              <a href="admin_prdList.do">
                              <button id="addBtn" type="button" class="btn btn-outline-info float-end mx-md-4" >전체보기</button></a>
                           	 </div>
                           </div>
                            
                       
                                <table id="datatablesSimple">
                                    <thead>
                                        <tr>
                                            <th>상품코드</th>
                                            <th>분류1</th>
                                            <th>분류2</th>
                                            <th>상품명</th>
                                            <th>금액</th>
                                            <th>관리</th>
                                        </tr>
                                    </thead>
                                    <tfoot> 
                                        <!-- 이게 뭐하는건지 모르겠음 foot -->
                                        
                                        <tr>
                                            <th>상품코드</th>
                                            <th>분류1</th>
                                            <th>분류2</th>
                                            <th>상품명</th>
                                            <th>금액</th>
                                            <th>관리</th>
                                        </tr>
                                    </tfoot>
                                    <tbody>
                                    <c:forEach items="${product}" var="product">
                                   		<tr>
                                            <td>${product.productid }</td>
                                            <td>${product.mainname }
                                             	<input type="hidden" value="${product.mainid }"/></td>
                                          
                                            <td>${product.subname }
                                              <input type="hidden" value="${product.subid }"/></td>
                                          
                                            <td>${product.productname }</td>
                                            <td><fmt:formatNumber value="${product.price}" pattern="#,###"/>원</td>                                          
                                            <td><a href="admin_prddetail.do?productid=${product.productid }"><input type="button" value="상세보기" ></a></td> 
                                        </tr>
				        
                                       </c:forEach> 
                                    </tbody>
                                </table>
                            <div><a href="admin_prd_insert.do"><button type="button" id="addBtn" class="btn btn-info">상품추가</button></a></div>
                         </div>
                    </div>
                <!--  -->
                
           <footer class="py-4 bg-light mt-auto">
                    <div class="container-fluid px-4">
                        <div class="d-flex align-items-center justify-content-between small">
                        </div>
                    </div>
                </footer>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="http://localhost/mpnp/3rdAdmin/js/scripts.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest" crossorigin="anonymous"></script>
        <script src="http://localhost/mpnp/3rdAdmin/js/datatables-simple-demo.js"></script>
    </body>
</html>
 