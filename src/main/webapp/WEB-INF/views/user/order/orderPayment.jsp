<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" info="설빈" %>
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
<link rel="stylesheet" href="http://localhost/mpnp/3rdDesign/common/css/headerFooter.css">
<link rel="stylesheet" type="text/css" href="http://localhost/mpnp/3rdDesign/_css/main.style.pc.css">
<link rel="stylesheet" type="text/css" href="http://localhost/mpnp/3rdDesign/css/order.css">
<link rel="stylesheet" type="text/css" href="http://localhost/mpnp/3rdDesign/_css/pc/common.css">

<script type="text/javascript"  src="https://vknfvtjnsgec6381690.cdn.ntruss.com/_script/jquery/jquery-3.3.1.min.js" ></script>
<script type="text/javascript"  src="https://vknfvtjnsgec6381690.cdn.ntruss.com/_script/jquery/jquery-ui.min.js"></script>
<script type="text/javascript"  src="https://vknfvtjnsgec6381690.cdn.ntruss.com/_script/jquery/jquery.inputmask.bundle.min.js" charset="utf-8"></script>
<script type="text/javascript"  src="https://vknfvtjnsgec6381690.cdn.ntruss.com/_script/jquery/jquery.number.min.js" charset="utf-8"></script>
<script type="text/javascript"  src="https://vknfvtjnsgec6381690.cdn.ntruss.com/_script/jquery/jquery.form.min.js" ></script>
<script type="text/javascript"  src="https://vknfvtjnsgec6381690.cdn.ntruss.com/_script/swiper.min.js"></script>
<script type="text/javascript"  src="https://vknfvtjnsgec6381690.cdn.ntruss.com/_script/clipboard.min.js"></script>
<script type="text/javascript"  src="http://localhost/mpnp/3rdDesign/_script/common.js?modifiedDate=20221013" ></script>
<script type="text/javascript"  src="http://localhost/mpnp/3rdDesign/_script/popup.js" ></script>
<script type="text/javascript"  src="http://localhost/mpnp/3rdDesign/_script/common.js?modifiedDate=20221013" ></script>
<script type="text/javascript" 	src="http://localhost/mpnp/3rdDesign/_script/ui.js"></script>
<script type="text/javascript" 	src="http://localhost/mpnp/3rdDesign/_script/ui_shop.js"></script>
<!-- 우편번호API -->
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
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

#memberZipCd,#memberAddr1,#memberAddr2{
    display: block;
    width: 100%;
    padding: 13px 10px 13px 10px !important;;
    border-radius: 4px;
    margin: 0px 0;
    background-image: none;
    -webkit-appearance: none;
    color: #333333;
    border: #dddddd solid 1px;
    resize: none;
    outline: none;
    vertical-align: middle;
    -webkit-border-radius: 4px;
    /* box-shadow: inset 0 1px 2px rgb(27 31 35 / 8%); */
    font-size: 15rem;
    margin:10px 0px;
}

#memberZipCd{
  width:50% !important;
  margin:0px 0px !important; 

}

.zipcode{
  display: flex;
  align-items: center;
  
}

.bg-black{
  background-color: var(--colors-main03);
  padding:13px 10px;
  border-radius: 4px;
  color:#fff;
}

	</style>
<script>
   //우편번호
    //본 예제에서는 도로명 주소 표기 방식에 대한 법령에 따라, 내려오는 데이터를 조합하여 올바른 주소를 구성하는 방법을 설명합니다.
