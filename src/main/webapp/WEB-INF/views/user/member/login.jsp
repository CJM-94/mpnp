<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" info="scriptlet의 사용" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html lang="ko">
<head>
<title>멍품냥품</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<meta name="format-detection" content="telephone=no">
<meta name="theme-color" content="#ffffff">

<link href="common/favicon/favicon.ico" rel="shrtcut icon">
<link href="common/favicon/android-icon-192x192.png" rel="apple-touch-icon-precomposed">

<link rel="stylesheet" href="http://localhost/mpnp/3rdDesign/common/css/headerFooter.css">
<link rel="stylesheet" type="text/css" href="http://localhost/mpnp/3rdDesign/_css/main.style.pc.css">
<link rel="stylesheet" type="text/css" href="https://vknfvtjnsgec6381690.cdn.ntruss.com/_css/jquery-ui.css">
<link rel="stylesheet" href="http://localhost/mpnp/3rdDesign/css/login.css">
<script type="text/javascript" src="http://localhost/mpnp/3rdDesign/_script/crypto.js"></script>
<script type="text/javascript" src="https://vknfvtjnsgec6381690.cdn.ntruss.com/_script/errHandler.min.js?v=22102810" userInfo="%7B%22mbrNo%22%3A0%2C%22appName%22%3A%22FRONT%22%2C%22sessionIp%22%3A%22211.244.65.66%22%2C%22appEnv%22%3A%22PRD%22%2C%22sessionId%22%3A%22NjliOTliYTEtMzM2Mi00OWE0LTk4NGQtODNkNDY1NDliOTMx%22%7D" webHookErrWebUrl="https://petsbe.webhook.office.com/webhookb2/6846f755-9900-4b13-8eb6-7c7a01c9abde@2ebad8bd-5697-4302-afcf-7b617ee135ff/IncomingWebhook/287ff9c2be6c4aecba75d0f1f665a86c/89d2885b-4579-4313-be4c-a1c2f9998d81"></script>
<script type="text/javascript"  src="https://vknfvtjnsgec6381690.cdn.ntruss.com/_script/jquery/jquery-3.3.1.min.js" ></script>
<script type="text/javascript"  src="https://vknfvtjnsgec6381690.cdn.ntruss.com/_script/jquery/jquery-ui.min.js"></script>

<script type="text/javascript"  src="http://localhost/mpnp/3rdDesign/_script/common.js?modifiedDate=20221013" ></script>
<script type="text/javascript"  src="http://localhost/mpnp/3rdDesign/_script/popup.js" ></script>
<script type="text/javascript" 	src="http://localhost/mpnp/3rdDesign/_script/ui.js"></script>
<script type="text/javascript" 	src="http://localhost/mpnp/3rdDesign/_script/ui_shop.js"></script>

  <!--google icons-->
	<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,400,0,0" />
	<!--google fonts-->
	<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap"
	rel="stylesheet">
	<script>
		$(function(){
		 $(".bt_dog").click(function(){
			$(".bt_cat").removeClass("active"); 
		 $(this).addClass("active")
		 $(".open_dog").css('display','block');
		 $(".open_cat").css('display','none');
		
		 });//click
		
		 $(".bt_cat").click(function(){
			 $(".bt_dog").removeClass("active"); 
			 $(this).addClass("active")
			 $(".open_cat").css('display','block');
			 $(".open_dog").css('display','none');
		
		 });//click
		 
		 $("#loginBtn").click(function(){
			 //alert("로그인버튼"); 확인완료
			 chkNull();
		 });
		
		
		});//ready function
		
		function chkNull() {
			let id=$("#id").val();
			if(id.trim() == ""){
				alert("아이디를 입력해주세요.")
				$("#id").val(""); 
				$("#id").focus();
				return;
			}else{
				$("#pass").focus(); 
			}//endif
			
			let pass = $("#pass").val();
			if(pass.trim() == ""){
				alert("비밀번호를 입력해주세요.");
				$("#pass").val("");	
				return; 
			}//endif
			
			$("#loginFrm").submit();
			
		}//chkNull
		
		</script>



</head>

<body class="body">

