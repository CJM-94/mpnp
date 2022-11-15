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

<link rel="stylesheet" href="http://localhost/mfnf/3rdDesign/common/css/headerFooter.css">
<link rel="stylesheet" type="text/css" href="http://localhost/mfnf/3rdDesign/_css/main.style.pc.css">
<link rel="stylesheet" type="text/css" href="https://vknfvtjnsgec6381690.cdn.ntruss.com/_css/jquery-ui.css">
<link rel="stylesheet" href="http://localhost/mfnf/3rdDesign/css/my.css">
<link rel="stylesheet" href="http://localhost/mfnf/3rdDesign/css/order.css">
<link rel="stylesheet" href="http://localhost/mfnf/3rdDesign/_css/pc\com.css">
<link rel="stylesheet" href="http://localhost/mfnf/3rdDesign/_css/pc\disp.css">
<link rel="stylesheet" href="http://localhost/mfnf/3rdDesign/css/mypage.css">
<link rel="stylesheet" href="http://localhost/mfnf/3rdDesign/css/popupme.css">

<script type="text/javascript" src="https://vknfvtjnsgec6381690.cdn.ntruss.com/_script/errHandler.min.js?v=22102810" userInfo="%7B%22mbrNo%22%3A0%2C%22appName%22%3A%22FRONT%22%2C%22sessionIp%22%3A%22211.244.65.66%22%2C%22appEnv%22%3A%22PRD%22%2C%22sessionId%22%3A%22NjliOTliYTEtMzM2Mi00OWE0LTk4NGQtODNkNDY1NDliOTMx%22%7D" webHookErrWebUrl="https://petsbe.webhook.office.com/webhookb2/6846f755-9900-4b13-8eb6-7c7a01c9abde@2ebad8bd-5697-4302-afcf-7b617ee135ff/IncomingWebhook/287ff9c2be6c4aecba75d0f1f665a86c/89d2885b-4579-4313-be4c-a1c2f9998d81"></script>
<script type="text/javascript"  src="https://vknfvtjnsgec6381690.cdn.ntruss.com/_script/jquery/jquery-3.3.1.min.js" ></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bPopup/0.11.0/jquery.bpopup.js"></script>
<script type="text/javascript"  src="https://vknfvtjnsgec6381690.cdn.ntruss.com/_script/jquery/jquery-ui.min.js"></script>

<script type="text/javascript"  src="http://localhost/mfnf/3rdDesign/_script/popup.js" ></script>
<script type="text/javascript"    src="http://localhost/mfnf/3rdDesign/_script/ui.js"></script>
<script type="text/javascript"    src="http://localhost/mfnf/3rdDesign/_script/ui_shop.js"></script>


  <!--google icons-->
	<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,400,0,0" />
	<!--google fonts-->
	<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap"
	rel="stylesheet">
  <script>  //2022-11-05 팝업창
    $(".prooptions").click(loadDynamic);  

