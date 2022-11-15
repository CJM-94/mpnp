<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" info="admin_header_include" %>
 

  
         <nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
            <!-- Navbar Brand-->
            <a class="navbar-brand  ps-3" href="http://localhost/group2_prj/admin/dashBoard.jsp">C&nbsp;M&nbsp;S&nbsp;</a>
            <!-- Sidebar Toggle-->
            <button class="btn btn-link btn-sm order-1 order-lg-0 me-4 me-lg-0" id="sidebarToggle" href="#!"><i class="fas fa-bars"></i></button>
            <!-- Navbar Search-->
            <form class="d-none d-md-inline-block form-inline ms-auto me-0 me-md-3 my-2 my-md-0">
           
                <div class="input-group" style="color:#FFFFFF">
                관리자 님
                </div>
            </form>
            <!-- Navbar-->
            <ul class="navbar-nav ms-auto ms-md-0 me-3 me-lg-4">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false"><i class="fas fa-user fa-fw"></i></a>
                    <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown">
                        <!-- <li><a class="dropdown-item" href="javascript:passwordChange()" target="_parent">정보변경</a></li> -->
                        <li><a class="dropdown-item" href="http://localhost/group2_prj/admin/adminPWChange.jsp" target="_parent">정보변경</a></li>
                        <li><a class="dropdown-item" href="http://localhost/group2_prj/admin/adminLogout.jsp">로그아웃</a></li>
                    </ul>
                </li>
            </ul>
        </nav>
        
        <div id="layoutSidenav">
            <div id="layoutSidenav_nav">
                <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
                    <div class="sb-sidenav-menu">
                        <div class="nav">
                            <div class="sb-sidenav-menu-heading">Menu</div>
                             <a class="nav-link" href="http://localhost/group2_prj/admin/dashBoard.jsp">
                                 <div class="sb-nav-link-icon"><i class="fas fa-tachometer-alt"></i></div>
                                 대시보드
                             </a>
                             <hr>
                             <a class="nav-link collapsed" href="http://localhost/group2_prj/admin/useBoard.jsp">
                                 <div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                                 등급관리   
                             </a>
                             <hr>
                             <a class="nav-link" href="http://localhost/group2_prj/admin/showBoard.jsp">
                                 <div class="sb-nav-link-icon"><i class="fas fa-book-open"></i></div>
                                 회원관리
                             </a>
                            <hr>
                            <a class="nav-link" href="http://localhost/group2_prj/admin/schedule_Board.jsp">
                                 <div class="sb-nav-link-icon"><i class="fas fa-chart-area"></i></div>
                                 상품관리
                             </a>
                            <hr>
                            <a class="nav-link" href="http://localhost/group2_prj/admin/schedule_Board.jsp">
                                 <div class="sb-nav-link-icon"><i class="fas fa-chart-area"></i></div>
                                 주문관리
                             </a>
                             <hr>
                             <a class="nav-link" href="http://localhost/group2_prj/admin/rsrvtBoard.jsp">
                                 <div class="sb-nav-link-icon"><i class="fas fa-table"></i></div>
                                 후기관리
                             </a>
                        </div>
                    </div>
                    <div class="sb-sidenav-footer">
                       
                    </div>
                </nav>
            </div>