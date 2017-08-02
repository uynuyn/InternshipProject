
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
   <div class="product-big-title-area">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="product-bit-title text-center">
                        <h2>Shopping Cart</h2>
                    </div>
                </div>
            </div>
        </div>
    </div> <!-- End Page title area -->
    
    <c:set value="${sessionScope.cart }" var="cart"></c:set>
    <c:choose>
		<c:when test="${cart eq null || empty cart }">
			<div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="product-bit-title text-center">
                    	<h2><i class="fa fa-shopping-cart" style="color: red"></i></h2>
                        <h2>Your Shopping Cart is empty</h2>
                        <spring:url value="/home" var="home"></spring:url>
						<h2><a class="button alt wc-forward" href="${home }">Home</a></h2>
                    </div>
                </div>
            </div>
        </div>	
		</c:when>
		<c:otherwise>
    <div class="single-product-area">
        <div class="zigzag-bottom"></div>
        <div class="container">
            <div class="row">
                <div class="col-md-4">
                    <div class="single-sidebar">
                        <h2 class="sidebar-title">Search Products</h2>
                        <form action="#">
                            <input type="text" placeholder="Search products...">
                            <input type="submit" value="Search">
                        </form>
                    </div>
                    
<%--                     <div class="single-sidebar">
                        <h2 class="sidebar-title">Products</h2>
                        <div class="thubmnail-recent">
                            <img src="<c:url value = '/resources/img/product-thumb-1.jpg'/>" class="recent-thumb" alt="">
                            <h2><a href="single-product.html">Sony Smart TV - 2015</a></h2>
                            <div class="product-sidebar-price">
                                <i>$700.00</i> <strong>$800.00</strong>
                            </div>                             
                        </div>
                        <div class="thubmnail-recent">
                            <img src="<c:url value = '/resources/img/product-thumb-1.jpg'/>" class="recent-thumb" alt="">
                            <h2><a href="single-product.html">Sony Smart TV - 2015</a></h2>
                            <div class="product-sidebar-price">
                                <i>$700.00</i> <strong>$800.00</strong>
                            </div>                             
                        </div>
                        <div class="thubmnail-recent">
                            <img src="<c:url value = '/resources/img/product-thumb-1.jpg'/>" class="recent-thumb" alt="">
                            <h2><a href="single-product.html">Sony Smart TV - 2015</a></h2>
                            <div class="product-sidebar-price">
                                <i>$700.00</i> <strong>$800.00</strong>
                            </div>                             
                        </div>
                        <div class="thubmnail-recent">
                            <img src="<c:url value = '/resources/img/product-thumb-1.jpg'/>" class="recent-thumb" alt="">
                            <h2><a href="single-product.html">Sony Smart TV - 2015</a></h2>
                            <div class="product-sidebar-price">
                                <i>$700.00</i> <strong>$800.00</strong>
                            </div>                             
                        </div>
                    </div>
          --%>           
                    <div class="single-sidebar">
                        <h2 class="sidebar-title">Recent Posts</h2>
                        <!-- <ul>
                            <li><a href="#">Sony Smart TV - 2015</a></li>
                            <li><a href="#">Sony Smart TV - 2015</a></li>
                            <li><a href="#">Sony Smart TV - 2015</a></li>
                            <li><a href="#">Sony Smart TV - 2015</a></li>
                            <li><a href="#">Sony Smart TV - 2015</a></li>
                        </ul> -->
                    </div>
                </div>
                
                <div class="col-md-8">
                    <div class="product-content-right">
                        <div class="woocommerce">
                            <form method="post" action="#">
                                <table  class="shop_table cart">
                                    <thead>
                                        <tr>
                                            <th class="product-remove">&nbsp;</th>
                                            <th class="product-thumbnail">&nbsp;</th>
                                            <th class="product-name">Product</th>
                                            <th class="product-price">Price</th>
                                            <th class="product-quantity">Quantity</th>
                                            <th class="product-subtotal">Total</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${cart }" var="c" varStatus="i">
                                        <tr class="cart_item">
                                            <td class="product-remove">
                                            <spring:url value="/cart/remove/${c.value.id }" var="remove"></spring:url>
                                                <a title="Remove this item" class="remove" href="${remove }"><i class="fa fa-times" aria-hidden="true"></i>
                                                </a> 
                                            </td>

                                            <td class="product-thumbnail">
                                                <a href="single-product.html"><img width="145" height="145" alt="poster_1_up" class="shop_thumbnail" src="<c:url value = '${c.value.imgPath }'/>"></a>
                                            </td>

                                            <td class="product-name">
                                                <a href="single-product.html">Ship Your Idea</a> 
                                            </td>

                                            <td class="product-price">
                                                <input hidden="" disabled="disabled" class="amount" value="${c.value.price }" id="b${i.index }"/> 
                                                <span class="amount">${c.value.price }</span>
                                            </td>

                                            <td class="product-quantity">
                                                <div class="quantity buttons_added">
                                                    <input hidden="" type="number" size="4" class="input-text qty text" title="Qty" value="1" min="0" step="1" id="${i.index }">
                                                    <span class="amount">${c.value.quantity }</span>
                                                    <input hidden="" value="${c.value.id }" id="a${i.index }">
                                                </div>
                                            </td>

                                            <td class="product-subtotal">
                                                <span class="amount" id="d${c.value.id }">${c.value.total }</span> 
                                            </td>
                                        </tr>
                                        </c:forEach>
                                        <tr>
                                            <td class="actions" colspan="6">
                                                <!-- <div class="coupon">
                                                    <label for="coupon_code">Coupon:</label>
                                                    <input type="text" placeholder="Coupon code" value="" id="coupon_code" class="input-text" name="coupon_code">
                                                    <input type="submit" value="Apply Coupon" name="apply_coupon" class="button">
                                                </div>
                                                <input type="submit" value="Update Cart" name="update_cart" class="button"> -->
                                                <c:if test='${cart ne null || not empty cart }'>
                                                <spring:url value="/checkout"  var="checkout"></spring:url>
                                                	<a id="mycheckout" class="checkout-button button alt wc-forward" href="${checkout }" >Proceed to Checkout</a>
                                                </c:if>
                                            </td>
                                        </tr>
                                    </tbody>
                                </table>
                            </form>

                            <div class="cart-collaterals">