function loadDynamic() {  
   $("#dynamic")  
   .load("https://dl.dropboxusercontent.com/s/6ro896byol223p0/ajax-data.txt?dl=1&token_hash=AAEhOzpJgzb71h8X_olqovBCKz0GF2BCXJogeZ0RIoWXoQ", // URL with only <div> content & dont load <head> or <html> or <body> etc...     
           // Callback function on completion (optional)  
           function (content) {  
               // make content visible with effect  
               $(this).hide().fadeIn("slow");  
               return false;  
           });  
} 
</script>
  <script type="text/javascript">
    let addressListCnt = "2";
    
    $(document).ready(function(){
      
    
      ui.shop.lnb.pos();
      // 배송지 추가
      $("[name=addAddressBtn]").click(function(){
// 					if($(".delist > li").length >= 5){
        // 배송지 5개에서 1개 삭제 후 배송지 추가 시 정상 추가 수정 20210518
        if(addressListCnt >= 5) {
          ui.toast('배송지는 5개까지 등록할 수 있어요');
          return false;
        }
        openAddressAddPop();
      })
      // 배송지 수정
      $("[name=updateAddressBtn]").click(function(){
        openAddressAddPop($(this).data('dlvra-no'));
      });
      // 배송지 삭제
      $("[name=deleteAddressBtn]").click(function(){
        deleteAddress($(this).data('dlvra-no') , $(this).data('gb-nm') , $(this).data('dftyn'));
      });
    });
    
    // 	배송지 추가 / 수정 팝업
    function openAddressAddPop(dlvraNo){
      if($("li[name^=del_]").length < 5 || (dlvraNo != null && dlvraNo != '')){
        var options = {
          url : "/mypage/service/popupAddressEdit"
          , data : {
            mbrDlvraNo : dlvraNo
          }
          , dataType : "html"
          , done : function(html){
            $("#addressAddPop").html(html);
            
            if ($("#addressAddPop #memberAddressForm").length == 0) {
              ui.alert('오류가 발생하였습니다. 관리자에게 문의하시기 바랍니다.');
            } else {
              ui.popLayer.open("addressAddPop");
            }
          }
        }
        ajax.call(options);
      }else {
        ui.toast('배송지는 5개까지 등록할 수 있어요');
        return false;
      }
    }
    // 	배송지 삭제
    function deleteAddress(mbrDlvraNo,gbNm,dftYn){
      if(dftYn == 'Y'){
        ui.alert("기본 배송지를 삭제할 수 없어요<br>기본 배송지를 변경하고 삭제해주세요.");
      }else{
        var msg = "'{gbNm}'배송지를 삭제할까요?";
        msg = msg.replace(/\{gbNm\}/g, gbNm);
        ui.confirm(msg , {
          ycb:function(){
            var options = {
              url : "/mypage/service/deleteAddress"
              , data : {mbrDlvraNo : mbrDlvraNo}
              , done : function(result){
                if(result > 0){
                  $("li[name=del_"+mbrDlvraNo+"]").remove();
                  // 배송지 삭제 시 배송지 카운트 수정 20210518
                  addressListCnt = addressListCnt - 1;
                  
                  ui.toast("배송지가 삭제되었어요")
                }
              }
            }
            ajax.call(options);
          },
          ncb:function(){
          },
          ybt:'예',
          nbt:'아니요'	
        });
      }
    }
    
  </script>





<style type="text/css">
	/* 아이폰 계열에서 저장되는 것 막음 / css 에 추가 */
	img, video {
		/* 화면을 길게 누르고 있을때 뜨는 팝업이나 액션시트를 제어 */
		-webkit-touch-callout:none;
		/* 텍스트나 이미지를 선택할 수 있게 하는 여부를 제어 */
		/*-webkit-user-select:none;*/
		/* 링크를 터치했을때 나오는 기본 영역의 색상을 제어 */
		/*-webkit-tap-highlight-color:transparent;*/
	}
</style>


<!--라이브 앱과 연동을위한 JS -->
<script src="https://sgr.aboutpet.co.kr/web/runInit/v1.js"></script>

</head>

<body class="body">

<!-- 기본 컨텐츠 -->
	<div class="wrap" id="wrap">
		<input type="hidden" id="viewJsonData" value="%7B%22vod_group_list_api_url%22%3A%22https%3A%2F%2Fsgr.aboutpet.co.kr%2Fv1%2Fplaylist%2Flist%3Fchannel_id%3D%22%2C%22vod_group_move_api_url%22%3A%22https%3A%2F%2Fsgr.aboutpet.co.kr%2Fv1%2Fplaylist%2Fmove_vod%2F%22%2C%22vod_group_add_api_url%22%3A%22https%3A%2F%2Fsgr.aboutpet.co.kr%2Fv1%2Fplaylist%2Fadd_item%2F%22%2C%22vod_upload_api_url%22%3A%22https%3A%2F%2Fsgr.aboutpet.co.kr%2Fv1%2Fvod%2Fupload%2F%22%2C%22vod_chnl_list_api_url%22%3A%22https%3A%2F%2Fsgr.aboutpet.co.kr%2Fv1%2Fchannel%2Flist%22%2C%22fo_mois_post_confmKey%22%3A%22U01TX0FVVEgyMDIxMDMzMDEwMzEzMDExMDk4MTk%3D%22%2C%22vod_api_chnl_id_log%22%3A%22aboutpet_log%22%2C%22vod_info_api_url%22%3A%22https%3A%2F%2Fsgr.aboutpet.co.kr%2Fv1%2Fvod%2Fvideo%2Finfo%2F%22%2C%22vod_group_chnl_ord_api_url%22%3Anull%2C%22vod_list_api_url%22%3A%22https%3A%2F%2Fsgr.aboutpet.co.kr%2Fv1%2Fvod%2Fvideo%2F%22%2C%22vod_group_default%22%3A%22unclassified%22%2C%22vod_api_chnl_id_tv%22%3A%22aboutpet_tv%22%7D">
		

