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
			<form action="/example/import/bill" method="POST" autocomplete="off"
				 class="form-horizontal" role="form">
				<div class="row">
					<div class="form-group col-md-3">
						<label for="staff">Employee Name</label> <input
							value="${sessionScope.staff.fullName }" type="text"
							class="form-control" readonly="readonly" />
					</div>
					<div class="form-group col-md-3">
						<label for="orderDate">Import Date</label>
						<input type="text" class="form-control"  value='<fmt:formatDate value="${today}" pattern="dd-MM-yyyy"/>' readonly="readonly"/>
					</div>
					<div class="form-group col-md-4">
						<label for="deliveryDate">Supplier</label>
						<select class="combobox form-control st" id="suppl"
							name="suppl" required>
							<option value="none">Select Supplier</option>
							<c:forEach var="supp" items="${supplier }">
								<option value="${supp.idSupplier }"
									<c:if test="${supp eq warehouse.supplier}">						
									<c:out value = "selected"></c:out>
								</c:if>><c:out
										value="${supp.nameSupplier }"></c:out></option>
							</c:forEach>
						</select>
					</div>

					<div class="form-group col-md-2">
						<label for="deliveryDate" style="visibility: hidden;">Add
							ImportDetails</label> <a class="btn btn-primary" id="btn-add">Add
							Import Details</a>
					</div>
				</div>

				<div class="import-detail">
					<!-- content of import detail -->
				</div>
				
				<div class="row">
					<div class="form-group col-md-6"></div>
					<div class="form-group col-md-3"></div>
					<div class="form-group col-md-3">
							<label class="control-label">Total Bill:</label>
							<input class="form-control col-md-2" name="total-bill" type="number" readonly="readonly" id="total-bill" value="0">	
					</div>				
				</div>
				
				<div class="row">
					<div class="form-group col-md-12">
						<div class="col-md-3"></div>
						<button type="submit"
							class="btn btn-primary btn-lg col-md-3 fix-position-btn " id="btn_order">ORDER</button>
						<a href="/example/admin/"
							class="btn btn-default btn-lg col-md-3 fix-position-btn ">CANCEL</a>
						<div class="col-md-3"></div>
					</div>
				</div>
			</form>
		</div>	
	</div>
</div>
<!--  end content -->
<script>
	function changePrice(id) {
		
		var unitPrice = document.getElementById('pd'+id).value;
		var quantity = document.getElementById('qty'+id).value;
		
		var totalPriceItem = unitPrice * quantity;
		var idInput = 'total' + id;
		document.getElementById(idInput).value = Number(totalPriceItem);
		
		var totalBill = Number(document.getElementById("total-bill").value);
		totalBill = Number(totalBill + totalPriceItem);
		document.getElementById("total-bill").value = Number(totalBill);
	};

	function myFunction(idElement) {
		var totalPrice = Number(document.getElementById('total' + idElement).value);
		var totalBill = Number(document.getElementById("total-bill").value);
		document.getElementById("total-bill").value = Number(totalBill - totalPrice);
		
		var myNode = document.getElementById(idElement);
		myNode.innerHTML = '';
	};
	
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
					+'<label for="">Unit Price</label>' 
					+'<input class="form-control" name="unitPrice" type="number" required  id="pd'+count+'" onkeyup="changePrice('+count+')"/></div>'
					+'<div class="form-group col-md-2"><label for="">Quantity</label>'
					+'<input name="quantity" type="number" class="form-control" min="0" required  id="qty'+count+'" onkeyup="changePrice('+count+')"/></div>'
					+'<div class="form-group col-md-2"><label for="">Total</label>'
					+'<input name="amount" type="number" class="form-control" readonly="readonly"  id="total'+count+'" value="0"/></div>'
					+'<div class="form-group col-md-1"><label for="abc" style="visibility: hidden;">Remove</label> '
					+'<a class="form-control btn btn-danger" onclick="myFunction('+count+')">Remove</a></div></div>';
			$("div.import-detail").append(str);
			count++;
			
		});
		
	});

</script>