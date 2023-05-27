<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--<%@ page session="false" %>--%>
<!doctype html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<meta name="viewport"
		  content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">
	<title>Home</title>

	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/static/css/layout/layout.css">

	<link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/static/img/logo_ico.png" type="image/x-icon">
	<link rel="icon" href="${pageContext.request.contextPath}/resources/static/img/logo_ico.png" type="image/x-icon">

	<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
	<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
</head>

<jsp:include page="layout/header.jsp" />
<body>
	<h1>
		Hello world!
	</h1>

	<P>  The time on the server is ${serverTime}. </P>
</body>
<jsp:include page="layout/footer.jsp" />

</html>