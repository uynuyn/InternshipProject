
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
    <div class="mainmenu-area">
        <div class="container">
            <div class="row">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                </div> 
                <div class="navbar-collapse collapse">
                    <ul class="nav navbar-nav">
                    <spring:url value="/home" var="home"></spring:url>
                        <li class="active"><a href="${home }">Home</a></li>
                        <li class="dropdown">
                        <a href="" class="dropdown-toggle" data-toggle="dropdown" id="departments">Departments<b class="caret"></b></a>
                        	<ul class="dropdown-content multi-column columns-3">
                        		<li>
								<div class="row">
								<c:forEach items="${sessionScope.listDepartment }" var="d">
									<div class="col-sm-3">
										<ul class="multi-column-dropdown">
										<spring:url value="/products/list/${d.code }" var="departmentUrl" />
											<li><h3><a href="${departmentUrl }">${d.name }</a></h3></li>
												<c:forEach items="${d.categories }" var="c">
												<spring:url value="/products/list/${d.code }/${c.code }" var="productUrl" />
													<li><a href="${productUrl }">${c.name }</a></li>
												</c:forEach>
											</ul>
									</div>
								</c:forEach>
									<!-- <div class="col-sm-3">
										<div class="w3ls_products_pos">
											<h4>50%<i>Off/-</i></h4>
											<img src="" alt=" " class="img-responsive" />
										</div>
									</div> -->
									<div class="clearfix"></div>
								</div>
								</li>
							</ul>
                        
                        </li>
                    </ul>
                </div>  
            </div>
        </div>
    </div> <!-- End mainmenu area -->
        <script>

        $(document).ready(function(){
            $("#departments").click(function(event){
        		event.preventDefault();
            	$.ajax({
        			url : "/shop/menu/listDepartment",
        			contentType : "application/json",
        			type : 'POST',
        			dataType : 'json',
        			timeout : 100000
        		});
            });
        });
        
        </script>