<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<div class="container" style="margin-top: 30pt; ">
	<div class="row" style="height: 300pt">
		<div class="col-md-5 col-md-offset-3">
			<!-- Modal Login -->
			<div class="modal-content">
				<div class="modal-header">
					<h2 class="form-signin-heading">Please sign in</h2>
				</div>
				<spring:url value="/login" var="login"></spring:url>
				<form:form action="${login }" method="post"
					modelAttribute="userFormLogin">
					<div class="modal-body">
					<spring:bind path="username">
						<div class="form-group ${status.error ? 'has-error' : ''}">
							<label class="sr-only" for="inputUserName">User name</label>
							<form:input path="username" type="text" placeholder="User name"
								name="username" class="form-control setfontinput"
								id="inputUserName" /> 
							<form:errors path="username" class="control-label" />
						</div>				
					</spring:bind>
					<spring:bind path="password">
						<div class="form-group ${status.error ? 'has-error' : ''}">
							<label class="sr-only" for="inputPassword">Password</label>
							<form:input path="password" type="password" name="password" placeholder="Password"
								class="form-control setfontinput" id="inputPassword" />
							<form:errors path="password" class="control-label"></form:errors>
						</div>
					</spring:bind>
						
					</div>
					<div class="modal-footer">
						<button type="submit" class="btn btn-lg btn-primary">Sign in</button>
						<button type="button" class="btn btn-lg btn-default"
							data-dismiss="modal">Cancel</button>
					</div>
				</form:form>
			</div>
			<!-- End Login Modal -->
		</div>
	</div>
</div>