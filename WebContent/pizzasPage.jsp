<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
	</head>
	<body>
		<div id="test">Unsere Pizzen</div>
		<ul>
		<c:forEach items="${pizzas}" var="pizza">
    		<li><b>${pizza.name}</b> - ${pizza.ingredients}</li>
			<c:if test="${sessionScope.username != null}">
				<a href="addToCart?id=${pizza.id}">Add to cart</a>
			</c:if>
		</c:forEach>
		</ul>
	</body>
</html>