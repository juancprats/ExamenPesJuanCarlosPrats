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

<%TarjetaCredito tarjeta = (TarjetaCredito) request.getAttribute("tarjetas");%>
    <table>
        <tr>
            <th>ID</th>
            <th>Numero</th>
            <th>Cupo máximo</th>
            <th>Cupo disponible</th>
            <th>Tipo</th>
            
        </tr>
        <!-- Las siguientes se cargan dinamicamente -->
      
        <%tarjeta.getId(); %>
        
            
        <tr>
         <form action="${ pageContext.request.contextPath}/Banco/ampliarCupo"  method="post">
            <td><input type="text" name="id" id="id" value="<%=tarjeta.getId() %>" size=5></td>
            <td><%=tarjeta.getNumero() %></td>
            <td><%=tarjeta.getCupoMaximo() %></td>
            <td><%=tarjeta.getCupoDisponible() %></td>
            <td><%=tarjeta.getTipo() %></td>
            <td><input type="text" name="aumento" value="" ></td>
           

            
            <td><input type="submit" value="Ampliar" /></td>
            
                
        </form>
        
        </tr>
        
    

       
        
    </table>
   <!--   ${ pageContext.request.contextPath}/Banco/Modificar-->
</body>
</html>