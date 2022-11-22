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
<link rel="stylesheet" type="text/css" href="http://localhost/mpnp/3rdDesign/css/order.css">
	<link rel="stylesheet" type="text/css" href="https://vknfvtjnsgec6381690.cdn.ntruss.com/_css/jquery-ui.css">
<script type="text/javascript" src="http://localhost/mpnp/3rdDesign/_script/crypto.js"></script>
	<script type="text/javascript" src="https://vknfvtjnsgec6381690.cdn.ntruss.com/_script/webHookPolicy.js?v=22102810"></script>
	<script type="text/javascript" src="https://vknfvtjnsgec6381690.cdn.ntruss.com/_script/errHandler.min.js?v=22102810" userInfo="%7B%22mbrNo%22%3A0%2C%22appName%22%3A%22FRONT%22%2C%22sessionIp%22%3A%22211.244.65.66%22%2C%22appEnv%22%3A%22PRD%22%2C%22sessionId%22%3A%22NjliOTliYTEtMzM2Mi00OWE0LTk4NGQtODNkNDY1NDliOTMx%22%7D" webHookErrWebUrl="https://petsbe.webhook.office.com/webhookb2/6846f755-9900-4b13-8eb6-7c7a01c9abde@2ebad8bd-5697-4302-afcf-7b617ee135ff/IncomingWebhook/287ff9c2be6c4aecba75d0f1f665a86c/89d2885b-4579-4313-be4c-a1c2f9998d81"></script>
<script type="text/javascript"  src="https://vknfvtjnsgec6381690.cdn.ntruss.com/_script/jquery/jquery-3.3.1.min.js" ></script>
<script type="text/javascript"  src="https://vknfvtjnsgec6381690.cdn.ntruss.com/_script/jquery/jquery-ui.min.js"></script>
<script type="text/javascript"  src="https://vknfvtjnsgec6381690.cdn.ntruss.com/_script/jquery/jquery.blockUI.js" charset="utf-8"></script>
<script type="text/javascript"  src="https://vknfvtjnsgec6381690.cdn.ntruss.com/_script/jquery/jquery.inputmask.bundle.min.js" charset="utf-8"></script>
<script type="text/javascript"  src="https://vknfvtjnsgec6381690.cdn.ntruss.com/_script/jquery/jquery.number.min.js" charset="utf-8"></script>
<script type="text/javascript"  src="https://vknfvtjnsgec6381690.cdn.ntruss.com/_script/jquery/jquery.form.min.js" ></script>

<script type="text/javascript"  src="https://vknfvtjnsgec6381690.cdn.ntruss.com/_script/swiper.min.js"></script>
<script type="text/javascript"  src="https://vknfvtjnsgec6381690.cdn.ntruss.com/_script/clipboard.min.js"></script>
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
		
		 })//click
		
		 $(".bt_cat").click(function(){
		 $(".bt_dog").removeClass("active"); 
		 $(this).addClass("active")
		 $(".open_cat").css('display','block');
		 $(".open_dog").css('display','none');
		
		 })//click
		
		
		
		})
		
		</script>





</head>

<body class="body">

