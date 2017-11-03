<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<div class="container" style="margin-top: 30pt; ">
	<div class="row" style="height: 300pt">
		<div class="col-md-5 col-md-offset-3">
			<!-- Modal Login -->
			<c:if test="${fail eq 'f' }">
			<script type="text/javascript">
					$(document).ready(function() {
							$("#modalInfor").modal("show");
					});
					</script>
			</c:if>
			<c:set value="${success }" var="s"/>
			<c:if test="${s }">
			<script type="text/javascript">
					$(document).ready(function() {
							$("#modalInforR").modal("show");
					});
					</script>
			</c:if>
			<div class="modal-content">
				<div class="modal-header">
					<h2 class="form-signin-heading">Please sign in</h2>
				</div>
				<spring:url value="/login" var="login"></spring:url>
				<form action="${login }" method="post">
				 <c:if test="${param.error != null}">
                                <div class="alert alert-danger">
                                    <p>Invalid username and password.</p>
                                </div>
                            </c:if>
                            <c:if test="${param.logout != null}">
                                <div class="alert alert-success">
                                    <p>You have been logged out successfully.</p>
                                </div>
                            </c:if>
					<div class="modal-body">
						<div class="form-group ${status.error ? 'has-error' : ''}">
							<label class="sr-only" for="inputUserName">User name</label>
							<input type="text" placeholder="User name"
								name="username" class="form-control setfontinput"
								id="inputUserName" /> 
						</div>				
						<div class="form-group ${status.error ? 'has-error' : ''}">
							<label class="sr-only" for="inputPassword">Password</label>
							<input type="password" name="password" placeholder="Password"
								class="form-control setfontinput" id="inputPassword" />
						</div>
						<input type="hidden" name="${_csrf.parameterName}"   value="${_csrf.token}" />
					</div>
					<div class="modal-footer">
						<spring:url value="/login/google" var="google"></spring:url>
						<button type="submit" class="btn btn-lg btn-primary">Sign in</button>
						<a href="${google }" class="btn btn-lg btn-primary">Google</a>
						<button type="button" class="btn btn-lg btn-default"
							data-dismiss="modal">Cancel</button>
					</div>
				</form>
			</div>
			<!-- End Login Modal -->
		</div>
	</div>
</div>
<div class="modal fade myModal" id="modalInfor" role="dialog">
		<div class="modal-dialog modal-sm" style="width: 500px">
			<div class="modal-content">
				<div class="modal-header">
						<i class="fa fa-hand-paper-o" aria-hidden="true" style="color: red;"></i>
						<h2 class="form-signin-heading">Error</h2>
				</div>
				<form action="">
				<div class="modal-body" >
					<h3>Login incorrect</h3>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-lg btn-default" data-dismiss="modal">Cancel</button>
				</div>
				</form>
			</div>
		</div>
	</div>
	
<div class="modal fade myModal" id="modalInforR" role="dialog">
		<div class="modal-dialog modal-sm" style="width: 500px">
			<div class="modal-content">
				<div class="modal-header">
						<i class="fa fa-hand-paper-o" aria-hidden="true" style="color: red;"></i>
						<h2 class="form-signin-heading">Register success</h2>
				</div>
				<form action="">
				<div class="modal-body" >
					<h3>Please login</h3>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-lg btn-default" data-dismiss="modal">Cancel</button>
				</div>
				</form>
			</div>
		</div>
	</div>
	