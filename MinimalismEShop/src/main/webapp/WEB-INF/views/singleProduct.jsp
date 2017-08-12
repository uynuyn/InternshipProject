<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
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
					<form action="">
						<input type="text" placeholder="Search products..."> <input
							type="submit" value="Search">
					</form>
				</div>

				<div class="single-sidebar">
					<h2 class="sidebar-title">Products</h2>
					<div class="thubmnail-recent">
						<img src="<c:url value='${p.imge }'/>" class="recent-thumb" alt="">
						<h2>
							<a href="">${p.name }</a>
						</h2>
						<div class="product-sidebar-price">
							<i>${p.price }</i>
						</div>
					</div>
				</div>

				<div class="single-sidebar">
					<h2 class="sidebar-title">Recent Searches</h2>
					<c:forEach items="${seen }" var="s">
					<div class="thubmnail-recent">
						<img src="<c:url value='${s.imge }'/>" class="recent-thumb" alt="">
						<h2>
							<a href="">${s.name }</a>
						</h2>
						<div class="product-sidebar-price">
							<i>${s.price }</i>
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
											<img src="<c:url value='${p.imge }'/>" alt="">
										</div>

										<!-- <div class="product-gallery">
                                        <img src="img/product-thumb-1.jpg" alt="">
                                        <img src="img/product-thumb-2.jpg" alt="">
                                        <img src="img/product-thumb-3.jpg" alt="">
                                        <img src="img/product-thumb-4.jpg" alt="">
                                    </div> -->
									</div>
								</div>

								<div class="col-sm-6">
									<div class="product-inner">
										<h2 class="product-name">${p.name }</h2>
										<div class="product-inner-price">
											<i>${p.price }</i>
										</div>

										<form action="" class="cart">
											<div class="quantity">
												<input type="number" size="4" class="input-text qty text"
													title="Qty" value="1" name="quantity" min="1" step="1">
											</div>
											<button class="add_to_cart_button" type="submit">Add
												to cart</button>
										</form>

										<div class="product-inner-category">
											<p>
												Category: <a href="">Ba lô</a>. Tags: <a href="">awesome</a>,
												<a href="">best</a>, <a href="">sale</a>, <a href="">shoes</a>.
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
										<img src="<c:url value ='${r.imge }'/>" alt="">
										<div class="product-hover">
											<a href="" class="add-to-cart-link"><i
												class="fa fa-shopping-cart"></i> Add to cart</a> <a href=""
												class="view-details-link"><i class="fa fa-link"></i> See
												details</a>
										</div>
									</div>

									<h2>
										<a href="">${r.name } ${i.index }</a>
									</h2>

									<div class="product-carousel-price">
										<i>${r.price }</i>
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
