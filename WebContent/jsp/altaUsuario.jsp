<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../Templates/cabecera.jsp"%>
<form action="../Banco/compruebaUsuario" method="post" enctype="text/html"
    name="form1">
    <fieldset>
        <legend>Validacion de usuario</legend>

        <label>Usuario:</label> <input type="text" name="usuario" required="required" /> 
            <label>Contraseña:</label> <input type="text" name="clave" required="required" /> </br>
             <input type="reset" name="borrar" value="BORRAR" /> 
             <input type="submit" name="enviar" value="ENVIAR" />

    </fieldset>
</form>

<%@ include file="../Templates/pie.jsp"%>