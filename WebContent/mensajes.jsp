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
<jsp:useBean id="mDao" class="jpa.Dao.MensajeDao" scope="request"/> 
<table>
<tr>
<th>Nombre
</th>
<th>Email
</th>
</tr>
<c:forEach var="m" items="${ m.getNombre()} ">
</table>
<%
List listado=mDao.listar();
for(int i=0;i=listado.size();i++){
	Mensaje m=(Mensaje)listado.get(i);

%>
<tr>
<td><c: out value= "${ m.getNombre()} "/>
<td><c: out value= "${ m.getEmail()} "/>


</tr>
<%} %>
</body>
</html>