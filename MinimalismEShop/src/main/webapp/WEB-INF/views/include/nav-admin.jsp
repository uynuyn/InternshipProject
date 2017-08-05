<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<div id="wrapper">
	<nav class="navbar navbar-default navbar-cls-top " role="navigation"
		style="margin-bottom: 0">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".sidebar-collapse">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<spring:url value="/home" var="home"></spring:url>
				<a class="navbar-brand" href="${home }">MinimalismShop</a>
		</div>
		<div
			style="color: white; padding: 15px 50px 5px 50px; float: right; font-size: 16px;">
			Today : <span id="date"></span> &nbsp; 
			<spring:url value="/logout" var="logout"/>
			<a href="${logout }"
				class="btn btn-danger square-btn-adjust">Logout</a>
		</div>
	</nav>
</div>
<script>
var d = new Date();
document.getElementById("date").innerHTML = d.toDateString();
</script>