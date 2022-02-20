package Dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entity.Fornitore;

public class FornitoreDao {
	@SuppressWarnings("unused")
	private Connection connection;
	private PreparedStatement InserisciFornitore,RicercaFornitorebyNome,RicercaFornitore,EliminaFornitore;
	
	public FornitoreDao(Connection connection) throws SQLException{
		this.connection=connection;
		EliminaFornitore=connection.prepareStatement("DELETE FROM Fornitore WHERE Nome=?");
		InserisciFornitore=connection.prepareStatement("INSERT INTO Fornitore VALUES (?,?,?)");
		RicercaFornitorebyNome=connection.prepareStatement("SELECT * FROM Fornitore WHERE NomeFornitore=?");
		RicercaFornitore=connection.prepareStatement("SELECT * FROM Fornitore");
	}
	
	public void EliminaFornitore(Fornitore forn)throws SQLException{
		EliminaFornitore.setString(1,forn.GetNome_Fornitore());
		EliminaFornitore.executeQuery();
	}
	
	public void InserisciFornitore(Fornitore forn) throws SQLException {
		InserisciFornitore.setString(1,forn.GetNome_Fornitore());
		InserisciFornitore.setString(2,forn.Categoria);
		InserisciFornitore.setString(3,forn.Casa_Produttrice);
		
		InserisciFornitore.executeQuery();
	
	}
	
	public Fornitore RicercaFornitorebyNome (String NomeFornitore) throws SQLException{
	
		RicercaFornitorebyNome.setString(1,NomeFornitore);
		
		ResultSet rs=RicercaFornitorebyNome.executeQuery();
		
		ArrayList<Fornitore> list = new ArrayList<Fornitore>();
		
		while(rs.next()) {
			Fornitore f = new Fornitore(rs.getString("Nome"),rs.getString("Categoria"),rs.getString("Casa_Produttrice"));
			list.add(f);
		}
		rs.close();
		return list.get(0);
	}
	
	public ArrayList<Fornitore> RicercaFornitore() throws SQLException{
	
		ResultSet rs=RicercaFornitore.executeQuery();
		
		ArrayList<Fornitore> list = new ArrayList<Fornitore>();
		
		while(rs.next()) {
			Fornitore f = new Fornitore(rs.getString("Nome"),rs.getString("Categoria"),rs.getString("Casa_Produttrice"));
			list.add(f);
		}
		rs.close();
		return list;
	}

}