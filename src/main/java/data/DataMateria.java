package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import entities.Materia;

public class DataMateria {
	
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
}
