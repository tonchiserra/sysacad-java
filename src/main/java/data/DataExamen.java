package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entities.Carrera;
import entities.Examen;

public class DataExamen {
	
	public Examen getOne(Examen unExamen) {
		Examen newExamen = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = DBConnector.getInstancia().getConnection().prepareStatement(
					"select legajo, idMateria, estado from examen where legajo=? and idMateria=?"
					);
			stmt.setInt(1, unExamen.getLegajo());
			stmt.setInt(2, unExamen.getIdMateria());
			rs = stmt.executeQuery();
			
			if(rs != null && rs.next()) {
				newExamen = new Examen();
				
				newExamen.setLegajo(rs.getInt("legajo"));
				newExamen.setIdMateria(rs.getInt("idMateria"));
				newExamen.setEstado(rs.getString("estado"));
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
		
		return newExamen;
	}
	
	public Examen update(Examen unExamen) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = DBConnector.getInstancia().getConnection().prepareStatement(
					"update examen set fecha = ?, estado = ?, nota = ? where legajo = ? and idMateria = ?"
					);
			stmt.setObject(1, unExamen.getFecha());
			stmt.setString(2, unExamen.getEstado());
			stmt.setDouble(3, unExamen.getNota());
			stmt.setInt(4, unExamen.getLegajo());
			stmt.setInt(5, unExamen.getIdMateria());
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

		return unExamen;
	}
	
	public Examen create(Examen newExamen) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = DBConnector.getInstancia().getConnection().prepareStatement(
					"insert into examen (legajo, idMateria) values (?, ?)",
					PreparedStatement.RETURN_GENERATED_KEYS
					);
			stmt.setInt(1, newExamen.getLegajo());
			stmt.setInt(2, newExamen.getIdMateria());
			stmt.executeUpdate();
			
			rs = stmt.getGeneratedKeys();
			
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
		
		return newExamen;
	}
}
