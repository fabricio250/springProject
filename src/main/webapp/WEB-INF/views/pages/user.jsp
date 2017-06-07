<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cadastro de Usuário</title>
</head>
<body>
	<h3>User Form</h3>
	<h1>O usuário é: ${user.primeiroNome}</h1>
	<form:form modelAttribute="user"
		action="${pageContext.request.contextPath}/user" method="POST">
		<div>
			<label>Primeiro nome:</label>
			<form:input path="primeiroNome" id="primeiroNome" type="text" />
		</div>
		<div>
			<label>Último Nome:</label>
			<form:input path="ultimoNome" id="ultimoNome" type="text" />
		</div>
		<div>
			<label>CPF:</label>
			<form:input path="cpf" id="cpf" type="text" />
		</div>
		<div>
			<label>Idade:</label>
			<form:input path="idade" id="idade" type="text" />
		</div>
		<div>
			<label>Sexo</label>
			<form:select path="sexo"  id="sexo">
				<form:option value="M"></form:option>
				<form:option value="F"></form:option>
			</form:select>
		</div>
		<div>
			<button type="submit">Save</button>
		</div>
	</form:form>
	<h2>List of User:</h2>	
	<table border="2">
		<tr>
			<td width="100" align="center">Primeiro Nome</td>
			<td width="100" align="center">Ultimo Nome</td>
			<td width="100" align="center">CPF</td>
			<td width="50" align="center">Idade</td>
			<td width="50" align="center">Sexo</td>
		</tr>
		<c:forEach items="${users}" var="user">
			<tr>
				<td align="center">${user.primeiroNome}</td>
				<td align="center">${user.ultimoNome}</td>
				<td align="left">${user.cpf}</td>
				<td align="center">${user.idade}</td>
				<td align="center">${user.sexo}</td>
			</tr>
		</c:forEach>
	</table>
	<div>
		<button type="submit">Apagar</button>
	</div>
</body>
</html>