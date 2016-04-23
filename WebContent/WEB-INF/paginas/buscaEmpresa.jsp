<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- Importa a tag lib do java -->
<!DOCTYPE html>
<html>
<head>
</head>
<body>
Resultado da busca:

<!-- 
	For each nao é uma tag qualquer ela é uma tag library
	ou tagLib que se chama core abreviado c

 -->
<c:forEach var="empresa" items="${empresas}">
	<li>${empresa.id}: ${empresa.nome}</li>
</c:forEach>

</body>
</html>