<!-- 기본 컨텐츠 -->
	<div class="wrap" id="wrap">
		<input type="hidden" id="viewJsonData" value="%7B%22vod_group_list_api_url%22%3A%22https%3A%2F%2Fsgr.aboutpet.co.kr%2Fv1%2Fplaylist%2Flist%3Fchannel_id%3D%22%2C%22vod_group_move_api_url%22%3A%22https%3A%2F%2Fsgr.aboutpet.co.kr%2Fv1%2Fplaylist%2Fmove_vod%2F%22%2C%22vod_group_add_api_url%22%3A%22https%3A%2F%2Fsgr.aboutpet.co.kr%2Fv1%2Fplaylist%2Fadd_item%2F%22%2C%22vod_upload_api_url%22%3A%22https%3A%2F%2Fsgr.aboutpet.co.kr%2Fv1%2Fvod%2Fupload%2F%22%2C%22vod_chnl_list_api_url%22%3A%22https%3A%2F%2Fsgr.aboutpet.co.kr%2Fv1%2Fchannel%2Flist%22%2C%22fo_mois_post_confmKey%22%3A%22U01TX0FVVEgyMDIxMDMzMDEwMzEzMDExMDk4MTk%3D%22%2C%22vod_api_chnl_id_log%22%3A%22aboutpet_log%22%2C%22vod_info_api_url%22%3A%22https%3A%2F%2Fsgr.aboutpet.co.kr%2Fv1%2Fvod%2Fvideo%2Finfo%2F%22%2C%22vod_group_chnl_ord_api_url%22%3Anull%2C%22vod_list_api_url%22%3A%22https%3A%2F%2Fsgr.aboutpet.co.kr%2Fv1%2Fvod%2Fvideo%2F%22%2C%22vod_group_default%22%3A%22unclassified%22%2C%22vod_api_chnl_id_tv%22%3A%22aboutpet_tv%22%7D">
		 <header class="header pc cu mode0" data-header="set0" id="header_pc">
	<input type="password" style="display:none;"/><!-- 크롬 패스워드 자동완성 방지 -->
	<div class="hdr">
		<div class="inr">

<c:import	url="../../user/main/user_header.jsp">
			<c:param name="id" value="${sessionScope.id }"></c:param>
</c:import>

			
</div>
	</div>
</header> 
	



		
		<div class="layers">
			<!-- 레이어팝업 넣을 자리 -->
			<!-- 등급안내 팝업 추가 2021.05.13 -->
			<article class="popLayer a popLank " id="popLank">
				<div class="pbd">
					<div class="phd">
						<div class="in">
							<h1 class="tit"></h1>
							<button type="button" class="btnPopClose">닫기</button>
						</div>
					</div>
					<div class="pct">
						<main class="poptents">
							<div class="rankCont">
								<div class="rank_imgBox rank_pc">
											<img src="/_images/common/img-level-pc.png" alt="어바웃펫 패미리 등급별 혜택 이미지">
										</div>
									</div>
						</main>
					</div>
				</div>
			</article>
			<!-- //등급안내 팝업 추가 2021.05.13 -->
		</div>
<!--// header pc--><!-- e : header 영역 -->

<!--❤️사이드바-->


<div class="layers tv seriesHome" id="gnbSrisListPopup"></div>
<!-- e : gnb 영역 -->			

