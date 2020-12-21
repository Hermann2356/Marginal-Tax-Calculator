<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html lang="en">
<head>
<title>Marginal Tax Design</title>
<link rel="stylesheet" href="format.css" />
<link rel="stylesheet" href="table-report.css" />
</head>
<body>
<jsp:include page="../menu.jsp"/>
<h1>Marginal Tax for ${status} (<fmt:formatNumber value="${salary}" type="currency" />)</h1>
<hr>
	<div class="bodyReport">

		<!-- <pre>
			${rules}
		</pre> -->

		<c:forEach items="${rules}" var="rule">
			<h2>Tax Rules Year for ${rule.year} <!-- ${statusDescription} --></h2>
			<table>
				<thead>
					<tr>
						<th>Rule <br /> No
						</th>
						<th>Rate</th>
						<th>Range 1</th>
						<th>Range 2</th>
						<th>Taxable <br /> Amount
						</th>
						<th>Tax <br /> Paid
						</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${rule.taxRules}" var="t">
						<c:if test="${t.ruleNo != 7}">
							<tr>
								<td>${t.ruleNo} <sup class="mark">${t.marker}</sup></td>
								<td><fmt:formatNumber type="percent" maxIntegerDigits="3" value="${t.rate}" /></td>
								<td class="money"><fmt:formatNumber value="${t.range1}" type="currency" /></td>
								<td class="money"><fmt:formatNumber value="${t.range2}" type="currency" /></td>
								<td class="money"><fmt:formatNumber value="${t.taxableAmount}" type="currency" /></td>
								<td class="money"><fmt:formatNumber value="${t.taxPaid}" type="currency" /></td>
							</tr>
						</c:if>

						<c:if test="${t.ruleNo == 7}">
							<tr>
								<td>${t.ruleNo} <sup class="mark">${t.marker}</sup></td>
								<td><fmt:formatNumber type="percent" maxIntegerDigits="3" value="${t.rate}" /></td>
								<td class="money"><fmt:formatNumber value="${t.range1}" type="currency" /></td>
								<td class="center">Infinite</td>
								<td class="center">N/A</td>
								<td class="center">N/A</td>
							</tr>
						</c:if>
					</c:forEach>
				</tbody>
			</table>
		</c:forEach>



		Developer: ${developer} TimeStamp: ${date}
	</div>
</body>
</html>