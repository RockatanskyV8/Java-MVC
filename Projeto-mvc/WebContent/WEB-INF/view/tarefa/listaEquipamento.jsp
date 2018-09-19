<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 	prefix="c"%>
		<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" 	prefix="fmt"%>
		<%@ taglib tagdir="/WEB-INF/tags" prefix="caelum"%>
		
		<title>Lista</title>
	</head>
	<body>
		<table style="width:50%">
			<tr>
				<th style="text-align:center">Nome</th>
				<th style="text-align:center">Local</th>
				<th style="text-align:center">Adquirido</th>
				<th style="text-align:center">Remover</th>
				<th style="text-align:center">Alterar</th>
			</tr>
			<c:forEach var="e" items="${equipamentos}">
				<tr id=${e.id } id="id">
				<td style="text-align:center">${e.getName() }</td>
				<td style="text-align:center">${e.getLocal() }</td>
				<td style="text-align:center"><fmt:formatDate value="${e.getAdquirido().time}" pattern="dd/MM/yyyy"/></td>
				<td style="text-align:center"><a href="removeEquipamento?id=${e.getId()}">Remover</a></td>
				<td style="text-align:center"><a href="mostraEquipamento?id=${e.getId()}">Alterar</a></td>
				</tr>
			</c:forEach>
		</table>
		
	</body>
</html>