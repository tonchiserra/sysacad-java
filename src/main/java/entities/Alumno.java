package entities;

public class Alumno extends Usuario {
	private int idCarrera;
	
	public Alumno() {
		super();
	}

	public int getIdCarrera() {
		return idCarrera;
	}

	public void setIdCarrera(int idCarrera) {
		this.idCarrera = idCarrera;
	}
}