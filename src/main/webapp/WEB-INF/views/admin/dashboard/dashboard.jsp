 <%@page import="java.util.List"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.GregorianCalendar"%>
<%@page import="java.util.Calendar"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" info=""%> 

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>관리자-대시보드</title>
        <link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" />
        <link href="http://localhost/mpnp/3rdAdmin/css/styles.css" rel="stylesheet" />
        <script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js" crossorigin="anonymous"></script>
        


    </head>
    <body class="sb-nav-fixed">
   <c:forEach var="item" items="${requestScope.dailyList}" varStatus="status">
        <input type="hidden" value="${item.daily }" id="daily_${status.count }" name="daily_value">
		<input type="hidden" value="${item.sales }" id="sales_${status.count }" name="sales_value">
   </c:forEach>
   <c:forEach var="item" items="${requestScope.monthlyList}" varStatus="status">
        <input type="hidden" value="${item.monthly }" id="daily_${status.count }" name="monthly_value">
		<input type="hidden" value="${item.sales }" id="sales_${status.count }" name="monthly_sales_value">
   </c:forEach>
   <c:forEach var="item" items="${requestScope.dogList}" varStatus="status">
        <input type="hidden" value="${item.subName }" id="daily_${status.count }" name="dog_subName">
		<input type="hidden" value="${item.salesCnt }" id="sales_${status.count }" name="dog_count">
   </c:forEach>
   <c:forEach var="item" items="${requestScope.catList}" varStatus="status">
        <input type="hidden" value="${item.subName }" id="daily_${status.count }" name="cat_subName">
		<input type="hidden" value="${item.salesCnt }" id="sales_${status.count }" name="cat_count">
   </c:forEach>
   
   <c:import url="http://localhost/mpnp/3rdAdmin/admin_common_header.jsp" />
        
        
            <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid px-4">
                        <h1 class="mt-4">대시보드</h1>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item active">Dashboard</li>
                        </ol>
                       
                        <div class="row">
                            <div class="col-xl-6">
                                <div class="card mb-4" style="height: 516px">
                                    <div class="card-header">
                                        <i class="fas fa-chart-bar me-1"></i>
                                        등급별 회원현황
                                    </div>
                                    <div class="card-body" style=" height:150px;">
                                        <table class="table table-hover "style="table-layout:fixed">
                                        <tr class="fw-bold"> 
	                                        <td style="width:25%">레벨</td>
	                                        <td style="width:20%">등급</td>
	                                        <td style="width:40%">기준</td>
	                                        <td style="width:15%">회원수</td>
                                        </tr>
                                        <c:forEach var="memByGrade" items="${memberList}" varStatus="status">
                                        <tr>
                                         <%-- // <c:out value="${status.count }"/> // <c:out value="${listMember.size() }"/> --%>
	                                        <td><c:out value="${memByGrade.lev }"/></td>
	                                        <td><c:out value="${memByGrade.gradeName }"/></td>
	                                        <td><c:out value="${memByGrade.minPrice }원 "/>~
	                                        <c:if test="${status.count < memberList.size()}">
	                                        <c:out value="${memByGrade.maxPrice }원 "/>
	                                        </c:if>
	                                        </td>
	                                        <td><c:out value="${memByGrade.memCnt }"/>명</td>
                                        </tr>
                                        </c:forEach>
                                        </table>
                                    </div>   
                                </div>
                            </div>
                            <div class="col-xl-6">
                                <div class="card mb-4" >
                                    <div class="card-header">
                                        <i class="fas fa-chart-bar me-1"></i>
                                        카테고리별 판매추이
                                    </div>
                                    <div class="card-body">
                                    	<!-- <input type="button" class="btn btn-info" value="고양이"> -->
                                        <canvas id="myBarChart" width="100%" height="50"></canvas>
                                    </div>
                                </div>
                            </div>
                        </div>
                        
                        <div class="row">
                            <div class="col-xl-6">
                                <div class="card mb-4">
                                    <div class="card-header">
                                        <i class="fas fa-chart-area me-1"></i>
                                       일별 매출
                                    </div>
                                    <div class="card-body">
                                        
                                        <canvas id="myAreaChart_day" width="100%" height="50px"></canvas>
                                    </div>
                                </div>
                            </div>
                            <div class="col-xl-6">
                                <div class="card mb-4">
                                    <div class="card-header">
                                        <i class="fas fa-chart-area me-1"></i>
                                       월별 매출
                                    </div>
                                    <div class="card-body">
                                        
                                        <canvas id="myAreaChart_month" width="100%" height="50px"></canvas>
                                    </div>
                                </div>
                            </div>
                        </div>




                    </div>
                </main>
                <!--  -->
                <footer class="py-4 bg-light mt-auto">
                    <div class="container-fluid px-4">
                        <div class="d-flex align-items-center justify-content-between small">
                            <div class="text-muted">Copyright &copy; Your Website 2022</div>
                        </div>
                    </div>
                </footer>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="http://localhost/mpnp/3rdAdmin/js/scripts.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
        <script src="http://localhost/mpnp/3rdAdmin/js/chart-area-demo-day.js"></script>
        <script src="http://localhost/mpnp/3rdAdmin/js/chart-area-demo-month.js"></script>
        <script src="http://localhost/mpnp/3rdAdmin/js/chart-bar-demo.js"></script>
        <script src="http://localhost/mpnp/3rdAdmin/js/chart-pie-demo.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest" crossorigin="anonymous"></script>
        <script src="http://localhost/mpnp/3rdAdmin/js/datatables-simple-demo.js"></script>
    </body>
</html>
