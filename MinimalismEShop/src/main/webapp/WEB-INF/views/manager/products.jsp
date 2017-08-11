<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div class="single-product-area">
	<div class="container">
		<div class="row">
			<c:forEach items="${listProduct }" var="p">
				<div class="col-md-3 col-sm-6">
					<div class="product-upper">
						<br> <br> <a
							href="<spring:url value='/product/single/${p.id }'/>"> <img
							src="<c:url value = '${p.imge }'/>" alt=""
							style="width: 200pt; height: 250pt;"></a>
					</div>
					<h2>
						<a href="">${p.name }</a>
					</h2>
					<div class="product-carousel-price">
						<i>${p.price }</i>
					</div>
					
							<div class="product-option-shop">
							<spring:url value="/admins/add-product-old/${p.id }" var="edit"></spring:url>
								<a class="add_to_cart_button addProduct" data-quantity="1"
									data-product_sku="" data-product_id="70" rel="nofollow"
									href="${edit }" id="${p.id }">Edit</a>
							</div>

				</div>

			</c:forEach>
		</div>

	</div>
</div>