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
<link rel="stylesheet" href="http://localhost/mpnp/3rdDesign/css/find_info.css">
<script type="text/javascript" src="https://vknfvtjnsgec6381690.cdn.ntruss.com/_script/errHandler.min.js?v=22102810" userInfo="%7B%22mbrNo%22%3A0%2C%22appName%22%3A%22FRONT%22%2C%22sessionIp%22%3A%22211.244.65.66%22%2C%22appEnv%22%3A%22PRD%22%2C%22sessionId%22%3A%22NjliOTliYTEtMzM2Mi00OWE0LTk4NGQtODNkNDY1NDliOTMx%22%7D" webHookErrWebUrl="https://petsbe.webhook.office.com/webhookb2/6846f755-9900-4b13-8eb6-7c7a01c9abde@2ebad8bd-5697-4302-afcf-7b617ee135ff/IncomingWebhook/287ff9c2be6c4aecba75d0f1f665a86c/89d2885b-4579-4313-be4c-a1c2f9998d81"></script>
<script type="text/javascript"  src="https://vknfvtjnsgec6381690.cdn.ntruss.com/_script/jquery/jquery-3.3.1.min.js" ></script>
<script type="text/javascript"  src="https://vknfvtjnsgec6381690.cdn.ntruss.com/_script/jquery/jquery-ui.min.js"></script>

<script type="text/javascript" 	src="http://localhost/mpnp/3rdDesign/_script/ui.js"></script>
<script type="text/javascript" 	src="http://localhost/mpnp/3rdDesign/_script/ui_shop.js"></script>

  <!--google icons-->
	<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,400,0,0" />
	<!--google fonts-->
	<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap"
	rel="stylesheet">
	<style>

 

	</style>
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
		 
		 $("#findPassBtn").click(function(){
			 $("#findPassFrm").submit();
		 });
		
		
		});
		
		/* 전화번호 하이픈추가  */
		function PhoneNumber(obj) {
		    var number = obj.value.replace(/[^0-9]/g, "");
		    var phone = "";
		    
			if(number.substr(0,2)==02){
			    if(number.length < 3) {
			        return number;
			    } else if(number.length < 6) {
			        phone += number.substr(0, 2);
			        phone += "-";
			        phone += number.substr(2);
			        
			    } else if(number.length < 10) {
			        phone += number.substr(0, 2);
			        phone += "-";
			        phone += number.substr(2, 3);
			        phone += "-";
			        phone += number.substr(5);
			    } else {
			        phone += number.substr(0, 2);
			        phone += "-";
			        phone += number.substr(2, 4);
			        phone += "-";
			        phone += number.substr(6,4);
			    }
			}else{
				if(number.length < 4) {
		        return number;
		   		} else if(number.length < 7) {
		        phone += number.substr(0, 3);
		        phone += "-";
		        phone += number.substr(3);
		    	} else if(number.length < 11) {
		        phone += number.substr(0, 3);
		        phone += "-";
		        phone += number.substr(3, 3);
		        phone += "-";
		        phone += number.substr(6);
		    } else {
		        phone += number.substr(0, 3);
		        phone += "-";
		        phone += number.substr(3, 4);
		        phone += "-";
		        phone += number.substr(7);
		    }
		}
		    obj.value = phone;
			return false;
	}//PhoneNumber
		
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
		<style>
			.result{
				margin-bottom:30px !important;
			}

			button.bg-black{
      margin:30px 0;

			}
		</style>
<!--// header pc--><!-- e : header 영역 -->
					<!-- s : gnb 영역 -->
					<main class="container page login srch" id="container" style="margin-left:-100px;margin-top:250px !important;">
						<div class="inr" style="min-height:629px;">
							<div class="contents" id="contents">

						<div class="group">
							<h3 class="tit-st4">비밀번호 찾기</h3>
							<div class="result">
								<span class="blue">비밀번호</span>가 생각나지 않으세요?
								<h4 class="t"></h4>
								<label for="find1_1" style="font-weight:lighter !important; font-size:14rem">회원정보에 등록한 휴대전화 번호와 입력한 휴대전화 번호가 같아야, 비밀번호를 찾을 수 있습니다.</label></span>
							
							</div>
							
								<div id="ck_cont">
									<div class="form_w form1">
										<form id="findPassFrm" action="m_findpass_process.do" method="post">
										<ul class="form">
											<li>
												<label for="name" class="tt">아이디</label>
												<div class="cont">
													<input type="text" name="id" id="id"  autofocus="autofocus"/>
												</div>
												</li>
											<li>
												<label for="name" class="tt">이름</label>
												<div class="cont">
													<input type="text" name="name" id="name" />
												</div>
											</li>
											<li>
												<span class="tt">휴대전화</span>
												<div class="cont">
													<div class="tel_w">
													<ul class="clearfix tel">
														<li>
															<input type="text" name="phone" id="phone" onkeyup="PhoneNumber(this)"  maxlength="13" class="small numberOnly">
														</li>
													</ul>
												</div>
												<!-- <div class="tel_confirm">
													<label for="smsAuthNumber" class="hide">인증번호 입력</label>
													<input type="text" name="smsAuthNumber" id="smsAuthNumber" placeholder="인증번호 6자리 숫자 입력" maxlength="6"/>
													<button type="button" class="bg-black" onclick="javascript:idSearchAuthProc('sms');return false;">인증번호 <span class="block-t">확인</span></button>
												</div> -->
<!-- 												<button type="button" class="bg-black" onclick="javascript:idSearchAuth();return false;">비밀번호 <span class="block-t">찾기</span></button> -->
												<button type="button" class="bg-black" id="findPassBtn" name="findPassBtn">비밀번호 <span class="block-t">찾기</span></button>
											</div>
											</li>
										</ul>
										</form>
									</div>
									
								</div>
							</div>
						</div><!-- .group -->
						</div>
					</div>


					</main>	


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