package es.examenPes.model.entity;

public class TarjetaCredito {
	private int id;
	private String numero;
	private int cupoMaximo;
	private int cupoDisponible;
	private String tipo;
	private String numComprobacion;
	private String contrasenha;
	private boolean bloqueada;
	
	
	public TarjetaCredito(int id, String numero, int cupoMaximo,
			int cupoDisponible, String tipo, String numComprobacion,
			String contrasenha, boolean bloqueada) {
		super();
		this.id = id;
		this.numero = numero;
		this.cupoMaximo = cupoMaximo;
		this.cupoDisponible = cupoDisponible;
		this.tipo = tipo;
		this.numComprobacion = numComprobacion;
		this.contrasenha = contrasenha;
		this.bloqueada = bloqueada;
	}


	public TarjetaCredito() {
		super();
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNumero() {
		return numero;
	}


	public void setNumero(String numero) {
		this.numero = numero;
	}


	public int getCupoMaximo() {
		return cupoMaximo;
	}


	public void setCupoMaximo(int cupoMaximo) {
		this.cupoMaximo = cupoMaximo;
	}


	public int getCupoDisponible() {
		return cupoDisponible;
	}


	public void setCupoDisponible(int cupoDisponible) {
		this.cupoDisponible = cupoDisponible;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public String getNumComprobacion() {
		return numComprobacion;
	}


	public void setNumComprobacion(String numComprobacion) {
		this.numComprobacion = numComprobacion;
	}


	public String getContrasenha() {
		return contrasenha;
	}


	public void setContrasenha(String contrasenha) {
		this.contrasenha = contrasenha;
	}


	public boolean isBloqueada() {
		return bloqueada;
	}


	public void setBloqueada(boolean bloqueada) {
		this.bloqueada = bloqueada;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (bloqueada ? 1231 : 1237);
		result = prime * result
				+ ((contrasenha == null) ? 0 : contrasenha.hashCode());
		result = prime * result + cupoDisponible;
		result = prime * result + cupoMaximo;
		result = prime * result + id;
		result = prime * result
				+ ((numComprobacion == null) ? 0 : numComprobacion.hashCode());
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TarjetaCredito other = (TarjetaCredito) obj;
		if (bloqueada != other.bloqueada)
			return false;
		if (contrasenha == null) {
			if (other.contrasenha != null)
				return false;
		} else if (!contrasenha.equals(other.contrasenha))
			return false;
		if (cupoDisponible != other.cupoDisponible)
			return false;
		if (cupoMaximo != other.cupoMaximo)
			return false;
		if (id != other.id)
			return false;
		if (numComprobacion == null) {
			if (other.numComprobacion != null)
				return false;
		} else if (!numComprobacion.equals(other.numComprobacion))
			return false;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		return true;
	}
	
	
	
	
}
