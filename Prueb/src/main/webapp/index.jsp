<%@page import="barmex.DBConexion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Page</title>
</head>
<body>
<h1>Hello World!</h1>
<%
if(DBConexion.conexion()!=null)
{
%>
<p>La conexión se realizó de forma correcta</p>
<%
}
else
{
%>
<p>Hubo un error en la conexión</p>
<%
}
%>
</body>
</html>