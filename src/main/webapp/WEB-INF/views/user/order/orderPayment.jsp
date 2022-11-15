<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" info="scriptlet의 사용" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html lang="ko">
<head>
<title>어바웃펫 : 새로운 반려 라이프의 시작</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<meta name="format-detection" content="telephone=no">
<meta name="theme-color" content="#ffffff">

<link href="common/favicon/favicon.ico" rel="shrtcut icon">
<link href="common/favicon/android-icon-192x192.png" rel="apple-touch-icon-precomposed">
<link rel="stylesheet" href="http://localhost/mfnf/3rdDesign/common/css/headerFooter.css">
<link rel="stylesheet" type="text/css" href="http://localhost/mfnf/3rdDesign/_css/main.style.pc.css">
<link rel="stylesheet" type="text/css" href="http://localhost/mfnf/3rdDesign/css/order.css">
<link rel="stylesheet" type="text/css" href="http://localhost/mfnf/3rdDesign/_css/pc/common.css">

<script type="text/javascript"  src="https://vknfvtjnsgec6381690.cdn.ntruss.com/_script/jquery/jquery-3.3.1.min.js" ></script>
<script type="text/javascript"  src="https://vknfvtjnsgec6381690.cdn.ntruss.com/_script/jquery/jquery-ui.min.js"></script>
<script type="text/javascript"  src="https://vknfvtjnsgec6381690.cdn.ntruss.com/_script/jquery/jquery.inputmask.bundle.min.js" charset="utf-8"></script>
<script type="text/javascript"  src="https://vknfvtjnsgec6381690.cdn.ntruss.com/_script/jquery/jquery.number.min.js" charset="utf-8"></script>
<script type="text/javascript"  src="https://vknfvtjnsgec6381690.cdn.ntruss.com/_script/jquery/jquery.form.min.js" ></script>
<script type="text/javascript"  src="https://vknfvtjnsgec6381690.cdn.ntruss.com/_script/swiper.min.js"></script>
<script type="text/javascript"  src="https://vknfvtjnsgec6381690.cdn.ntruss.com/_script/clipboard.min.js"></script>
<script type="text/javascript"  src="http://localhost/mfnf/3rdDesign/_script/common.js?modifiedDate=20221013" ></script>
<script type="text/javascript"  src="http://localhost/mfnf/3rdDesign/_script/popup.js" ></script>
<script type="text/javascript"  src="http://localhost/mfnf/3rdDesign/_script/common.js?modifiedDate=20221013" ></script>
<script type="text/javascript" 	src="http://localhost/mfnf/3rdDesign/_script/ui.js"></script>
<script type="text/javascript" 	src="http://localhost/mfnf/3rdDesign/_script/ui_shop.js"></script>

  <!--google icons-->
	<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,400,0,0" />
	<!--google fonts-->
	<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap"
	rel="stylesheet">

	<style>
li.open, div.ctset {
    margin-top: -20px !important; 
    padding: 50px 30px;
    background-color: transparent !important;
    border-radius: 10px 10px 30px 10px;
}

	</style>
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
				<div class="usr">
						<a class="rank_icon" href="javascript:rankBox();"><em class="lv welcome">웰컴</em></a>
							<a href="javascript:;" class="name"><b class="t">seb0103@daum.net</b><i class="i">님</i></a>
						<div class="sbm">
							<ul class="sm">
							<li><a href="/mypage/info/indexPswdUpdate" data-content="1319879" data-url="/mypage/info/indexPswdUpdate" class="bt">비밀번호 설정</a></li>
									<li><a href="/mypage/info/indexManageDetail" data-content="1319879" data-url="/mypage/info/indexManageDetail" class="bt">회원정보 수정</a></li>
									<li><a href="/logout" data-content="1319879" data-url="/logout" class="bt">로그아웃</a></li>
								</ul>
						</div>
					</div>
				
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
			
						<li id="liTag_10" class="active"><a href="/shop/home/" class="bt">스토어</a></li> <!-- APET-1250 210728 kjh02  -->
						<li id="liTag_00" class=""><a href="/mypage/indexMyPage/" class="bt">MY</a></li>
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

		
<!--// header pc--><!-- e : header 영역 -->
					<!-- s : gnb 영역 -->
				

