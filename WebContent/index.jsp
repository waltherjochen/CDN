<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
	</head>
	<body>
		<div id="test">Pizza Shop</div>
		<c:if test="${not empty sessionScope.userId}">
			Welcome <b>${sessionScope.user.username}</b>! 
		</c:if>
		<p>
			<a href="pizzas">Pizzas</a>
			<c:if test="${not empty sessionScope.userId}">
				<a href="cart">Cart</a>
			</c:if>
			<a href="login">Login</a>
			<a href="logout">Logout</a>
		</p>
	</body>
</html>