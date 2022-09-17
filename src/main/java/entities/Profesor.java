package entities;

public class Profesor extends Usuario {
	private double sueldo;
	
	public Profesor() {
		super();
	}

	public double getSueldo() {
		return sueldo;
	}

	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}
}