<script>
$(function(){

	
})

</script>
<!--팝업창-->

<input class="modal-state" id="modal-1" type="checkbox" />
<div class="modal">
  <label class="modal__bg" for="modal-1"></label>
  <div class="modal__inner">
    <label class="modal__close" for="modal-1"></label>
    <div class="pbd " id="popupAddressEdit">
      <div class="phd">
        <div class="in">
          <h1 class="tit" style="font-size:20rem;font-weight: bold;margin-bottom:20px;">배송지 입력</h1>
        </div>
      </div>
      <div class="pct" style="height: 505.6px;">
        <main class="poptents">
          <form id="memberAddressForm">
            <input type="hidden" name="mbrNo" value="1319879">
            <input type="hidden" name="mbrDlvraNo" value="">
            <input type="hidden" name="goodsRcvPstCd" value="">
            <input type="hidden" name="goodsRcvPstEtc" value="">
            <input type="hidden" name="pblGateEntMtdCd" value="">
            <input type="hidden" name="pblGatePswd" value="">
            <input type="hidden" name="dlvrDemand" value="">
            <input type="hidden" name="dlvrDemandYn" value="N">
          <div class="uidelivsets">
            <ul class="list" id="addressul">
              <li class="name">
                <div class="hdt">배송지 명칭</div>
                <div class="cdt">
                  <div class="input del">
                    <input type="text" name="gbNm" placeholder="배송지 명칭을 입력해주세요" title="배송지" value="">
                  </div>
                </div>
              </li>
              <li class="user">
                <div class="hdt">받는 사람</div>
                <div class="cdt">
                  <div class="input del">
                    <input type="text" name="adrsNm" placeholder="이름을 입력해주세요." title="받는 사람" value="">
                  </div>
                </div>
              </li>
              <li class="phone">
                <div class="hdt">휴대폰번호</div>
                <div class="cdt">
                  <div class="input del">
                    <input type="text" name="mobile" placeholder="-없이 번호만 입력해주세요" title="휴대폰번호" value="">
                  </div>
                  <span id="mobileValidate" style="color:red;display:none">휴대폰번호를 정확히 입력해주세요.</span>
                </div>
              </li>
              <li class="adrs">
                <div class="hdt">주소</div>
                <div class="cdt">
                  <div class="uiadrset">
                    <div class="adrbox a1" id="adrOff">
                      <div class="adr">주소를 검색해주세요.</div>
                      <a href="javascript:;" class="btAdr" data-content="" data-url="">주소검색</a>
                    </div>
                    <div class="adrbox a1" data-selected="false" style="display: none;">
                      <div class="adr on" id="adrOn"></div>
                      <a href="javascript:;" class="btAdr" data-content="" data-url="">주소검색</a>
                    </div>
                    <div class="adrbox a2" data-selected="false" style="display: none;">
                      <input type="hidden" name="roadAddr" value="">
                      <input type="hidden" name="prclAddr" value="">
                      <input type="hidden" name="postNoNew" value="">
                      <input type="hidden" name="prclDtlAddr" value="">
                      <span class="input"><input type="text" name="roadDtlAddr" placeholder="상세주소를 입력하세요." value=""></span>
                    </div>
                  </div>
                </div>
              </li>
              <li class="dreq" data-selected="false" style="display: none;">
                <div class="hdt">배송 요청사항</div>
                <div class="cdt">
                  <div class="uiadrreq">
                    <div class="pwf" id="aftDeliReq" style="display: none;">
                        <em class="t" id="goodsRcvPst">
                          </em>
                        <em class="p" id="pblGateEntMtd">&nbsp; 
                          <if test="false">
                            </if>
                        </em>
                      <div class="txt" id="dlvrDemand"></div>
                      <div class="btt"><a href="#" onclick="memberAddress.dlvrDemandPop();" class="btn sm btMod" data-content="layerAlert" data-url="">변경</a></div>
                    </div>
                    <div class="pss" id="insertDeliReq">
                      <a href="#" onclick="memberAddress.dlvrDemandPop();" class="btn btPdPl" data-content="layerAlert" data-url="">상품 수령 장소를 선택해주세요</a>
                    </div>
                  </div>
                  <div class="saves">
                    <div class="pp"><label class="checkbox"><input type="checkbox" name="dftYn" value="N"><span class="txt"><em class="tt">기본 배송지로 등록</em></span></label></div>
                  </div>
                </div>
              </li>
            </ul>
          </div>
          </form>
          <div class="btnList bot">
            <label class="modal__close2" for="modal-1" style="cursor: pointer;">취소</label>
            <button type="button" id="addBtn" onclick="insertAddress();" class="btn lg a disabled save" data-content="" data-url="insertAddress();" style="	background-color:var(--colors-main03) !important;cursor: pointer;">저장</button>
            </div>
        </main>		
        <div id="dynamic" class="hidden"></div>	
      </div>
    </div>
	<div id="dynamic" class="hidden"></div>
  </div>
