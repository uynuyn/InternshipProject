<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="product-big-title-area">
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="product-bit-title text-center">
					<h2>Check out</h2>
				</div>
			</div>
		</div>
	</div>
</div>
<c:set value="${sessionScope.users }" var="u"></c:set>
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
					<c:forEach items="${cart }" var="c">
					<div class="thubmnail-recent">
                            <img src="<c:url value='${c.value.imgPath }'/>" class="recent-thumb" alt="" style="width:40pt;height:50pt;">
                            <h2><a href="#">${c.value.name }</a></h2>
                            <div class="product-sidebar-price">
                                <i>Quantity: ${c.value.quantity }-</i> <strong> Price: <fmt:formatNumber
														value="${c.value.price }" type="currency" minFractionDigits="0"/></strong>
                            </div>                             
                        </div>
                        </c:forEach>
				</div>

				
			</div>

			<div class="col-md-8">
				<div class="product-content-right">
					<div class="woocommerce">
					
						<spring:url value="/checkout" var="checkout"></spring:url>
						<form:form action="${checkout }" class="checkout" method="POST"
							name="checkout" modelAttribute="checkoutForm">

							<div id="customer_details" class="col2-set">
								<div class="col-1">
									<div class="woocommerce-billing-fields">
										<h3>Billing Details</h3>
										<spring:bind path="username">
											<div class="form-group ${status.error ? 'has-error' : ''}">
												<p id="billing_username_field"
													class="form-row form-row-last validate-required">
													<label class="" for="billing_username">Username <abbr
														title="required" class="required">*</abbr>
													</label>
													<form:input path="username" disabled="disabled" type="text"
														value="${u.username }" placeholder=""
														id="billing_last_name" name="billing_last_name"
														class="input-text " />
													<form:errors path="username" class="control-label" />
												</p>
											</div>
										</spring:bind>

										<div class="clear"></div>
										<spring:bind path="email">
											<div class="form-group ${status.error ? 'has-error' : ''}">
												<p id="billing_email_field"
													class="form-row form-row-first validate-required validate-email">
													<label class="" for="billing_email">Email Address <abbr
														title="required" class="required">*</abbr>
													</label>
													<form:input path="email" type="text" value="${u.email }"
														placeholder="" id="billing_email" name="billing_email"
														class="input-text " />
													<form:errors path="email" class="control-label" />
												</p>
											</div>
										</spring:bind>

										<spring:bind path="phone">
											<div class="form-group ${status.error ? 'has-error' : ''}">
												<p id="billing_phone_field"
													class="form-row form-row-last validate-required validate-phone">
													<label class="" for="billing_phone">Phone <abbr
														title="required" class="required">*</abbr>
													</label>
													<form:input path="phone" type="text" value="${u.phone }"
														placeholder="" id="billing_phone" name="billing_phone"
														class="input-text " />
													<form:errors path="phone" class="control-label" />
												</p>
											</div>
										</spring:bind>
										
										<spring:bind path="note">
												<p id="billing_note_field"
													class="form-row form-row-last validate-required validate-note">
													<label class="" for="billing_note">Note
													</label>
													<form:input path="note" type="text" value=""
														placeholder="" id="billing_note" name="billing_note"
														class="input-text " />
												</p>
										</spring:bind>

										<div class="clear"></div>
									</div>
								</div>
								<div class="col-2">
									<div class="woocommerce-billing-fields">
										<h3></h3>
										<spring:bind path="firstname">
											<div class="form-group ${status.error ? 'has-error' : ''}">
												<p id="billing_first_name_field"
													class="form-row form-row-first validate-required">
													<label class="" for="billing_first_name">First Name
														<abbr title="required" class="required">*</abbr>
													</label>
													<form:input path="firstname" type="text"
														value="${u.firstname }" placeholder=""
														id="billing_first_name" name="billing_first_name"
														class="input-text " />
													<form:errors path="firstname" class="control-label" />
												</p>
											</div>
										</spring:bind>
										<spring:bind path="lastname">
											<div class="form-group ${status.error ? 'has-error' : ''}">
												<p id="billing_last_name_field"
													class="form-row form-row-last validate-required">
													<label class="" for="billing_last_name">Last Name <abbr
														title="required" class="required">*</abbr>
													</label>
													<form:input path="lastname" type="text"
														value="${u.lastname }" placeholder=""
														id="billing_last_name" name="billing_last_name"
														class="input-text " />
													<form:errors path="lastname" class="control-label" />
												</p>
											</div>
										</spring:bind>
										<spring:bind path="addressStreet">
											<div class="form-group ${status.error ? 'has-error' : ''}">
												<p id="billing_address_1_field"
													class="form-row form-row-wide address-field validate-required">
													<label class="" for="billing_address_1">Address <abbr
														title="required" class="required">*</abbr>
													</label>
													<form:input path="addressStreet" type="text"
														value="${u.addressStreet }" placeholder="Street address"
														id="billing_address_1" name="billing_address_1"
														class="input-text " />
													<form:errors path="addressStreet" class="control-label" />
												</p>
											</div>
										</spring:bind>
										<spring:bind path="addressSuite">
											<div class="form-group ${status.error ? 'has-error' : ''}">
												<p id="billing_address_2_field"
													class="form-row form-row-wide address-field">
													<form:input path="addressSuite" type="text"
														value="${u.addressSuite }"
														placeholder="Apartment, suite, unit etc. (optional)"
														id="billing_address_2" name="billing_address_2"
														class="input-text " />
													<form:errors path="addressSuite" class="control-label" />
												</p>
											</div>
										</spring:bind>
										<spring:bind path="addressCity">
											<div class="form-group ${status.error ? 'has-error' : ''}">
												<p id="billing_city_field"
													class="form-row form-row-wide address-field validate-required"
													data-o_class="form-row form-row-wide address-field validate-required">
													<label class="" for="billing_city">Town / City <abbr
														title="required" class="required">*</abbr>
													</label>
													<form:input path="addressCity" type="text"
														value="${u.addressCity }" placeholder="Town / City"
														id="billing_city" name="billing_city" class="input-text " />
													<form:errors path="addressCity" class="control-label" />
												</p>
											</div>
										</spring:bind>
										<div class="clear"></div>


										<div class="clear"></div>
									</div>
								</div>
							</div>

							<h3 id="order_review_heading">Your order</h3>

							<div id="order_review" style="position: relative;">
								<table class="shop_table">
									<thead>
										<tr>
											<th class="product-name">Product</th>
											<th class="product-total">Total</th>
										</tr>
									</thead>
									<tfoot>

										<tr class="cart-subtotal">
											<th>Cart Subtotal</th>
											<td><span class="amount"> <fmt:formatNumber
														value="${sessionScope.viewCart.amount }" type="currency" />
											</span></td>
										</tr>

										<tr class="shipping">
											<th>Shipping and Handling</th>
											<td>Free Shipping <input type="hidden"
												class="shipping_method" value="free_shipping"
												id="shipping_method_0" data-index="0"
												name="shipping_method[0]">
											</td>
										</tr>


										<tr class="order-total">
											<th>Order Total</th>
											<td><strong><span class="amount"><fmt:formatNumber
															value="${sessionScope.viewCart.amount }" type="currency" /></span></strong>
											</td>
										</tr>

									</tfoot>
								</table>


								<div id="payment">
									<ul class="payment_methods methods">
										<li class="payment_method_bacs"><input type="radio"
											data-order_button_text="" checked="checked" value="bacs"
											name="payment_method" class="input-radio"
											id="payment_method_bacs"> <label
											for="payment_method_bacs">Cash</label></li>
										<!-- <li class="payment_method_bacs">
                                                <input type="radio" data-order_button_text="" checked="checked" value="bacs" name="payment_method" class="input-radio" id="payment_method_bacs">
                                                <label for="payment_method_bacs">Direct Bank Transfer </label>
                                                <div class="payment_box payment_method_bacs">
                                                    <p>Make your payment directly into our bank account. Please use your Order ID as the payment reference. Your order won’t be shipped until the funds have cleared in our account.</p>
                                                </div>
                                            </li>
                                            <li class="payment_method_cheque">
                                                <input type="radio" data-order_button_text="" value="cheque" name="payment_method" class="input-radio" id="payment_method_cheque">
                                                <label for="payment_method_cheque">Cheque Payment </label>
                                                <div style="display:none;" class="payment_box payment_method_cheque">
                                                    <p>Please send your cheque to Store Name, Store Street, Store Town, Store State / County, Store Postcode.</p>
                                                </div>
                                            </li>
                                            <li class="payment_method_paypal">
                                                <input type="radio" data-order_button_text="Proceed to PayPal" value="paypal" name="payment_method" class="input-radio" id="payment_method_paypal">
                                                <label for="payment_method_paypal">PayPal <img alt="PayPal Acceptance Mark" src="https://www.paypalobjects.com/webstatic/mktg/Logo/AM_mc_vs_ms_ae_UK.png"><a title="What is PayPal?" onclick="javascript:window.open('https://www.paypal.com/gb/webapps/mpp/paypal-popup','WIPaypal','toolbar=no, location=no, directories=no, status=no, menubar=no, scrollbars=yes, resizable=yes, width=1060, height=700'); return false;" class="about_paypal" href="https://www.paypal.com/gb/webapps/mpp/paypal-popup">What is PayPal?</a>
                                                </label>
                                                <div style="display:none;" class="payment_box payment_method_paypal">
                                                    <p>Pay via PayPal; you can pay with your credit card if you don’t have a PayPal account.</p>
                                                </div>
                                            </li> -->
									</ul>

									<div class="form-row place-order">

										<input type="submit" data-value="Place order"
											value="Place order" id="place_order"
											name="woocommerce_checkout_place_order" class="button alt">


									</div>

									<div class="clear"></div>

								</div>
							</div>
						</form:form>

					</div>
				</div>
			</div>
		</div>
	</div>
</div>