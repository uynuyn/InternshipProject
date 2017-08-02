<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
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
										<a href="#" class="view-details-link">
										<i class="fa fa-link"></i> See details</a>
									</div>
								</div>

								<h2>
									<a href="<spring:url value='/product/single/${p.id }'/>">${p.name }</a>
								</h2>

								<div class="product-carousel-price">
									<i>${p.price }</i>
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
<script>
$(document).ready(function(){
    $(".addProduct").click(function(event){
		var id = $(this).attr('id');
		alert(id);
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
			}
		});
    });
});
</script>