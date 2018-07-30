<%@ page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix="v" uri='http://vdab.be/tags'%>
<%@taglib prefix='spring' uri='http://www.springframework.org/tags'%>
<%@taglib prefix='form' uri='http://www.springframework.org/tags/form'%>

<!doctype html>
<html lang='nl'>
<head>
	<v:head title='Winkelwagen' />
</head>

<body>
	<v:menu />
	<h1>Winkelwagen</h1>
	<c:choose>
		<c:when test="${not empty fout}">
			<p>Error : ${fout} </p>
		</c:when>
		<c:otherwise>
			<c:choose>
				<c:when test="${not empty id}">
					<p>Je winkelwagentje is bevestigd als bestelbon ${id} </p>
				</c:when>
				<c:otherwise>
					<c:set var="total" value="${0}"/>
					<table>
						<tr><th>bier</th><th>prijs</th><th>aantal</th><th>te betalen</th></tr>
						<c:forEach items="${bestelBon.bestelbonlijnen}" var="b">
							<tr><td>${b.bier.naam}</td><td>${b.bier.prijs}</td><td>${b.aantal}</td><td>${b.totaalBestelbonLijn}</td></tr>
							<c:set var="total" value="${total+b.totaalBestelbonLijn}"/>
						</c:forEach>
					</table>
					<p><b>totaal:${total}</b></p>
					<form:form commandName='bestelBon' method="post" id="bestelbonform">
						<form:label path='naam'>Naam:<form:errors path='naam'/></form:label>
						<form:input path='naam' autofocus='autofocus' required='required' maxlength='50'/>
						<form:label path="adres.straat">Straat<form:errors path="adres.straat" delimiter=", "/></form:label>
						<form:input path="adres.straat" required="required"  maxlength="50"/>
						<form:label path="adres.huisNr">Huisnummer<form:errors path="adres.huisNr" delimiter=", "/></form:label>
						<form:input path="adres.huisNr" required="required"  maxlength="50"/>
						<form:label path="adres.postcode">Postcode<form:errors path="adres.postcode" delimiter=", "/></form:label>
						<form:input path="adres.postcode" type="number" required="required" min="1000" max="9999"/>
						<form:label path="adres.gemeente">Gemeente<form:errors path="adres.gemeente" delimiter=", "/>	</form:label>
						<form:input path="adres.gemeente" required="required"  maxlength="50"/>
						<input type='submit' value='Als bestelbon bevestigen'>
						<script>
							document.getElementById('bestelbonform').onsubmit= function() {
								document.getElementById('submitknop').disabled=true;
							};
						</script>
					</form:form>
				</c:otherwise>
			</c:choose>
		</c:otherwise>
	</c:choose>
</body>
</html>