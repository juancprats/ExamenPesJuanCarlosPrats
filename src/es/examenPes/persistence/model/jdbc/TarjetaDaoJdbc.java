package es.examenPes.persistence.model.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import es.examenPes.model.entity.TarjetaCredito;
import es.examenPes.persistence.model.dao.TarjetaDao;

public class TarjetaDaoJdbc implements TarjetaDao {
	
	Connection cx;

	public TarjetaDaoJdbc() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	private void abrirConexion() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			cx = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/Banco", "root",
					"root");
			
			cx.setAutoCommit(false);
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

	}

	private void cerrarConexion() {
		try {
			if (cx != null)
				cx.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void create(TarjetaCredito tarjeta) {
		abrirConexion();
		try {
		PreparedStatement ps = cx
				.prepareStatement("INSERT INTO tarjetacredito VALUES(?,?,?,?,?,?,?,?)");
		
		ps.setInt(1, 0);
		ps.setString(2, tarjeta.getNumero());
		ps.setInt(3, tarjeta.getCupoMaximo());
		ps.setInt(4, tarjeta.getCupoDisponible());
		ps.setString(5, tarjeta.getTipo());
		ps.setString(6, tarjeta.getNumComprobacion());
	    ps.setString(7, tarjeta.getContrasenha());
	    ps.setBoolean(8, tarjeta.isBloqueada());
			
			ps.executeUpdate();
			cx.commit();
		} catch (SQLException e) {
			
			try {
				cx.rollback();
			} catch (SQLException e1) {
			
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		
		finally {
			cerrarConexion();
		}

	}
	
	@Override
	public ArrayList<TarjetaCredito> findAll() {
		ArrayList<TarjetaCredito> tarjeta = new ArrayList<TarjetaCredito>();
		try {
			abrirConexion();

			PreparedStatement ps = cx.prepareStatement("SELECT * FROM tarjetacredito");
			ResultSet consulta = ps.executeQuery();
			while (consulta.next()) {
				TarjetaCredito tarjetaTemporal = new TarjetaCredito();
				tarjetaTemporal.setId(consulta.getInt("id"));
				tarjetaTemporal.setNumero(consulta.getString("numero"));
				tarjetaTemporal.setCupoMaximo(consulta.getInt("cupoMaximo"));
				tarjetaTemporal.setCupoDisponible(consulta.getInt("cupoDisponible"));
				tarjetaTemporal.setTipo(consulta.getString("tipo"));
				tarjetaTemporal.setNumComprobacion(consulta.getString("numComprobacion"));
				tarjetaTemporal.setContrasenha(consulta.getString("contrasenha"));
				tarjetaTemporal.setBloqueada(true);
				
				tarjeta.add(tarjetaTemporal);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			cerrarConexion();
		}
		return tarjeta;
	}
	
	
	public TarjetaCredito buscarPorId(int id) {
		
		TarjetaCredito tarjeta =new TarjetaCredito();
		abrirConexion();
		try {
			PreparedStatement ps = cx.prepareStatement("SELECT * FROM tarjetacredito WHERE id= ?");
			ps.setInt(1, id);
			ResultSet consulta = ps.executeQuery();
			consulta.next();
				tarjeta.setId(consulta.getInt("id"));
				tarjeta.setNumero(consulta.getString("numero"));
				tarjeta.setCupoMaximo(consulta.getInt("cupoMaximo"));
				tarjeta.setCupoDisponible(consulta.getInt("cupoDisponible"));
				tarjeta.setTipo(consulta.getString("tipo"));
				tarjeta.setNumComprobacion(consulta.getNString("numComprobacion"));
				tarjeta.setContrasenha(consulta.getString("contrasenha"));
				tarjeta.setBloqueada(true);

				
			}
				
		 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	
		return tarjeta;
	}

	
public TarjetaCredito buscarParaAumento(int id, int aumento) {
		
		TarjetaCredito tarjeta = new TarjetaCredito();
		abrirConexion();
		try {
			PreparedStatement ps = cx.prepareStatement("SELECT * FROM tarjetacredito WHERE id LIKE ?");
			ps.setInt(1, id );
			ResultSet consulta = ps.executeQuery();
			consulta.next();
				
			tarjeta.setId(consulta.getInt("id"));
			tarjeta.setNumero(consulta.getString("numero"));
			tarjeta.setCupoMaximo(consulta.getInt("cupoMaximo")+aumento);
			tarjeta.setCupoDisponible(consulta.getInt("cupoDisponible"));
			tarjeta.setTipo(consulta.getString("tipo"));
			tarjeta.setNumComprobacion(consulta.getString("numComprobacion"));
			tarjeta.setContrasenha(consulta.getString("contrasenha"));
			tarjeta.setBloqueada(true);

				
			
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	
		return tarjeta;
	}

	@Override
	public void updatecupo(TarjetaCredito t,int aumento) {
		abrirConexion();
		PreparedStatement ps;
		try {
			ps = cx.prepareStatement("UPDATE tarjetacredito SET cupoDisponible=?  WHERE id = ?");				
				ps.setInt(1, aumento);				
				ps.setInt(2, t.getId());
				
				 ps.executeUpdate();
				 cx.commit();				
			}
		 catch (SQLException e) {
			 try {
				cx.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		finally {
			cerrarConexion();
	}

	}



	public void updateBloqueo(TarjetaCredito actualizadobloqueo) {
		abrirConexion();
		PreparedStatement ps;
		try {
		ps = cx.prepareStatement("UPDATE tarjetacredito SET bloqueada=true  WHERE id = ?");				
						
		
			ps.setInt(1, actualizadobloqueo.getId());
			ps.executeUpdate();
			 cx.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 	
		 
		 
	}



	





	

}
