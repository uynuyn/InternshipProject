<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<div id="wrapper">
	<nav class="navbar-default navbar-side" role="navigation">
		<div class="sidebar-collapse">
			<ul class="nav" id="main-menu">
				<li class="text-center"><img
					src="<c:url value ='/resources/img/2.jpg' />"
					class="user-image img-responsive" /></li>


				<li><spring:url value="/admin" var="admin"></spring:url> <a
					class="active-menu" href="${admin }"><i
						class="fa fa-dashboard fa-3x"></i> Dashboard</a></li>
				<li><a href="#"><i class="fa fa-sitemap fa-3x"></i> Product</a>
					<ul class="nav nav-second-level">
						<li><spring:url value="/admins/add-product"
								var="addnewproduct"></spring:url> <a href="${addnewproduct }">Add
								NEW GroupProduct</a></li>
						<li>
							<a href="#">Add GroupProduct</a>
							<ul class="nav nav-third-level">
								<c:forEach items="${sessionScope.listDepartment }" var="d">
								<spring:url value="/admins/view-product/${d.code }" var="addold"></spring:url>
									<li><a href="${addold }">${d.name }</a>
										<ul class="nav nav-fourth-level">
											<c:forEach items="${d.categories }" var="c">
											<spring:url value="/admins/view-product/${d.code }/${c.code }" var="addoldcode"></spring:url>
												<li><a href="${addoldcode }">${c.name }</a></li>
											</c:forEach>
										</ul>
									</li>
								</c:forEach>
							</ul>
							</li>
					</ul></li>
				<li>
				<li><a href="chart.html"><i
						class="fa fa-bar-chart-o fa-3x"></i> Morris Charts</a></li>
				<li><a href="table.html"><i class="fa fa-table fa-3x"></i>
						Table Examples</a></li>
				<li><a href="form.html"><i class="fa fa-edit fa-3x"></i>
						Forms </a></li>


				<li><a href="#"><i class="fa fa-sitemap fa-3x"></i>
						Multi-Level Dropdown<span class="fa arrow"></span></a>
					<ul class="nav nav-second-level">
						<li><a href="#">Second Level Link</a></li>
						<li><a href="#">Second Level Link</a></li>
						<li><a href="#">Second Level Link<span class="fa arrow"></span></a>
							<ul class="nav nav-third-level">
								<li><a href="#">Third Level Link</a></li>
								<li><a href="#">Third Level Link</a></li>
								<li><a href="#">Third Level Link</a></li>

							</ul></li>
					</ul></li>
				<li><a href="blank.html"><i class="fa fa-square-o fa-3x"></i>
						Blank Page</a></li>
			</ul>

		</div>

	</nav>
</div>