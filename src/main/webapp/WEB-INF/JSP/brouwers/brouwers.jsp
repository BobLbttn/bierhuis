<%@ page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix="v" uri='http://vdab.be/tags'%>
<%@taglib prefix='spring' uri='http://www.springframework.org/tags'%>

<!doctype html>
<html lang='nl'>
<head>
	<v:head title='Brouwers' />
</head>

<body>
	<v:menu />
	<h1>Brouwers</h1>
	<table>
			<c:forEach items="${brouwers}" var="brouwer">
				<tr>
					<spring:url var='url' value='/brouwers/{id}'>
 						<spring:param name='id' value='${brouwer.id}'/>
					</spring:url>
					<td><a href='${url}'>${brouwer.naam}</a></td>
				</tr>
			</c:forEach>
	</table>
</html>