</div>
<!--팝업창-->





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




<!--❤️사이드바-->


<div class="layers tv seriesHome" id="gnbSrisListPopup"></div>
<!-- e : gnb 영역 -->			
					<!-- s : LNB 영역 -->

<nav class="lnb shop" id="lnb">
	<div class="inr" style="width:220px;">
		<nav class="menushop"style="margin-right:20px;">
			<h2 class="bt bt_my">MY</h2>
		

			<div class="ctset ctset1 active" data-ui-tab-ctn="tab_my_cate" data-ui-tab-val="tab_my_cate_1" style="width:200px;">
				<ul class="sm">
					<li><a class="bt" href="/mypage/order/indexDeliveryList" data-url="/mypage/order/indexDeliveryList" data-content="0">주문내역</a></li>
					<li><a class="bt" href="/mypage/goodsCommentList" data-url="/mypage/goodsCommentList" data-content="0">상품 후기</a></li>
					<li><a class="bt" href="/mypage/info/indexPswdUpdate" data-content="0" data-url="/mypage/info/indexPswdUpdate" >비밀번호 설정</a></li>
					<li><a class="bt" href="/mypage/info/indexManageCheck" data-content="0" data-url="/mypage/info/indexManageCheck" >회원정보 수정</a></li>
				</ul>
			</div>

			
	</nav>

		<nav class="menushop" style="margin-top:30px;">
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

  </script> -->
	<!--❤️ 버튼 눌렀을 때 팝업-->
	<!--❤️ 테스트-->
	<script>
		
		//수정,삭제 열기
		function addClass(shipID){
			const dmenu = document.querySelectorAll('.dmenu');
			var dmenuArr = new Array();
			for(let i=0;i<dmenu.length;i++){
				
	  	dmenuArr = dmenu[i].className.split(" "); //클래스명 쪼개서 배열에 {uidropmu, dmenu, 1222}
			if(dmenuArr[2] == shipID){
				$('.' + shipID).toggleClass("open");
			
			}
			};//addclass

			//수정팝업창
			function loadDynamic(shipID) {  
		
      $("." + shipID)  
      .load("https://dl.dropboxusercontent.com/s/6ro896byol223p0/ajax-data.txt?dl=1&token_hash=AAEhOzpJgzb71h8X_olqovBCKz0GF2BCXJogeZ0RIoWXoQ", // URL with only <div> content & dont load <head> or <html> or <body> etc...     
              // Callback function on completion (optional)  
              function (content) {  
                  // make content visible with effect  
                  $(this).hide().fadeIn("slow");
                  return false;  
              });  
  }
	
		}

		function updateAddress(){
		alert("수정완료");
	}
		

	</script>
		<!--❤️ 테스트-->

  <main class="container lnb page my" id="container" style="margin-top:100px;margin-left:100px;">
    <div class="inr" style="min-height: 592.047px;">			
      <!-- 본문 -->
      <div class="contents" id="contents" style="min-height: 714px;">
        <!-- PC 타이틀 모바일에서 제거 -->
        <div class="pc-tit">
          <h2>배송지 관리</h2>
          <label class="btn prooptions add_ship" for="modal-1" href="#" style="color: var(--colors-main03)">배송지 추가</label>
        </div>
        <div class="uiDelisel" style="margin-top:80px;">
            <ul class="delist">
              <li class="active" name="del_234869">
                  <div class="box t2">

                    <nav class="uidropmu dmenu 1222">
                      <button type="button" class="bt st menu_bt" onClick="addClass(1222);"  ><span class="material-symbols-outlined">
                        expand_more
                        </span></button>
                      <ul class="menu">
												<li><label class="btn_modify prooptions" onClick="loadDynamic(1322)"for="modal-2" href="#">수정</label></li>
                        <li><button type="button" class="bt" name="deleteAddressBtn" data-dlvra-no="234869" data-gb-nm="집" data-dftyn="Y" data-content="" data-url="/mypage/service/deleteAddress">삭제</button></li>
                      </ul>			

                    </nav>
                    <div class="new_tit_area on" >
                        집<em class="bdg">기본배송지</em>
                      </div>
                    <div class="inf">
                      <div class="adrs">[13477]경기도 성남시 분당구 판교공원로4길 27(판교동) &nbsp; 아파트</div>
                      <div class="usrs">												
                        유설빈
                          / 010-1234-5678</div>
                    </div>
                                      </div>
                                  </li>
                              <li class="" name="del_234898">
                  <div class="box t2">
                    <nav class="uidropmu dmenu 1322">
                      <button type="button" class="bt st menu_bt " onClick="addClass(1322);" ><span class="material-symbols-outlined">
                        expand_more
                        </span></button>
                      <ul class="menu">
                        <li><label class="btn_modify prooptions" onClick="loadDynamic(1322)"for="modal-2" href="#">수정</label></li>
                        <li><button type="button" class="bt" name="deleteAddressBtn" data-dlvra-no="234898" data-gb-nm="학원" data-dftyn="N" data-content="" data-url="/mypage/service/deleteAddress">삭제</button></li>
                      </ul>									
                    </nav>
                    <div class="new_tit_area ">
                        학원</div>
                    <div class="inf">
                      <div class="adrs">[06235]서울특별시 강남구 테헤란로 132(역삼동) &nbsp; 8층</div>
                      <div class="usrs">												
                        강사님
                          / 010-1111-1111</div>
                    </div>
                                      </div>
                                  </li>
                                  <li class="" name="del_234897">
                                    <div class="box t2">
                                      <nav class="uidropmu dmenu 1323">
                                        <button type="button" class="bt st menu_bt 1323" onClick="addClass(1323);" ><span class="material-symbols-outlined">
                                          expand_more
                                          </span></button>
                                        <ul class="menu">
                                          <li><label class="btn_modify prooptions 1323" onClick="loadDynamic(1323)"for="modal-2" href="#">수정</label></li>
                                          <li><button type="button" class="bt" name="deleteAddressBtn" data-dlvra-no="234897" data-gb-nm="회사" data-dftyn="N" data-content="" data-url="/mypage/service/deleteAddress">삭제</button></li>
                                        </ul>									
                                      </nav>
                                      <div class="new_tit_area ">
                                          대표님</div>
                                      <div class="inf">
                                        <div class="adrs">[06235]서울특별시 강남구 테헤란로 132(역삼동) &nbsp; 8층</div>
                                        <div class="usrs">												
                                          강사님
                                            / 010-1111-1111</div>
                                      </div>
                                                        </div>
                                                    </li>
                              </ul>
                      </div>
                  </div>
      </div>
    </main>
