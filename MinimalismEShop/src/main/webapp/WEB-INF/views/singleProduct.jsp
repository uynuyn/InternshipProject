<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:set value="${groupProduct }" var="p" />

<div class="product-big-title-area">
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="product-bit-title">
					<div class="product-breadcroumb">
						<a href="">Home</a>
						<spring:url value="/products/list/${p.category.department.code }"
							var="departmentUrl" />
						<a href="${departmentUrl }">${p.category.department.name }</a>
						<spring:url
							value="/products/list/${p.category.department.code }/${p.category.code }"
							var="productUrl" />
						<a href="${productUrl }">${p.category.name }</a> <a href="">${p.name }</a>
					</div>

				</div>
			</div>
		</div>
	</div>
</div>

<div class="single-product-area">
	<div class="zigzag-bottom"></div>
	<div class="container">
		<div class="row">
			<div class="col-md-4">
				<div class="single-sidebar">
					<h2 class="sidebar-title">Search Products</h2>
					<spring:url value="/products/list/search" var="search"></spring:url>
					<form action="${search }" >
					
						<input name="keyword" type="text" placeholder="Search products..."/>
					
						<input type="submit" value="Search">
					</form>
				</div>

				<div class="single-sidebar">
					<h2 class="sidebar-title">Products</h2>
					<div class="thubmnail-recent">
						<img src="<c:url value='${p.imge }'/>" class="recent-thumb" alt="" style="width:40pt;height:50pt;">
						<h2>
							<span>${p.name }</span>
						</h2>
						<div class="product-sidebar-price">
							<i><fmt:formatNumber value="${p.price }" type="currency" minFractionDigits="0" /></i>
						</div>
					</div>
				</div>

				<div class="single-sidebar">
					<h2 class="sidebar-title">Recent Searches</h2>
					<c:forEach items="${sessionScope.seen }" var="s">
						<div class="thubmnail-recent">
							<img src="<c:url value='${s.imge }'/>" class="recent-thumb"
								alt="" style="width:40pt;height:50pt;">
							<h2>
								<a href="<spring:url value='/product/single/${s.id }'/>">${s.name }</a>
							</h2>
							<div class="product-sidebar-price">
								<i><fmt:formatNumber value="${s.price }" type="currency" minFractionDigits="0" /></i>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>


			<div class="col-md-8">
				<div class="product-content-right">
					<c:choose>
						<c:when test="${p!=null }">

							<div class="row">
								<div class="col-sm-6">
									<div class="product-images">
										<div class="product-main-img">
											<img src="<c:url value='${p.imge }'/>" alt="" style="width: 300pt; height: 350pt;">
										</div>

										
									</div>
								</div>

								<div class="col-sm-6">
									<div class="product-inner">
										<h2 class="product-name">${p.name }</h2>
										<div class="product-inner-price">
											<i><fmt:formatNumber value="${p.price }" type="currency" minFractionDigits="0" /></i>
										</div>

										<form action="" class="cart">
										<c:choose>
											<c:when test="${p.endProduct }">
											<div class="quantity">
												<input type="number" size="4" class="input-text qty text"
													title="Qty" value="1" name="quantity" min="1" step="1" disabled="disabled">
											</div>
											
											<button class="add_to_cart_button addProduct" type="submit" id="${p.id }">Add
												to cart</button>
											</c:when>
											<c:otherwise>
												<button class="add_to_cart_button" type="button">Out of stock</button>
											</c:otherwise>
										</c:choose>
											
										</form>

										<div class="product-inner-category">
											<p>
												Category: <a href="${productUrl }">${p.category.name }</a>. 
												Tags: <a href="${search }?keyword=${p.code }">${p.name }</a>.
											</p>
										</div>

										<div role="tabpanel">
											<ul class="product-tab" role="tablist">
												<li role="presentation" class="active"><a href="#home"
													aria-controls="home" role="tab" data-toggle="tab">Description</a></li>
												<li role="presentation"><a href="#profile"
													aria-controls="profile" role="tab" data-toggle="tab">Reviews</a></li>
											</ul>
											<div class="tab-content">
												<div role="tabpanel" class="tab-pane fade in active"
													id="home">
													<h2>Product Description</h2>
													<p>${p.description }</p>
												</div>
												<div role="tabpanel" class="tab-pane fade" id="profile">
													<h2>Reviews</h2>
													<div class="submit-review">
														<p>
															<label for="name">Name</label> <input name="name"
																type="text">
														</p>
														<p>
															<label for="email">Email</label> <input name="email"
																type="email">
														</p>
														<div class="rating-chooser">
															<p>Your rating</p>

															<div class="rating-wrap-post">
																<i class="fa fa-star"></i> <i class="fa fa-star"></i> <i
																	class="fa fa-star"></i> <i class="fa fa-star"></i> <i
																	class="fa fa-star"></i>
															</div>
														</div>
														<p>
															<label for="review">Your review</label>
															<textarea name="review" id="" cols="30" rows="10"></textarea>
														</p>
														<p>
															<input type="submit" value="Submit">
														</p>
													</div>
												</div>
											</div>
										</div>

									</div>
								</div>
							</div>
						</c:when>
					</c:choose>

					<div class="related-products-wrapper">
						<h2 class="related-products-title">Related Products</h2>
						<div class="related-products-carousel">
							<c:forEach items="${relatedProduct }" var="r" varStatus="i">
								<div class="single-product">
									<div class="product-f-image">
										<img src="<c:url value ='${r.imge }'/>" alt=""
											style="width: 200pt; height: 250pt;">
										<div class="product-hover">
											<a href="" class="add-to-cart-link"><i
												class="fa fa-shopping-cart"></i> Add to cart</a> 
												<a
												href="<spring:url value='/product/single/${r.id }'/>"
												class="view-details-link"><i class="fa fa-link"></i> See
												details</a>
										</div>
									</div>

									<h2>
										<a href="">${r.name } ${i.index }</a>
									</h2>

									<div class="product-carousel-price">
										<i><fmt:formatNumber value="${r.price }" type="currency" minFractionDigits="0" /></i>
									</div>
								</div>
							</c:forEach>
						</div>
					</div>
				</div>
			</div>
		</div>
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
					<button type="button" class="btn btn-lg btn-default" data-dismiss="modal">Continue shopping</button>
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