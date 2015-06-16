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
         <form action="${ pageContext.request.contextPath}/Banco/bloqueo"  method="post">
            <td><input type="text" name="id" id="id" value="<%=tarjeta.getId() %>" size=5></td>
            <td><input type="text" name="numero" id="numero" value="<%=tarjeta.getNumero() %>" size=5></td>
            <td><input type="text" name="cupoDisponible" id="cupoDisponible" value="<%=tarjeta.getCupoDisponible() %>" size=5></td>
            <td><input type="text" name="cupoMaximo" id="cupoMaximo" value="<%=tarjeta.getCupoMaximo() %>" size=5></td>
            <td><input type="text" name="contrasenha" id="contrasenha" value="<%=tarjeta.getContrasenha() %>" size=5></td>
            <td><input type="text" name="numComprobacion" id="numComprobacion" value="<%=tarjeta.getNumComprobacion() %>" size=5></td>
            <td><input type="text" name="tipo" id="tipo" value="<%=tarjeta.getTipo() %>" size=5></td>
            <td><input type="text" name="bloqueada" id="bloqueada" value="<%=tarjeta.isBloqueada() %>" size=5></td> 
           
            
           

            
            <td><input type="submit" value="Bloquear" /></td>
            
                
        </form>
        
        </tr>
        
    

       
        
    </table>
   <!--   ${ pageContext.request.contextPath}/Banco/Modificar-->
</body>
</html>