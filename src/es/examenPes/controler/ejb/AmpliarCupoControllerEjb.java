package es.examenPes.controler.ejb;

import java.util.ArrayList;





import es.examenPes.controller.AmpliarCupoController;
import es.examenPes.model.entity.TarjetaCredito;
import es.examenPes.persistence.model.dao.TarjetaDao;
import es.examenPes.persistence.model.jdbc.TarjetaDaoJdbc;

public class AmpliarCupoControllerEjb implements AmpliarCupoController{

	public TarjetaCredito aumentacupo(TarjetaCredito t, int aumento) {
		TarjetaDaoJdbc daoTarjeta = new TarjetaDaoJdbc();
		
		int parcial = t.getCupoDisponible();
		int aumentado=aumento+parcial;
		daoTarjeta.updatecupo(t, aumentado);
		t.setCupoDisponible(aumentado);
		return t;
		
		
	}
	
	/*public void actualizar(int id, int aumento) {
		TarjetaDao tarjetaDao = new TarjetaDaoJdbc();
		tarjetaDao.updatecupo(id, aumento);
		
	}*/

	
}
