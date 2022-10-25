package data;

import entities.*;

import java.sql.*;
import java.util.LinkedList;

public class DataCarrera {
	
	public Carrera create(Carrera newCarrera) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = DBConnector.getInstancia().getConnection().prepareStatement(
					"insert into carrera (nombre, descripcion) values (?, ?)",
					PreparedStatement.RETURN_GENERATED_KEYS
					);
			stmt.setString(1, newCarrera.getNombre());
			stmt.setString(2, newCarrera.getDescripcion());
			stmt.executeUpdate();
			
			rs = stmt.getGeneratedKeys();
			
			while(rs != null && rs.next()) {						
				newCarrera.setIdCarrera(rs.getInt(1));
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
		
		return newCarrera;
	}
	
	public Carrera getOne(Carrera unaCarrera) {
		Carrera newCarrera = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = DBConnector.getInstancia().getConnection().prepareStatement(
					"select idCarrera, nombre, descripcion from carrera where idCarrera=?"
					);
			stmt.setInt(1, unaCarrera.getIdCarrera());
			rs = stmt.executeQuery();
			
			if(rs != null && rs.next()) {
				newCarrera = new Carrera();
				
				newCarrera.setIdCarrera(rs.getInt("idCarrera"));
				newCarrera.setNombre(rs.getString("nombre"));
				newCarrera.setDescripcion(rs.getString("descripcion"));
			}
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
		
		return newCarrera;
	}
	
	public LinkedList<Carrera> getAll() {
		LinkedList<Carrera> carreras = new LinkedList<>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = DBConnector.getInstancia().getConnection().prepareStatement(
					"select idCarrera, nombre, descripcion from carrera"
					);
			rs = stmt.executeQuery();
			
			while(rs != null && rs.next()) {
				Carrera unaCarrera = new Carrera();
				
				unaCarrera.setIdCarrera(rs.getInt("idCarrera"));
				unaCarrera.setNombre(rs.getString("nombre"));
				unaCarrera.setDescripcion(rs.getString("descripcion"));
				
				carreras.add(unaCarrera);
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
		
		return carreras;
	}
	
	public Carrera update(Carrera unaCarrera) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = DBConnector.getInstancia().getConnection().prepareStatement(
					"delete from carrera where idCarrera=?"
					);
			stmt.setInt(1, unaCarrera.getIdCarrera());
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
		
		return unaCarrera;
	}
	
	public Carrera delete(Carrera unaCarrera) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = DBConnector.getInstancia().getConnection().prepareStatement(
					"update carrera set nombre = ?, descripcion = ? where idCarrera = ?"
					);
			stmt.setString(1, unaCarrera.getNombre());
			stmt.setString(2, unaCarrera.getDescripcion());
			stmt.setInt(3, unaCarrera.getIdCarrera());
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

		return unaCarrera;
	}
	
	
}
