<%@page import="es.examenPes.model.entity.TarjetaCredito"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../Templates/cabecera.jsp"%>
<script type="text/javascript">
function enviar(boton){
      // asigna al formulario el formulario que está en la lista de formularios en la 
      //posición indicada por el nombre del botón pulsado, que lleva un secuencial
      var formulario=document.forms.item(boton.name)
     
      // alteramos el actión según el botón pulsado
      switch (boton.value){
      case "Ampliar":
          formulario.action="${ pageContext.request.contextPath}/Banco/buscarParaAmpliar";
          formulario.submit();
          break;
      
        //el editar no funciona, hay q hacerlo como Manuel ha hecho modificar
      case "Bloquear":

          document.getElementById("numero " + boton.name).disabled=false;
          document.getElementById("cupoMaximo " + boton.name).disabled=false;
          document.getElementById("cupoMaximo " + boton.name).disabled=false;
          document.getElementById("tipo " + boton.name).disabled=false;
          break;
      }
  }
</script>
<%ArrayList<TarjetaCredito> tarjeta = (ArrayList<TarjetaCredito>) request.getAttribute("tarjetas");%>
<table>
	<tr>
		<th>ID</th>
		<th>Numero</th>
		<th>Cupo máximo</th>
		<th>Cupo disponible</th>
		<th>Tipo</th>

	</tr>
	<!-- Las siguientes se cargan dinamicamente -->
	<% int n=1; %>
	<%for (TarjetaCredito t : tarjeta) {%>


	<tr>
		<form
			action="${ pageContext.request.contextPath}/Banco/buscarParaAmpliar"
			method="post">
			<td><input type="text" name="id" id="id <%=n %>"
				value="<%=t.getId()%>" size=5></td>
			<td><input type="text" name="numero" id="numero <%=n %>"
				value="<%=t.getNumero()%>" size=5></td>
			<td><input type="text" name="cupoMaximo" id="cupoMaximo <%=n %>"
				value="<%=t.getCupoMaximo()%>" size=5></td>
			<td><input type="text" name="cupoDisponible"
				id="cupoDisponible <%=n %>" value="<%=t.getCupoDisponible()%>"
				size=5></td>
			<td><input type="text" name="tipo" id="tipo <%=n %>"
				value="<%=t.getTipo()%>" size=5></td>



			<td><input type="submit" value="Ampliar" name="ampliar" /></td>


		</form>

	</tr>
	<%n++; %>


	<%}%>

</table>
<!--   ${ pageContext.request.contextPath}/Banco/Modificar-->
<%@ include file="../Templates/pie.jsp"%>