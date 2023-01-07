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
	
	public Carrera baja(Carrera unaCarrera) {
		unaCarrera = dataCarrera.delete(unaCarrera);
		
		return unaCarrera;
	}
	
	public Carrera modificacion(Carrera unaCarrera) {
		unaCarrera = dataCarrera.update(unaCarrera);
		
		return unaCarrera;
	}
	
	public Carrera consulta(Carrera unaCarrera) {
		unaCarrera = dataCarrera.getOne(unaCarrera);
		
		return unaCarrera;
	}
}
