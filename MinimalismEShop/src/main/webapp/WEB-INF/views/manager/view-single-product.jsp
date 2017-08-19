<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:set value="${groupProduct }" var="p"></c:set>
<!-- Page Heading -->
<div id="page-wrapper">
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-4">
				<div class="product-images">
					<div class="product-main-img">
						<img src="<c:url value='${p.imge }'/>" alt=""
							style="width: 300pt; height: 350pt;">
					</div>


				</div>
			</div>

			<div class="col-sm-6">
				<div class="product-inner">
					<div class="row" style="padding-top: 30pt;">
					
						<div class="col-sm-5">
							<p class="form-row form-row-last validate-required validate-image">
								<label class="" for="">CATEGORY</label>
								<span style="float: right;">${p.category.name }</span>
							</p>
							<p class="form-row form-row-last validate-required validate-image">
								<label class="" for="">PRODUCT</label>
								<span style="float: right;">${p.name }</span>
							</p>
							<p class="form-row form-row-last validate-required validate-image">
								<label class="" for="">PRICE</label>
								<span style="float: right;">${p.price }</span>
							</p>
							<p class="form-row form-row-last validate-required validate-image">
								<label class="" for="">QUANTITY</label>
								<span style="float: right;">${qty }</span>
							</p>
							<p class="form-row form-row-last validate-required validate-image">
								<label class="" for="">DESCRIPTION</label>
								<span style="float: right;">${p.description }</span>
							</p>
							
							<br>
							<br>
							<div class="product-option-shop">
							<spring:url value="/admins/add-product-old/${p.id }" var="edit"></spring:url>
								<a class="add_to_cart_button" data-quantity="1"
									data-product_sku="" data-product_id="70" rel="nofollow"
									href="${edit }" id="${p.id }">Edit</a>									
							</div>
							
						</div>
					</div>

				</div>
			</div>
		</div>

	</div>
</div>
