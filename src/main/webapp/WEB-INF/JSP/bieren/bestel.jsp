<%@ page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix="v" uri='http://vdab.be/tags'%>
<%@taglib prefix='spring' uri='http://www.springframework.org/tags'%>
<%@taglib prefix='form' uri='http://www.springframework.org/tags/form'%>

<!doctype html>
<html lang='nl'>
<head>
	<v:head title='Bestel' />
</head>

<body>
	<v:menu />
	<h1>${bier.naam}</h1>
	<dl>
		<dt>Alcohol</dt><dd>${bier.alcohol} %</dd>
		<dt>Prijs</dt><dd>${bier.prijs} &euro;</dd>
		<dt>Soort</dt><dd>${bier.soort.naam}</dd>
		<dt>Brouwer</dt><dd>${bier.brouwer.naam}</dd>
	</dl>
	<spring:url var='url' value='/bieren/{id}'>
 		<spring:param name='id' value='${bier.id}'/>
	</spring:url>
	<form:form commandName="aantalBieren" action='${url}' method='post'>
		<form:label path='aantal'>Aantal:
			<form:errors path='aantal' delimiter=", "/>
		</form:label>
		<form:input path='aantal' type="number" min="1" step="1" autofocus="autofocus" required="required" />
		<input type="submit" value="Toevoegen">
	</form:form>

</body>
</html>