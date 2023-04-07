package logic;

import java.util.LinkedList;

import data.DataExamen;

public class Examen {
	private DataExamen dataExamen;
	
	public Examen() {
		dataExamen = new DataExamen();
	}
	
	public LinkedList<entities.Examen> consulta(entities.Examen unExamen) {
		LinkedList<entities.Examen> losExamenes = new LinkedList<>();
		
		losExamenes = dataExamen.getByLegajo(unExamen);
		
		return losExamenes;
	}
}