<!--❤️main-->
<main class="container page shop od order" id="container" style="margin-top:100px;">
	<!-- 페이지 헤더 -->
	<div class="pageHeadPc">
		<div class="inr">
			<div class="hdt">
				<h3 class="tit">주문결제</h3>
			</div>
		</div>
	</div>

	<div class="inr" style="min-height: 357px;">

		<!-- 본문 -->
		<form id="order_payment_form" name="order_payment_form">

			<!-- 카카오페이 옵션 -->
			<input type="hidden" name="EasyPayCardCode" id="easyPayCardCode" value="">				<!-- 간편결제 카드코드 -->
			<input type="hidden" name="EasyPayQuota" id="easyPayQuota" value="">				<!-- 간편결제 할부개월 -->

		</form>
		<!-- 상품상세 배송선택 param -->
		<input type="hidden" id="dlvrSelectId" value="">
		<input type="hidden" id="dlvrStartId" value="">
		
		
		<div class="contents" id="contents">
			<div class="ordersets">
				<section class="sect usrs">
					<div class="hdts"><span class="tit">주문 고객 정보</span></div>
					<div class="cdts">
						<div class="box">
							<div class="cdts" id="noMemDiv">
								<div class="ptset">
									<span>유설빈</span>
								</div>
								<div class="ptt" style="margin-top: 10px"><b class="t">010-1111-1274</b></div>
							</div>
							<div class="usr" id="memDiv" style="display:none;"><em class="nm" id="memDiv-mbrNm">,</em><i class="tel" id="memDiv-mobile">010-1111-1274</i></div>
							<!-- <div class="bts"><a href="/mypage/info/indexManageDetail" class="btn c sm btMyMod">개인정보수정</a></div> -->
							
							<input type="hidden" id="memberYn" value="N">
						</div>
					</div>
				</section>
				<section class="sect addr">

							<div class="hdts"><span class="tit">배송지</span></div>
							<div class="cdts">
								<ul class="adrlist">
							
									<li class="arr">
										<div class="dt">주소</div>
										<div class="dd">
											<div class="adrbox a1">
												<div class="adr" id="addressInfo">[06252] 서울특별시 강남구 강남대로 328(역삼동)</div>
												<a href="javascript:;" class="btAdr" onclick="orderDlvra.openPostPop();">주소검색</a>
											</div>
											<div class="adrbox a2" style="">
												<span class="input coms"><input type="text" maxlength="30" id="order_payment_road_dtl_addr" placeholder="상세주소를 입력하세요." style="padding-right: 29px;"></span>
											</div>
										</div>
									</li>
								</ul>
								<div class="adrreq" style="">
									<div class="tit">배송 요청사항</div>
									<div class="pwf" id="existDemand" style="display: none">
										<em class="t" id="demandGoodsRcvPstCd"></em>
										<em class="p" id="demandPblGateEntMtdCd"></em>
										<div class="txt" id="demandDlvrDemand"></div>
										<div class="btt"><a href="javascript:;" class="btn sm btMod" onclick="orderDlvra.changeDlvrDemandPop();">변경</a></div>
									</div>
									<div class="pss" id="noExistDemand">
										<textarea name="delivery_request" id="" cols="93" rows="5" placeholder="요청사항을 입력해주세요." style="border-radius: 3px;border: 1px solid #dddddd;padding:10px 10px;"></textarea>

									</div>
								</div>
								<div class="saves">
									<div class="pp"><label class="checkbox"><input type="checkbox" id="order_payment_adrs_insert_yn" checked="" value="Y"><span class="txt"><em class="tt">등록한 정보를 회원정보에 반영합니다. (휴대폰번호/주소)</em></span></label></div>
								</div>
							</div>
						</section>
					<input type="hidden" id="preBookYn" value="N">
				
				<div id="dlvrAreaTmpl01" style="display:none;">
					<div class="delivery_choice" id="localCompDlvr">
						<div class="hdd">
							<span class="delivery_item"></span>
							<span class="arrival_info"></span>
							<!-- 사전예약 상품인경우 배송선택 없음. -->
							<button type="button" class="btn sm" onclick="orderArea.popupSelDelivery()">변경</button>
							</div>
						<div class="cdd pd_tog_box open">
							<ul class="lst">
								<li>
											<div class="tt">ANF 캣 홀리스틱 헬시 키튼 샘플 40g</div>
											<div class="ts">1개 / 
												500원
													</div>
										</li>
									</ul>
						</div>
					</div>
				</div>
				
				<div id="dlvrAreaTmpl03" style="display:none;">
					<div class="delivery_choice" id="localCompDlvr">
						<div class="hdd delivery_gs">
							<span class="delivery_item"></span>
							<div class="arrival_info_wrap">
								<span class="arrival_info">1~2일 소요 예정</span>
								<!--
								<span class="arrival_info sub">밤 12시 전 주문 : 다음날 도착(98%)</span>
								<span class="arrival_info sub">밤 12시 이후 주문 : 2일 이내 도착</span>
								-->
							</div>
							<!-- 사전예약 상품인경우 배송선택 없음. -->
							<button type="button" class="btn sm" onclick="orderArea.popupSelDelivery()">변경</button>
							</div>
						<div class="cdd pd_tog_box open">
							<ul class="lst">
								<li>
											<div class="tt">ANF 캣 홀리스틱 헬시 키튼 샘플 40g</div>
											<div class="ts">1개 / 
												500원
													</div>
										</li>
									</ul>
						</div>
					</div>
				</div>
					
				<div id="dlvrAreaTmpl02" style="display:none;">
					</div>
				<section class="sect deli">
					<div class="hdts"><span class="tit">상품정보</span></div>
					
						<div class="cdts" id="dlvrArea">
							<span class="text">ANF 캣 홀리스틱 헬시 키튼 샘플 40g</span>
							<span class="text">&nbsp;[수량: 1개]</span>

					</div>
				</section>
				<section class="sect disc" id="existCoupon">
					<div class="hdts"><span class="tit">할인 혜택</span></div>
					<div class="cdts">
						<div class="cpset"><!-- @@ 02.22 변경 -->
							<div class="ht">OO등급</div>
							<div class="dt">
								<input type="hidden" id="tot_goods_cp_dc_amt" name="tot_goods_cp_dc_amt" value="0">
								<input type="hidden" id="tot_dlvr_cp_dc_amt" name="tot_dlvr_cp_dc_amt" value="0">
								<input type="hidden" id="local_cp_dc_tot_amt" name="local_cp_dc_tot_amt" value="0">
								<em class="prc"><b class="p" id="tot_goodsdlvr_cp_dc_amt_view">OO</b><i class="w">%</i></em>
								<span class="txt">할인적용</span>
							</div>
						</div>
						
					</div>
					

					
				</section>

				

	
				
				<section class="sect binf">
					<div class="hdts"><span class="tit">결제 수단</span></div>
					<div class="cdts">
						<ul class="bilist">
						
							<li id="commonPayLi" class="open">
								<div class="hht">
									<label class="radio" onclick="selectCommonPayment();">
									
									</label>
								</div>
								<div class="ddt" style="margin-left:20px;">
									<ul class="biltab">
										
										<li class="kpay active" id="kakaoPayLi"><button type="button" data-ui-tab-btn="tab_bils" data-ui-tab-val="tab_bils_6" class="btn" value="71" onclick="selectPayMethod('71');"><span class="txt">카카오페이</span></button></li>
									</ul>
									<div data-ui-tab-ctn="tab_bils" data-ui-tab-val="tab_bils_1">
						
									</div>
									<div data-ui-tab-ctn="tab_bils" data-ui-tab-val="tab_bils_2"></div>
									<div data-ui-tab-ctn="tab_bils" data-ui-tab-val="tab_bils_3"></div>
									<div data-ui-tab-ctn="tab_bils" data-ui-tab-val="tab_bils_4"></div>
									<div data-ui-tab-ctn="tab_bils" data-ui-tab-val="tab_bils_5"></div>
									<div data-ui-tab-ctn="tab_bils" data-ui-tab-val="tab_bils_6"></div>
								</div>
							</li>
							</ul>
						<div class="defbilchk" onclick="checkedDefaultPayMethod();">
							<!-- <label class="checkbox" onclick="checkedDefaultPayMethod();">
								<input type="checkbox" id="order_payment_default_pay_method" checked=""> <span class="txt">기본 결제수단으로 저장</span>
							</label> -->
						</div>
					</div>
					</section>

					<section class="sect bprc">
						<input type="hidden" id="order_payment_total_pay_amt_ex_gs_point" value="94000">
						<input type="hidden" id="order_payment_total_pay_amt_ex_svmn_point" value="94000">
						<div class="hdts"><span class="tit">결제 금액</span></div>
						<div class="cdts">
							<ul class="prcset">
								<li>
									<div class="dt">총 상품금액</div>
									<div class="dd">
										<span class="prc"><em class="p">99,000</em><i class="w">원</i></span>
										<input type="hidden" id="order_payment_total_goods_amt" value="99000">
										<input type="hidden" id="order_payment_total_local_goods_amt" value="">
										<input type="hidden" id="fstPurchGoodsIncYn" value="N">
									</div>
								</li>
								<li id="couponDcLi">
									<div class="dt">등급할인</div>
									<div class="dd">
										<span class="prc dis"><em class="p" id="order_payment_total_dc_amt_view">-5,000</em><i class="w">원</i></span>
										<input type="hidden" id="order_payment_total_dc_amt" value="5000">
									</div>
								</li>
								<li id="svmnDcLi" style="display:none;">
									<div class="dt">적립금 사용</div>
									<div class="dd">
										<span class="prc dis"><em class="p" id="order_payment_svmn_amt_view">0</em><i class="w">점</i></span>
									</div>
								</li>
						
								<li>
									<div class="dt">배송비</div>
									<div class="dd">
										<span class="prc"><em class="p" id="order_payment_total_dlvr_amt_view">0</em><i class="w">원</i></span>
										<input type="hidden" id="gb_01_total_dlvr_amt" value="0">
										<input type="hidden" id="gb_02_total_dlvr_amt" value="0">
										<input type="hidden" id="order_payment_total_dlvr_amt" value="0">
									</div>
								</li>
							</ul>
							<div class="tot">
								<div class="dt">총 결제금액</div>
								<div class="dd">
									<span class="prc"><em class="p" id="order_payment_total_pay_amt_view">94,000</em><i class="w">원</i></span>
									<input type="hidden" id="order_payment_total_pay_amt" value="94000">
								</div>
							</div>
							<!-- 01 주문서-리테일멤버십 가입 안한 경우 -->
						
							<!-- 02 주문서-리테일멤버십 등록 한 경우 -->
					
						</div>
					</section>
				<section class="sect agre">
					<div class="hdts"></div>
					<div class="cdts">
						
						<script>
							//전체동의 체크/해제😍
							$(function(){
							 $("#chkAllTerms").click(function(){
									
									if($("#chkAllTerms").is(":checked")){
										
										$("input[name=ordTerms]").prop("checked",true);
							
									}else{
									$("input[name=ordTerms]").prop("checked",false);
							
									};//end else
							
							 })//click

							 $("input[name=ordTerms]").click(function() {
									var total = $("input[name=ordTerms]").length;
									var checked = $("input[name=ordTerms]:checked").length;

							if(total != checked) $("#chkAllTerms").prop("checked", false);
							else $("#chkAllTerms").prop("checked", true); 
							});
							
							})
							
							
							
							
							</script>

						<ul class="agreeset">
							<li class="all">
								<span class="checkbox">
									<input type="checkbox" id="chkAllTerms" name="chkAllTerms" onclick="selectAll(this)">
									<span class="txt"><em class="tt st">주문상품 및 결제대행 이용약관에 모두 동의합니다.</em></span>
								</span>
							</li>
							<li>
								<span class="checkbox">
									<input type="checkbox" id="chk1" name="ordTerms" onclick="checkSelectAll()">
									<span class="txt"><em class="tt">주문할 상품의 상품명, 상품가격, 배송정보를 확인하였으며, 구매에 동의하시겠습니까?(전자상거래법 제8조 제2항)</em></span>
								</span>
							</li>

							<!-- 기본약관 -->
							<li id="thirdPartyTerm" style="display:none;">
										<span class="checkbox">
											<input type="checkbox" id="terms_73" name="thirdPartyOrdTerms" data-idx="6" data-terms-no="73" onclick="checkSelectAll()">
											<span class="txt"><a href="javascript:;" name="termPopBtn" data-index="6" class="tt lk">개인정보 제3자정보제공 동의(상품 공급사)</a></span>
										</span>
										<a href="javascript:;" name="contentPopBtn" title="내용보기" data-content="" data-url="" data-index="6"></a>
									</li>
								<!-- 나이스페이먼츠 -->
							<li class="nicePaymentTerms" style="display: block;">
										<span class="checkbox">
											<input type="checkbox" class="chkNiceTerms" name="ordTerms" id="terms_47" data-idx="1" data-terms-no="47" onclick="checkSelectAll()">
											<span class="txt"><a href="javascript:;" name="termPopBtn" data-index="1" class="tt lk">NICE페이먼츠 전자금융거래 이용약관</a></span>
										</span>
										<a href="javascript:;" name="contentPopBtn" title="내용보기" data-content="" data-url="" data-index="1"></a>
									</li>
								<li class="nicePaymentTerms" style="display: block;">
										<span class="checkbox">
											<input type="checkbox" class="chkNiceTerms" name="ordTerms" id="terms_72" data-idx="4" data-terms-no="72" onclick="checkSelectAll()">
											<span class="txt"><a href="javascript:;" name="termPopBtn" data-index="4" class="tt lk">NICE페이먼츠 개인정보 수집 및 이용에 대한 동의</a></span>
										</span>
										<a href="javascript:;" name="contentPopBtn" title="내용보기" data-content="" data-url="" data-index="4"></a>
									</li>
								<li class="nicePaymentTerms" style="display: block;">
										<span class="checkbox">
											<input type="checkbox" class="chkNiceTerms" name="ordTerms" id="terms_44" data-idx="5" data-terms-no="44" onclick="checkSelectAll()">
											<span class="txt"><a href="javascript:;" name="termPopBtn" data-index="5" class="tt lk">NICE페이먼츠 개인정보 제3자 제공에 대한 동의</a></span>
										</span>
										<a href="javascript:;" name="contentPopBtn" title="내용보기" data-content="" data-url="" data-index="5"></a>
									</li>
								</ul>
						<div class="bts">
							<a href="javascript:;" name="contentPopBtn" class="btn a lg btnBill" onclick="validNonMember();">
								<span class="prc"><em class="p" id="order_payment_end_pay_amt_view">51,800</em><i class="w">원</i></span> <span class="txt">결제하기</span>
							</a>
						</div>
					</div>
				</section>
			</div>
			<div class="banners">
				<div class="uibanners">
					<div class="banner_slide">
						<div class="swiper-container slide swiper-container-initialized swiper-container-horizontal">
							<ul class="swiper-wrapper list" style="transition-duration: 0ms; transform: translate3d(0px, 0px, 0px);"></ul>
							<div class="swiper-pagination swiper-pagination-clickable swiper-pagination-bullets swiper-pagination-lock"></div>
							<div class="sld-nav"><button type="button" class="bt prev" tabindex="0" role="button" aria-label="Previous slide">이전</button><button type="button" class="bt next" tabindex="0" role="button" aria-label="Next slide">다음</button></div><!-- @@ 03.18 추가 -->
						<span class="swiper-notification" aria-live="assertive" aria-atomic="true"></span></div>
					</div>
				</div>
			</div>
		</div>

	</div>
</main>
<!--❤️main-->
				
		<!-- s : 본문영역 -->			






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