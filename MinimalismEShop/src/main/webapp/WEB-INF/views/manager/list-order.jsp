<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!-- Page Heading -->
<div id="page-wrapper">
	<div class="container-fluid">

		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">
					<small>List Order</small>
				</h1>
			</div>
		</div>

		<!-- content are available here -->
		<div class="row">
			<div class="jumbotron">
				<div class="form-group">
					<div class="col-sm-2">
						<label class="control-label">Select Date</label>
					</div>
					<spring:url value="/admins/list-order" var="date"></spring:url>
					<form action="${date }">
						<div class="col-sm-3">
							<input type="date" name="dateOrder" class="form-control"/>
						</div>
						<div class="col-sm-1">
							<button type="submit" class="btn btn-info pull-right">View</button>
						</div>
					</form>
				</div>
			</div>
		</div>
		<div class="row" style="min-height: 50vh">
			<div class="col-lg-12">
				<div>
					<table class="table table-bordered table-hover">
						<thead>
							<tr>
								<th>STT</th>
								<th>Code Order</th>
								<th>Customer Name</th>
								<th>Date Order</th>
								<th>Amount (USD)</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${listOrder }" var="order" varStatus="stt">
								<tr>
									<td>${stt.index +1 }</td>
									<td>${order.user.username }</td>
									<td>${order.user.firstname }${order.user.lastname }</td>
									<td><fmt:formatDate value="${order.orderDate }"
											type="date" /></td>
									<td>${order.amount }</td>

								</tr>
							</c:forEach>
						</tbody>
					</table>
					<div class="row">
						<div class="form-group col-md-12">
							<div class="col-md-3"></div>
							<button type="submit" class="btn btn-primary btn-lg col-md-3">UPDATE</button>
							<a href="/example/admin/" class="btn btn-default btn-lg col-md-3">CANCEL</a>
							<div class="col-md-3"></div>
						</div>
					</div>
				</div>
			</div>

		</div>

	</div>
</div>
<!-- end content -->
<script>
	$(document).ready(function() {

		$("input.datepicker").datepicker();
		$(".remove-from-orders").click(function() {
			href = $(this).attr("href");
			console.log(href);
			$.ajax({
				url : href,
				dataType : "json",
				success : function(response) {
					toastr.success("Delete " + response);
				}
			});
			$(this).parents("tr").hide(500).html("");
			return false;
		});

	});
</script>