package data;

import entities.*;

import java.sql.*;

public class DataUsuario {
	
	public Usuario create(Usuario newUsuario) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = DBConnector.getInstancia().getConnection().prepareStatement(
					"insert into usuario (legajo, contrasenia, nombre, apellido, dni, email, idCarrera, sueldo) values (?, ?, ?, ?, ? ,?, ?, ?)",
					PreparedStatement.RETURN_GENERATED_KEYS
					);
			stmt.setInt(1, newUsuario.getLegajo());
			stmt.setString(2, newUsuario.getContrasenia());
			stmt.setString(3, newUsuario.getNombre());
			stmt.setString(4, newUsuario.getApellido());
			stmt.setString(5, newUsuario.getDNI());
			stmt.setString(6, newUsuario.getEmail());
		
			if(newUsuario.getClass() == Profesor.class) {
				stmt.setObject(7, null);
				double sueldo = ((Profesor) newUsuario).getSueldo();
				stmt.setDouble(8, sueldo);
			} else {
				int idCarrera = ((Alumno) newUsuario).getIdCarrera();
				stmt.setInt(7, idCarrera);
				stmt.setObject(8, null);
			}
			
			stmt.executeUpdate();
			
			rs = stmt.getGeneratedKeys();
			
			while(rs != null && rs.next()) {						
				newUsuario.setLegajo(rs.getInt(1));
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) {rs.close();}
				if(stmt!=null) {stmt.close();}
				DBConnector.getInstancia().releaseConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return newUsuario;
	}
	
	public Usuario getByUser(Usuario user) {
		
		Usuario newUser = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = DBConnector.getInstancia().getConnection().prepareStatement(
					"select legajo,nombre,apellido,dni,email,sueldo,idCarrera from usuario where legajo=? and contrasenia=?"
					);
			stmt.setInt(1, user.getLegajo());
			stmt.setString(2, user.getContrasenia());
			rs = stmt.executeQuery();
			
			if(rs!=null && rs.next()) {
				
				if(rs.getDouble("sueldo") > 0) {
					newUser = new Profesor();
					((Profesor) newUser).setSueldo(rs.getDouble("sueldo"));
				}else {
					newUser = new Alumno();
					((Alumno) newUser).setIdCarrera(rs.getInt("idCarrera"));
				}
				
				newUser.setLegajo(rs.getInt("legajo"));
				newUser.setNombre(rs.getString("nombre"));
				newUser.setApellido(rs.getString("apellido"));
				newUser.setDNI(rs.getString("dni"));
				newUser.setEmail(rs.getString("email"));
				
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
	
	public Usuario getOne(Usuario user) {
		Usuario newUser = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = DBConnector.getInstancia().getConnection().prepareStatement(
					"select legajo,nombre,apellido,dni,email,sueldo,idCarrera from usuario where legajo=?"
					);
			stmt.setInt(1, user.getLegajo());
			rs = stmt.executeQuery();
			
			if(rs!=null && rs.next()) {
				
				if(rs.getDouble("sueldo") > 0) {
					newUser = new Profesor();
					((Profesor) newUser).setSueldo(rs.getDouble("sueldo"));
				}else {
					newUser = new Alumno();
					((Alumno) newUser).setIdCarrera(rs.getInt("idCarrera"));
				}
				
				newUser.setLegajo(rs.getInt("legajo"));
				newUser.setNombre(rs.getString("nombre"));
				newUser.setApellido(rs.getString("apellido"));
				newUser.setDNI(rs.getString("dni"));
				newUser.setEmail(rs.getString("email"));
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
	
	public Usuario delete(Usuario unUsuario) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = DBConnector.getInstancia().getConnection().prepareStatement(
					"select legajo, nombre, apellido, dni, email from usuario where legajo=?"
					);
			stmt.setInt(1, unUsuario.getLegajo());
			stmt.setString(2, unUsuario.getNombre());
			stmt.setString(3, unUsuario.getApellido());
			stmt.setString(4, unUsuario.getDNI());
			stmt.setString(5, unUsuario.getEmail());
			rs = stmt.executeQuery();
			
			if(rs != null && rs.next()) {
				unUsuario = new Usuario();
				
				unUsuario.setLegajo(rs.getInt("legajo"));
				unUsuario.setNombre(rs.getString("nombre"));
				unUsuario.setApellido(rs.getString("apellido"));
				unUsuario.setDNI(rs.getString("dni"));
				unUsuario.setEmail(rs.getString("email"));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} 
		
		try {
			stmt = DBConnector.getInstancia().getConnection().prepareStatement(
					"delete from usuario where legajo=?"
					);
			stmt.setInt(1, unUsuario.getLegajo());
			stmt.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
			unUsuario.setNombre(null);
			unUsuario.setApellido(null);
		} finally {
			try {
				if(rs!=null) {rs.close();}
				if(stmt!=null) {stmt.close();}
				DBConnector.getInstancia().releaseConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return unUsuario;
	}
	
	public Usuario update(Usuario unUsuario) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = DBConnector.getInstancia().getConnection().prepareStatement(
					"update usuario set nombre = ?, apellido = ?, email = ?, idCarrera = ?, sueldo = ? where legajo = ?"
					);
			stmt.setString(1, unUsuario.getNombre());
			stmt.setString(2, unUsuario.getApellido());
			stmt.setString(3, unUsuario.getEmail());
			
			if(unUsuario.getClass() == Profesor.class) {
				stmt.setObject(4, null);
				double sueldo = ((Profesor) unUsuario).getSueldo();
				stmt.setDouble(5, sueldo);
			} else {
				int idCarrera = ((Alumno) unUsuario).getIdCarrera();
				stmt.setInt(4, idCarrera);
				stmt.setObject(5, null);
			}
			
			stmt.setInt(6, unUsuario.getLegajo());
			stmt.executeUpdate();

		} catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) { rs.close(); }
				if(stmt != null) { stmt.close(); }
				DBConnector.getInstancia().releaseConnection();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}

		return unUsuario;
	}
}
