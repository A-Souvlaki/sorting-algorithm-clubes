package model;

import java.io.Serializable;

public class Tecnica implements Comparable<Tecnica>,Serializable{
	private String nombreTecnica;
	private int factorDeInfluencia;
	private Tecnica siguiente;
	
	public Tecnica(String nombreTecnica, int factorDeInfluencia, Tecnica siguiente) {
		this.nombreTecnica = nombreTecnica;
		this.factorDeInfluencia = factorDeInfluencia;
		this.siguiente = siguiente;
	}
	
	public Tecnica(String nombreTecnica, int factorDeInfluencia) {
		this.nombreTecnica = nombreTecnica;
		this.factorDeInfluencia = factorDeInfluencia;
	}

	public String getNombreTecnica() {
		return nombreTecnica;
	}

	public void setNombreTecnica(String nombreTecnica) {
		this.nombreTecnica = nombreTecnica; 
	}

	public double getFactorDeInfluencia() {
		return factorDeInfluencia;
	}

	public void setFactorDeInfluencia(int factorDeInfluencia) {
		this.factorDeInfluencia = factorDeInfluencia;
	}

	public Tecnica getSiguiente() {
		return siguiente;
	}

	public void setSiguiente(Tecnica siguiente) {
		this.siguiente = siguiente;
	}

	@Override
	public String toString() {
		return "Tecnica [nombreTecnica: " + nombreTecnica + ", factorDeInfluencia: " + factorDeInfluencia + "]";
	}

	@Override
	public int compareTo(Tecnica o) {
		return nombreTecnica.compareTo(o.getNombreTecnica());
	}
	
	

	

	
	

	
	
}