<!--❤️main끝-->			

<!--❤️수정팝업창-->
<style>
.modal__inner{
	width:45% !important;
}	
.modify_cancel{
	height: 50px;
    min-width: 50px;
    padding: 24px 20px !important;
    font-size: 15rem;
    font-weight: 700;
		border-color: #ddd;
    background-color: #fff;
    color: #666;
    font-weight: 700;
    color: #000;
		border: 1px solid #dddddd;
    background: #ffffff;
    color: #666666;
    height: 32px;
    overflow: hidden;
    padding: 0 12px;
    display: inline-flex;
    justify-content: center;
    align-items: center;
    vertical-align: middle;
    cursor: pointer;
    white-space: nowrap;
    border-radius: 4px;
    line-height: 1;

}

.btnList.bot {
    text-align: center;
}



</style>


<input class="modal-state" id="modal-2" type="checkbox" />
<div class="modal">
  <label class="modal__bg" for="modal-2"></label>
  <div class="modal__inner">
    <label class="modal__close" for="modal-2"></label>
		<div class="layers">

      <div class="pbd " id="popupAddressEdit">
        <div class="phd">
          <div class="in">
            <h1 class="tit" style="font-size:20rem;font-weight: bold;">배송지 변경</h1>
          </div>
        </div>
        <div class="pct" style="height: 582px;">
          <main class="poptents">
            <form id="memberAddressForm">
              <input type="hidden" name="mbrNo" value="1319879">
              <input type="hidden" name="mbrDlvraNo" value="234869">
              <input type="hidden" name="goodsRcvPstCd" value="10">
              <input type="hidden" name="goodsRcvPstEtc" value="">
              <input type="hidden" name="pblGateEntMtdCd" value="30">
              <input type="hidden" name="pblGatePswd" value="">
              <input type="hidden" name="dlvrDemand" value="집 문앞에 놓아주세요">
              <input type="hidden" name="dlvrDemandYn" value="Y">
            <div class="uidelivsets">
              <ul class="list" id="addressul">
                <li class="name">
                  <div class="hdt">배송지 명칭</div>
                  <div class="cdt">
                    <div class="input del">
                      <input type="text" name="gbNm" placeholder="배송지 명칭을 입력해주세요" title="배송지" value="집">
                    </div>
                  </div>
                </li>
                <li class="user">
                  <div class="hdt">받는 사람</div>
                  <div class="cdt">
                    <div class="input del">
                      <input type="text" name="adrsNm" placeholder="이름을 입력해주세요." title="받는 사람" value="유설빈">
                    </div>
                  </div>
                </li>
                <li class="phone">
                  <div class="hdt">휴대폰번호</div>
                  <div class="cdt">
                    <div class="input del">
                      <input type="text" name="mobile" placeholder="-없이 번호만 입력해주세요" title="휴대폰번호" value="01012345678">
                    </div>
                    <span id="mobileValidate" style="color:red;display:none">휴대폰번호를 정확히 입력해주세요.</span>
                  </div>
                </li>
                <li class="adrs">
                  <div class="hdt">주소</div>
                  <div class="cdt">
                    <div class="uiadrset">
                      <div class="adrbox a1" id="adrOff" style="display: none;">
                        <div class="adr">주소를 검색해주세요.</div>
                        <a href="javascript:;" class="btAdr" data-content="" data-url="">주소검색</a>
                      </div>
                      <div class="adrbox a1" data-selected="false">
                        <div class="adr on" id="adrOn">경기도 성남시 분당구 판교공원로4길 27(판교동)</div>
                        <a href="javascript:;" class="btAdr" data-content="" data-url="">주소검색</a>
                      </div>
                      <div class="adrbox a2" data-selected="false">
                        <input type="hidden" name="roadAddr" value="경기도 성남시 분당구 판교공원로4길 27(판교동)">
                        <input type="hidden" name="prclAddr" value="경기도 성남시 분당구 판교동 553 분당판교청소년수련관, 판교도서관">
                        <input type="hidden" name="postNoNew" value="13477">
                        <input type="hidden" name="prclDtlAddr" value="아파트">
                        <span class="input"><input type="text" name="roadDtlAddr" placeholder="상세주소를 입력하세요." value="아파트"></span>
                      </div>
                    </div>
                  </div>
                </li>
                <li class="dreq" data-selected="false">
              
                    <div class="saves">
                      <div class="pp"><label class="checkbox"><input type="checkbox" name="dftYn" value="Y" checked=""><span class="txt"><em class="tt">기본 배송지로 등록</em></span></label></div>
                    </div>
                  </div>
                </li>
              </ul>
            </div>
            </form>
            <div class="btnList bot">
							<label class="modify_cancel" for="modal-2" >취소</label>
							
              <button type="button" id="addBtn" onclick="updateAddress();" class="btn lg a">
							
								저장
							
							</button>
              </div>
          </main>			
        </div>
      </div>

		</div>
	<div id="dynamic" class="hidden  1222"></div>
  </div>
</div>



<!--수정팝업창-->


	

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