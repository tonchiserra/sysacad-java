package data;

import entities.*;

import java.sql.*;
import java.util.LinkedList;

public class DataComision {
	
	public void create(Comision cComision) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try 
		{
			pstmt= DBConnector.getInstancia().getConnection().prepareStatement(
					"insert into comision (codigoComision, cupoTotal) values (?, ?)", 
					PreparedStatement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, cComision.getCodigoComision());
			pstmt.setInt(2, cComision.getCupoTotal());
			pstmt.executeUpdate();
		} 
		catch(SQLException er) {er.printStackTrace();}
		finally 
		{
			try 
			{
				if(rs!=null)   {rs.close();}
				if(pstmt!=null) {pstmt.close();}
				DBConnector.getInstancia().releaseConnection();
			} catch (SQLException e) {e.printStackTrace();}
		}
		
	}
	
	public void delete(Comision dComision) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try 
		{
			pstmt= DBConnector.getInstancia().getConnection().prepareStatement("delete from comision where codigoComision=?");
			pstmt.setString(1, dComision.getCodigoComision());
			pstmt.executeUpdate();
		} 
		catch(SQLException er) {er.printStackTrace();}
		finally 
		{
			try 
			{
				if(rs!=null)   {rs.close();}
				if(pstmt!=null) {pstmt.close();}
				DBConnector.getInstancia().releaseConnection();
			} catch (SQLException e) {e.printStackTrace();}
		}
		
	}
		
	
	public void update(Comision uComision) {
		PreparedStatement pstmt=null;
		
		try 
		{
			pstmt= DBConnector.getInstancia().getConnection().prepareStatement(
					"update comision set cupoTotal=? where codigoComision=?");
			pstmt.setInt(1, uComision.getCupoTotal());
			pstmt.setString(2, uComision.getCodigoComision());
			pstmt.executeUpdate();
		} 
		catch(SQLException er) {er.printStackTrace();}
		finally 
		{
			try 
			{
				if(pstmt!=null) {pstmt.close();}
				DBConnector.getInstancia().releaseConnection();
			} catch (SQLException e) {e.printStackTrace();}
		}
	}
	
	
	public Comision getOne(Comision getComision) {
		Comision c = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		
		try 
		{
			pstmt= DBConnector.getInstancia().getConnection().prepareStatement(
					"select * from comision where codigoComision=?");
			pstmt.setString(1, getComision.getCodigoComision());
			rs= pstmt.executeQuery();
			
			
			if(rs!=null && rs.next()) 
			{
				c = new Comision();
				c.setCodigoComision(rs.getString("codigoComision"));
				c.setCupoTotal(rs.getInt("cupoTotal"));
			}
			
		} catch(SQLException er) {er.printStackTrace();}
		finally 
		{
			try 
			{
				if(rs!=null)   {rs.close();}
				if(pstmt!=null) {pstmt.close();}
				DBConnector.getInstancia().releaseConnection();
			} catch (SQLException e) {e.printStackTrace();}
		}
		
		return c; 
		
	}
	
	public LinkedList<Comision> getAll() {
		LinkedList<Comision> lcomisiones=new LinkedList<>();
		Statement stmt=null;
		ResultSet rs=null;
		
		try 
		{
			stmt= DBConnector.getInstancia().getConnection().createStatement();
			rs= stmt.executeQuery("select * from comision");
			
			if(rs!=null) 
			{
				while(rs.next()) 
				{
					Comision c=new Comision();
					c.setCodigoComision(rs.getString("codigoComision"));
					c.setCupoTotal(rs.getInt("cupoTotal"));
	
					lcomisiones.add(c);
				}
			}
			
		} catch(SQLException er) {er.printStackTrace();}
		finally 
		{
			try 
			{
				if(rs!=null)   {rs.close();}
				if(stmt!=null) {stmt.close();}
				DBConnector.getInstancia().releaseConnection();
			} catch (SQLException e) {e.printStackTrace();}
		}
		
		return lcomisiones;
	}
	
	
	
	
}
