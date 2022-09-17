package data;

import entities.*;

import java.sql.*;

public class DataUsuario {
	
	public Usuario getByUser(Usuario user) {
		
		Usuario newUser = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = DBConnector.getInstancia().getConnection().prepareStatement(
					"select legajo,nombre,apellido,dni,email,sueldo,idCarrera from persona where legajo=? and contraseña=?"
					);
			stmt.setInt(1, user.getLegajo());
			stmt.setString(2, user.getContrasena());
			rs = stmt.executeQuery();
			
			if(rs!=null && rs.next()) {
				
				/*if(rs.getDouble("sueldo") > 0) {
					newUser = new Profesor();
				}else {
					newUser = new Alumno();
				}*/
				
				newUser = new Usuario();
				
				newUser.setLegajo(rs.getInt("legajo"));
				newUser.setNombre(rs.getString("nombre"));
				newUser.setApellido(rs.getString("apellido"));
				newUser.setDNI(rs.getString("dni"));
				newUser.setEmail(rs.getString("email"));
				
				//Falta sueldo en cado de profesor y idCarrera en caso de alumno
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) {rs.close();}
				if(stmt!=null) {stmt.close();}
				DBConnector.getInstancia().releaseConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return newUser;
	}
}
