<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:if test='${thanhcong eq false && not empty users}'>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#modalInforLogin").modal("show");
		});
	</script>
</c:if>
<c:set value="${sessionScope.users }" var="u"></c:set>
<div class="slider-area">
	<div id="slide-list" class="carousel carousel-fade slide"
		data-ride="carousel">

		<div class="slide-bulletz">
			<div class="container">
				<div class="row">
					<div class="col-md-12">
						<ol class="carousel-indicators slide-indicators">
							<li data-target="#slide-list" data-slide-to="0" class="active"></li>
							<li data-target="#slide-list" data-slide-to="1"></li>
						</ol>
					</div>
				</div>
			</div>
		</div>

		<div class="carousel-inner" role="listbox">
			<div class="item active">
				<div class="single-slide">
					<div class="slide-bg slide-one"></div>
					<div class="slide-text-wrapper"></div>
				</div>
			</div>
			<div class="item">
				<div class="single-slide">
					<div class="slide-bg slide-two"></div>
					<div class="slide-text-wrapper"></div>
				</div>
			</div>

		</div>

	</div>
</div>
<!-- End slider area -->
<div
	style="padding: 2px 0 3px; background: none repeat scroll 0 0 #1abc9c;">

</div>
<!-- End promo area -->


<div class="maincontent-area">
	<div class="container">
		<c:choose>
			<c:when test="${u ne null || not empty u }">
				<!--  start Recommendations for You -->
				<div class="row" style="margin-top: 100px;">
					<div class="col-md-12">
						<div class="latest-product">
							<h2 class="section-title">Recommendations for You</h2>
							<div class="product-carousel">
								<c:forEach items="${kMeanProducts }" var="p">
									<div class="single-product">
										<div class="product-f-image">
											<img src="<c:url value = '${p.imge }'/>" alt=""
												style="width: 200pt; height: 220pt;">
											<div class="product-hover">
												<a href="#" class="add-to-cart-link" id="${p.id }"><i
													class="fa fa-shopping-cart"></i> Add to cart </a> <a
													href="<spring:url value='/product/single/${p.id }'/>"
													class="view-details-link"><i class="fa fa-link"></i>
													See details</a>
											</div>
										</div>

										<h2>
											<a href="<spring:url value='/product/single/${p.id }'/>">${p.name }</a>
										</h2>

										<div class="product-carousel-price">
											<i><fmt:formatNumber value="${p.price }" type="currency"
													minFractionDigits="0" /></i>
										</div>
									</div>
								</c:forEach>
							</div>
						</div>
					</div>
				</div>
			</c:when>
			<c:otherwise>
				<div class="row" style="margin-top: 100px;">
					<div class="col-md-12">
						<div class="latest-product">
							<h2 class="section-title">We Have Recommendations for You</h2>
							<div class="col-md-3"></div>
							<div class="col-md-6">
								<a style="background-color: #1abc9c; width: 100%;" href='<spring:url value="/login" />' class="btn btn-lg btn-success">Sign in</a>
							</div>
						</div>
					</div>
				</div>
			</c:otherwise>
		</c:choose>
		<!-- End  Recommendations for You -->
		<div class="row" style="margin-top: 100px;">
			<div class="col-md-12">
				<div class="latest-product">
					<h2 class="section-title">Latest Products</h2>
					<div class="product-carousel">
						<c:forEach items="${products }" var="p">
							<div class="single-product">
								<div class="product-f-image">
									<img src="<c:url value = '${p.imge }'/>" alt=""
										style="width: 200pt; height: 220pt;">
									<div class="product-hover">
										<a href="#" class="add-to-cart-link" id="${p.id }"><i
											class="fa fa-shopping-cart"></i> Add to cart </a> <a
											href="<spring:url value='/product/single/${p.id }'/>"
											class="view-details-link"><i class="fa fa-link"></i> See
											details</a>
									</div>
								</div>

								<h2>
									<a href="<spring:url value='/product/single/${p.id }'/>">${p.name }</a>
								</h2>

								<div class="product-carousel-price">
									<i><fmt:formatNumber value="${p.price }" type="currency"
											minFractionDigits="0" /></i>
								</div>
							</div>
						</c:forEach>
					</div>
				</div>
			</div>
		</div>

	</div>
</div>
<!-- End main content area -->
<div class="promo-area">
	<div class="container">
		<div class="row">
			<div class="col-md-3 col-sm-6">
				<div class="single-promo">
					<i class="fa fa-refresh"></i>
					<p>30 Days return</p>
				</div>
			</div>
			<div class="col-md-3 col-sm-6">
				<div class="single-promo">
					<i class="fa fa-truck"></i>
					<p>Free shipping</p>
				</div>
			</div>
			<div class="col-md-3 col-sm-6">
				<div class="single-promo">
					<i class="fa fa-lock"></i>
					<p>Secure payments</p>
				</div>
			</div>
			<div class="col-md-3 col-sm-6">
				<div class="single-promo">
					<i class="fa fa-gift"></i>
					<p>New products</p>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- End promo area -->
<div class="brands-area">
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="brand-wrapper">
					<h2 class="section-title">Brands</h2>
					<div class="brand-list">
						<img src="/shop/resources/img/services_logo__1.jpg" alt="">
						<img src="/shop/resources/img/services_logo__2.jpg" alt="">
						<img src="/shop/resources/img/services_logo__3.jpg" alt="">
						<img src="/shop/resources/img/services_logo__4.jpg" alt="">
						<img src="/shop/resources/img/services_logo__1.jpg" alt="">
						<img src="/shop/resources/img/services_logo__2.jpg" alt="">
						<img src="/shop/resources/img/services_logo__3.jpg" alt="">
						<img src="/shop/resources/img/services_logo__4.jpg" alt="">
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- End brands area -->


<div class="modal fade myModal" id="modalInfor" role="dialog">
	<div class="modal-dialog modal-sm" style="width: 500px">
		<div class="modal-content">
			<div class="modal-header">
				<i class="fa fa-hand-paper-o" aria-hidden="true" style="color: red;"></i>
				<h2 class="form-signin-heading">
					<i class="fa fa-shopping-cart" style="color: red"></i>MinimalismShop<i
						class="fa fa-shopping-cart" style="color: red"></i>
				</h2>
			</div>
			<form action="">
				<div class="modal-body">
					<spring:url value="/cart" var="cart"></spring:url>
					<h3>
						<a href="${cart }">Go to cart</a>
					</h3>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-lg btn-default"
						data-dismiss="modal">Continue Shopping</button>
				</div>
			</form>
		</div>
	</div>
</div>
<div class="modal fade myModal" id="modalInforLogin" role="dialog">
	<div class="modal-dialog modal-sm" style="width: 500px">
		<div class="modal-content">
			<div class="modal-header">
				<i class="fa fa-hand-paper-o" aria-hidden="true" style="color: red;"></i>
				<h2 class="form-signin-heading">Sign Up Success</h2>
			</div>
			<form action="">
				<div class="modal-body">
					<h2 class="form-signin-heading">You are logged into the system</h2>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-lg btn-default"
						data-dismiss="modal">Verification</button>
				</div>
			</form>
		</div>
	</div>
</div>
<script>
	$(document).ready(function() {
		$(".add-to-cart-link").click(function(event) {
			var id = $(this).attr('id');
			event.preventDefault();
			$.ajax({
				url : "/shop/cart/addCart/" + id + "/" + 1,
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




