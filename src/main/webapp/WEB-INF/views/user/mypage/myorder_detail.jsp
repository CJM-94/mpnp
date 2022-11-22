<%@page import="javax.script.ScriptContext"%>
<%@page import="java.util.Enumeration"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" info="설빈" %>
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
<link rel="stylesheet" type="text/css" href="http://localhost/mpnp/3rdDesign//_css/main.style.pc.css">
<link rel="stylesheet" type="text/css" href="https://vknfvtjnsgec6381690.cdn.ntruss.com/_css/jquery-ui.css">

<link rel="stylesheet" href="http://localhost/mpnp/3rdDesign/_css/pc/layout.css">
<link rel="stylesheet" href="http://localhost/mpnp/3rdDesign/_css/pc/shop.css">
<link rel="stylesheet" href="http://localhost/mpnp/3rdDesign/css/order.css">
<script type="text/javascript" src="/_script/crypto.js"></script>
<script type="text/javascript" src="https://vknfvtjnsgec6381690.cdn.ntruss.com/_script/errHandler.min.js?v=22102810" userInfo="%7B%22mbrNo%22%3A0%2C%22appName%22%3A%22FRONT%22%2C%22sessionIp%22%3A%22211.244.65.66%22%2C%22appEnv%22%3A%22PRD%22%2C%22sessionId%22%3A%22NjliOTliYTEtMzM2Mi00OWE0LTk4NGQtODNkNDY1NDliOTMx%22%7D" webHookErrWebUrl="https://petsbe.webhook.office.com/webhookb2/6846f755-9900-4b13-8eb6-7c7a01c9abde@2ebad8bd-5697-4302-afcf-7b617ee135ff/IncomingWebhook/287ff9c2be6c4aecba75d0f1f665a86c/89d2885b-4579-4313-be4c-a1c2f9998d81"></script>
<script type="text/javascript"  src="https://vknfvtjnsgec6381690.cdn.ntruss.com/_script/jquery/jquery-3.3.1.min.js" ></script>
<script type="text/javascript"  src="https://vknfvtjnsgec6381690.cdn.ntruss.com/_script/jquery/jquery-ui.min.js"></script>

<script type="text/javascript"  src="http://localhost/mpnp/3rdDesign//_script/common.js?modifiedDate=20221013" ></script>
<script type="text/javascript" 	src="http://localhost/mpnp/3rdDesign//_script/ui.js"></script>
<script type="text/javascript" 	src="http://localhost/mpnp/3rdDesign//_script/ui_shop.js"></script>

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
		
		 })//click
		
		
		})
		
		</script>
		<script type="text/javascript">
					  $(function(){
						var form_data = ""; //히든으로 넣을 공간
						var expression = /\B(?<!\.\d*)(?=(\d{3})+(?!\d))/g;
						var priceArr = new Array();
						//상품의 개별 총 가격 배열에 넣기
					  $(".totalPrice_info").each(function(i,element){
						 var price = $(element).find("#totalP").val()*1;
						 priceArr.push(price);
					  })//en each
					 
					  //상품 총 합계 구하기
					  var sum = 0;
					  priceArr.forEach((item)=>{
						  sum += item;
					  });//end forEach
					  
					  
					  //할인액 구하기
					  //할인율 가져오기
					  var rate = ($("#discount_rate").val()*1)/100;
					  //해당 상품에 적용되는 할인 액
					  var rate_price = sum * rate;
					  
					
					  //총 결제금액 구하기
					  var deli_fee = 2500;
					  
					   var actual_price;
					  if(sum < 30001){//sum이 (구매한 상품금액이 30000원 이하인 경우)
						  deli_fee = 0;
					  } //end if
				
					  actual_price = sum - rate_price -deli_fee ; 
					 
					  
					  //숫자에 단위 넣기
					  const rate_ = rate_price.toString()
                      .replace(expression, ","); //할인금액
					  const total_pri = actual_price.toString()
                      .replace(expression, ","); //상품 총가격
					  const cn1 = sum.toString()
                      .replace(expression, ","); // 총 결제금액
					  const ship_fee = deli_fee.toString()
                      .replace(expression, ","); // 배송비
                     
					  $(".totalProductPrice").html(total_pri); //상품 총 금액
					  $("#order_payment_total_dc_amt_view").html(rate_); //할인금액
					  $("#order_payment_total_dlvr_amt_view").html(ship_fee);//배송비
					  $("#order_payment_total_pay_amt_view").html(cn1);//총 결제금액
					  $("#order_payment_end_pay_amt_view").html(cn1);//총 결제금액
					  
					 $('#actualPrice').attr("value",sum);
					 $('#discountPrice').attr("value",rate_price);
					 $('#totalPrice').attr("value",actual_price);
					 
					  })//reay
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
			<div class="tdt">
				<ul class="menu">					
					<li><a href="/join/indexTerms?header=Y&goSns=Y" class="bt">회원가입</a></li>
		                <li><a href="javascript:clickLogin();" class="bt">로그인</a></li>
		                <!-- <li><a href="javascript:;" class="bt">로그인/회원가입</a></li> -->
				
					</ul>
			</div>
			<div class="hdt">
				<!-- mobile -->
				<button class="mo-header-btnType02">취소</button><!-- on 클래스 추가 시 활성화 -->
				<!-- // mobile -->
				<button class="btnGnb" type="button">메뉴</button>
