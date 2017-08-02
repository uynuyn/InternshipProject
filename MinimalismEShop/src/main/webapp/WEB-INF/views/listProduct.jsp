<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<c:set value="${breadcrumb }" var="b"/>
 <div class="product-big-title-area">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="product-bit-title">
                         <div class="product-breadcroumb">
                            <a href="">Home</a>
                            <spring:url value="/products/list/${b.category.department.code }" var="departmentUrl" />
							<a href="${departmentUrl }">${b.category.department.name }</a>
							<spring:url value="/products/list/${b.category.department.code }/${b.category.code }" var="productUrl" />
                            <a href="${productUrl }">${b.category.name }</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    
    
    <div class="single-product-area">
        <div class="zigzag-bottom"></div>
        <div class="container">
            <div class="row">
            <c:forEach items="${listProduct }" var="p">
                <div class="col-md-3 col-sm-6">
                    <div class="single-shop-product">
                        <div class="product-upper">
                            <a href="<spring:url value='/product/single/${p.id }'/>">
                            <img src="<c:url value = '${p.imge }'/>" alt="" style="width:200pt;height:250pt;"></a>
                        </div>
                        <h2><a href="">${p.name }</a></h2>
                        <div class="product-carousel-price">
                            <i>${p.price }</i>
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
            
            <div class="row">
                <div class="col-md-12">
                    <div class="product-pagination text-center">
                        <nav>
                          <ul class="pagination">
                            <li>
                              <a href="#" aria-label="Previous">
                                <span aria-hidden="true">&laquo;</span>
                              </a>
                            </li>
                            <li><a href="#">1</a></li>
                            <li><a href="#">2</a></li>
                            <li><a href="#">3</a></li>
                            <li><a href="#">4</a></li>
                            <li><a href="#">5</a></li>
                            <li>
                              <a href="#" aria-label="Next">
                                <span aria-hidden="true">&raquo;</span>
                              </a>
                            </li>
                          </ul>
                        </nav>                        
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script>
$(document).ready(function(){
    $(".addProduct").click(function(event){
		var id = $(this).attr('id');
		alert(id);
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
			}
		});
    });
});
</script>