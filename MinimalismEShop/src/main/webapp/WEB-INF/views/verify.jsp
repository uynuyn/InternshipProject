<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<div class="container" style="margin-top: 30pt; ">
	<div class="row" style="height: 300pt">
		<div class="col-md-5 col-md-offset-3">
		<c:choose>
			<c:when test="${fail eq false || empty fail }">
			<script type="text/javascript">
					$(document).ready(function() {
							$("#modalInfor").modal("show");
					});
			</script>
			</c:when>
			<c:otherwise>
			<script type="text/javascript">
					$(document).ready(function() {
							$("#modalInforF").modal("show");
					});
			</script>
			</c:otherwise>
		</c:choose>
			
			<div class="modal-content">
				<div class="modal-header">
					<h2 class="form-signin-heading">Verify your email</h2>
				</div>
				<spring:url value="/verify" var="verify"></spring:url>
				<form action="${verify }" method="post">
					<div class="modal-body">
							<label class="sr-only" for="inputVerify">Verify that you have this mail</label>
							<input type="text" placeholder="Verify that you have this mail"
								name="verify" class="form-control setfontinput"
								id="verify" /> 
						
					</div>
					<div class="modal-footer">
						<button type="submit" class="btn btn-lg btn-primary">Sign in</button>
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
						<h2 class="form-signin-heading">Please check your email</h2>
				</div>
				<form action="">
				<div class="modal-body" >
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-lg btn-default" data-dismiss="modal">Verification</button>
				</div>
				</form>
			</div>
		</div>
	</div>
	
<div class="modal fade myModal" id="modalInforF" role="dialog">
		<div class="modal-dialog modal-sm" style="width: 500px">
			<div class="modal-content">
				<div class="modal-header">
						<i class="fa fa-hand-paper-o" aria-hidden="true" style="color: red;"></i>
						<h2 class="form-signin-heading">Oh no...</h2>
				</div>
				<form action="">
				<div class="modal-body" >
				<h2 class="form-signin-heading">Account Lock is invalid. Try again?</h2>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-lg btn-default" data-dismiss="modal">Verification</button>
				</div>
				</form>
			</div>
		</div>
	</div>