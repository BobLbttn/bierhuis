<%@ page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix="v" uri='http://vdab.be/tags'%>
<!doctype html>
<html lang='nl'>
<head>
	<v:head title='Welkom' />
</head>
<body>
	<v:menu />
	<h1>Welkom in het huis van de Belgische bieren</h1>
	<img src="images/bierhuis.jpg" alt="bier">	
	<p>We hebben momenteel ${aantalBieren} bieren.</p>
</html>