<%@page import="es.examenPes.model.entity.TarjetaCredito"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Tarjeta actualizada</title>
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
      
        
        
            
        <tr>
        
            <td>La tarjeta número  <%=tarjeta.getNumero() %>  está bloqueada</td>
           
                 
        </tr>
        
    

       
        
    </table>
   <!--   ${ pageContext.request.contextPath}/Banco/Modificar-->
</body>
</html>