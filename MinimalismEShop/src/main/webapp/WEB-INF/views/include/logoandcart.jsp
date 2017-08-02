 <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<div class="site-branding-area">
        <div class="container">
            <div class="row">
                <div class="col-sm-6">
                    <div class="logo">
                    <spring:url value="/home" var="home"></spring:url>
                        <h1><a href="${home }"><span>Minimalism</span>Shop</a></h1>
                    </div>
                </div>
                
                <div class="col-sm-6">
                    <div class="shopping-item">
                    <spring:url value="/cart" var="cart"></spring:url>
                        <a href="${cart }">Cart - <span class="cart-amunt" id="totalCartID">${sessionScope.viewCart.amount }</span> <i class="fa fa-shopping-cart"></i>
                         		<span id ="add-cart" class="product-count">${sessionScope.viewCart.qty }</span>
                         </a>
                    </div>
                </div>
            </div>
        </div>
</div> <!-- End site branding area -->