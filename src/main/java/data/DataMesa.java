package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.LinkedList;

import entities.Materia;
import entities.Mesa;

public class DataMesa {
	public Mesa create(Mesa newMesa) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = DBConnector.getInstancia().getConnection().prepareStatement(
					"insert into mesa (llamado, idMateria, fechaHora) values (?, ?, ?)",
					PreparedStatement.RETURN_GENERATED_KEYS
					);
			stmt.setInt(1, newMesa.getLlamado());
			stmt.setInt(2, newMesa.getIdMateria());
			stmt.setObject(2, newMesa.getFechaHora());
			stmt.executeUpdate();
			
			rs = stmt.getGeneratedKeys();
			
			while(rs != null && rs.next()) {
				newMesa.setLlamado(rs.getInt(1));
				newMesa.setIdMateria(rs.getInt(2));
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
		
		return newMesa;
	}
	
	public LinkedList<Mesa> getAll() {
		LinkedList<Mesa> mesas = new LinkedList<>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = DBConnector.getInstancia().getConnection().prepareStatement(
					"select idMateria, fechaHora, llamado from mesa"
					);
			rs = stmt.executeQuery();
			
			while(rs != null && rs.next()) {
				Mesa unaMesa = new Mesa();
				
				unaMesa.setIdMateria(rs.getInt("idMateria"));
				unaMesa.setFechaHora(rs.getObject("fechaHora", LocalDateTime.class));
				unaMesa.setLlamado(rs.getInt("llamado"));
				
				mesas.add(unaMesa);
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
		
		return mesas;
	}
	
	public Mesa delete(Mesa unaMesa) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = DBConnector.getInstancia().getConnection().prepareStatement(
					"delete from mesa where llamado=? and idMateria=? and fachaHora=?"
					);
			stmt.setInt(1, unaMesa.getLlamado());
			stmt.setInt(2, unaMesa.getIdMateria());
			stmt.setObject(3, unaMesa.getFechaHora());
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
		
		return unaMesa;
	}
	
	public Mesa update(Mesa unaMesa) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = DBConnector.getInstancia().getConnection().prepareStatement(
					"update mesa set llamado = ?, idMateria = ?, fechaHora = ? where llamado=? and idMateria=? and fachaHora=?"
					);
			stmt.setInt(1, unaMesa.getLlamado());
			stmt.setInt(2, unaMesa.getIdMateria());
			stmt.setObject(3, unaMesa.getFechaHora());
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

		return unaMesa;
	}
	
	public Mesa getOne(Mesa unaMesa) {
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		
		try {
			pstmt = DBConnector.getInstancia().getConnection().prepareStatement(
					"select llamado, idMateria, fechaHora from mesa where llamado=? and idMateria=? and fachaHora=?");
			pstmt.setInt(1, unaMesa.getLlamado());
			pstmt.setInt(2, unaMesa.getIdMateria());
			pstmt.setObject(3, unaMesa.getFechaHora());
			rs = pstmt.executeQuery();
			
			if(rs!=null && rs.next()) {
				unaMesa.setLlamado(rs.getInt("llamado"));
				unaMesa.setIdMateria(rs.getInt("idMateria"));
			}
			
		} catch(SQLException er) {
			er.printStackTrace();
		} finally {
			try {
				if(rs!=null)   {rs.close();}
				if(pstmt!=null) {pstmt.close();}
				DBConnector.getInstancia().releaseConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return unaMesa; 
		
	}
}
