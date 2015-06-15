package es.examenPes.controler.ejb;

import java.util.ArrayList;




import es.examenPes.controller.BuscarPorIdControler;
import es.examenPes.model.entity.TarjetaCredito;
import es.examenPes.persistence.model.jdbc.TarjetaDaoJdbc;

public class BuscarPorIdControlerEjb implements BuscarPorIdControler{
	
public TarjetaCredito buscarPorId(int id ) {
		
		TarjetaDaoJdbc daoTarjeta = new TarjetaDaoJdbc();
		TarjetaCredito tarjeta = daoTarjeta.buscarPorId(id);
		return tarjeta;
		
	}

}
