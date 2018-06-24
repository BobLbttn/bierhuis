<%@ page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix="v" uri='http://vdab.be/tags'%>
<%@taglib prefix='spring' uri='http://www.springframework.org/tags'%>

<!doctype html>
<html lang='nl'>
<head>
	<v:head title='Bieren' />
</head>

<body>
	<v:menu />
	<h1>${brouwer.naam}</h1>
	<c:choose>
		<c:when test="${not empty brouwer.bieren}">
			<table>
				<c:forEach items="${brouwer.bieren}" var="bier">
					<tr>
						<spring:url var='url' value='/bieren/info/{id}'>
 							<spring:param name='id' value='${bier.id}'/>
						</spring:url>
						<td><a href='${url}'>${bier.naam}</a></td>
					</tr>
				</c:forEach>
			</table>
		</c:when>
		<c:otherwise>
			<div class='fout'>Geen bieren gevonden</div>
		</c:otherwise>
	</c:choose>
</body>
</html>