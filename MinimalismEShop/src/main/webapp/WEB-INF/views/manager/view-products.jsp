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
					<small>List Products</small>
				</h1>
				<ol class="breadcrumb">
					<li><i class="fa fa-dashboard"></i> Home</li>
					<li class="active">List Products</li>
				</ol>
			</div>
		</div>

		<!-- content are available here -->
		<div class="row">
			<div class="jumbotron">
				<form class="form-horizontal" role="form">
					<div class="form-group">
						<div class="col-sm-2">
							<label class="control-label">Select Category</label>
						</div>
						<div class="col-sm-3">
							<select class="combobox form-control" name="idCateg">
								<option value="none">Chọn Loại Sản Phẩm</option>
								<c:forEach var="categ" items="${category }">
									<option value="${categ.idCategory }"
										<c:if test="${categ eq categorySelected}">							
									<c:out value = "selected"></c:out>
							</c:if>><c:out
											value="${categ.categoryName }"></c:out></option>
								</c:forEach>
							</select>
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
					<table class="table table-bordered table-hover">
						<thead>
							<tr>
								<th>STT</th>
								<th>Code Product</th>
								<th>Product Name</th>
								<th>Size</th>
								<th>Color</th>
								<th>Age</th>
								<th>price</th>
								<th>Description</th>
								<th>Region</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${product }" var="product" varStatus="stt">
								<tr>
									<td>${stt.index +1 }</td>
									<td>${product.idProduct }</td>
									<td>${product.nameProduct }</td>
									<td>${product.size }</td>
									<td>${product.color }</td>
									<!-- <td><c:if test="${product.latest eq '1' }">
											<c:out value="1"></c:out>
										</c:if> <c:if test="${product.latest eq '0' }">
											<c:out value="0"></c:out>
										</c:if></td> -->
									<td>${product.age }</td>
									<td>${product.price }</td>
									<td>${product.region }</td>
									<td>${product.description }</td>
									<td><a
										href="/example/import/update/${product.idProduct }"
										class="btn btn-sm btn-info">Sửa</a> <a href="#"
										class="btn btn-sm btn-danger">Xóa</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>

		</div>

	</div>
</div>
<!-- end content -->
<script>
$(document).ready(function() {
	$('.combobox').combobox();
});
</script>