<%--                             <div class="cross-sells">
                                <h2>You may be interested in...</h2>
                                <ul class="products">
                                    <li class="product">
                                        <a href="single-product.html">
                                            <img width="325" height="325" alt="T_4_front" class="attachment-shop_catalog wp-post-image" src="<c:url value = '/resources/img/product-2.jpg'/>">
                                            <span>Ship Your Idea</span>
                                            <span class="price"><span class="amount">£20.00</span></span>
                                        </a>

                                        <a class="add_to_cart_button" data-quantity="1" data-product_sku="" data-product_id="22" rel="nofollow" href="single-product.html">Select options</a>
                                    </li>

                                    <li class="product">
                                        <a href="single-product.html">
                                            <img width="325" height="325" alt="T_4_front" class="attachment-shop_catalog wp-post-image" src="<c:url value = '/resources/img/product-4.jpg'/>">
                                            <span>Ship Your Idea</span>
                                            <span class="price"><span class="amount">£20.00</span></span>
                                        </a>

                                        <a class="add_to_cart_button" data-quantity="1" data-product_sku="" data-product_id="22" rel="nofollow" href="single-product.html">Select options</a>
                                    </li>
                                </ul>
                            </div>
 --%>

                            <div class="cart_totals " id ="cart_totalsid">
                                <h2>Cart Totals</h2>

                                <table >
                                    <tbody>
                                        <tr class="cart-subtotal">
                                            <th>Cart Subtotal</th>
                                            <td><span class="amount" >${sessionScope.viewCart.amount }</span></td>
                                        </tr>

                                        <tr class="shipping">
                                            <th>Shipping and Handling</th>
                                            <td>Free Shipping</td>
                                        </tr>

                                        <tr class="order-total">
                                            <th>Order Total</th>
                                            <td><strong><span class="amount">${sessionScope.viewCart.amount }</span></strong> </td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>
                            </div>
                        </div>                        
                    </div>                    
                </div>
            </div>
        </div>
    </div>
    </c:otherwise>
    </c:choose>
    <script>
$(document).ready(function(){
    $(".qty").click(function(){
    	var qty = $(this).val();
    	var getId = $(this).id();
    	var id = $("#a"+getId).val();
    	var price = $("#b"+getId).val();
		alert(qty);
		event.preventDefault();
    	$.ajax({
			url : "/shop/cart/addCart/"+id+"/" + qty ,
			contentType : "application/json",
			type : 'POST',
			dataType : 'json',
			timeout : 100000
		});
		$("#d"+getId).val(parseInt(qty)*parseInt(price));
    });
    $(".remove").click(function() {
		href = $(this).attr("href");
		console.log(href);
		$.ajax({
			url : href,
			dataType : "json",
			success : function(response) {
				console.log(response);
				$("#add-cart").html(Number(response));
				if(response==0){
					document.getElementById("mycheckout").style.display = "none";
					document.getElementById("cart_totalsid").style.display = "none";
					document.getElementById("totalCartID").innerHTML='0.0';
					}
			}
			});
		$(this).parents("tr").hide(500).html("");
		return false;
	});

   
});
</script>