package logic;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import data.DataExamen;
import data.DataUsuario;
import entities.Examen;
import entities.Usuario;

public class Inscripcion {
	private DataUsuario dataUsuario;
	private DataExamen dataExamen;
	
	public Inscripcion() {
		dataUsuario = new DataUsuario();
		dataExamen = new DataExamen();
	}
	
	public Examen validate(Examen unExamen, String unaFecha) {
		unExamen = dataExamen.getOne(unExamen);
		
		if(unExamen.getEstado().equalsIgnoreCase("regular")) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
			String[] fecha = unaFecha.split("T");
 			unaFecha = fecha[0] + " " + fecha[1];
			LocalDateTime dateTime = LocalDateTime.parse(unaFecha, formatter);
			
			unExamen.setFecha(dateTime);
			unExamen.setEstado("a rendir");
			unExamen.setNota(0);
			unExamen = dataExamen.update(unExamen);
		}
		
		return unExamen;
	}
}
