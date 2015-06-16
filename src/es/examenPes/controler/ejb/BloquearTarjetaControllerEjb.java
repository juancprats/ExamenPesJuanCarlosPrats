package es.examenPes.controler.ejb;

import es.examenPes.controller.BloquearTarjetaController;
import es.examenPes.model.entity.TarjetaCredito;
import es.examenPes.persistence.model.jdbc.TarjetaDaoJdbc;

public class BloquearTarjetaControllerEjb implements BloquearTarjetaController{
	public TarjetaCredito bloqueada(TarjetaCredito actualizadobloqueo){
		TarjetaDaoJdbc daoTarjeta = new TarjetaDaoJdbc();
		
		boolean b = actualizadobloqueo.isBloqueada();
		if (b){
			actualizadobloqueo.setBloqueada(true);
		}
		daoTarjeta.updateBloqueo(actualizadobloqueo);
		return actualizadobloqueo;
		
		
	}
}