<!-- -->
				<h1 class="logo shop">
					<a class="bt" href="javascript:goShopDeleteCookie();">AboutPet</a>
				</h1>
				<nav class="menushop">
							<button type="button" class="bt st" id="headerTxt"></button>
							<div class="list">
								<ul class="menu">
									<li class=""><a class="bt" href="javascript:void(0);" onclick="sendDispClsfNo(300000173)"><b class="t" id="b_tag_300000174">강아지</b></a></li>
									<li class="active"><a class="bt" href="javascript:void(0);" onclick="sendDispClsfNo(300000174)"><b class="t" id="b_tag_300000174">고양이</b></a></li>
								
								</ul>
							</div>
						</nav>
<!-- -->
				<!-- mobile -->
				<button class="mo-header-backNtn" onclick="storageHist.goBack();">뒤로</button>
					<div class="mo-heade-tit"  >
					<span class="tit"></span>
								</div>
				<div class="mo-header-rightBtn">
						<button class="mo-header-btnType01">
							<span class="mo-header-icon"></span>
							</button>
					</div>
				<button class="mo-header-close"></button>
				<!-- // mobile -->
				<nav class="tmenu">
					<ul class="list">
			
						<li id="liTag_10" class=""><a href="/shop/home/" class="bt">스토어</a></li> <!-- APET-1250 210728 kjh02  -->
						<li id="liTag_00" class="active"><a href="/mypage/indexMyPage/" class="bt">MY</a></li>
					</ul>
				</nav>
			</div>
			<div class="cdt" >
						<div class="schs">
								<div class="form ">
									<div class="input del kwd"><input id="srchWord" name="srchWord"  type="search" maxlength="50" value="" autocomplete="off" placeholder="검색어를 입력해주세요." ></div>
									<button type="button" class="btnSch" data-content="" data-url="/commonSearch">검색</button>
									
									<!-- 자동완성 드롭박스 -->
									<div class="key-word-list" id="key-word-list" style="display:none;"><ul></ul></div>
									<!-- 자동완성 드롭박스 -->
								</div>
							</div>
						<div class="menu">
							<!-- <button id="alertBtn" class="bt alim  " type="button">알림</button> -->
							<button class="bt cart" type="button" onclick="location.href='/order/indexCartList/'" >
									</button>
							<button id="srchClsBtn" class="bt close" type="button" style="display: none;" onclick="searchCommon.srchClsBtn();">닫기</button>
							<div class="alims" id ="alertDiv">
							</div>
						</div>
						</div>
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



<div class="layers tv seriesHome" id="gnbSrisListPopup"></div>
<!-- e : gnb 영역 -->			
	
</script>

				<!-- s : 검색 영역 -->
