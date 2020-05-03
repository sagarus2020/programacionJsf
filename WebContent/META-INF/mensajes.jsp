<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import= " java.util.* "%>
    

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listado de mensajes</title>
</head>
<body>
<h1>Listado de mensajes</h1>
<jsp:useBean id="mDao" class="mensaje.Dao.MensajeDao" scope="request"/> 
<table>
<tr>
<th>Nombre</th>
<th>Email</th>
</tr>
<c:forEach var="m" items="${ mDao.listar()} }">
<tr>
<td><c: out value= "${ m.Nombre} "/>
<td><c: out value= "${ m.Email} "/>
</tr>
</table>
</c:forEach>

</body>
</html>