<!-- 기본 컨텐츠 -->
	<div class="wrap" id="wrap">
		<input type="hidden" id="viewJsonData" value="%7B%22vod_group_list_api_url%22%3A%22https%3A%2F%2Fsgr.aboutpet.co.kr%2Fv1%2Fplaylist%2Flist%3Fchannel_id%3D%22%2C%22vod_group_move_api_url%22%3A%22https%3A%2F%2Fsgr.aboutpet.co.kr%2Fv1%2Fplaylist%2Fmove_vod%2F%22%2C%22vod_group_add_api_url%22%3A%22https%3A%2F%2Fsgr.aboutpet.co.kr%2Fv1%2Fplaylist%2Fadd_item%2F%22%2C%22vod_upload_api_url%22%3A%22https%3A%2F%2Fsgr.aboutpet.co.kr%2Fv1%2Fvod%2Fupload%2F%22%2C%22vod_chnl_list_api_url%22%3A%22https%3A%2F%2Fsgr.aboutpet.co.kr%2Fv1%2Fchannel%2Flist%22%2C%22fo_mois_post_confmKey%22%3A%22U01TX0FVVEgyMDIxMDMzMDEwMzEzMDExMDk4MTk%3D%22%2C%22vod_api_chnl_id_log%22%3A%22aboutpet_log%22%2C%22vod_info_api_url%22%3A%22https%3A%2F%2Fsgr.aboutpet.co.kr%2Fv1%2Fvod%2Fvideo%2Finfo%2F%22%2C%22vod_group_chnl_ord_api_url%22%3Anull%2C%22vod_list_api_url%22%3A%22https%3A%2F%2Fsgr.aboutpet.co.kr%2Fv1%2Fvod%2Fvideo%2F%22%2C%22vod_group_default%22%3A%22unclassified%22%2C%22vod_api_chnl_id_tv%22%3A%22aboutpet_tv%22%7D">
		
	<script>
	
	function clickLogin(){
		location.href = "/indexLogin?returnUrl="+location.pathname+location.search;
	}
	</script>
	
	
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

		
		

				<!-- s : 검색 영역 -->
<!-- e : 검색 영역 -->
<!--❤️사이드바 끝-->
<!--❤️main-->
<main class="container page shop od cart" id="container" style="margin-top:100px;">

	
	<div class="pageHeadPc">
		<div class="inr">
			<div class="hdt">
				<h3 class="tit">장바구니</h3>
			</div>
		</div>
	</div>
	<div class="inr" style="min-height: 357px;">
		<!-- 본문 -->
		<div class="contents" id="contents">
<script>
	//전체동의 체크, 해제 지우지마세용😍
	$(function(){
	 $("#chkAll").click(function(){
			
			if($("#chkAll").is(":checked")){
				
				$("input[name=cartIds]").prop("checked",true);
			
	
			}else{
			$("input[name=cartIds]").prop("checked",false);
	
			};//end else
	
	 })//

	 
	$("input[name=cartIds]").click(function() {
		var total = $("input[name=cartIds]").length;
		var checked = $("input[name=cartIds]:checked").length;

		if(total != checked) $("#chkAll").prop("checked", false);
		else $("#chkAll").prop("checked", true); 
	});
	
	})
	
	
	
	
	</script>


<form id="cartForm">
<input type="hidden" name="fstPurchBeneTgYn" id="fstPurchBeneTgYn" value="N">
<div class="allcheck scroll_fixed">
		<div class="inr">
			<div class="box">
				<label class="checkbox"><input type="checkbox" id="chkAll" checked="checked"><span class="txt">전체 선택 <i class="i">(2/2)</i></span></label>
				<a href="javascript:void(0);" class="lk" onclick="cartGoods.del()" data-content="" data-url="https://aboutpet.co.kr/order/deleteCart">선택 삭제</a>
			</div>
		</div>
	</div>
	<div class="cartWrap">
		<div class="cartPrds">
			<!-- APET-1523 스탬프 상품 -->
			<!-- 자사 -->
				<section class="sect abt">
						<div class="frstat" id="apetBarDiv">
							<label class="checkbox"><input type="checkbox" id="chkCompNo912" value="912" checked="checked" name="cartIds"><span class="txt"><span class="dt"><span class="t">멍품냥품 배송 상품</span></span></span></label>
							<div class="box">
								<div class="gage">
									<div class="inf">
										<input type="hidden" id="apetDlvrcBuyPrc" value="30000">
										<!-- 상품 선택이 되지 않아서 무료배송 여부를 알 수 업는 경우 -->
										<em class="pp" id="noneDlvrBar" style="display: none;">👀 <b class="p">30,000</b><i class="w">원</i></em> <span class="tt" style="display: none;">이상 무료배송</span>
										<!-- 선택한 상품의 가격이 총 30000원을 넘는 경우 -->
										<em class="pp" id="fullDlvrBar" style="">🚚 <b class="p">무료배송</b></em>
										<!-- 선택한 상품의 가격이 30000원 이하인 경우 -->
										<em class="pp" id="addDlvrBar" style="display:none;">💸 <b class="p"></b><i class="w">원 이상</i></em> <span class="tt" style="display:none;">추가하면 무료배송!</span>
										<span class="prc"><em class="p">30,000</em><i class="w">원</i></span>
									</div>
									<div class="bar">
										<em class="b free" id="apetBar" style="width: 100%;"></em>
									</div>
								</div>
							</div>
						</div>
				<!-- 업체 -->
				<ui class="cartlist" id="cartList912" data-comp-no="912">

