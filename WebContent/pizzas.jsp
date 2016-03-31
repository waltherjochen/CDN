<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
	</head>
	<body>
		<div id="test">Unsere Pizzen</div>
		<ul>
		<c:forEach items="${pizzas}" var="pizza">
    		<li><b>${pizza.name}</b> - ${pizza.ingredients}</li>
		</c:forEach>
		</ul>
	</body>
</html>