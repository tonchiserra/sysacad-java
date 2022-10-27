package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import entities.Mesa;

public class DataMesa {
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
				//unaMesa.setFechaHora(rs.getDate("fechaHora"));
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
}