<li>
<div class="untcart " id="untcart163361418348766992">


<label class="checkbox">
	<input type="checkbox" id="chkCartId0001" name="cartId" value="cart_0001" checked="checked">
	<span class="txt"></span>
</label>
<button type="button" class="bt del" >삭제</button>
<div class="box">
	<div class="tops">
		<a href="javascript:;" onclick="fnGoGoodsDetail('GI251051246')" >
			<img src="https://cdudsyowwnmx6388661.cdn.ntruss.com/aboutPet/images/goods/GI251051246/23cf8322-0287-4298-8267-af005d6c1486.jpg?type=f&amp;w=259&amp;h=259&amp;quality=90&amp;align=4" alt="가필드 고양이모래 보라(굵은입자) 4.53kg 카사바모래" class="img" onerror="this.src='../../_images/common/img_default_thumbnail_2@2x.png'">
			</a>
		<div class="name">
			<a href="javascript:;" onclick="fnGoGoodsDetail('GI251051246')" class="tit" >가필드 고양이모래 보라(굵은입자) 4.53kg 카사바모래</a>
			</div>
	</div>
	
	<div class="amount ">
			<span class="uispined st load" data-max="2" data-min="1">
						<input type="number" class="amt" id="buyQty163361418348766992" name="buyQty" value="1" data-cart-id="163361418348766992" data-min-ord-qty="1" data-max-ord-qty="2" autofocus="autofocus" title="수량입력">
					<div class="bx sel">	<select class="val slt" title="수량선택"><option type="button" value="1">1</option><option type="button" value="2">2</option></select></div><div class="bx num">	<button type="button" class="bt mod">변경</button></div></span>
				<div class="prcs">
				<em class="dispTp00 st" style="display:none">쿠폰적용가</em>
					<span class="prc"><em class="p">19,800</em><i class="w">원</i></span>
				<div class="free">
								2,500원
								<!-- 조건부 무료배송 - 가격-->
										<!-- 주문당적용 -->
											(30,000원 이상 무료배송)
										</div>
						</div>
			</div>
		

	</div>
</div>
</li>