/* 우편번호시작 API */
			 function execDaumPostcode() {
			        new daum.Postcode({
			            oncomplete: function(data) {
			                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
			
			                // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
			                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
			                var roadAddr = data.roadAddress; // 도로명 주소 변수
			                var extraRoadAddr = ''; // 참고 항목 변수
			
			                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
			                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
			                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
			                    extraRoadAddr += data.bname;
			                }
			                // 건물명이 있고, 공동주택일 경우 추가한다.
			                if(data.buildingName !== '' && data.apartment === 'Y'){
			                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
			                }
			                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
			                if(extraRoadAddr !== ''){
			                    extraRoadAddr = ' (' + extraRoadAddr + ')';
			                }
			
			                // 우편번호와 주소 정보를 해당 필드에 넣는다.
			                document.getElementById("memberZipCd").value = data.zonecode;
			                document.getElementById("memberAddr1").value = roadAddr
			                //커서를 상세주소로 이동
			                document.getElementById("memberAddr2").focus();
			     
			
			            }
			        }).open();
			    }//execDaumPostcode() 
			    
</script>
<script>
//결제하기 유효성 검사
	$(function(){
		$(".btnBill").click(function(){
		//	check();
		})//end click
		
	})
	
		 function check(){
		
			var zipcode=$("#memberZipCd").val();
			if(zipcode.trim()==""){
				alert("우편번호를 입력해주세요..");
				$("#memberZipCd").focus();
				return ;
			}//addr2
			

			var addr1=$("#memberAddr1").val();
			if(addr1.trim()==""){
				alert("주소를 입력해주세요..");
				$("#memberAddr1").focus();
				return ;
			}//addr2
			
			

			var addr2=$("#memberAddr2").val();
			if(addr2.trim()==""){
				alert("상세주소를 입력해주세요..");
				$("#memberAddr2").focus();
				return ;
			}//addr2
			
			//var shipReq=$("#shipReq").val();
			if($("#shipReq").val().length ==0 ){
				alert("배송요청사항을 입력해주세요.");
				
			  $("#shipReq").focus();
				return ;
			}//addr2
			
			if($("#shipReq").val().length < 10){
				alert("요청사항은 최소 10자 이상 입력가능합니다");
				$("#shipReq").focus();
				return ;
			}
			
			var mailChk =$(':checkbox[id=chk1]:checked' );
			if(mailChk.length<1){
				alert("구매동의 여부를 체크해주세요");
				return ;
				
			}//mailChk
			
			var smsChk =$(':checkbox[id=terms_72]:checked');
			if(smsChk.length<1){
				alert("개인정보 수집 및 이용에 동의해주세요");
				return;
				
			}//smsChk
			
			var perChk =$(':checkbox[id=terms_44]:checked');
			if(perChk.length<1){
				alert("개인정보 제공여부에 동의해주세요");
				return;
				
			}//perChk
			
			if(confirm("결제하시겠습니까?")){
				$("#orderFrm").submit();
				
			}//confirm
				
			}//check
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


<!--본문  -->

		<!-- 상품정보 -->
		<c:forEach  items="${opvo}" var="op">
		<div class="product_info_div">
		 <input type="hidden" class="indi_prdId"  value="${op.prdId}">			
		 <input type="hidden" class="indi_prdName"  value="${op.prdName}">			
		 <input type="hidden" class="indi_prdPrice" value="${op.prdPrice}">			
		 <input type="hidden" class="indi_prdCnt"  value="${op.prdCnt}">			
		</div>
		</c:forEach>
		
		<!-- 주문정보 넘기기 -->
		<form action="orderPayment_process.do" id="orderFrm" name="orderFrm">

					<input type="hidden" name="memberName" id="memberName" value="${orDom.memberName}">
                    <input type="hidden" name="phone" id="phone" value="${orDom.phone}"> 
                    
                     <input type="hidden" name="ship_name" id="ship_name" value=""> 
                     
                     <input type="hidden" name="receiver" id="receiver" value=""> 
                     <input type="hidden" name="receiver_phone" id="receiver_phone" value=""> <input type="hidden" name="actualPrice" id="actualPrice" value="">



			
		<!-- 끝 -->
		<!-- 상품상세 배송선택 param -->

		
		
		<div class="contents" id="contents">
			<div class="ordersets">
				<section class="sect usrs">
					<div class="hdts"><span class="tit">주문 고객 정보</span></div>
					<div class="cdts">
						<div class="box">
							<div class="cdts" id="noMemDiv">
								<div class="ptset">
									<span>${orDom.memberName}</span>
								</div>
								<div class="ptt" style="margin-top: 10px"><b class="t">${orDom.phone}</b></div>
							</div>
							<div class="usr" id="memDiv" style="display:none;"><em class="nm" id="memDiv-mbrNm">,</em><i class="tel" id="memDiv-mobile">${orDom.phone}</i></div>
							<!-- <div class="bts"><a href="/mypage/info/indexManageDetail" class="btn c sm btMyMod">
