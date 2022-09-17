package logic;

import java.util.LinkedList;

import data.*;
import entities.*;

public class Login {
	private DataUsuario dataUsuario;
	
	public Login() {
		dataUsuario = new DataUsuario();
	}
	
	public Usuario validate(Usuario unUsuario) {
		/* para hacer más seguro el manejo de passwords este sería un lugar 
		 * adecuado para generar un hash de la password utilizando un cifrado
		 * asimétrico como sha256 y utilizar el hash en lugar de la password en plano 
		 */
		return dataUsuario.getByUser(unUsuario);
	}
}
