<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <div class="header-area">
        <div class="container">
            <div class="row">
                <div class="col-md-8">
                    <div class="user-menu">
                        <ul>
                            <li><a href="#"><i class="fa fa-user"></i> My Account</a></li>
                            <li><a href="#"><i class="fa fa-heart"></i> Wishlist</a></li>
                            <li><a href="cart.html"><i class="fa fa-user"></i> My Cart</a></li>
                            <li><a href="checkout.html"><i class="fa fa-user"></i> Checkout</a></li>
                            <li><a href="#" id="loginlink" class="loginlink"><i class="fa fa-user"></i> Login</a></li>
							<li><a href="#" id="registerlink" class="registerlink"><i class="fa fa-user"></i> Register</a></li>
                            
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
                                    <li><a href="#">INR</a></li>
                                    <li><a href="#">GBP</a></li>
                                </ul>
                            </li>

                            <li class="dropdown dropdown-small">
                                <a data-toggle="dropdown" data-hover="dropdown" class="dropdown-toggle" href="#"><span class="key">language :</span><span class="value">English </span><b class="caret"></b></a>
                                <ul class="dropdown-menu">
                                    <li><a href="#">English</a></li>
                                    <li><a href="#">French</a></li>
                                    <li><a href="#">German</a></li>
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
	<!-- Modal Login -->
    <div class="modal fade myModal" id="modalLogin" role="dialog">
		<div class="modal-dialog modal-sm" style="width: 500px">
			<div class="modal-content">
				<div class="modal-header">
						<h2 class="form-signin-heading">Please sign in</h2>
				</div>
				<form action="">
				<div class="modal-body" >
					<label class="sr-only" for="inputUserName">User name</label>
					<input type="text" autofocus required placeholder="User name" name="username" class="form-control setfontinput" id="inputUserName">
					<label class="sr-only" for="inputPassword">Password</label>
					<input type="password" name="password" required placeholder="Password" class="form-control setfontinput" id="inputPassword">
				</div>
				<div class="modal-footer">
					<button type="submit" class="btn btn-lg btn-primary">Sign in</button>
					<button type="button" class="btn btn-lg btn-default" data-dismiss="modal">Cancel</button>
				</div>
				</form>
			</div>
		</div>
	</div> <!-- End Login Modal -->
	
	<!-- Modal Register -->
    <div class="modal fade myModal" id="modalRegister" role="dialog">
		<div class="modal-dialog modal-sm" style="width: 500px">
			<div class="modal-content">
				<div class="modal-header">
						<h2 class="form-signin-heading">Please sign up</h2>
				</div>
				<form action="">
				<div class="modal-body" >
					<label class="sr-only" for="inputUserName">User name</label>
					<input type="text" autofocus required placeholder="User name" name="username" class="form-control setfontinput" id="inputUserName">
					<label class="sr-only" for="inputEmail">Email</label>
					<input type="email" required placeholder="Email... ex@example.com" name="email" class="form-control setfontinput" id="inputEmail">
					<label class="sr-only" for="inputPhone">Phone</label>
					<input type="tel" pattern="d{10,11}" required placeholder="Phone" name="phone" class="form-control setfontinput" id="inputPhone">
					<label class="sr-only" for="inputPassword">Password</label>
					<input type="password" pattern="{6,20}" name="password" required placeholder="Password more than 6 less 20" class="form-control setfontinput" id="inputPassword">
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-lg btn-primary" data-dismiss="modal" id="confirmationlink">Sign up</button>
					<button type="button" class="btn btn-lg btn-default" data-dismiss="modal">Cancel</button>
				</div>
				</form>
			</div>
		</div>
	</div> <!-- End Login Modal -->
	
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