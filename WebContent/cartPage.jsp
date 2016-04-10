<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
	</head>
	<body>
		<div id="test">Warenkorb</div>
		<ul>
		<c:forEach items="${cartItems}" var="cartItem">
    		<li>${cartItem.id} - <b>${cartItem.pizzaName}</b></li>
		</c:forEach>
		</ul>
	</body>
</html>