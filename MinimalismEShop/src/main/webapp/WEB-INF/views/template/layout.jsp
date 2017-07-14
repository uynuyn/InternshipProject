<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html lang="en">
<head>
<tiles:insertAttribute name="head"></tiles:insertAttribute>
</head>
<body>
	<!-- insert header -->
	<tiles:insertAttribute name="nav-bar" />

	<!-- insert logo and cart -->
	<tiles:insertAttribute name="logo" />

	<!-- insert body -->
	<tiles:insertAttribute name="body" />
	
	<!-- insert footer top-->
	<tiles:insertAttribute name="footertop" />
	
	<!-- insert footer -->
	<tiles:insertAttribute name="footer" />
</body>
</html>