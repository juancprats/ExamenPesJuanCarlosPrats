package es.examenPes.persistence.model.dao;

import java.util.ArrayList;

import es.examenPes.model.entity.TarjetaCredito;

public interface TarjetaDao {
	
	public void create(TarjetaCredito tarjeta);

	ArrayList<TarjetaCredito> findAll();

	ArrayList<TarjetaCredito> buscarPorId(int id);

}
