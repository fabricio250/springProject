<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>Produto Form</h3>
	<h1>O usuário é: ${user.primeiroNome}</h1>
	<form:form modelAttribute="produto" action="${pageContext.request.contextPath}/produto/save" method="GET">
		<div>
			<label>Nome:</label>
			<form:input path="Nome" id="nome" type="text" />
		</div>
		<div>
			<label>Quantidade:</label>
			<form:input path="quantidade" id="quantidade" type="text" />
		</div>
		<div>
			<label>Preço:</label>
			<form:input path="preco" id="preco" type="text" />
		</div>
		<div>
			<button type="submit">Save</button>
		</div>
	</form:form>
</body>
</html>