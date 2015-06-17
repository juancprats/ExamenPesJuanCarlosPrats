package es.examenPes.controler.ejb;

import java.util.ArrayList;


import es.examenPes.controler.ModificarPorCupoController;
import es.examenPes.model.entity.TarjetaCredito;
import es.examenPes.persistence.model.dao.TarjetaDao;
import es.examenPes.persistence.model.jdbc.TarjetaDaoJdbc;

public class ModificarPorCupoControllerEjb implements ModificarPorCupoController{
public ArrayList<TarjetaCredito> buscarPorId(int id) {
		
		TarjetaDaoJdbc daoTarjeta = new TarjetaDaoJdbc();
		ArrayList<TarjetaCredito> clientes = new ArrayList<TarjetaCredito>(); /*daoTarjeta.searchById(id);*/
		return clientes;
		
	}

@Override
public void actualizar(TarjetaCredito actualizado) {
	TarjetaDao tarjetaDao = new TarjetaDaoJdbc();
	/*tarjetaDao.updatecupo(actualizado);*/
	
}
}
