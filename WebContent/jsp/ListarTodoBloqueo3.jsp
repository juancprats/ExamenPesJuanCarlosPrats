<%@page import="es.examenPes.model.entity.TarjetaCredito"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../Templates/cabecera.jsp"%>

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

		<td>La tarjeta número <%=tarjeta.getNumero() %> está bloqueada
		</td>


	</tr>





</table>
<!--   ${ pageContext.request.contextPath}/Banco/Modificar-->
<%@ include file="../Templates/pie.jsp"%>