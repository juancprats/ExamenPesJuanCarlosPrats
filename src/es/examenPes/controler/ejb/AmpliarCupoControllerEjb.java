package es.examenPes.controler.ejb;

import java.util.ArrayList;





import es.examenPes.controller.AmpliarCupoController;
import es.examenPes.model.entity.TarjetaCredito;
import es.examenPes.persistence.model.dao.TarjetaDao;
import es.examenPes.persistence.model.jdbc.TarjetaDaoJdbc;

public class AmpliarCupoControllerEjb implements AmpliarCupoController{

	public TarjetaCredito aumentacupo(TarjetaCredito actualizado, int aumento) {
		TarjetaDaoJdbc daoTarjeta = new TarjetaDaoJdbc();
		TarjetaCredito tarjeta = daoTarjeta.updatecupo(actualizado,aumento);
		return tarjeta;
		
	}
	
	public void actualizar(int id, int aumento) {
		TarjetaDao tarjetaDao = new TarjetaDaoJdbc();
		tarjetaDao.updatecupo(id, aumento);
		
	}

	
}
