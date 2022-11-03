package entities;

import java.time.LocalDateTime;

public class Examen {
	private int legajo;
	private int idMateria;
	private LocalDateTime fecha;
	private String estado;
	private double nota;
	
	public int getLegajo() {
		return legajo;
	}
	
	public void setLegajo(int legajo) {
		this.legajo = legajo;
	}
	
	public int getIdMateria() {
		return idMateria;
	}
	
	public void setIdMateria(int idMateria) {
		this.idMateria = idMateria;
	}
	
	public LocalDateTime getFecha() {
		return fecha;
	}
	
	public void setFecha(LocalDateTime fecha) {
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
