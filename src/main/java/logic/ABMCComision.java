package logic;

import data.DataComision;
import entities.Comision;

public class ABMCComision {
	private DataComision dataComision;
	
	public ABMCComision() {
		dataComision = new DataComision();
	}
	
	public Comision alta(Comision nuevaComision) {
		nuevaComision = dataComision.create(nuevaComision);
		
		return nuevaComision;
	}
	
	public Comision baja(Comision unaComision) {
		unaComision = dataComision.delete(unaComision);
		
		return unaComision;
	}
	
	public Comision modificacion(Comision unaComision) {
		unaComision = dataComision.update(unaComision);
		
		return unaComision;
	}
	
	public Comision consulta(Comision unaComision) {
		unaComision = dataComision.getOne(unaComision);
		
		return unaComision;
	}
}