<!--❤️right main page-->
<!-- 로그인 영역끝 -->
<main class="container page login srch" id="container" style="margin-bottom:-70px !important;" >
			
  <div class="inr" style="min-height: 429px;margin-top:250px;">
    <!-- 본문 -->
    <div class="contents" id="contents">
      <!-- PC 타이틀 모바일에서 제거  -->
      <div class="pc-tit">
        <h2>로그인</h2>
      </div>
      <!-- // PC 타이틀 모바일에서 제거  -->
      <div class="fake-pop">
        <form id="loginFrm" action="login_process.do" method="post">
          <div class="pct">
            <div class="poptents">
              
              <!-- 회원 정보 입력 -->
              <input type="hidden" name="mbrNo" id="mbrNo">
              <input type="hidden" name="mbrStatCd" id="mbrStatCd">
              <input type="hidden" name="authJson" id="authJson">
              <input type="hidden" name="deviceToken" id="appPushToken">
              <input type="hidden" id="deviceTpCd" name="deviceTpCd" value="DEVICE_TYPE">
              
              <input type="hidden" id="RSAModulus" value="9ddb7a61c6cd3c3c2e7413e4a5aeebf210af0d21352da6f4e8bd58a6021f580cf0b394f57608dd8f88a0f38393f266d0cd8caa7dfcb7675ed76ddd583396b36dc8f7605fd6f3d1291807e5b2128818d64139bc47da05190da72a3474695c44ccfe078935065aa81c2dd5a44e2318d604bdce4ad0471a3f90f0e8921840141293">
              <input type="hidden" id="RSAExponent" value="10001">
              
              <div class="member-input">
                <ul class="list">
                  <li>
                    <div class="input">
                      <input type="text" class="ipt" name="id" id="id" placeholder="아이디" autocomplete="new-password" maxlength="40" autofocus>
                    </div>
                  </li>
                  <li>
                    <div class="input">
                      <input type="password" class="ipt" name="pass" id="pass" placeholder="비밀번호" autocomplete="new-password" maxlength="15">
                    </div>
                    <p class="validation-check" id="newErrMsg" style="display: none;">아이디 또는 비밀번호를 다시 확인해주세요</p>
                  </li>
                </ul>
              </div>
              <!-- // 회원 정보 입력 -->
            </div>
          </div>
       <!--    <div class="check-wrap">
              <label class="checkbox">
                <input type="checkbox" name="keepYn" id="keepYn" value="Y" checked="checked"><span class="txt">아이디 저장</span>
              </label>
            </div> -->
          </form>
        <div class="pbt pull">
          <div class="btnSet" id="inactiveBtn">
            <a href="javascript:;" class="btn lg gray" id="loginBtn">로그인</a>
          </div>
          <div class="btnSet" id="activeBtn" style="display:none;">
            <a href="javascript:amplitudeLoginBtn('로그인');login();" class="btn lg a" data-content="" data-url="">로그인</a>
          </div>
        
        </div>
        
        <div class="lnk-set">
         <!--  <a href="javascript:amplitudeLoginBtn('아이디 찾기','/login/indexFindId');" data-content="" data-url="/login/indexFindId">아이디 찾기</a> -->
          <a href="m_findid_form.do" data-content="">아이디 찾기</a>
<!--           <a href="javascript:amplitudeLoginBtn('비밀번호 찾기','/login/indexFindPswd');" data-content="" data-url="/login/indexFindId">비밀번호 찾기</a> -->
          <a href="m_findpass_form.do" data-content="">비밀번호 찾기</a>
          <a href="join_terms.do" data-content="">회원가입</a>
          </div>
        
          <!-- 애플 심사전 -->
        
   
        <!-- 애플 심사후 -->
          </div>
    </div>
  
  </div>
</main>



    <!--❤️main-->
				<!-- s : 검색 영역 -->
<!-- e : 검색 영역 -->
<!--❤️사이드바 끝-->
<!--❤️main-->
 
	

<!-- footer -->	
<footer class="footer" id="footer" style="width: 100%;">
	<div class="inr">
		<div class="link">
			<ul class="list">
				<li><a href="javascript:void(0);" onclick ="openTerms('2001' , 'Y'); return false;">서비스 이용약관</a></li>
				<li><a href="javascript:void(0);" onclick ="openTerms('2002' , 'Y'); return false;" class="fc_black">개인정보 처리방침</a></li>
				<li><a href="javascript:void(0);" onclick ="openPartnershipInquiry();return false;">입점/제휴 문의</a></li>
				<li class="hide_mo"><a href="http://www.gsretail.com/gsretail/ko/brand/about-pet" target="_blank">회사소개</a></li>
					<li class="hide_mo"><a href="https://gsretail.recruiter.co.kr/appsite/company/index" target="_blank">채용정보</a></li>
				<!-- 무조건 모바일웹으로 들어간 1경우에만 나타나게 만들기 -->
				</div>
		 <div class="info">
			<ul class="list">
				<li>주식회사 멍품냥품</li>
				<li>대표자명 : 최정민 유원준 정선홍 하지윤 유설빈</li>
				<li>사업자 등록번호 : 022-10-0025 
				</li>
				<li class="dn">통신판매업신고번호 : 제 2020-서울강남-03142호</li>
				<li>TEL : 1644-1234</li>
			</ul>
				<ul class="list">
					<li>
						<p class="adr">서울특별시 강남구 테헤란로 한독빌딩 8층</p>
					</li>
				
				</ul>
			</div>
	<div class="copy">© copyright (c) www.aboutpet.co.kr all rights reserved.</div>
	<div class="info escrow">
			
		</div>
	</div>
</footer>
<!-- // footer -->

<div id ="layers">
</div><!-- e : footer 영역 -->
	</div>
</body>
</html>