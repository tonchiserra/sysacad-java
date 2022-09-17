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
		/* para hacer m�s seguro el manejo de passwords este ser�a un lugar 
		 * adecuado para generar un hash de la password utilizando un cifrado
		 * asim�trico como sha256 y utilizar el hash en lugar de la password en plano 
		 */
		return dataUsuario.getByUser(unUsuario);
	}
}
