<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:set value="${breadcrumb }" var="b" />
<div class="product-big-title-area">
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="product-bit-title">
					<div class="product-breadcroumb">
						<a href="">Home</a>
						<spring:url value="/products/list/${b.department.code }"
							var="departmentUrl" />
						<a href="${departmentUrl }">${b.department.name }</a>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<div class="container">
	<div class="row">
		<c:forEach items="${listCategory }" var="c">
			<div class="col-md-12">
				<div class="latest-product">
				<br>
				<spring:url value="/products/list/${c.department.code }/${c.code }" var="productUrl" />
					<a class="section-title" href="${productUrl }" style="text-decoration: none;">${c.name }</a>
					<div class="product-carousel">
						<c:forEach items="${c.groupProducts }" var="p">
							<div class="single-product">
								<div class="product-f-image">
									<img src="<c:url value = '${p.imge }'/>" alt="" style="width:200pt;height:230pt;">
									<div class="product-hover">
									<c:choose>
										<c:when test="${p.endProduct }">
											<a href="#" class="add-to-cart-link addProduct" id="${p.id }">
												<i class="fa fa-shopping-cart"></i> Add to cart</a>
										</c:when>
										<c:otherwise>
											<a href="#" class="add-to-cart-link" id="${p.id }">
												<i class="fa fa-times"></i> Sorry</a>
										</c:otherwise>
									</c:choose>
										<a href="<spring:url value='/product/single/${p.id }'/>" class="view-details-link">
										<i class="fa fa-link"></i> See details</a>
									</div>
								</div>

								<h2>
									<a href="<spring:url value='/product/single/${p.id }'/>">${p.name }</a>
								</h2>

								<div class="product-carousel-price">
									<i><fmt:formatNumber value="${p.price }" type="currency" minFractionDigits="0" /></i>
								</div>
							</div>
						</c:forEach>
					</div>
					<br>
				</div>
			</div>
		</c:forEach>
	</div>
</div>
    <div class="modal fade myModal" id="modalInfor" role="dialog">
		<div class="modal-dialog modal-sm" style="width: 500px">
			<div class="modal-content">
				<div class="modal-header">
						<i class="fa fa-hand-paper-o" aria-hidden="true" style="color: red;"></i>
						<h2 class="form-signin-heading"><i class="fa fa-shopping-cart" style="color: red"></i>MinimalismShop<i class="fa fa-shopping-cart" style="color: red"></i></h2>
				</div>
				<form action="">
				<div class="modal-body" >
				    <spring:url value="/cart" var="cart"></spring:url>
					<h3><a href="${cart }">Go to cart</a></h3>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-lg btn-default" data-dismiss="modal">Cancel</button>
				</div>
				</form>
			</div>
		</div>
	</div>
<script>
$(document).ready(function(){
    $(".addProduct").click(function(event){
		var id = $(this).attr('id');
		event.preventDefault();
    	$.ajax({
			url : "/shop/cart/addCart/"+ id +"/"+1,
			contentType : "application/json",
			type : 'POST',
			dataType : 'json',
			timeout : 100000,
			success : function(response) {
				console.log($("#add-cart").text());
				$("#add-cart").html(Number(response));
				$("#modalInfor").modal("show");
			}
		});
    });
});
</script>