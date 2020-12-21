<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html lang="en">
<head>
<title>Marginal Tax</title>
<link rel="stylesheet" href="format.css" />
<link rel="stylesheet" href="table-report.css" />
</head>
<body>
	<jsp:include page="../menu.jsp"/>
	Developer: sterling, hermann TimeStamp: ${timestamp}
	<hr/>
	client: ${client}
	
	
	<div class="bodyReport">
		<h1>Clients</h1>
		<a href = "clients?status=ALL">All Status</a>	
		<a href = "clients?status=MFJ">Married Filing Jointly</a>	
		<a href = "clients?status=S">Single</a>	
		<a href = "clients?status=MFS">Married Filing Single</a>	
		<a href = "clients?status=HH">Head Of House Hold</a>					
		<table>
			<thead>
				<tr>
					<th rowspan="2">Client <br /> Id
					</th>
					<th colspan='2'>Name</th>
					
					<th rowspan="2" >Current <br /> Salary</th>
					<th rowspan="2" >Status</th>					
				</tr>
				<tr>					
					<th>First</th>
					<th>Last</th>										
				</tr>
			</thead>
			<tbody>
			
			<c:forEach items="${clients}" var="c">
			
			<c:if test="${c.clientId == client.clientId}">
				<tr class="highlight">
			</c:if>
			
			<c:if test="${c.clientId != client.clientId}">
				<tr>
			</c:if>
					<td class="center"><a href="client.view?clientId=${c.clientId}">${c.clientId}</a></td>
					<td class="center">${c.firstName}</td>
					<td class="center">${c.lastName}</td>
					<td class="money center"><fmt:formatNumber value="${c.currentSalary}" type="currency" /></td>
					<td class="center">${c.status}</td>					
				</tr>
			</c:forEach>
			</tbody>
		</table>	
	</div>
	
</body>
</html>