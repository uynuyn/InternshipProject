<!--Sản phâm nhóm  -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:set value="${breadcrumb }" var="b"/>
<c:set value="${listProduct }" var="l"></c:set>
 <div class="product-big-title-area">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="product-bit-title">
                    <c:if test="${l ne null }">
                    <c:choose>
                    	<c:when test="${f eq null || empty f}">
                    	<div class="product-breadcroumb">
                            <a href="">Home</a>
                            <spring:url value="/products/list/${b.category.department.code }" var="departmentUrl" />
							<a href="${departmentUrl }">${b.category.department.name }</a>
							<spring:url value="/products/list/${b.category.department.code }/${b.category.code }" var="productUrl" />
                            <a href="${productUrl }">${b.category.name }</a>
                        </div>
                    	</c:when>
                    	<c:otherwise>
                    	<div class="product-breadcroumb">
                            <a href="">Search</a>
                        </div>
                    	</c:otherwise>
                    </c:choose>
                         </c:if>
                        
                    </div>
                </div>
            </div>
        </div>
    </div>
    
    
    <div class="single-product-area">
        <div class="zigzag-bottom"></div>
        <div class="container">
            <div class="row">
            <c:if test="${l eq null }">
           <div class="col-md-12">
					<div class="product-bit-title text-center">
						
						<h2>Product is not found</h2>
						<spring:url value="/home" var="home"></spring:url>
						<h2>
							<a class="button alt wc-forward" href="${home }">Home</a>
						</h2>
					</div>
				</div>
            </c:if>
            <c:forEach items="${listProduct }" var="p">
                <div class="col-md-3 col-sm-6">
                    <div class="single-shop-product">
                        <div class="product-upper">
                            <a href="<spring:url value='/product/single/${p.id }'/>">
                            <img src="<c:url value = '${p.imge }'/>" alt="" style="width:200pt;height:250pt;"></a>
                        </div>
                        <h2><a href="<spring:url value='/product/single/${p.id }'/>">${p.name }</a></h2>
                        <div class="product-carousel-price">
                            <i><fmt:formatNumber value="${p.price }" type="currency" minFractionDigits="0" /></i>
                        </div>  
                        <c:choose>
                        	<c:when test="${p.endProduct }">
                        		<div class="product-option-shop">
                            		<a class="add_to_cart_button addProduct" data-quantity="1" data-product_sku="" data-product_id="70" rel="nofollow" href="#" id="${p.id }">Add to cart</a>
                        		</div>
                        	</c:when>
                        	<c:otherwise>
		                        <div class="product-option-shop">
		                            <a class="add_to_cart_button" data-quantity="1" data-product_sku="" data-product_id="70" rel="nofollow" href="#" id="${p.id }">Sorry</a>
		                        </div>                     	
                        	</c:otherwise>
                        </c:choose>
                        
                    </div>
                </div>
                </c:forEach>
            </div>
            
         
        </div>
    </div>
    <div class="modal fade myModal" id="modalInfor" role="dialog">
		<div class="modal-dialog modal-sm" style="width: 500px">
			<div class="modal-content">
				<div class="modal-header">
						<i class="fa fa-hand-paper-o" aria-hidden="true" style="color: red;"></i>
						<h2 class="form-signin-heading"><i class="fa fa-shopping-cart" style="color: red"></i>MinimalismShop<i class="fa fa-shopping-cart" style="color: red"></i></h2>
				</div>
				<form action="">
				<div class="modal-body" >
				    <spring:url value="/cart" var="cart"></spring:url>
					<h3><a href="${cart }">Go to cart</a></h3>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-lg btn-default" data-dismiss="modal">Cancel</button>
				</div>
				</form>
			</div>
		</div>
	</div>
    <script>
$(document).ready(function(){
    $(".addProduct").click(function(event){
		var id = $(this).attr('id');
		event.preventDefault();
    	$.ajax({
			url : "/shop/cart/addCart/"+ id +"/"+1,
			contentType : "application/json",
			type : 'POST',
			dataType : 'json',
			timeout : 100000,
			success : function(response) {
				console.log($("#add-cart").text());
				$("#add-cart").html(Number(response));
		    	$("#modalInfor").modal("show");
			}
		});
    });
});
</script>