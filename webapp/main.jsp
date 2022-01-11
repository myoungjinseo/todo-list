<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="main.css">
</head>
<body>
	<section id="section-style">
		<header>
			<h1 id="mainTitle">나의해야할 할일들</h1>
		</header>
		<div id="add" onclick="location.href='todoForm.jsp'">새로운
			TODO 등록</div>
		<section id="outBox">
			<c:forEach var="type" items="${todoTypes}">	
				<section id="${type}">
					<div class="listHeader">${type}</div>
					<c:forEach var="list" items="${todoList}">
						<c:if test="${list.type eq type}">
							<div class="item">
								<h1 class="item-header">${list.title}</h1>
								<div class="item-content">등록날짜:${list.regDate},
									${list.name}, 우선순위 ${list.sequence}</div>
								<c:if test="${list.type ne 'DONE'}">
									<button class="change"
										onclick="changeButtonClick(${list.id}, this)">→</button>
								</c:if>
							</div>
						</c:if>
					</c:forEach>
				</section>
			</c:forEach>
			<div style="clear: both; height: 170px"></div>
		</section>
	</section>
	<script src="main.js" type ="text/javascript" ></script>
</body>
</html>
