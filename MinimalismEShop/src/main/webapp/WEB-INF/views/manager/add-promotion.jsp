<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.Date" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<style>
.img-prod {
	height: 50px;
	width: 50px;
	box-shadow: 0 0 4px green;
}

.fix-position-btn {
	margin-right: 5px;
}
</style>
<c:set var="today" value="<%=new Date() %>"></c:set>
<div id="page-wrapper">
	<div class="container-fluid">

		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">
					<small>Import Store</small>
				</h1>
				<ol class="breadcrumb">
					<li><i class="fa fa-dashboard"></i> Home</li>
					<li class="active">Import Store</li>
				</ol>
			</div>
		</div>

		<div class="container">
			${message}
			<form:form action="/example/promotion/add" method="POST" autocomplete="off"
				 class="form-horizontal" role="form" modelAttribute="promotion">
				<div class="row">
					<div class="form-group col-md-3">
						<label for="staff">Name Promotion</label> <form:input
							path="note" type="text"
							class="form-control" required="required" />
					</div>
					<div class="form-group col-md-3">
						<label for="orderDate">Start Date</label>
						<form:input type="date" class="form-control " path="startDate" name="start_date"  required="required"/>
					</div>
					<div class="form-group col-md-3">
						<label for="orderDate">Expired Date</label>
						<form:input type="date" class="form-control " path="expiredDate" name="expired_date" required="required"/>
					</div>

					<div class="form-group col-md-2">
						<label for="deliveryDate" style="visibility: hidden;">Add
							PromotionDetails</label> <a class="btn btn-primary" id="btn-add">Add
							Promotion Details</a>
					</div>
				</div>

				<div class="promotion_detail">
					<!-- content of import detail -->
				</div>
				<div class="row">
					<div class="form-group col-md-12">
						<div class="col-md-3"></div>
						<button type="submit"
							class="btn btn-primary btn-lg col-md-3 fix-position-btn ">ADD</button>
						<a href="/example/admin/"
							class="btn btn-default btn-lg col-md-3 fix-position-btn ">CANCEL</a>
						<div class="col-md-3"></div>
					</div>
				</div>
			</form:form>
		</div>	
	</div>
</div>
<!--  end content -->
<script>
	
	$(document).ready(function() {
		$("input.datepicker").datepicker();
		var count = 0;

		$("#btn-add").click(function() {
			var str = '<div class="row" id="' + count + '">'
					+'<div class="form-group col-md-3">'
					+'<label for="deliveryDate">Product Name</label>'
					+'<select class="combobox form-control" name="product" id="product" required>'
					+'<option value="none">Select Product</option><c:forEach var="prod" items="${products }">'
					+'<option value="${prod.idProduct }"'
					+'<c:if test="${prod.nameProduct}"><c:out value = "selected">'
					+'</c:out></c:if>><c:out value="${prod.nameProduct }">'
					+'</c:out></option></c:forEach></select>'
					+'</div><div class="form-group col-md-2">'
					+'<label for="">Discount</label> <input  class="form-control" name="discount" type="number" placeholder=" >= 0% and <= 60%" required/></div>'
					+'<div class="form-group col-md-2"><label for="">Gift</label>'
					+'<input name="gift" type="text" class="form-control"/></div>'
					+'<div class="form-group col-md-1"><label for="abc" style="visibility: hidden;">Remove</label> '
					+'<a class="form-control btn btn-danger" onclick="myFunction('+count+')">Remove</a></div></div>';
			$("div.promotion_detail").append(str);
			count++;
		});
		function myFunction(idElement) {
			var myNode = document.getElementById(idElement);
			myNode.innerHTML = '';
		};
	});

</script>