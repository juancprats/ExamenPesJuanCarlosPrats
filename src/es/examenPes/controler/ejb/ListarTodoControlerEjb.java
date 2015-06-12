package es.examenPes.controler.ejb;

import java.util.ArrayList;

import es.examenPes.model.entity.TarjetaCredito;
import es.examenPes.persistence.model.jdbc.TarjetaDaoJdbc;



public class ListarTodoControlerEjb {
	public ArrayList<TarjetaCredito> listarTodos() {
		// TODO Auto-generated method stub
		TarjetaDaoJdbc daoTarjeta = new TarjetaDaoJdbc();
		ArrayList<TarjetaCredito> tarjeta = daoTarjeta.findAll();
		return tarjeta;
	}

}
