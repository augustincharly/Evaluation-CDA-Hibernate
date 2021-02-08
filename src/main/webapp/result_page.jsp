<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<title>ResultPage</title>
</head>
<body>
	<h1 style="text-align: center">Reporting Page</h1>
	<div>Marques</div>
	<ul>
		<c:forEach var="item" items="${marques}">
	 		<li> ${item[0]} - ${item[1]} </li>
	 	</c:forEach>
	</ul>
	<div>Nombre de véhicules - ${count}</div>
	<div>Les 10 dernières voitures ajoutées</div>
	<ul>
		<c:forEach var="car" items="${lastAdded}">
	 		<li> ${car} </li>
	 	</c:forEach>
	</ul>
</body>
</html>