<!-- e : 검색 영역 -->
<!--❤️사이드바 끝-->
<!--❤️main-->
<main class="container lnb page shop order my" id="container" style="margin-left:-100px;margin-top:100px;">

	<form id="claim_request_list_form">
		<input type="hidden" id="delivery_detail_ord_no" name="ordNo" value="">
		<input type="hidden" id="delivery_detail_ord_dtl_seq" name="ordDtlSeq" value="">
		<input type="hidden" id="clm_tp_cd" name="clmTpCd" value="">
		<input type="hidden" id="clm_rsn_cd" name="clmRsnCd" value="">
		<input type="hidden" id="mngb" name="mngb" value="OD">
	</form>

		<div class="inr" style="min-height: 429px;">
			<!-- 본문 -->
			<div class="contents" id="contents" style="min-height: 550.8px;">
				<!-- PC 타이틀 모바일에서 제거  -->
				<div class="pc-tit">
					<h2>주문 상세</h2>
				</div>
				<!-- // PC 타이틀 모바일에서 제거  -->
				<!-- 주문 배송 -->

				<div class="delivery-oder-area">
				<div class="inr-box border-on">
					<div class="item-list">
						<div class="top">
							<div class="tit">
								<p class="data">2022.10.30</p>
								<span class="icon-left-gap">주문번호 : ${moDom.orderId}</span>
							</div>
							<!-- 전체 구매확정 여부 -->
							<!-- APET-1523 자사 전체 취소 가능 여부 - 자사인 경우 배송준비중까지 상태 아닌경우-->
								<!-- APET-1523 자사 전체 배송완료 체크-->
								<!-- 주문 취소 가능 여부 eq Y -->
									</div>
					<!-- </div> -->
					<!-- 파랑 t3   결제완료 배송중 배송준비중   -->
					<!-- 빨강 t4  입금대기 반품신청  반품진행중  교환신청 교환진행중 -->
					<!-- 검정   구매확정 배송완료 반품완료 CLM_DTL_STAT 260 반품거부 250 교환완료 450 교환거부 350  -->
					<!-- 회색 t2 주문취소 110 120 -->
					<!-- <div class="item-list"> -->
							<div class="bottom">
								<div class="t-box">
									<p class="tit t3">${moDom.status}</p>
									
								</div>

					
								<div class="float-bx">
										<div class="untcart"><!-- .disabled -->
											<div class="box">
												<div class="tops">
													<div class="pic">
														<a href="/goods/indexGoodsDetail?goodsId=GS251062051" data-url="/goods/indexGoodsDetail?goodsId=GS251062051">
														<img src="https://cdudsyowwnmx6388661.cdn.ntruss.com/aboutPet/images/goods/GS251062051/PI000001260_1.jpg?type=f&amp;w=259&amp;h=259&amp;quality=90&amp;align=4" alt="[2+1] 펫모닝 바베큐 PMD-159 (랜덤발송)" class="img" onerror="this.src='../../_images/common/img_default_thumbnail_2@2x.png'">
														</a>
													</div>
													<c:forEach items="${list}" var="list">
													<div class="name">
														<div class="tit k0421">
															<a href="/goods/indexGoodsDetail?goodsId=GS251062051" data-url="/goods/indexGoodsDetail?goodsId=GS251062051">
																${list.prdName }</a>
														</div>
														<div class="stt">
	<!-- 														/ -->
															${list.totalCnt}개
															</div>
														<div class="prcs">
															<!-- APET-1523 스탬프 -->
															<span class="prc"><em class="p">${list.prdPrice}</em><i class="w">원</i></span>
																</div>
													</div>
													</c:forEach>
												</div>
											</div>
										</div>
										 <div class="btn-bx 
											">
											<div class="btnSet">
											</div>
											</div>
										<!-- APET-1537: FE 배송준비중 상태 조기 변경으로 인한 고객 자체취소 불가 개선 -->
										</div>
									</div>
						<!-- </div> -->
						</div>
					</div>
					
					<div class="ordersets pc-cut">
						<section class="sect addr">
							<div class="hdts"><span class="tit">배송지</span></div>
							<div class="cdts">
								<div class="adrset">
									<div class="name">
										<em class="t g">${moDOM2.deliveryName }</em>
									</div>
									<div class="adrs">
										[${moDOM2.zipcode}] ${moDOM2.addr }</div>
									<div class="tels">${moDOM2.receiver}/${moDOM2.phone}</div>
								</div>
								<div class="adrreq">
								<!-- 배송요청사항 노출을 위해 주석 -->
								<div class="pwf">
										<em class="t">
											택배함</em>
										<em class="p">
											필요없음&nbsp; 
											</em>
										<div class="txt custom_ellipsis_dlvr">${moDom.shipReq }</div>
									</div>
								</div>
							</div>
						</section>
						<section class="sect bprc">
							<div class="hdts"><span class="tit">결제 정보</span></div>
							<div class="cdts">
								<ul class="prcset">

								<li>
										<div class="dt">상품 금액</div>
										<div class="dd">
											<span class="prc"><em class="p">3,400</em><i class="w">원</i></span>
										</div>
									</li>
									<li>
										<div class="dt">배송비</div>
										<div class="dd">
											<span class="prc"><em class="p">2,500</em><i class="w">원</i></span>
										</div>
									</li>
								
									</ul>

							<div class="tot">
									<div class="dt">최종 결제금액</div>
									<div class="dd">
										<span class="prc"><em class="p">5,900</em><i class="w">원</i></span>
									</div>
								</div>
							</div>
						</section>
						
						
						<section class="sect binf">
							<div class="hdts"><span class="tit">결제 수단</span></div>
							<div class="cdts">
								<div class="result">
									<div class="hd">
										<em class="b">카카오페이</em>
										
										</div>
									<div class="dd">
									</div>
								</div>
							</div>
						</section>
				
						<div class="my_btnWrap t2">
							<div class="btnSet">
								<a href="/mypage/order/indexDeliveryList" data-content="" data-url="/mypage/order/indexDeliveryList" class="btn lg d">주문 목록</a>
								<a href="/shop/home/" class="btn lg b">계속 쇼핑하기</a>
							</div>
						</div>
					</div>
				</div>
				<!-- // 주문 배송 -->

			</div>
			
		</div>
	</main>
  <!--❤️main-->
	<input type="hidden" id="decodeNickNm" value="jsh1706"/>
		
	<style>
		.expire{
			font-size: 13rem;
			color: #ff7777;
			margin-top: 7px;
			padding: 0 5px 0;
			position:absolute;
			left:53%;
			top:20%;
		}
	</style>

	<!-- e -->

					</main>
			</div>
	</div>
</article><!-- 플로팅 영역 --><!-- location 영역 포함  -->			
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