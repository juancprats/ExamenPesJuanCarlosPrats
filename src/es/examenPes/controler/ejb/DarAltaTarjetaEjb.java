package es.examenPes.controler.ejb;

import es.examenPes.model.entity.TarjetaCredito;
import es.examenPes.persistence.model.dao.TarjetaDao;
import es.examenPes.persistence.model.jdbc.TarjetaDaoJdbc;

public class DarAltaTarjetaEjb {
	private TarjetaDao tarjetaDao;
	public void agregar(TarjetaCredito tarjeta){
	tarjetaDao = new TarjetaDaoJdbc();
	tarjetaDao.create(tarjeta);
	}

}
