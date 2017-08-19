<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<!-- Page Heading -->
<div id="page-wrapper">
	<div class="container-fluid">
		<c:set value="${order }" var="o"></c:set>
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">
					<small style="color: #FF8080">DELIVERY ${o.id }</small>
				</h1>
			</div>
		</div>

		<!-- content are available here -->
		<spring:url value="/delivery/shipping/${o.id }" var="add"></spring:url>

		<form action="${add }" class="" method="POST" name="">
			<div class="row" id="customer_details">
				<div class="col-lg-6">
					<div class="woocommerce-billing-fields">
						<div class="row">
							<div class="col-lg-6">
								<div class="woocommerce-billing-fields">
									<p id="billing_customername_field"
										class="form-row form-row-last validate-required">
										<label class="" for="billing_customername">Custommer
											name </label> <input type="text" value="${o.name }" placeholder=""
											id="billing_customername" name="billing_name"
											class="input-text " disabled="disabled" />
									</p>
								</div>
							</div>
							<div class="col-lg-6">
								<div class="woocommerce-billing-fields">
									<p id="billing_customername_field"
										class="form-row form-row-last validate-required">
										<label class="" for="billing_customername">Phone</label> <input
											type="text" value="${o.phone }" placeholder=""
											id="billing_customername" name="billing_name"
											class="input-text " disabled="disabled" />
									</p>
								</div>
							</div>
						</div>
						<p id="billing_name_field"
							class="form-row form-row-first validate-required validate-name">
							<label class="" for="billing_name">Customer Address </label> <input
								type="text" value="${o.address }" placeholder=""
								id="billing_customeraddress" name="customeraddress"
								class="input-text " disabled="disabled" />
						</p>



					</div>
				</div>
				<div class="col-lg-6">
					<div class="woocommerce-billing-fields">

						<p id="billing_image_field"
							class="form-row form-row-last validate-required validate-image">
							<label class="" for="billing_image">Order Date</label> <input
								type="text"
								value="<fmt:formatDate type = 'date' value = '${o.date}' />"
								placeholder="" id="billing_orderdate" name="date"
								class="input-text " disabled="disabled" />
						</p>

						<p id="billing_qty_field"
							class="form-row form-row-last validate-required">
							<label class="" for="billing_last_name">Subtotal </label> <input
								type="text" value="${o.subtotal }" placeholder=""
								id="billing_customeraddress" name="customeraddress"
								class="input-text " disabled="disabled" />
							<form:errors path="qty" class="control-label" />
						</p>

					</div>
				</div>
				<div class="col-lg-12">
					<p id="billing_price_field"
						class="form-row form-row-first validate-required">
						<label class="" for="billing_price">List product </label>
					<table class="shop_table cart">
						<thead>
							<tr>
								<th class="product-name">Product</th>
								<th class="product-name">Category</th>
								<th class="product-quantity">Quantity</th>
								<th class="product-subtotal">Total</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${o.lstProduct }" var="p" varStatus="i">
								<tr class="cart_item">
									<td class="product-thumbnail"><a target="_blank" href="#">${p.name }</a></td>
									<td class="product-name"><a target="_blank" href="#">${p.category }</a></td>

									<td class="product-quantity"><a target="_blank" href="#">${p.quantity }</a></td>

									<td class="product-subtotal"><span class="amount"><fmt:formatNumber
												value="${p.price }" type="currency" minFractionDigits="0" /></span></td>
								</tr>
							</c:forEach>

						</tbody>
					</table>

				</div>

				<div class="col-lg-12">
					<br> <br> <br>

					<div class="row">
						<div class="col-lg-9"></div>
						<div class="col-lg-3">
							<input type="submit" data-value="Delivery" value="Delivery"
								id="place_order" name="woocommerce_checkout_place_order"
								class="button alt"
								style="width: 100%; height: 45pt; font-size: 20pt">

						</div>

					</div>
				</div>

			</div>
		</form>
	</div>
</div>

<!-- end content -->
