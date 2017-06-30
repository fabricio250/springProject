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
	<c:choose>
		<c:when test="${user.id > 0}">
			<c:set var="formMethod" value="PUT"></c:set>
			<c:url var="formAction" value="/user/${user.id}"></c:url>
		</c:when>
		<c:otherwise>
			<c:set var="formMethod" value="POST"></c:set>
			<c:url var="formAction" value="/user"></c:url>
		</c:otherwise>
	</c:choose>
	<div class="container">
		<h1>O usuário é: ${user.primeiroNome}</h1>
	</div>
	<div class="container">
	<form:form modelAttribute="user"
		action="${formAction}" method="${formMethod}">
		<div class="form-group row">
			<label>Primeiro nome:</label>
			<form:input class="form-control" path="primeiroNome" id="primeiroNome" type="text" />
		</div>
		<div class="form-group row">
			<label>Último Nome:</label>
			<form:input class="form-control" path="ultimoNome" id="ultimoNome" type="text" />
		</div>
		<div class="form-group row">
			<label>CPF:</label>
			<form:input class="form-control" path="cpf" id="cpf" type="text" />
		</div>
		<div class="form-group row">
			<label>Idade:</label>
			<form:input class="form-control" path="idade" id="idade" type="text" />
		</div>
		<div class="form-group row"">
			<label>Sexo</label>
			<form:select path="sexo" id="sexo">
				<form:option value="M"></form:option>
				<form:option value="F"></form:option>
			</form:select>
		</div>
		<div class="form-group row">
			<button class="btn btn-primary" type="submit">
			 	<i class="fa fa-floppy-o" aria-hidden="true"></i> Save
			</button>
		</div>
	</form:form>
	</div>
	<h2>List of User:</h2>
	<table class="table table-striped" border="2">
		<tr>
			<td width="100" align="center">Primeiro Nome</td>
			<td width="100" align="center">Ultimo Nome</td>
			<td width="100" align="center">CPF</td>
			<td width="50" align="center">Idade</td>
			<td width="50" align="center">Sexo</td>
			<td width="50" align="center">Edit</td>
			<td width="50" align="center">Delete</td>

		</tr>
		<c:forEach items="${users}" var="user">
			<tr>
				<td align="center">${user.primeiroNome}</td>
				<td align="center">${user.ultimoNome}</td>
				<td align="left">${user.cpf}</td>
				<td align="center">${user.idade}</td>
				<td align="center">${user.sexo}</td>

				<td align="center"><a
					href="${pageContext.request.contextPath}/user/${user.id}">Edit</a></td>
				<td align="center"><a
					href="${pageContext.request.contextPath}/user/${user.id}">Delete</a></td>	
			</tr>
		</c:forEach>
	</table>
	<div>
		<button type="submit">Apagar</button>
	</div>
	
</body>
</html>