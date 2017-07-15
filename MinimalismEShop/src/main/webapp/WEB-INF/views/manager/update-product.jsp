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
					<small>EDIT PRODUCT</small>
				</h1>
				<ol class="breadcrumb">
					<li><i class="fa fa-dashboard"></i> HOME</li>
					<li class="active">EDIT PRODUCT</li>
				</ol>
			</div>
		</div>

		<!-- content are available here -->
		<div class="row" style="min-height: 50vh">
			<div class="jumbotron">
				<form:form id="frmThemSP" autocomplete="off" method="POST"
					modelAttribute="product" class="form-horizontal" role="form"
					  action="/example/import/update" enctype="multipart/form-data">
					<div class="form-group">
						<div class="col-sm-2">
							<label class="control-label">Tên Sản Phẩm</label>
						</div>
						<div
							class="col-sm-4  
				<c:if test = "${product_has_error }">
					<c:out value ="has-error"></c:out>
				</c:if> ">
							<form:input path="nameProduct" type="text" class="form-control"
								placeholder="Tên sản phẩm" />
						</div>
						<c:if test="${product_has_error }">
							<div class="col-sm-3">
								<div id="wrongId" class=" alert alert-danger"
									style="padding: 6px 12px">Sản phẩm đã tồn tại</div>
							</div>
						</c:if>
						<div class="col-sm-2">
							<label class="control-label fix-postion-of-label">Region</label>
						</div>
						<div class="col-sm-4">
							<form:input path="region"  type="text" class="form-control"
								placeholder="Vùng xuất xứ" />
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-2">
							<label class="control-label">Size </label>
						</div>
						<div class="col-sm-4">
							<form:input path="size" type="text" class="form-control"
								placeholder="Mô tả" />
						</div>
						<div class="col-sm-2">
							<label class="control-label fix-postion-of-label">Image</label>
						</div>
						<div class="col-sm-4">
							<input type="file" class="form-control"
								placeholder="Hình ảnh" name="file-image" id ="file-image"/>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-2">
							<label class="control-label">Loại Sản Phẩm</label>
						</div>
						<div class="col-sm-4">
							<form:select path="category.idCategory" class="combobox form-control" name="idCategory">

								<c:forEach var="categ" items="${category }">
									<option value="${categ}"
										<c:if test="${categ.idCategory eq product.category.idCategory}">						
										<c:out value = "selected"></c:out>
										</c:if>><c:out value="${categ.categoryName }"></c:out></option>
								</c:forEach>
							</form:select>
						</div>
						<div class="col-sm-2">
							<label class="control-label fix-postion-of-label">Special</label>
						</div>
						<div class="col-sm-4">
							<label class="radio-inline"> <form:radiobutton
									path="special" value="false" selected="seletected" />False
							</label> <label class="radio-inline"> <form:radiobutton
									path="special" value="true" />True
							</label>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-2">
							<label class="control-label">Color</label>
						</div>
						<div class="col-sm-4">
							<form:input path="color" type="text" class="form-control"
								placeholder="Color" />
						</div>
						<div class="col-sm-2">
							<label class="control-label fix-postion-of-label">Age</label>
						</div>
						<div class="col-sm-4">
							<form:input path="age" type="number" class="form-control"
								placeholder="Tuổi(tháng)" />
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-2">
							<label class="control-label">Giá bán</label>
						</div>
						<div class="col-sm-4">
							<form:input path="price" type="number" class="form-control"
								placeholder="Giá bán" />
						</div>
						<div class="col-sm-2">
							<label class="control-label fix-postion-of-label">Latest</label>
						</div>
						<div class="col-sm-4">
							<label class="radio-inline"> <form:radiobutton
									path="latest" value="false" selected="seletected" />False
							</label> <label class="radio-inline"> <form:radiobutton
									path="latest" value="true" />True
							</label>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-2">
							<label class="control-label">Mô tả</label>
						</div>
						<div class="col-sm-10">
							<form:textarea path="description" cols="137" rows="8" />
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="submit" class="btn btn-default btn-success">Thêm</button>
							<button type="submit" class="btn btn-default">Quay lại</button>
						</div>
					</div>
				</form:form>
			</div>
		</div>
	</div>
</div>
<!-- end content -->
<script type='text/javascript'>
	/* attach a submit handler to the form */
	$(document).ready(function() {
		$('.combobox').combobox();
		$("#frmThemSP").on('submit', function(e) {
			var btn = $(this).find("button[type=submit]:focus");
			var id = btn.attr('id');
			if (id == 'btnBack') {
				e.preventDefault();
			}
			
			var $form = $( this );
			$.ajax({
				url:  $form.attr( 'action' ),
				type : 'POST',
				success : function(response) {
					toastr.success(response);
				}
			});
		});
	});
</script>
