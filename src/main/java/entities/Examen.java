package entities;

import java.time.LocalDate;

public class Examen {
	String legajo;
	int idMateria;
	LocalDate fecha;
	String estado;
	double nota;
	
	public String getLegajo() {
		return legajo;
	}
	
	public void setLegajo(String legajo) {
		this.legajo = legajo;
	}
	
	public int getIdMateria() {
		return idMateria;
	}
	
	public void setIdMateria(int idMateria) {
		this.idMateria = idMateria;
	}
	
	public LocalDate getFecha() {
		return fecha;
	}
	
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	
	public String getEstado() {
		return estado;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public double getNota() {
		return nota;
	}
	
	public void setNota(double nota) {
		this.nota = nota;
	}
}
