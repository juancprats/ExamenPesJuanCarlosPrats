package es.examenPes.controler.ejb;

import java.util.ArrayList;




import es.examenPes.controller.BuscarPorIdControler;
import es.examenPes.model.entity.TarjetaCredito;
import es.examenPes.persistence.model.jdbc.TarjetaDaoJdbc;

public class BuscarPorIdControlerEjb implements BuscarPorIdControler{
	
public ArrayList<TarjetaCredito> buscarPorId(int id ) {
		
		TarjetaDaoJdbc daoTarjeta = new TarjetaDaoJdbc();
		ArrayList<TarjetaCredito> tarjeta = daoTarjeta.buscarPorId(id);
		return tarjeta;
		
	}

}
