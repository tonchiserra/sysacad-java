package entities;

import java.time.LocalDateTime;

public class Mesa {
	int llamado;
	LocalDateTime fechaHora;
	int idMateria;
	
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
