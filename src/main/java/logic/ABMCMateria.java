package logic;

import data.DataMateria;
import entities.Materia;

public class ABMCMateria {
	private DataMateria dataMateria;
	
	public ABMCMateria() {
		dataMateria = new DataMateria();
	}
	
	public Materia alta(Materia nuevaMateria) {
		nuevaMateria = dataMateria.create(nuevaMateria);
		
		return nuevaMateria;
	}
	
	public Materia baja(Materia unaMateria) {
		unaMateria = dataMateria.delete(unaMateria);
		
		return unaMateria;
	}
	
	public Materia modificacion(Materia unaMateria) {
		unaMateria = dataMateria.update(unaMateria);
		
		return unaMateria;
	}
	
	public Materia consulta(Materia unaMateria) {
		unaMateria = dataMateria.getOne(unaMateria);
		
		return unaMateria;
	}
}
