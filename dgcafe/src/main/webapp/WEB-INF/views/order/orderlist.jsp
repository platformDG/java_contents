<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문하기</title>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/default.css'/>">
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/order.css'/>">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
	<c:set var="baseURL" value="${fn:replace(req.requestURL, fn:substring(req.requestURI, 0, fn:length(req.requestURI)), req.contextPath)}" />
	<c:set var="path" value="${requestScope['javax.servlet.forward.servlet_path']}" />
	<div class="wrap">
		<div class="cate-wrap">
			<a href="<c:url value='all'/>" class="category all">전체</a>
			<c:forEach var="li" items="${category}">
				<a href="<c:url value='${li.cid}'/>" class="category ${li.cid}">${li.categoryName}</a>
			</c:forEach>
		</div>
		<div class="items-wrap">
			<div class="items-inner-wrap">
				<c:forEach var="li" items="${menuitem}">
					<div class="items">
						<a onclick="javascript:sendPost('<c:url value='${baseURL}${path}'/>', ${li.mid} );"class="a-item">
							<p>
								<img src="<c:url value='/resources/image/${li.imageName}'/>" style="width: 180px; height: 180px;" />
							</p>
							<p class="text">${li.menuName}</p>
							<p class="text"><fmt:formatNumber value="${li.menuPrice}" pattern="#,###"/>원</p>
						</a>
					</div>
				</c:forEach>
			</div>
			<div class="items-side-wrap">
				<div class="side inner-a">
					<div class="order-inner-wrap">
						<div class="menuname">
							<span>메뉴이름</span>
						</div>
						<div class="menuamount">
							<span>수량</span>
						</div>
						<div class="menudelete">
							<span>비고</span>
						</div>
					</div>
					<c:forEach var="li" items="${cart}">
						<div class="order-inner-wrap">
							<div class="menuname">
								<span>${li.menuItem.menuName}</span>
							</div>
							<div class="menuamount">
								<input class="a-btn" type=button value="-" onclick="location.href='<c:url value="${baseURL}${path}/minus/${li.menuItem.menuName}"/>'" >
								<span>${li.amount}</span>
								<input class="a-btn" type=button value="+" onclick="location.href='<c:url value="${baseURL}${path}/plus/${li.menuItem.menuName}"/>'" >
							</div>
							<div class="menudelete">
								<span> <a href="<c:url value='${baseURL}${path}/delete/${li.menuItem.menuName}'/>" class="a-item">삭제</a>
								</span>
							</div>
						</div>
					</c:forEach>
				</div>
				<div class="side inner-b">
					<div class="b-btn">
					<p class="text">주문 총 금액 : <fmt:formatNumber value="${cartprice}" pattern="#,###"/> 원</p>
					</div>
					<div class="c-btn">
						<a href="<c:url value='${baseURL}${path}/success'/>">계산</a>
					</div>
					<div class="c-btn">
						<a href="<c:url value='${baseURL}${path}/cancel'/>">취소</a>
					</div>
				</div>
        <c:if test="${not empty orderList}">
            <div class="modal">
                <p class="text">주문완료</p>
                <p class="text">${orderList.orderName}</p>
                <p class="text"><fmt:formatNumber value="${orderList.orderPrice}" pattern="#,###"/> 원</p>
                <p class="text">또 뵙겠습니다!</p>
                <input type="submit" class="in-btn" value="닫기" onclick="location.href='<c:url value="${baseURL}${path}"/>'">
            </div>
          </c:if>
			</div>
		</div>
</body>
<script>
   function sendPost(url, param) {
     var form = document.createElement('form');
     form.setAttribute('method', 'post');
     form.setAttribute('action', url);
     document.charset = "UTF-8";

     var hiddenField = document.createElement('input');
     hiddenField.setAttribute('type', 'hidden');
     hiddenField.setAttribute('name', "mid");
     hiddenField.setAttribute('value', param);
     form.appendChild(hiddenField);

     document.body.appendChild(form);
     form.submit();
   }

   $(".category").each(function(){
	  if($(this).hasClass("${fn:substring(path,17,fn:length(path))}")){
		  $(this).addClass("on");
	  }else{
		  $(this).removeClass("on");
	  }
   });
   
</script>
</html>
