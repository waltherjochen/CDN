<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
	</head>
	<body>
		<div id="test">Pizza Shop</div>
		<c:if test="${not empty sessionScope.username}">
			Welcome <b>${sessionScope.username}</b>! 
		</c:if>
		<p>
			<a href="pizzas">Pizzas</a>
			<a href="login">Login</a>
			<a href="logout">Logout</a>
		</p>
	</body>
</html>