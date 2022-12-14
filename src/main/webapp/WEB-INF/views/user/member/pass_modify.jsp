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
<link rel="stylesheet" href="http://localhost/mpnp/3rdDesign/css/mypage.css">
<script type="text/javascript" src="http://localhost/mpnp/3rdDesign/_script/crypto.js"></script>
<script type="text/javascript" src="https://vknfvtjnsgec6381690.cdn.ntruss.com/_script/errHandler.min.js?v=22102810" userInfo="%7B%22mbrNo%22%3A0%2C%22appName%22%3A%22FRONT%22%2C%22sessionIp%22%3A%22211.244.65.66%22%2C%22appEnv%22%3A%22PRD%22%2C%22sessionId%22%3A%22NjliOTliYTEtMzM2Mi00OWE0LTk4NGQtODNkNDY1NDliOTMx%22%7D" webHookErrWebUrl="https://petsbe.webhook.office.com/webhookb2/6846f755-9900-4b13-8eb6-7c7a01c9abde@2ebad8bd-5697-4302-afcf-7b617ee135ff/IncomingWebhook/287ff9c2be6c4aecba75d0f1f665a86c/89d2885b-4579-4313-be4c-a1c2f9998d81"></script>
<script type="text/javascript"  src="https://vknfvtjnsgec6381690.cdn.ntruss.com/_script/jquery/jquery-3.3.1.min.js" ></script>
<script type="text/javascript"  src="https://vknfvtjnsgec6381690.cdn.ntruss.com/_script/jquery/jquery-ui.min.js"></script>

<script type="text/javascript"  src="http://localhost/mpnp/3rdDesign/_script/common.js?modifiedDate=20221013" ></script>
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
		
		 })//click
		
		 $(".bt_cat").click(function(){
		 $(".bt_dog").removeClass("active"); 
		 $(this).addClass("active")
		 $(".open_cat").css('display','block');
		 $(".open_dog").css('display','none');
		
		 });//click
		 
		 
		
		
		});//ready
		
		</script>



<body class="body">

<!-- 기본 컨텐츠 -->
	<div class="wrap" id="wrap">
		<input type="hidden" id="viewJsonData" value="%7B%22vod_group_list_api_url%22%3A%22https%3A%2F%2Fsgr.aboutpet.co.kr%2Fv1%2Fplaylist%2Flist%3Fchannel_id%3D%22%2C%22vod_group_move_api_url%22%3A%22https%3A%2F%2Fsgr.aboutpet.co.kr%2Fv1%2Fplaylist%2Fmove_vod%2F%22%2C%22vod_group_add_api_url%22%3A%22https%3A%2F%2Fsgr.aboutpet.co.kr%2Fv1%2Fplaylist%2Fadd_item%2F%22%2C%22vod_upload_api_url%22%3A%22https%3A%2F%2Fsgr.aboutpet.co.kr%2Fv1%2Fvod%2Fupload%2F%22%2C%22vod_chnl_list_api_url%22%3A%22https%3A%2F%2Fsgr.aboutpet.co.kr%2Fv1%2Fchannel%2Flist%22%2C%22fo_mois_post_confmKey%22%3A%22U01TX0FVVEgyMDIxMDMzMDEwMzEzMDExMDk4MTk%3D%22%2C%22vod_api_chnl_id_log%22%3A%22aboutpet_log%22%2C%22vod_info_api_url%22%3A%22https%3A%2F%2Fsgr.aboutpet.co.kr%2Fv1%2Fvod%2Fvideo%2Finfo%2F%22%2C%22vod_group_chnl_ord_api_url%22%3Anull%2C%22vod_list_api_url%22%3A%22https%3A%2F%2Fsgr.aboutpet.co.kr%2Fv1%2Fvod%2Fvideo%2F%22%2C%22vod_group_default%22%3A%22unclassified%22%2C%22vod_api_chnl_id_tv%22%3A%22aboutpet_tv%22%7D">
		
	<script>
	
	function clickLogin(){
		location.href = "/indexLogin?returnUrl="+location.pathname+location.search;
	}
	
	//장바구니 수 set, 캐시 이슈로 ajax 호출
	function setCartCnt(){
		$.ajax({
			url : "/order/getCartCnt"
			, dataType : "json"
			, type : "POST"
			, success : function(data){
				var $cartCntObj = $('.header .menu .cart').find('em');
				var $shopMainCartCntObj = $('#btnCart').find('em');
				if($cartCntObj.length == 0){
					if(data.cartCnt != 0){
						var html = '<em class="n">'+data.cartCnt+'</em>';
						$('.header .menu .cart').html(html);
					}
				}else{
					if(data.cartCnt == 0){
						$cartCntObj.remove();
					}else{
						$cartCntObj.text(data.cartCnt);
					}
				}
				
			
			}
		});
	}

  	//등급 레이어팝업 스크립트 추가 2021.05.13
	var rankBox = function(){
		ui.popLayer.open('popLank',{
			ocb:function(){
				// console.log("popLank 열림");
			},
			ccb:function(){
				// console.log("popLank 닫힘");
			}
		});

		if("PC" == "PC") {
			$(".rank_pc").addClass("on");
		}else {										
			$(".rank_mo").addClass("on");
		}
	}
  	
	function closeTopbanner() {
		$('#topBanner').addClass('hide');
		var cookieName	= getTopbannerCookieName();
		setCookieTopBanner(cookieName, "done", 1);
	}
