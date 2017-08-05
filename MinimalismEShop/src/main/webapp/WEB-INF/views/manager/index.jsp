<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<div id="wrapper">
	<c:set value="${sessionScope.users }" var="u"></c:set>
	<div id="page-wrapper">
		<div id="page-inner">
			<div class="row">
				<div class="col-md-9">
					<h2>Admin Dashboard</h2>
					<h5>Welcome ${u.username } , Love to see you back.</h5>
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
							
								<p class="main-text"><a href="${listOrder }">${numberOrder } Orders</a></p>
								<p class="text-muted">Pending</p>
						</div>


					</div>
				</div>
			</div>
			<!-- /. ROW  -->
			<hr />
			<div class="row">
				<div class="col-md-3 col-sm-6 col-xs-6">
					<div class="panel panel-back noti-box">
						<span class="icon-box bg-color-red set-icon"> <i
							class="fa fa-envelope-o"></i>
						</span>
						<div class="text-box">
							<p class="main-text">120 New</p>
							<p class="text-muted">Messages</p>
						</div>
					</div>
				</div>
				<div class="col-md-3 col-sm-6 col-xs-6">
					<div class="panel panel-back noti-box">
						<span class="icon-box bg-color-green set-icon"> <i
							class="fa fa-bars"></i>
						</span>
						<div class="text-box">
							<p class="main-text">30 Tasks</p>
							<p class="text-muted">Remaining</p>
						</div>
					</div>
				</div>


			</div>
			<!-- /. ROW  -->

			<!-- /. PAGE INNER  -->
		</div>
		<!-- /. PAGE WRAPPER  -->
	</div>
</div>