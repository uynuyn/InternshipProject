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
		<c:set value="${notification }" var="n" />

		<c:choose>
			<c:when test="${n eq 'delivery' }">
				<script type="text/javascript">
					$(document).ready(function() {
						$("#modalInforDelivery").modal("show");
					});
				</script>
			</c:when>
			<c:when test="${n eq 'ship' }">
				<script type="text/javascript">
					$(document).ready(function() {
						$("#modalInforShip").modal("show");
					});
				</script>
			</c:when>
		</c:choose>
		

		<!-- content are available here -->
		<div class="row">
			<div class="jumbotron">
				<div class="form-group">
					<div class="col-sm-2">
						<label class="control-label">Select Date</label>
					</div>
					<c:choose>
						<c:when test="${delivery eq 'delivery' }">
							<spring:url value="/${delivery }/list-order" var="date"></spring:url>

						</c:when>
						<c:otherwise>
							<spring:url value="/admins/list-order" var="date"></spring:url>

						</c:otherwise>
					</c:choose>
					<form action="${date }">
						<div class="col-sm-3">
							<input type="date" name="dateOrder" class="form-control" />
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
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${listOrder }" var="order" varStatus="stt">
								<c:choose>
									<c:when test="${delivery eq 'delivery' }">
										<spring:url value="/${delivery }/view-product-order/${order.id }" var="o"></spring:url>
									</c:when>
									<c:otherwise>
										<spring:url value="/view-product-order/${order.id }" var="o"></spring:url>
									</c:otherwise>
								</c:choose>

								<tr>
									<td><a href="${o }" style="color: black; font-size: 15pt;">${order.id }</a></td>
									<td><a href="${o }" style="color: black; font-size: 15pt;">${order.user.username }</a></td>
									<td><a href="${o }" style="color: black; font-size: 15pt;">${order.user.firstname }${order.user.lastname }</a></td>
									<td><a href="${o }" style="color: black; font-size: 15pt;"><fmt:formatDate
												value="${order.orderDate }" type="date" /></a></td>

								</tr>
							</c:forEach>
						</tbody>
					</table>

				</div>
			</div>

		</div>

	</div>
</div>

<!-- Modal notification  -->

<div class="modal fade myModal" id="modalInforDelivery" role="dialog">
	<div class="modal-dialog modal-sm" style="width: 500px">
		<div class="modal-content">
			<div class="modal-header">
				<i class="fa fa-hand-paper-o" aria-hidden="true" style="color: red;"></i>
				<h2 class="form-signin-heading">Delivery successful</h2>
			</div>
				
				<div class="modal-footer">
					<button type="button" class="btn btn-lg btn-default"
						data-dismiss="modal">Done</button>
				</div>
		</div>
	</div>
</div>
<div class="modal fade myModal" id="modalInforShip" role="dialog">
	<div class="modal-dialog modal-sm" style="width: 500px">
		<div class="modal-content">
			<div class="modal-header">
				<i class="fa fa-hand-paper-o" aria-hidden="true" style="color: red;"></i>
				<h2 class="form-signin-heading">Transfer successful</h2>
			</div>
				
				<div class="modal-footer">
					<button type="button" class="btn btn-lg btn-default"
						data-dismiss="modal">Done</button>
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