<li>
<div class="untcart " id="untcart163835245642463181">






      <div class="cart_info">
      <label class="checkbox">
	<input type="checkbox"  class="indi_checkbox" checked="checked">
	 </label>
	<input type="hidden" class="indi_prdId"  value="pr_0000017"/>
	<input type="hidden" class="indi_prdCnt"  value="5"/>
	<input type="hidden" class="indi_cartId"  value="ca_0000037"/>

	
	<div class="cart_info">
	  <label class="checkbox">
	<input type="checkbox"  class="indi_checkbox" checked="checked">
	 </label>
	 
	<input type="hidden" class="indi_prdId"  value="p0012"/>
	<input type="hidden" class="indi_prdCnt"  value="1"/>
	<input type="hidden" class="indi_cartId"  value="ca_0000042"/>
	
	</div>
		<script>
					//주문하기 버튼
					$(function(){
						$(".btnOrder").click(function(){
							var form_contents = "";
							var orderNumber = 0;
							
							
							//hidden 동적 추가
							$(".cart_info").each(function(i, element){
								if($(element).find(".indi_checkbox").is(":checked") === true){
								var cartId = $(element).find(".indi_cartId").val(); //카트 아이디
								var prdId= $(element).find(".indi_prdId").val()
								var prdCnt = $(element).find(".indi_prdCnt").val() ; //상품 수량
								/* var prdPrice = $(element).find(".indi_prdPrice").val() ;  // 상품가격 */
								//var prdName =$(element).find(".indi_prdName").val()  //상품명
								
								var cartId_Input  = "<input name='orders["+ orderNumber  +"].cartId' type='hidden' value='" + cartId+"'>"; 
								form_contents += cartId_Input;
							 	var prd_id_Input  = "<input name='orders["+ orderNumber  +"].prdId' type='hidden' value='" + prdId+"'>"; 
								form_contents += prd_id_Input;
								
								var prdCnt_Input  = "<input name='orders["+ orderNumber  +"].prdCnt' type='hidden' value='" +prdCnt+"'>"; 
								form_contents += prdCnt_Input;
								/* var price_Input  = "<input name='orders["+ orderNumber  +"].prdPrice' type='hidden' value='" + prdPrice+"'>"; 
								form_contents += price_Input;  
								var name_Input  = "<input name='orders["+ orderNumber  +"].prdName' type='hidden' value='" + prdName+"'>"; 
								form_contents += name_Input;  */
								
								orderNumber += 1;
								}//end checked
							});//end cart Info
							
							$("#orderFrm").html(form_contents);
							$("#orderFrm").submit();
							
							
						})
						
					})
					</script>
					
	
	
	<span class="txt"></span>

<button type="button" class="bt del" onclick="cartGoods.del('163835245642463181', )" data-content="163835245642463181" data-url="https://aboutpet.co.kr/order/deleteCart">삭제</button>
<div class="box">
	<div class="tops">
		<a href="javascript:;" onclick="fnGoGoodsDetail('GS251054025')" class="pic" data-content="GS251054025" data-url="https://aboutpet.co.kr/goods/indexGoodsDetail?goodsId=GS251054025">
			<img src="https://cdudsyowwnmx6388661.cdn.ntruss.com/aboutPet/images/goods/GS251054025/c97543a3-2c13-4787-ba8f-e5d363025434.jpg?type=f&amp;w=259&amp;h=259&amp;quality=90&amp;align=4" alt="[4개세트] 바른벤토모래 7kg 고양이모래" class="img" onerror="this.src='../../_images/common/img_default_thumbnail_2@2x.png'">
			</a>
		<div class="name">
			<a href="javascript:;" onclick="fnGoGoodsDetail('GS251054025')" class="tit" data-content="GS251054025" data-url="https://aboutpet.co.kr/goods/indexGoodsDetail?goodsId=GS251054025">[4개세트] 바른벤토모래 7kg 고양이모래</a>
			</div>
	</div>
	
	<div class="amount ">
			<span class="uispined st load" data-max="100" data-min="1">
						<input type="number" class="amt" id="buyQty163835245642463181" name="buyQty" value="1" data-cart-id="163835245642463181" data-min-ord-qty="1" data-max-ord-qty="100" autofocus="autofocus" title="수량입력">
					<div class="bx sel">	<select class="val slt" title="수량선택"><option type="button" value="1">1</option><option type="button" value="2">2</option><option type="button" value="3">3</option><option type="button" value="4">4</option><option type="button" value="5">5</option><option type="button" value="6">6</option><option type="button" value="7">7</option><option type="button" value="8">8</option><option type="button" value="9">9</option><option type="button" value="10">+10</option></select></div><div class="bx num">	<button type="button" class="bt mod">변경</button></div></span>
				<div class="prcs">
				<em class="dispTp00 st" style="display:none">쿠폰적용가</em>
					<span class="prc"><em class="p">44,700</em><i class="w">원</i></span>
				<div class="free">
								2,500원
								<!-- 조건부 무료배송 - 가격-->
										<!-- 주문당적용 -->
											(30,000원 이상 무료배송)
										</div>
						</div>
			</div>
		

	</div>
