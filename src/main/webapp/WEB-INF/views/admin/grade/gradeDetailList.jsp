<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" info="scriptlet의 사용" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>등급관리-등급상세보기</title>
        <link href="http://localhost/mpnp/3rdAdmin/css/styles.css" rel="stylesheet" />
        <style type="text/css">
        body{background-color : #fff;}
        textarea {height:90; resize: none;}
        </style>
        <script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js" crossorigin="anonymous"></script>
        <!--제이쿼리-->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
		<script type="text/javascript" src="https://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
<script type="text/javascript">
	//추가하기버튼
	function addBtn() {
	 if(confirm("등급 정보를 변경하시겠습니까?")){
		$("#graFrm").submit();
	 }
	}//addBtn
</script>

</head>
    <body>
        <div id="layoutAuthentication">
            <div id="layoutAuthentication_content">
                <main>
                      <form id="graFrm" name="graFrm" action="http://localhost/mpnp/admin_g_modify_process.do" method="post">
                    <div class="container">
                         <input type="hidden" id="gradeId" name="gradeId"  value="${agDom.gradeId}"/>
                     
                        <div class="row justify-content-center">
                            <!-- col lg 5 - 크기 조정 -->
                            <div class="col-lg-6">
                                <div class="card shadow-lg border-0 rounded-lg mt-5">
                                    <div class="card-header navy bg-dark"><h3 class="text-start text-white font-weight-light my-4 " style="font-weight: bold;">등급 상세보기</h3></div>
                                    <div class="card-body">
                                       
                                        <div class="dataTable-top"></div>
                                        <div class="row">
                                            <div class="col-3"><b>등급명</b></div> 
                                            <div class="col-4"><input id="gradeName" name="gradeName" type="text" class="dataTable-input" value="${agDom.gradeName}"></div>
                                        </div>
                                        <div class="dataTable-top"></div>
                                        <div class="row">
                                            <div class="col-3"><b>등급레벨</b></div> 
                                            <div class="col-2">
                                                <input id="level" name="level" type="text" class="dataTable-input" value="${agDom.gradeLevel}" placeholder="">
                                            </div>
                                        </div>
                                        <div class="dataTable-top"></div>
                                        <div class="row">
                                            <div class="col-3"><b>할인율</b></div> 
                                            <div class="col-2">
                                                <input id="discountRate" name="discountRate" type="text" class="dataTable-input" value="${agDom.discountRate }" placeholder="">
                                            </div>
                                            <div class="col-2 mt-2">(%)</div>
                                        </div>
                                        <div class="dataTable-top"></div>
                                        <div class="row">
                                            <div class="col-3"><b>구매금액</b></div>
                                            <div class="col-3"><input type="text" name="minPrice" id="minPrice" class="dataTable-input" placeholder="시작값(원)" value="${agDom.minPrice }"></div>
                                            <div class="col-1 mt-2">~</div>
                                            <div class="col-3"><input type="text" name="maxPrice" id="maxPrice" class="dataTable-input" placeholder="끝값(원)" value="${agDom.maxPrice }"></div>
                                        </div>
                                        <div class="dataTable-top"></div>
                                        <div class="row">
                                            <div class="col-3"><b>설명</b></div> 
                                            <div class="col-8">
                                            <textarea class="dataTable-input"  id="gradeInfo" name="gradeInfo" >${agDom.gradeInfo}</textarea>
                                            </div>
                                        </div>
                                        <div class="dataTable-top"></div>
                                     
                                        
                                             <div class="mt-4 mb-0">
                                                 <div class="col text-center">
                                                     <a class="btn btn-info btn-sm" onclick="addBtn()" >변경</a>
                                                     <a class="btn btn-light btn-sm" onclick="history.back()">닫기</a>
                                                 </div>
                                             </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        </form>
                </main>
                    </div>
            </div>
            <div id="layoutAuthentication_footer">
                <footer class="py-4 bg-light mt-auto">
                    <div class="container-fluid px-4">
                        <div class="d-flex align-items-center justify-content-between small">
                           
                           
                        </div>
                    </div>
                </footer>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="js/scripts.js"></script>
    </body>
</html>