</script><!-- header pc-->
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
					<!-- s : gnb 영역 -->

<!--❤️사이드바-->


<div class="layers tv seriesHome" id="gnbSrisListPopup"></div>
<!-- e : gnb 영역 -->			
					<!-- s : LNB 영역 -->

<nav class="lnb shop" id="lnb">
	<div class="inr" style="width:220px;">
		<nav class="menushop"style="margin-right:20px;margin-top:-30px;">
			<h2 class="bt bt_my">MY</h2>
		

			<div class="ctset ctset1 active" data-ui-tab-ctn="tab_my_cate" data-ui-tab-val="tab_my_cate_1" style="width:200px;">
				<ul class="sm">
					<li><a class="bt" href="order_information_form.do"" data-content="0">주문내역</a></li>
					<li><a class="bt" href="writable_review_list.do"  data-content="0">상품 후기</a></li>
					<li><a class="bt" href="mypage_pass_confirm.do?what=updatePass">비밀번호 설정</a></li>
					<li><a class="bt" href="mypage_pass_confirm.do?what=updateMemberInfo" >회원정보 수정</a></li>
					<li><a class="bt" href="des_list.do" data-content="0"  >배송지 관리</a></li>
				</ul>
			</div>

			
	</nav>

		<nav class="menushop">
			<h2 class="bt bt_store">스토어</h2>
			<div class="button_wrap">
			<button type="button" class="bt st bt_dog active">강아지</button>
			<button type="button" class="bt st  bt_cat">고양이</button>
		</div>

				<li class="open open_dog" id="tab_category_12565" style="width:200px;">
								<ul class="sm">
									<li class=""><a class="bt" href="javascript:setCateList('12673', '12565', 'N');"><b class="t">강쥐사료</b></a></li>
									<li class=""><a class="bt" href="javascript:setCateList('12675', '12565', 'N');"><b class="t">간식</b></a></li>
								</ul>
								<ul class="sm_2">
									<li class=""><a class="bt" href="javascript:setCateList('12685', '12565', 'N');"><b class="t">패션/의류</b></a></li>
									<li class=""><a class="bt" href="javascript:setCateList('100000244', '12565', 'N');"><b class="t">기타</b></a></li>
								 </ul> 
				</li>

				<li class="open open_cat" id="tab_category_12565" style="width:200px;display:none;">
					<ul class="sm">
						<li class=""><a class="bt" href="javascript:setCateList('12673', '12565', 'N');"><b class="t">냥이사료</b></a></li>
						<li class=""><a class="bt" href="javascript:setCateList('12675', '12565', 'N');"><b class="t">간식</b></a></li>
					</ul>
					<ul class="sm_2">
						<li class=""><a class="bt" href="javascript:setCateList('12685', '12565', 'N');"><b class="t">패션/의류</b></a></li>
						<li class=""><a class="bt" href="javascript:setCateList('100000244', '12565', 'N');"><b class="t">기타</b></a></li>
					 </ul> 
	</li>
		</nav>
	
		</div>
	
