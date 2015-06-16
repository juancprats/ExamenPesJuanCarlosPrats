<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../Templates/cabecera.jsp"%>
<form action="../Banco/altaTarjeta" method="post" enctype="text/html"
	name="form1">
	<fieldset>
		<legend>Alta de Tarjeta</legend>

		<label>Número de tarjeta:</label> <input type="text" name="numero"
			required="required" /> <label>Cupo máximo:</label> <input type="text"
			name="cupoMaximo" required="required" /> <label>Cupo
			disponible:</label> <input type="text" name="cupoDisponible"
			required="required" /> <label>Tipo (Visa/Master Card):</label> <input
			type="text" name="tipo" required="required" /> <label>Número
			comprobación:</label> <input type="text" name="numComprobacion"
			required="required" /> <label>Contraseña:</label> <input type="text"
			name="contrasenha" required="required" /> <label>Bloqueada:</label> <input
			type="text" name="bloqueada" required="required" /> <input
			type="hidden" name="id" id="id" /> <br> <br> <input
			type="reset" name="borrar" value="BORRAR" /> <input type="submit"
			name="enviar" value="ENVIAR" />

	</fieldset>
</form>

<%@ include file="../Templates/pie.jsp"%>