수정</a></div> -->
							
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
											<div class="cont">
								<ul class="add">
									<li class="clearfix a1">
										<div class="zipcode">
										<!--	<label for="memberZipCd" class="hide">우편번호</label>  -->
											<input type="text" name="zipcode" id="memberZipCd" placeholder="우편번호" readonly/> 
											<button id="addrBtn" type="button" class="bg-black" title="새창으로 열립니다." onclick="execDaumPostcode()">우편번호 찾기</button>
											
										</div>
									</li>
									<li class="clearfix a2">
										<span class="l">
											<!-- <label for="memberAddr1" class="hide">주소</label> -->
											<input type="text" name="addr" id="memberAddr1" placeholder="주소" readonly />
										</span>
										<span class="r">
											<!-- <label for="memberAddr2" class="hide">나머지 주소</label> -->
											<input type="text" name="addrDetail" id="memberAddr2"  placeholder="상세주소를 입력하세요" value="" class="long" />
										</span>
									</li>
								</ul>
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
										<textarea name="shipReq" id="shipReq" cols="93" rows="5" placeholder="요청사항을 입력해주세요." style="border-radius: 3px;border: 1px solid #dddddd;padding:10px 10px;"></textarea>

									</div>
								</div>
							
								<div class="saves">
									<div class="pp"><label class="checkbox"><input type="checkbox" id="deafaultFlag" name="deafaultFlag" checked="" value="O"><span class="txt"><em class="tt">기본 배송지로 설정</em></span></label></div>
								</div>
							</div>
						</section>
					<input type="hidden" id="preBookYn" value="N">
				
			
				
					
				<div id="dlvrAreaTmpl02" style="display:none;">
					</div>
				<section class="sect deli">
					<div class="hdts"><span class="tit">상품정보</span></div>
					
					<ul class="lst"> 
					
							<c:forEach  items="${opvo}" var="op">
								<li>
											<div class="tt">${op.prdName}</div>
											<div class="ts">${op.prdCnt}개 / 
												${op.prdPrice}원
													</div>
										</li>
						</c:forEach>
									</ul>
				

				
			
				</section>
				<section class="sect disc" id="existCoupon">
					<div class="hdts"><span class="tit">할인 혜택</span></div>
					<div class="cdts">
						<div class="cpset"><!-- @@ 02.22 변경 -->
							<div class="ht">${orDom.gradeName }등급</div>
							<div class="dt">
								<input type="hidden" id="tot_goods_cp_dc_amt" name="tot_goods_cp_dc_amt" value="0">
								<input type="hidden" id="tot_dlvr_cp_dc_amt" name="tot_dlvr_cp_dc_amt" value="0">
								<input type="hidden" id="local_cp_dc_tot_amt" name="local_cp_dc_tot_amt" value="0">
								<em class="prc"><b class="p" id="tot_goodsdlvr_cp_dc_amt_view">${orDom.discountRate }</b><i class="w">%</i></em>
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
									
								</div>
							</li>
							</ul>
						<div class="defbilchk" onclick="checkedDefaultPayMethod();">
						
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
									<input type="checkbox" id="chkAllTerms" name="chkAllTerms">
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
							<a href="javascript:;" name="contentPopBtn"  class="btn a lg btnBill" >
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
		</form>

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