</nav><!-- e : LNB 영역 -->
				<!-- s : 검색 영역 -->
<!-- e : 검색 영역 -->
<!--❤️사이드바 끝-->
<!--❤️main-->
  <!--❤️main-->
	<script>
		$(document).ready(function(){
			
			//다 입력된 경우 변경 버튼 활성화
			$(".inputPswd").on('keyup', function(e) {
				if($("#pass_error").html() != "" ||  $("#_error").html() != ""){
					$("#pass_error").html("")
					$("#_error").html("");
				}
				
				if($("#pass").val() != "" && $("#").val()  != ""){
					//버튼 활성화
					$("#updateBtn").attr("disabled",false);
					$("#updateBtn").attr("class","btn lg a");
					
				}else{
					//버튼 비활성화
					$("#updateBtn").attr("disabled",true);
					$("#updateBtn").attr("class","btn lg a gray");
				}
			});
	
			$(document).on("blur", "#pass", function(){
				fncPswdCheck();
			});
			
			$(document).on("blur", "#passCheck", function(){
				if($("#passCheck").val() != $("#pass").val()){
					$("#passCheck_error").html("동일한 비밀번호를 입력해주세요.");
					//$("#passCheck").focus();
				}else{
					$("#passCheck_error").html("");
				}
			});
		});
		
		// 알럿창 띄우기
		var popAlert = function(msg, callback){
			ui.toast('<p>'+msg+'</p>',{
				ccb:function(){
					if(callback.length > 0){
						var returnUrl = "";
						if(returnUrl.indexOf("indexManageDetail") > -1){
							jQuery("<form action=\"/mypage/info/indexManageDetail\" method=\"post\"><input type=\"hidden\" name=\"checkCode\" value=\"f844fd4a067f5a543f9bb3adf7236d94\" /><input type=\"hidden\" name=\"type\" value=\"MNG\" /></form>").appendTo('body').submit();
							return;
						}
						
						if("PC"!= 'PC' ){
							//location.href="/indexMyInfo?returnUrl=/mypage/indexMyPage";
							location.href="/indexMyInfo";
							return;
						}
						
						location.href="/mypage/indexMyPage/";
					}
				},
				ybt:'확인'	
			});
		}
		
		//비밀번호 변경
		function fncUpdatePswd(){
			if(fncPswdCheck()){
				var pass = $("#pass").val();
				var rsa = new RSAKey();
				rsa.setPublic($("#RSAModulus").val(), $("#RSAExponent").val());
				var pass_enc = rsa.encrypt(pass);
				$("#pass").val(pass_enc);
				
				var options = {
					url: "/mypage/info/updateMemberPassword",
					data : $("#pswdForm").serialize(),
					done : function(data){
						if(data.resultCode == 'F'){
							popAlert('오류가 발생되었습니다. 관리자에게 문의하십시요.');
							return;
						}
						else if(data.resultCode == 'duplicated'){
							ui.toast('이전에 사용된 비밀번호는 사용하실 수 없어요.'); // 체크하는게 맞는지 노확실
						}else{
							popAlert('비밀번호가 변경되었어요.', 'callback');
						}
					}
				}
				ajax.call(options);
				
				$("#pass").val(pass);
			}else{
				if($("#pass_error").html() != ''){
					$("#pass").focus();
				}else{
					$("#passCheck").focus();
				}
			}
		}
		
		//비번 유효성 체크
		function fncPswdCheck(){
			$("#pass_error").html("");
			$("#passCheck_error").html("");
			
			if($("#pass").val() == ""){
				$("#pass_error").html("비밀번호를 입력해주세요.");
				//$("#pass").focus();
				return false;
			}
			 
			var pass=$("#pass").val();
			var num = pass.search(/[0-9]/);
			var eng = pass.search(/[a-zA-Z]/);
			var spe= pass.search(/[~!@#$%^&*()_+|<>?:{}]/); 
			//비밀번호 유효성 검사 :영문, 숫자, 특수문자 중 2종류 이상 8~12자 이내
					if(pass.length < 8 || pass.length >13){
						$("#pass_error").html("8자리 ~ 12자리 이내로 입력해주세요");
						  return ;
					}else if( (num < 0 && eng < 0) || (eng < 0 && spe < 0) || (spe < 0 && num < 0) ){
						$("#pass_error").html("영문,숫자,특수문자 중 2가지 이상을 포함해주세요");
						  return;
					}
	
			if($("#passCheck").val() != $("#pass").val()){
				$("#passCheck_error").html("동일한 비밀번호를 입력해주세요.");
				return false;
			}
			
			return true;
		}
	</script>
	
	
	<script type="text/javascript">
	
	$(function() {
		$("#modifyPassBtn").click(function() {
			fncPswdCheck();
			if(fncPswdCheck()){
				alert("비밀번호가 정상적으로 변경되었습니다. 다시 로그인해주세요");
				$("#modifyPassFrm").submit();
			}
		});
	});
	</script>
	
	
	
	<style>
.container{
	margin-top:-5px;
	margin-bottom:170px;
}


	
	</style>
	
			
		 
				<!--❤️nav-->
	
	
	
			<!--❤️main-->
			<!-- 바디 - 여기위로 템플릿 -->
			<main class="container page login srch" id="container" style="margin-left:200px;margin-top:200px;margin-bottom:10px;">
				<div class="inr">
					<!-- 본문 -->
					<div class="contents" id="contents">
						
						<!-- PC 타이틀 모바일에서 제거  -->
						<div class="pc-tit">
							<h2>비밀번호 변경</h2>
						</div>
						<div class="fake-pop">
							<input type="hidden" id="RSAModulus" value="913bdf5042384fe17f4214726154170906dd67eeb2b5d138a4b077e104beb3efe9c45481f5d6b13e70add0c02d5c58ed75a0877aabf37e210e1c0b17838b33a037a901a397289df12732f427c63a5397aeb0ad340b91a98e8e3e1da08cad8ff3d966451506871301987988c93d26c4faa4ecd97d6d70b3fc460204a2e42c2afd" />
							<input type="hidden" id="RSAExponent" value="10001" />
							
							<div class="result">
								<p class="sub">변경할 비밀번호를 입력해주세요.</p>
							</div>
							
							<form id="modifyPassFrm" action="m_modifypass_process.do">
							<%-- <input type="text" id="id" name="id" value="${param.id }"> --%>
								<div class="member-input email mt60">
									<ul class="list">
										<li>
											<strong class="tit">새 비밀번호</strong>
											<div class="input del">
												<input type="password" class="inputPswd" id="pass" name="pass" placeholder="영문,숫자,특문 중 두 개 이상 포함 8~12자" autocomplete="new-password" maxlength="12" autofocus="autofocus">
											</div>
											<p class="validation-check" id="pass_error"></p>
										</li>
										<li>
											<strong class="tit">새 비밀번호 확인</strong>
											<div class="input del">
												<input type="password" class="inputPswd" id="passCheck" placeholder="비밀번호를 다시 한번 입력해주세요" autocomplete="new-password" maxlength="12">
											</div>
											<p class="validation-check" id="passCheck_error" ></p>
										</li>
									</ul>
								</div>
							
							<div class="pbt mt30">
								<!-- <div class="btnSet">
									<a href="javascript:alert_sample();" id="updateBtn" class="btn lg a">변경하기</a>
								</div> -->
								<div class="btnSet">
<!-- 									<a href="javascript:fncUpdatePswd();" id="updateBtn" class="btn lg a gray"  data-content="" data-url="" disabled>완료</a> -->
									<button type="button" id="modifyPassBtn" class="btn lg a gray">확인</button>
								</div>
							</div>
							</form>
						</div>
					</div>
				</div>
			</main>
			
			
		
	
<!--❤️main끝-->			
	

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