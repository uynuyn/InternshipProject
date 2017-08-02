<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<c:set value="${sessionScope.users }" var="u"></c:set>
 <div class="header-area">
        <div class="container">
            <div class="row">
                <div class="col-md-8">
                    <div class="user-menu">
                        <ul>
                            <li><a href="#"><i class="fa fa-heart"></i> Wishlist</a></li>
                            <spring:url value="/cart" var="cart"/>
                            <li><a href="${cart }"><i class="fa fa-user"></i> My Cart</a></li>
                            <c:choose>
                            	<c:when test="${u eq null || empty u }">
                            	<spring:url value="/login" var="l"/>
		                            <li><a href="${l }" id="loginlink" class="loginlink"><i class="fa fa-user"></i> Login</a></li>
		                           <spring:url value="/register" var="r"></spring:url>
									<li><a href="${r }" id="registerlink" class="registerlink"><i class="fa fa-user"></i> Register</a></li>                            	
                            	</c:when>
                            	<c:otherwise>
                          			<li><a href="#" class="loginlink"><i class="fa fa-user"></i> Hello ${u.username }</a></li>		
                            	</c:otherwise>
                            </c:choose>
                            
                        </ul>
                    </div>
                </div>
                
                <div class="col-md-4">
                    <div class="header-right">
                        <ul class="list-unstyled list-inline">
                            <li class="dropdown dropdown-small">
                                <a data-toggle="dropdown" data-hover="dropdown" class="dropdown-toggle" href="#"><span class="key">currency :</span><span class="value">USD </span><b class="caret"></b></a>
                                <ul class="dropdown-menu">
                                    <li><a href="#">USD</a></li>
                                    <li><a href="#">VND</a></li>
                                </ul>
                            </li>

                            <li class="dropdown dropdown-small">
                                <a data-toggle="dropdown" data-hover="dropdown" class="dropdown-toggle" href="#"><span class="key">language :</span><span class="value">English </span><b class="caret"></b></a>
                                <ul class="dropdown-menu">
                                    <li><a href="#">English</a></li>
                                    <li><a href="#">Tiếng Việt</a></li>
                                </ul>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div> <!-- End header area -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	
	
	
	
	<!-- Message confirm -->
	<div class="modal fade myModal" id="modalConfirm" role="dialog">
		<div class="modal-dialog modal-sm" style="width: 500px">
			<div class="modal-content">
				<div class="modal-header">
						<h2 class="form-signin-heading">Confirmation</h2>
				</div>
				<form action="">
				<div class="modal-body" >
					<label>Enter the confirmation code from the mail</label>
					<input type="text" autofocus required placeholder="User name" name="Confirmation" class="form-control setfontinput" id="inputConfirmation">
				</div>
				<div class="modal-footer">
					<button type="submit" class="btn btn-lg btn-primary">Confirmation</button>
					<button type="button" class="btn btn-lg btn-default" data-dismiss="modal">Cancel</button>
				</div>
				</form>
			</div>
		</div>
	</div> <!-- End Login Modal -->
	
<!-- Latest jQuery form server -->
    <script src="https://code.jquery.com/jquery.min.js"></script>
    
    <!-- Bootstrap JS form CDN -->
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
    
    <!-- jQuery sticky menu -->
    <script src="/shop/resources/js/owl.carousel.min.js"></script>
    <script src="/shop/resources/js/jquery.sticky.js"></script>
    
    <!-- jQuery easing -->
    <script src="/shop/resources/js/jquery.easing.1.3.min.js"></script>
    
    <!-- Main Script -->
    <script src="/shop/resources/js/main.js"></script>
