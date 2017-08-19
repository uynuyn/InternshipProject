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
					<small style="color: #FF8080">INPUT PRODUCT</small>
				</h1>
			</div>
		</div>

		<!-- content are available here -->
		<spring:url value="/admins/add-product" var="add"></spring:url>

		<form:form action="${add }" class="checkout" method="POST" name=""
			modelAttribute="addproductForm" enctype="multipart/form-data">
			<div class="row" id="customer_details">
				<div class="col-lg-6">
					<div class="woocommerce-billing-fields">
						<spring:bind path="idCategory">
							<p id="billing_category_field"
								class="form-row form-row-last validate-required">
								<label class="" for="billing_category">Category </label>
								<form:select path="idCategory">
									<c:forEach items="${listCategory }" var="c">
										<form:option value="${c.id }">${c.department.name} - ${c.name }</form:option>
									</c:forEach>
								</form:select>

								<form:errors path="idCategory" class="control-label" />
							</p>
						</spring:bind>

						<spring:bind path="name">
							<div class="form-group ${status.error ? 'has-error' : ''}">
								<p id="billing_name_field"
									class="form-row form-row-first validate-required validate-name">
									<label class="" for="billing_name">Name product </label>
									<form:input path="name" type="text" value="" placeholder=""
										id="billing_name" name="billing_name" class="input-text " />
									<form:errors path="name" class="control-label" />
								</p>
							</div>
						</spring:bind>

						<spring:bind path="image">
							<div class="form-group ${status.error ? 'has-error' : ''}">
								<p id="billing_image_field"
									class="form-row form-row-last validate-required validate-image">
									<label class="" for="billing_image">Image </label>
									<form:input path="image" type="file" value="" placeholder=""
										id="billing_phone" name="billing_phone" class="input-text " />
									<form:errors path="image" class="control-label" />
								</p>
							</div>
						</spring:bind>

						
					</div>
				</div>
				<div class="col-lg-6">
					<div class="woocommerce-billing-fields">
						<spring:bind path="price">
							<div class="form-group ${status.error ? 'has-error' : ''}">
								<p id="billing_price_field"
									class="form-row form-row-first validate-required">
									<label class="" for="billing_price">Price </label>
									<form:input path="price" type="number" value="0" placeholder=""
										id="billing_price" name="billing_price" class="input-text "
										min="0" />
									<form:errors path="price" class="control-label" />
								</p>
							</div>
						</spring:bind>
						<spring:bind path="qty">
							<div class="form-group ${status.error ? 'has-error' : ''}">
								<p id="billing_qty_field"
									class="form-row form-row-last validate-required">
									<label class="" for="billing_last_name">Quantity </label>
									<form:input path="qty" type="number" value="1" placeholder=""
										id="billing_qty" name="billing_qty" class="input-text "
										min="1" />
									<form:errors path="qty" class="control-label" />
								</p>
							</div>
						</spring:bind>
						<spring:bind path="size">
							<p id="billing_size_field"
								class="form-row form-row-last validate-required validate-size">
								<label class="" for="billing_size">Size </label>
								<form:select path="size">
									<form:option value="0">No thing</form:option>
									<form:option value="1">Small</form:option>
									<form:option value="2">Medium</form:option>
									<form:option value="3">Large</form:option>
								</form:select>
								<form:errors path="size" class="control-label" />
							</p>
						</spring:bind>
						<%-- <spring:bind path="isSpecial">
							<div class="form-group ${status.error ? 'has-error' : ''}">
								<p id="billing_isSpecial_field"
									class="form-row form-row-wide address-field validate-required">
									<label class="" for="billing_address_1">Special </label> <label
										class="radio-inline"> <form:radiobutton
											path="isSpecial" value="false" selected="seletected" />False
									</label> <label class="radio-inline"> <form:radiobutton
											path="isSpecial" value="true" />True
									</label>
									<form:errors path="isSpecial" class="control-label" />
								</p>
							</div>
						</spring:bind>
						<spring:bind path="isLastest">
							<div class="form-group ${status.error ? 'has-error' : ''}">
								<p id="billing_isLastest_field"
									class="form-row form-row-wide address-field validate-required"
									data-o_class="form-row form-row-wide address-field validate-required">
									<label class="" for="billing_isLastest">Lastest </label> <label
										class="radio-inline"> <form:radiobutton
											path="isLastest" value="false" selected="seletected" />Old
									</label> <label class="radio-inline"> <form:radiobutton
											path="isLastest" value="true" />New
									</label>
									<form:errors path="isLastest" class="control-label" />
								</p>
							</div>
						</spring:bind> --%>

					</div>
				</div>
				<div class="col-lg-12">
					<spring:bind path="description">
						<div class="form-group ${status.error ? 'has-error' : ''}">
							<p id="billing_description_field"
								class="form-row form-row-wide address-field validate-required"
								data-o_class="form-row form-row-wide address-field validate-required">
								<label class="" for="billing_description">Description </label>
								<form:input path="description" type="text" value=""
									placeholder="" id="billing_description"
									name="billing_description" class="input-text " />
								<form:errors path="description" class="control-label" />
							</p>
						</div>
					</spring:bind>
				</div>
				<div class="col-lg-12">
					<br> <br> <br>

					<div class="row">
						<div class="col-lg-9"></div>
						<div class="col-lg-3">

							<input type="submit" data-value="SAVE" value="SAVE"
								id="place_order" name="woocommerce_checkout_place_order"
								class="button alt"
								style="width: 100%; height: 45pt; font-size: 20pt">

						</div>

					</div>
				</div>

			</div>
		</form:form>
	</div>
</div>

<!-- end content -->
