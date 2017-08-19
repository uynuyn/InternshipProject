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
				<c:set value="${result }" var="r"/>
				<c:if test="${r eq 'fail' }">
					<script type="text/javascript">
					$(document).ready(function() {
							$("#modalInfor").modal("show");
					});
					</script>
				</c:if>
				<spring:url value="/register" var="register"></spring:url>
				<form:form action="${register }" method="post"
					modelAttribute="userFormRegister">
					<div class="modal-body">
						<spring:bind path="username">
						<div class="form-group ${status.error ? 'has-error' : ''}">
							<label class="sr-only" for="inputUserName">User name</label>
							<form:input path="username" type="text" placeholder="User name"
								class="form-control setfontinput" id="inputUserName" />
							<form:errors path="username" class="control-label" />
						</div>	
						</spring:bind>
						<spring:bind path="email">
						<div class="form-group ${status.error ? 'has-error' : ''}">
							<label class="sr-only" for="inputEmail">Email</label>
							<form:input path="email" type="email"
								placeholder="Email... ex@example.com"
								class="form-control setfontinput" id="inputEmail" />
							<form:errors path="email" class="control-label" />	
						</div>
						</spring:bind>
						<spring:bind path="phone">
							<div class="form-group ${status.error ? 'has-error' : ''}">
								<label class="sr-only" for="inputPhone">Phone</label>
								<form:input path="phone" type="tel" placeholder="Phone"
									class="form-control setfontinput" id="inputPhone" />
								<form:errors path="phone" class="control-label" />	
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

<div class="modal fade myModal" id="modalInfor" role="dialog">
		<div class="modal-dialog modal-sm" style="width: 500px">
			<div class="modal-content">
				<div class="modal-header">
						<i class="fa fa-hand-paper-o" aria-hidden="true" style="color: red;"></i>
						<h2 class="form-signin-heading">Try another?</h2>
				</div>
				<form action="">
				<div class="modal-body" >
					<h3 style="color: #FF5959;">Someone already has that username. Note that we ignore periods and capitalization in usernames. </h3>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-lg btn-default" data-dismiss="modal">Cancel</button>
				</div>
				</form>
			</div>
		</div>
	</div>