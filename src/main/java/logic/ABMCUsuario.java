package logic;

import data.DataUsuario;
import entities.Usuario;

public class ABMCUsuario {
	private DataUsuario dataUsuario;
	
	public ABMCUsuario() {
		dataUsuario = new DataUsuario();
	}
	
	public Usuario alta(Usuario nuevoUsuario) {
		nuevoUsuario = dataUsuario.create(nuevoUsuario);
		
		return nuevoUsuario;
	}
	
	public Usuario baja(Usuario unUsuario) {
		unUsuario = dataUsuario.delete(unUsuario);
		
		return unUsuario;
	}
	
	public Usuario modificacion(Usuario unUsuario) {
		unUsuario = dataUsuario.update(unUsuario);
		
		return unUsuario;
	}
	
	public Usuario consulta(Usuario unUsuario) {
		unUsuario = dataUsuario.getOne(unUsuario);
		
		return unUsuario;
	}
}
