package edu.ieu.conversion.socket.sever;

public class TipoCambio {
	private String id;
	private String monedaOrigen;
	private String monedaDestino;
	private Double factorConversion;
	
	public TipoCambio() {	}
	
	public TipoCambio(String id, String monedaOrigen, String monedaDestino, Double factorConversion) {
		this.id = id;
		this.monedaOrigen = monedaOrigen;
		this.monedaDestino = monedaDestino;
		this.factorConversion = factorConversion;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMonedaOrigen() {
		return monedaOrigen;
	}

	public void setMonedaOrigen(String monedaOrigen) {
		this.monedaOrigen = monedaOrigen;
	}

	public String getMonedaDestino() {
		return monedaDestino;
	}

	public void setMonedaDestino(String monedaDestino) {
		this.monedaDestino = monedaDestino;
	}

	public Double getFactorConversion() {
		return factorConversion;
	}

	public void setFactorConversion(Double factorConversion) {
		this.factorConversion = factorConversion;
	}
}

