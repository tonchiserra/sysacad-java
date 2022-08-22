package entities;

import java.time.LocalDateTime;

public class Mesa {
	private int llamado;
	private LocalDateTime fechaHora;
	private int idMateria;
	
	public int getLlamado() {
		return llamado;
	}
	
	public void setLlamado(int llamado) {
		this.llamado = llamado;
	}
	
	public LocalDateTime getFechaHora() {
		return fechaHora;
	}
	
	public void setFechaHora(LocalDateTime fechaHora) {
		this.fechaHora = fechaHora;
	}
	
	public int getIdMateria() {
		return idMateria;
	}
	
	public void setIdMateria(int idMateria) {
		this.idMateria = idMateria;
	}
}
