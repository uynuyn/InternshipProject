<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<div class="container" style="margin-top: 10pt">
	<div class="row" style="height: 339px">
		<div class="col-md-5 col-md-offset-3">
			<!-- Modal Register -->
			<div class="modal-content">
				<div class="modal-header">
					<h2 class="form-signin-heading">Please sign up</h2>
				</div>
				<spring:url value="/register" var="register"></spring:url>
				<form:form action="${register }" method="post"
					modelAttribute="userFormRegister">
					<div class="modal-body">
						<spring:bind path="username">
							<label class="sr-only" for="inputUserName">User name</label>
							<form:input path="username" type="text" placeholder="User name"
								class="form-control setfontinput" id="inputUserName" />
						</spring:bind>
						<spring:bind path="email">
							<label class="sr-only" for="inputEmail">Email</label>
							<form:input path="email" type="email"
								placeholder="Email... ex@example.com"
								class="form-control setfontinput" id="inputEmail" />
						</spring:bind>
						<spring:bind path="phone">
							<div class="form-group ${status.error ? 'has-error' : ''}">
								<label class="sr-only" for="inputPhone">Phone</label>
								<form:input path="phone" type="tel" placeholder="Phone"
									class="form-control setfontinput" id="inputPhone" />
							</div>
						</spring:bind>
						<spring:bind path="password">
							<div class="form-group ${status.error ? 'has-error' : ''}">
								<label class="sr-only" for="inputPassword">Password</label>
								<form:input path="password" type="password" pattern="{6,20}"
									placeholder="Password more than 6 less 20"
									class="form-control setfontinput" id="inputPassword" />
								<form:errors path="password" class="control-label" />
							</div>
						</spring:bind>
					</div>
					<div class="modal-footer">
						<!-- <button type="button" class="btn btn-lg btn-primary" data-dismiss="modal" id="confirmationlink">Sign up</button> -->
						<button type="submit" class="btn btn-lg btn-primary">Sign
							up</button>
						<button type="button" class="btn btn-lg btn-default"
							data-dismiss="modal">Cancel</button>
					</div>
				</form:form>
			</div>
		</div>
	</div>
</div>