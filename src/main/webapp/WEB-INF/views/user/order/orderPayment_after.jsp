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
	<script type="text/javascript">
		$(function(){
			$(".btnBill").click(function(){
				
				check();
			})//end click
		})//end ready

	
		 function check(){
		// addPrd();
		
			
			//var shipReq=$("#shipReq").val();
			if($("#shipReq").val().length ==0 ){
				alert("배송요청사항을 입력해주세요.");
				
			  $("#shipReq").focus();
				return ;
			}//addr2
			
			if($("#shipReq").val().length < 5 || $("#shipReq").val().length >50  ){
				alert("요청사항은 최소 5자 이상 50자 이하 입력가능합니다");
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
	    	   product_submit();
				$("#orderFrm").submit();
				
			}//confirm
			
			//submitPrdArry();
		
				
			}//check
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
					  var rate_price = Math.ceil(sum * rate);
					  
					
					  //총 결제금액 구하기
					  var deli_fee =0;
					  
					   var actual_price;
					  if(sum < 30001){//sum이 (구매한 상품금액이 30000원 이하인 경우)
						  deli_fee = 2500;
					  } //end if
				
					  actual_price =( sum - rate_price) +deli_fee ; 
					//  alert("actual_price" + actual_price);
					 // alert("sum" + sum);
					 
					  
					  //숫자에 단위 넣기
					  const rate_ = rate_price.toString()
                      .replace(expression, ","); //할인금액
					  const total_pri = actual_price.toString()
                      .replace(expression, ","); //상품 총가격
					  const cn1 = sum.toString()
                      .replace(expression, ","); // 총 결제금액
					  const ship_fee = deli_fee.toString()
                      .replace(expression, ","); // 배송비
                     
					  $(".totalProductPrice").html(cn1); //상품 총 금액
					  $("#order_payment_total_dc_amt_view").html(rate_); //할인금액
					  $("#order_payment_total_dlvr_amt_view").html(ship_fee);//배송비
					  $("#order_payment_total_pay_amt_view").html(total_pri);//총 결제금액
					  $("#order_payment_end_pay_amt_view").html(total_pri);//총 결제금액
					  
					 $('#actualPrice').attr("value",actual_price);
					 $('#discountPrice').attr("value",rate_price);
					 $('#totalPrice').attr("value",sum);
					 
					  })//reay
					</script>
					<script>
					//전화번호 하이픈
					const autoHyphen2 = (target) => {
						 target.value = target.value
						   .replace(/[^0-9]/g, '')
						  .replace(/^(\d{0,3})(\d{0,4})(\d{0,4})$/g, "$1-$2-$3").replace(/(\-{1,2})$/g, "");
						}
					
					//기본배송지 값 설정(안됨..)
				  $(function(){
					  if(document.getElementById("defaultFlag").checked) {
						    document.getElementById("input_check_hidden").disabled = true;
						}
					  
				  })
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

		         <!-- 상품 hidden -->
         <c:forEach  items="${opvo}" var="op">
         <div class="prd_hid">
		 <input type="hidden" class="indi_prdId"  id="prdId" name="prdId" value="${op.prdId}">			
		 <input type="hidden" class="indi_prdName" id="prdName" name="prdName"  value="${op.prdName}">			
		 <input type="hidden" class="indi_prdPrice" id="prdPrice" name="prdPrice"   value="${op.prdPrice}">			
		 <input type="hidden" class="indi_prdCnt" id="prdCnt" name="prdCnt"  value="${op.prdCnt}">	
		 <input type="hidden" class="indi_cartId"  id="cartId" name="cartId"   value="${op.cartId}">	
         </div>
		</c:forEach>
         <!--  -->
         <form id="test" name="test" action="orderPayment_process.do" method="post">
         
         </form>
	
	<script type="text/javascript">
	
	
		 function product_submit(){
		
			var form_contents = "";
			var orderNumber = 0;
			
			
			//hidden 동적 추가
			$(".prd_hid").each(function(i, element){
			
				var cartId = $(element).find(".indi_cartId").val(); //카트 아이디
				var prdId= $(element).find(".indi_prdId").val()
				var prdCnt = $(element).find(".indi_prdCnt").val() ; //상품 수량
				var prdPrice = $(element).find(".indi_prdPrice").val() ;  // 상품가격 
				var prdName =$(element).find(".indi_prdName").val()  //상품명
				
				var cartId_Input  = "<input name='orders["+ orderNumber  +"].cartId' type='hidden' value='" + cartId+"'>"; 
				form_contents += cartId_Input;
			 	var prd_id_Input  = "<input name='orders["+ orderNumber  +"].prdId' type='hidden' value='" + prdId+"'>"; 
				form_contents += prd_id_Input;
				var prdCnt_Input  = "<input name='orders["+ orderNumber  +"].prdCnt' type='hidden' value='" +prdCnt+"'>"; 
				form_contents += prdCnt_Input;
				var price_Input  = "<input name='orders["+ orderNumber  +"].prdPrice' type='hidden' value='" + prdPrice+"'>"; 
				form_contents += price_Input;  
				var name_Input  = "<input name='orders["+ orderNumber  +"].prdName' type='hidden' value='" + prdName+"'>"; 
				form_contents += name_Input;  
				
				orderNumber += 1;
			
			});//end cart Info
			
			$("#productArea").html(form_contents);
			
			}//end function
			

	</script>
	

	<div class="inr" style="min-height: 357px;">



	<!-- 주문정보 넘기기 -->
		<form action="http://localhost/mpnp/orderPayment_process.do" id="orderFrm" name="orderFrm" method="post">
		<input type="hidden" name="memberName" id="memberName" value="${orDom.memberName}">
            <input type="hidden" name="phone" id="phone" value="${orDom.phone}"> 
            
            <div id="productArea">
        
        
        </div>
                    


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
									<span>${orDom.memberName}</span>
								</div>
								<div class="ptt" style="margin-top: 10px"><b class="t">${orDom.phone}</b></div>
							</div>
							<div class="usr" id="memDiv" style="display:none;"><em class="nm" id="memDiv-mbrNm">,</em><i class="tel" id="memDiv-mobile">${orDom.phone}</i></div>
							<!-- <div class="bts"><a href="/mypage/info/indexManageDetail" class="btn c sm btMyMod">개인정보수정</a></div> -->
							
							<input type="hidden" id="memberYn" value="N">
						</div>
					</div>
				</section>
	<section class="sect addr">
									<div class="hdts"><span class="tit">배송지</span></div>
									<div class="cdts">
										<div class="adrset">
											
											<div class="name tx">
												<em class="t" id="dlvraGbNmEm">${osDom.shipName}</em><em class="bdg" id="dftDelivery">기본배송지</em>
											</div>
 											<script type="text/javascript">
 											 $(function(){
 												 $("#desid").change(function(){
 													 if($("#desid").val() != "none"){
 													setChangeAddr();
 												 }//end if
 												 });//change
 												 
 											 })//ready
 											
											  function setChangeAddr(){
 												var data ={
 														desid :$("#desid").val()
 													
 												}
 												 console.log(data) 
 												 
 												 
												 $.ajax({
													 url:"order_ship_addr.do",
													 data: "desid="+$("#desid").val(),
													 dataType:"json",
													 error:function(xhr){
														 alert("배송지 조회 중 문제가 발생하였습니다");
														 console.log("에러코드" + xhr.status + "뭐지" + xhr.state() + "흐음" + xhr.statusText);
													 },
													 success:function(jsonObj){
														 
														 if(jsonObj.resultFlag){
															  alert("배송지가 변경되었습니다.");
															  var addrName = document.getElementById("dlvraGbNmEm");
															  var addr = document.getElementById("changeAddr");
															   if($("#zipcode").val() != jsonObj.zipcode){
															  $("#dftDelivery").html("일반배송지");
															   }else{
																   $("#dftDelivery").html("기본배송지");
															   }
															  addrName.innerHTML = jsonObj.shipname;
															  addr.innerHTML = "["+jsonObj.zipcode+"] " + "" + jsonObj.addr +" " + jsonObj.addrDetail;
															 $("#desId").val( jsonObj.desID);
														 }
														 }//end if
												 })
											 }
											</script>  
											<input type="hidden" id="desId" name="desId" value="${osDom.desid}"/>
											<input type="hidden" id="zipcode" name="zipcode" value="${osDom.zipcode}"/>
											
											<div class="adrs" id="changeAddr" name="changeAddr">
												[${osDom.zipcode}] ${osDom.addr}, ${osDom.addrDetail}
												</div>
											
											<!-- <div class="bts"><a href="javascript:;" onclick="orderDlvra.addressListPop();" data-content="layerAlert" data-url="/order/popupAddressList" class="btn c sm btnDeMod">배송지 변경</a></div> -->
											<div class="bts">
												<select style="padding:10px;color: #666666;border:1px soid #666;border-radius:3px;" name="desid" id="desid">
												<option value="none">배송지변경</option>
												<c:forEach items='${list}' var="dname" >
												 <option value="${dname.desid}">${dname.shipName}
												 </option>
												 </c:forEach>
												</select>
											</div>
										</div>
											<div class="adrreq">
									<div class="tit">배송 요청사항</div>
									<div class="pwf" id="existDemand" style="display: none">
										<em class="t" id="demandGoodsRcvPstCd"></em>
										<em class="p" id="demandPblGateEntMtdCd"></em>
										<div class="txt" id="demandDlvrDemand"></div>
										<div class="btt"><a href="javascript:;" class="btn sm btMod" onclick="orderDlvra.changeDlvrDemandPop();">변경</a></div>
									</div>
									<div class="pss" id="noExistDemand">
										<textarea name="shipReq" id="shipReq" cols="91" rows="5" placeholder="요청사항을 입력해주세요." style="border-radius: 3px;border: 1px solid #dddddd;padding:10px 10px;"></textarea>

									</div>
								</div>
									</div>
								</section>
					<input type="hidden" id="preBookYn" value="N">
				

				
				
					
		
				<section class="sect deli">
					<div class="hdts"><span class="tit">상품정보</span></div>
					<ul class="lst"> 
					
							<c:forEach  items="${opvo}" var="op">
								<li style="margin:10px 0px;">
											<div class="tt" style="font-weight:bold">👀 ${op.prdName} </div>
											<div class="ts totalPrice_info" style="margin-left:25px;">
												[${op.prdCnt}개 * ${op.prdPrice}원 = 총 ${op.totalPrice}원]
												<input type="hidden" id="totalP" name="totalP" value="${op.totalPrice}"/>
												
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
								<input type="hidden" id="discount_rate"" value="${orDom.discountRate}"/>
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
								
									<div data-ui-tab-ctn="tab_bils" data-ui-tab-val="tab_bils_6"></div>
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
										<span class="prc"><em class="p totalProductPrice">99,000</em><i class="w">원</i></span>
										<input type="hidden" id="totalPrice"  name="totalPrice"value="">
										
									</div>
								</li>
								<li id="couponDcLi">
									<div class="dt">등급할인</div>
									<div class="dd">
										<span class="prc dis"><em class="p" id="order_payment_total_dc_amt_view">-5,000</em><i class="w">원</i></span>
										<input type="hidden" id="discountPrice" name="discountPrice" value="">
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
									<input type="hidden" id="actualPrice" name="actualPrice" value="">
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