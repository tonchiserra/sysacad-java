package entities;

public class Materia {
	private int idMateria;
	private String nombre;
	private String descripcion;
	private int anio;
	private int idCarrera;
	private int plan;
	
	public int getIdMateria() {
		return idMateria;
	}
	
	public void setIdMateria(int idMateria) {
		this.idMateria = idMateria;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public int getAnio() {
		return anio;
	}
	
	public void setAnio(int anio) {
		this.anio = anio;
	}
	
	public int getIdCarrera() {
		return idCarrera;
	}
	
	public void setIdCarrera(int idCarrera) {
		this.idCarrera = idCarrera;
	}
	
	public int getPlan() {
		return plan;
	}
	
	public void setPlan(int plan) {
		this.plan = plan;
	}
}
