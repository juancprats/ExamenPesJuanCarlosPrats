<%@page import="es.examenPes.model.entity.TarjetaCredito"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%ArrayList<TarjetaCredito> tarjeta = (ArrayList<TarjetaCredito>)request.getAttribute("tarjeta");%>
    <table>
        <tr>
            <th>ID</th>
            <th>Numero</th>
            <th>Cupo máximo</th>
            <th>Cupo disponible</th>
            <th>Tipo</th>
            
        </tr>
        <!-- Las siguientes se cargan dinamicamente -->
   
        <%for (TarjetaCredito t : tarjeta) {%>
        
            
        <tr>
         <form action="${ pageContext.request.contextPath}/Banco/Modificar"  method="post">
            <td><input type="text" name="id" value="<%=t.getId()%>" size=5></td>
            <td><%=t.getNumero()%></td>
            <td><%=t.getCupoMaximo()%></td>
            <td><%=t.getCupoDisponible()%></td>
            <td><%=t.getTipo()%></td>
            
            <td><input type="button" name="<%=t.getId()%>" value="Modificar" /></td>
        </form>
        </tr>
        
    

        <%}%>
        
    </table>
</body>
</html>