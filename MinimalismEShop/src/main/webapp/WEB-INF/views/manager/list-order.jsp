<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- Page Heading -->
<div id="page-wrapper">
	<div class="container-fluid">

		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">
					<small>List Order</small>
				</h1>
				<ol class="breadcrumb">
					<li><i class="fa fa-dashboard"></i> Home</li>
					<li class="active">List Order</li>
				</ol>
			</div>
		</div>

		<!-- content are available here -->
		<div class="row">
			<div class="jumbotron">
				<form class="form-horizontal" role="form"
					action="/example/export/dateOrder" method="post">
					<div class="form-group">
						<div class="col-sm-2">
							<label class="control-label">Select Date</label>
						</div>
						<div class="col-sm-3">
							<input type="date" name="dateOrder"
								class="form-control"/>
						</div>
						<div class="col-sm-1">
							<button type="submit" class="btn btn-info pull-right">View</button>
						</div>
					</div>
				</form>
			</div>
		</div>
		<div class="row" style="min-height: 50vh">
			<div class="col-lg-12">
				<div>
					<form action="/example/export/update" method="post">
						<table class="table table-bordered table-hover">
							<thead>
								<tr>
									<th>STT</th>
									<th>Code Order</th>
									<th>Customer Name</th>
									<th>Date Order</th>
									<th>Amount (USD)</th>
									<th>Status</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${listOrder }" var="order" varStatus="stt">
									<tr>
										<td>${stt.index +1 }</td>
										<td>${order.idOrder }</td>
										<td>${order.customer.fullName }</td>
										<td>${order.orderDate }</td>
										<td>${order.amount }</td>
										<td><input type="checkbox" value="${order.idOrder }"
											id="${order.idOrder }" name="payment"></td>
										<td><a href="/example/export/remove/${order.idOrder }" class="btn btn-sm btn-danger remove-from-orders">Xóa</a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						<div class="row">
							<div class="form-group col-md-12">
								<div class="col-md-3"></div>
								<button type="submit"
									class="btn btn-primary btn-lg col-md-3">UPDATE</button> <a
									href="/example/admin/" class="btn btn-default btn-lg col-md-3">CANCEL</a>
								<div class="col-md-3"></div>
							</div>
						</div>
					</form>
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
					toastr.success("Delete "+response);
				}
			});
			$(this).parents("tr").hide(500).html("");
			return false;
		});

	});
</script>