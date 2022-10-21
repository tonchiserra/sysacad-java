package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import entities.Carrera;
import entities.Materia;

public class DataMateria {
	
	public Materia create(Materia newMateria) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = DBConnector.getInstancia().getConnection().prepareStatement(
					"insert into materia (nombre, descripcion, anio, idCarrera) values (?, ?, ?, ?)",
					PreparedStatement.RETURN_GENERATED_KEYS
					);
			stmt.setString(1, newMateria.getNombre());
			stmt.setString(2, newMateria.getDescripcion());
			stmt.setInt(3, newMateria.getAnio());
			stmt.setInt(4, newMateria.getIdCarrera());
			stmt.executeUpdate();
			
			rs = stmt.getGeneratedKeys();
			
			while(rs != null && rs.next()) {
				newMateria.setIdMateria(rs.getInt(1));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) {rs.close();}
				if(stmt!=null) {stmt.close();}
				DBConnector.getInstancia().releaseConnection();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		return newMateria;
	}
	
	public LinkedList<Materia> getAll() {
		LinkedList<Materia> materias = new LinkedList<>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = DBConnector.getInstancia().getConnection().prepareStatement(
					"select idMateria, nombre, descripcion, anio, idCarrera from materia"
					);
			rs = stmt.executeQuery();
			
			while(rs != null && rs.next()) {
				Materia unaMateria = new Materia();
				
				unaMateria.setIdMateria(rs.getInt("idMateria"));
				unaMateria.setNombre(rs.getString("nombre"));
				unaMateria.setDescripcion(rs.getString("descripcion"));
				unaMateria.setAnio(rs.getInt("anio"));
				unaMateria.setIdCarrera(rs.getInt("idCarrera"));
				
				materias.add(unaMateria);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) { rs.close(); }
				if(stmt != null) { stmt.close(); }
				DBConnector.getInstancia().releaseConnection();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		return materias;
	}
	
	public Materia update(Materia unaMateria) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = DBConnector.getInstancia().getConnection().prepareStatement(
					"delete from materia where idMateria=?"
					);
			stmt.setInt(1, unaMateria.getIdMateria());
			stmt.executeUpdate();
			
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
		
		return unaMateria;
	}
	
	public Materia delete(Materia unaMateria) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = DBConnector.getInstancia().getConnection().prepareStatement(
					"update materia set nombre = ?, descripcion = ?, anio = ?, idCarrera = ? where idMateria = ?"
					);
			stmt.setString(1, unaMateria.getNombre());
			stmt.setString(2, unaMateria.getDescripcion());
			stmt.setInt(3, unaMateria.getAnio());
			stmt.setInt(4, unaMateria.getIdCarrera());
			stmt.setInt(5, unaMateria.getIdMateria());
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

		return unaMateria;
	}
}