</div>
</li>
</ui>
					
					<div class="totset">
						<div class="ptt">
							<em class="p" id="compTotalGoodsAmt912">64,500</em><i class="w">원</i>
							<i class="e">+</i>
							<b class="t">배송비</b><em class="p" id="compTotalDlvrAmt912">0</em><i class="w">원</i>
							<i class="e q">=</i>
							<em class="prc"><em class="p" id="compTotalAmt912">64,500</em><i class="w">원</i></em>
						</div>
						<div class="gud">장바구니에 담은 상품의 합계금액 입니다.</div>
					</div>
					
					
					</section>
				<input type="hidden" name="dlvrcPlcAmt" data-dlvrc-plc-no="1" data-comp-no="912" data-sale-psb-cd="00" id="dlvrcPlcAmt1" value="0">
			<input type="hidden" name="dlvrcPlcChkAmt" data-dlvrc-plc-no="1" data-comp-no="912" data-sale-psb-cd="00" id="dlvrcPlcChkAmt1" value="0">
			<div class="cartOrdr">
				<div class="ctinr" style="bottom: 6.4px;">
					<div class="odbox">
						<div class="hdt"><span class="tit">결제 금액</span></div>
						<ul class="prcset">
							<li>
								<div class="dt">상품금액</div>
								<div class="dd">
									<span class="prc"><em class="p" id="totalChkGoodsAmt">64,500</em><i class="w">원</i></span>
								</div>
							</li>
					
							<li>
								<div class="dt">배송비</div>
								<div class="dd">
									<span class="prc"><em class="p" id="totalChkDlvrAmt">0</em><i class="w">원</i></span>
								</div>
							</li>
						</ul>
						<div class="tot">
							<div class="dt">최종 결제금액</div>
							<div class="dd">
								<span class="prc"><em class="p" id="totalChkAmt">64,500</em><i class="w">원</i></span>
							</div>
						</div>
			
								
					</div>
				
					<div class="btntot">
						<div class="inr">
							<a href="javascript:void(0);" class="btn lg a btnOrder" data-content=""  data-url="https://aboutpet.co.kr/order/indexOrderPayment">
								<em class="p">총</em> <i class="i" id="goodsOrdCntText">2</i><em class="s">개</em>
								<em class="prc"><i class="i" id="totalChkAmtText">64,500</i><i class="s">원</i></em>
								<em class="p" id="orderBtnText">주문하기</em>
							</a>
						</div>
					</div>
						</form>
		
					
					
					<!-- APET-1628 스탬프 미노출 처리 -->
					</div>
			</div>
		</div>
	</div>
</div>
	</div>
</main>
<!--❤️main-->				
	

<nav class="floatNav">
	<div class="inr">
		<div class="bts">
			<!-- 스토어 전환 버튼 -->
			<div class="float-toggle-store is-cat hide_pc hide_mo">
				<!-- NOTE: 현재 스토어가 강이지인 경우 'is-dog', 고양이인 경우 'is-cat' 클래스 추가 -->
				<div class="inner">
					<button type="button" class="btn-toggle-store btn-dog">
						<span>강아지</span>
					</button>
					<button type="button" class="btn-toggle-store btn-cat">
						<span>고양이</span>
					</button>
				</div>
			</div>
			<!-- // 스토어 전환 버튼 -->
			
			<div class="pd tp">
				<button type="button" class="bt tops">페이지위로</button>
			</div>
			</div>
	</div>
</nav>

		


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
	
				<!-- 주문 form  -->
					<form action="orderPayment_form.do" method="get" id="orderFrm" name="orderFrm">
					
					</form>
</footer>
<!-- // footer -->

<div id ="layers">
</div><!-- e : footer 영역 -->
	</div>
</body>
</html>