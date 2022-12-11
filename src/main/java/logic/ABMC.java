package logic;

import data.DataCarrera;
import entities.Carrera;

public class ABMC {
	private DataCarrera dataCarrera;
	
	public ABMC() {
		dataCarrera = new DataCarrera();
	}
	
	public Carrera alta(Carrera nuevaCarrera) {
		nuevaCarrera = dataCarrera.create(nuevaCarrera);
		
		return nuevaCarrera;
	}
}
