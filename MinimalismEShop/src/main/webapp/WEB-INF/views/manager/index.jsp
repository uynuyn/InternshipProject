<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div id="wrapper">
	<c:set value="${sessionScope.users }" var="u"></c:set>
	<div id="page-wrapper">
		<div id="page-inner">
			<div class="row">
				<div class="col-md-6">
					<h2>Admin Dashboard</h2>
					<h5>Welcome ${u.username } , Love to see you back.</h5>
				</div>
				<div class="col-md-3">
					<div class="panel panel-back noti-box">
						<spring:url value="/delivery/list-order" var="listPackage"></spring:url>
						<a href="${listPackage }"> <span
							class="icon-box bg-color-red set-icon"> <i
								class="fa fa-bell-o"></i>
						</span>
						</a>
						<div class="text-box">
							<p class="main-text">
								<a href="${listPackage }">${numberPackage } Package</a>
							</p>
							<p class="text-muted">Delivery</p>
						</div>
					</div>
				</div>
				<div class="col-md-3">
					<div class="panel panel-back noti-box">
						<spring:url value="/admins/list-order" var="listOrder"></spring:url>
						<a href="${listOrder }"> <span
							class="icon-box bg-color-brown set-icon"> <i
								class="fa fa-bell-o"></i>
						</span>
						</a>
						<div class="text-box">

							<p class="main-text">
								<a href="${listOrder }">${numberOrder } Orders</a>
							</p>
							<p class="text-muted">Staff</p>
						</div>


					</div>
				</div>
			</div>
			<!-- /. ROW  -->
			<hr />

		<div class="container">
		
			<div class="row">
				<c:forEach items="${listCategory }" var="c">
					<div class="col-md-12">
						<div class="latest-product">
							<br>
							<spring:url
								value="/admins/view-product/${c.department.code }/${c.code }"
								var="productUrl" />
							<a class="section-title" href="${productUrl }"
								style="text-decoration: none;">${c.name }</a>
							<br>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
		<!-- /. ROW  -->

		<!-- /. PAGE INNER  -->
	</div>
	<!-- /. PAGE WRAPPER  -->
</div>

</div>	
