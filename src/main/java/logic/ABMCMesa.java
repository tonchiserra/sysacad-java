package logic;

import data.DataMesa;
import entities.Mesa;

public class ABMCMesa {
	private DataMesa dataMesa;
	
	public ABMCMesa() {
		dataMesa = new DataMesa();
	}
	
	public Mesa alta(Mesa nuevaMesa) {
		nuevaMesa = dataMesa.create(nuevaMesa);
		
		return nuevaMesa;
	}
	
	public Mesa baja(Mesa unaMesa) {
		unaMesa = dataMesa.delete(unaMesa);
		
		return unaMesa;
	}
	
	public Mesa modificacion(Mesa unaMesa) {
		unaMesa = dataMesa.update(unaMesa);
		
		return unaMesa;
	}
	
	public Mesa consulta(Mesa unaMesa) {
		unaMesa = dataMesa.getOne(unaMesa);
		
		return unaMesa;
	}
}
